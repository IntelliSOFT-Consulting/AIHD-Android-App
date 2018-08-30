package org.aihdint.aihd.common;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.aihdint.aihd.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Developed by Rodney on 09/02/2018.
 */

public class Alerts {
    private Context mContext;

    public Alerts(Context mContext) {
        this.mContext = mContext;
    }

    public static void alert_msg(Context context, String title, String message) {
            AlertDialog alertDialog = new AlertDialog.Builder(context).create();

            // Set Dialog Title
            alertDialog.setTitle(title);

            // Set Dialog Message
            alertDialog.setMessage(message);


            // Set OK Button
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            // Show Alert Message
            alertDialog.show();
    }

    public void share(Context context) {
        //AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(getAc(), R.style.AppTheme));

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        assert inflater != null;
        View dialogView = inflater.inflate(R.layout.dialog, null);
        alertDialogBuilder.setMessage("Alerts ?");

        ImageView facebook = dialogView.findViewById(R.id.imageViewFacebook);
        ImageView twitter = dialogView.findViewById(R.id.imageViewTwitter);
        ImageView whatsapp = dialogView.findViewById(R.id.imageViewWhatsapp);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msgToShare = String.valueOf(Html.fromHtml("Want more insights on AIHD Data, Visit AIHD on <br />" +
                        "http://aihdint.org"));
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                // intent.putExtra(Intent.EXTRA_SUBJECT, "Foo bar"); // NB: has no effect!
                intent.putExtra(Intent.EXTRA_TEXT, msgToShare);

                // See if official Facebook app is found
                boolean facebookAppFound = false;
                List<ResolveInfo> matches = mContext.getPackageManager().queryIntentActivities(intent, 0);
                for (ResolveInfo info : matches) {
                    if (info.activityInfo.packageName.toLowerCase().startsWith("com.facebook.katana")) {
                        intent.setPackage(info.activityInfo.packageName);
                        facebookAppFound = true;
                        break;
                    }
                }

                // As fallback, launch sharer.php in a browser
                if (!facebookAppFound) {
                    Toast.makeText(mContext.getApplicationContext(), "Application not found, opening browser", Toast.LENGTH_LONG).show();
                    String sharerUrl = "https://www.facebook.com/sharer/sharer.php?u=" + msgToShare;
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl));
                }

                mContext.startActivity(intent);
            }

        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //share("twitter","your comment");
                Intent tweetIntent = new Intent(Intent.ACTION_SEND);
                tweetIntent.putExtra(Intent.EXTRA_TEXT, String.valueOf(Html.fromHtml("Want more insights on AIHD Data, Visit AIHD on <br />" +
                        "http://aihdint.org/")));
                tweetIntent.setType("text/plain");

                PackageManager packManager = mContext.getPackageManager();
                List<ResolveInfo> resolvedInfoList = packManager.queryIntentActivities(tweetIntent, PackageManager.MATCH_DEFAULT_ONLY);

                boolean resolved = false;
                for (ResolveInfo resolveInfo : resolvedInfoList) {
                    if (resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")) {
                        tweetIntent.setClassName(
                                resolveInfo.activityInfo.packageName,
                                resolveInfo.activityInfo.name);
                        resolved = true;
                        break;
                    }
                }
                if (resolved) {
                    mContext.startActivity(tweetIntent);
                } else {
                    Intent i = new Intent();
                    i.putExtra(Intent.EXTRA_TEXT, String.valueOf(Html.fromHtml("Want more insights on AIHD Data, Visit AIHD on <br />" +
                            "<a href='http://aihdint.org/'>here</a>")));
                    i.setAction(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://twitter.com/intent/tweet?text=" + urlEncode()));
                    mContext.startActivity(i);
                    Toast.makeText(mContext.getApplicationContext(), "Twitter app isn't found", Toast.LENGTH_LONG).show();
                }

            }

        });

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PackageManager pm = mContext.getPackageManager();
                try {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    String text = String.valueOf(Html.fromHtml("Want more insights on AIHD Data, Visit AIHD on <br />" +
                            "http://aihdint.org/"));
                    PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
                    //Check if package exists or not. If not then code
                    //in catch block will be called
                    intent.setPackage("com.whatsapp");
                    intent.putExtra(Intent.EXTRA_TEXT, text);
                    //startActivity(Intent.createChooser(intent, "Alerts with"));
                    mContext.startActivity(intent);
                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(mContext.getApplicationContext(), "WhatsApp not Installed", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        alertDialogBuilder.setView(dialogView).setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                //Dismiss
                arg0.dismiss();
            }
        });

        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
            }
        });
        alertDialog.show();
    }


    private String urlEncode(){
        try {
            return URLEncoder.encode("", "UTF-8");
        }catch (UnsupportedEncodingException e) {
            Log.wtf("UTF Issue", "UTF-8 should always be supported", e);
        }
        return "";
    }


}
