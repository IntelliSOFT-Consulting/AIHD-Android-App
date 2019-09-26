package org.aihdint.aihd.common;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class JSONFormBuilder {

    public static JSONObject observations(String conceptID, String groupID, String type, String conceptAnswer, String datetime, String comment) {

        JSONObject jsonObs = new JSONObject();

        try {
            //Values
            if (!TextUtils.isEmpty(conceptAnswer) && !TextUtils.isEmpty(conceptID)) {
                jsonObs.put("concept_id", conceptID);
                jsonObs.put("group_id", groupID);
                jsonObs.put("type", type);
                jsonObs.put("concept_answer", conceptAnswer);
                jsonObs.put("datetime", datetime);
                jsonObs.put("comment", comment);
            }
            //Json Object for Obeservation
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObs;
    }

    public static JSONArray checkLength(JSONArray jsonArray,JSONArray jsonObs) {
        if (jsonArray.length() > 0) {
            jsonObs.put(jsonArray);
        }

        return jsonObs;
    }

    public static JSONArray concatArray(JSONArray... arrs)
            throws JSONException {
        JSONArray result = new JSONArray();

        for (JSONArray arr : arrs) {
            for (int i = 0; i < arr.length(); i++) {
                JSONObject element = (JSONObject) arr.get(i);
                if (element.length() > 0) {
                    result.put(arr.get(i));
                }

            }
        }

        return result;
    }


    public static String loadForm(Context mContext, String folder, String file_name) {

        String data = null;
        ProgressDialog pDialog = File_Upload.showProgressDialog(mContext, "Reading DM HTN Form ...");

        //Read File
        try {
            File myFile = new File(Environment.getExternalStorageDirectory() + "/aihd/" + folder + "/" + file_name);
            FileInputStream fIn = new FileInputStream(myFile);
            BufferedReader myReader = new BufferedReader(
                    new InputStreamReader(fIn));
            String aDataRow;
            StringBuilder aBuffer = new StringBuilder();
            while ((aDataRow = myReader.readLine()) != null) {
                aBuffer.append(aDataRow).append("\n");
            }
            Log.e("Reading from storage", aBuffer.toString());
            data = aBuffer.toString();
            myReader.close();
            //Toast.makeText(getBaseContext(), "Done reading SD 'mysdfile.txt'",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        pDialog.dismiss();
        //Log.d("JSON FollowUp", jsonObs1.toString() + " " + dir.toString());

        return data;
    }
}
