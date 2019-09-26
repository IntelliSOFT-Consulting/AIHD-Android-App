package org.aihdint.aihd.patient;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;

import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.app.Variables;
import org.aihdint.aihd.common.Common;
import org.aihdint.aihd.common.DateCalendar;
import org.aihdint.aihd.forms.DM_FollowUp;
import org.aihdint.aihd.forms.DM_Initial;
import org.aihdint.aihd.R;
import org.aihdint.aihd.common.NavigationDrawerShare;
import org.aihdint.aihd.model.PatientProfile;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Profile extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {


    private String patient_id;
    private String gender;
    private String records;
    private String isDeceased;
    private EditText editTextDeathDate;
    private String cause_of_death;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String identifier = intent.getStringExtra("identifier");
        patient_id = intent.getStringExtra("patient_id");
        gender = intent.getStringExtra("gender");
        isDeceased = intent.getStringExtra("death");

        TextView textViewName = findViewById(R.id.patient_name);
        textViewName.setText(name);

        if (patient_id != null) {
            List<PatientProfile> patient = PatientProfile.findWithQuery(PatientProfile.class, "SELECT * FROM PATIENT_PROFILE WHERE patient_id = ? ", patient_id);

            for (PatientProfile pn : patient) {
                records = pn.getMedicationFile();
            }
        }


        TextView textViewIdentifier = findViewById(R.id.patient_identifier);
        if (identifier != null) {
            textViewIdentifier.setText(identifier);
        }

    }


    public void summary(View view) {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        @SuppressLint("InflateParams") final View dialogView = inflater.inflate(R.layout.patient_summary, null);
        alertDialogBuilder.setMessage("Patient Summary");

        TextView textViewAppointment = dialogView.findViewById(R.id.appointment);
        LinearLayout linearLayoutDiabetes = dialogView.findViewById(R.id.diabetes);
        LinearLayout linearLayoutHypertension = dialogView.findViewById(R.id.hypertension);

        TextView textViewTreatment = dialogView.findViewById(R.id.treatment);
        TextView textViewDrug = dialogView.findViewById(R.id.drug);
        TextView textViewFrequency = dialogView.findViewById(R.id.frequency);

        TextView textViewVitals = dialogView.findViewById(R.id.textViewVitals);

        Log.d("Range", String.valueOf(DateCalendar.dateRange(DateCalendar.date(), "2018-10-05")));

        final Button showDrugs = dialogView.findViewById(R.id.showDrugs);
        final Button hideDrugs = dialogView.findViewById(R.id.hideDrugs);
        final LinearLayout drugs = dialogView.findViewById(R.id.drugs);

        final Button showVitals = dialogView.findViewById(R.id.showVitals);
        final Button hideVitals = dialogView.findViewById(R.id.hideVitals);
        final LinearLayout vitals = dialogView.findViewById(R.id.vitals);

        try {
            JSONObject jsonObj = new JSONObject(records);

            // Getting JSON Array node
            JSONArray obs = jsonObj.getJSONArray("obs");

            if (obs.length() > 0) {
                for (int i = 0; i < obs.length(); i++) {
                    JSONObject concept = obs.getJSONObject(i);

                    switch (concept.optString("concept_id")) {
                        case "165086":
                            if (!concept.optString("concept_answer").equals("1175")) {
                                linearLayoutDiabetes.setVisibility(View.VISIBLE);
                            }
                            break;
                        case "165091":
                            if (!concept.optString("concept_answer").equals("1175")) {
                                linearLayoutHypertension.setVisibility(View.VISIBLE);
                            }
                            break;
                        case "1282":
                            textViewTreatment.append(Common.conceptAnswer(concept, "1282") + " \n");
                            break;
                        case "1443":
                            textViewDrug.append(String.format("%s mg", concept.getString("concept_answer")) + " \n");
                            break;
                        case "160855":
                            textViewFrequency.append(Common.conceptAnswer(concept, "160855") + " \n");
                            break;
                        case "5096":
                            if (DateCalendar.dateRange(DateCalendar.date(), concept.optString("concept_answer")) > 0) {
                                textViewAppointment.setTextColor(getResources().getColor(R.color.light_green));
                                textViewAppointment.append("Appointment Date: ");
                            } else {
                                textViewAppointment.setTextColor(getResources().getColor(R.color.orange));
                                textViewAppointment.append("Missed Appointment: ");
                            }
                            textViewAppointment.append(concept.optString("concept_answer"));
                            break;
                        case "5089":
                            textViewVitals.append("Weight: " + concept.optString("concept_answer") + " \n");
                            break;
                        case "5085":
                            textViewVitals.append("Blood Pressure: " + concept.optString("concept_answer") + "/");
                            break;
                        case "5086":
                            textViewVitals.append(concept.optString("concept_answer") + " \n");
                            break;
                        case "5242":
                            textViewVitals.append("Repiratory rate: " + concept.optString("concept_answer") + " \n");
                            break;

                        default:
                            break;
                    }
                }
            }


        } catch (Exception e) {
            // hiding the progress bar
            e.printStackTrace();
        }

        showDrugs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drugs.setVisibility(View.VISIBLE);
                showDrugs.setVisibility(View.GONE);
                hideDrugs.setVisibility(View.VISIBLE);
            }
        });

        hideDrugs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drugs.setVisibility(View.GONE);
                hideDrugs.setVisibility(View.GONE);
                showDrugs.setVisibility(View.VISIBLE);
            }
        });

        showVitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vitals.setVisibility(View.VISIBLE);
                showVitals.setVisibility(View.GONE);
                hideVitals.setVisibility(View.VISIBLE);
            }
        });

        hideVitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vitals.setVisibility(View.GONE);
                hideVitals.setVisibility(View.GONE);
                showVitals.setVisibility(View.VISIBLE);
            }
        });

        //alertDialogBuilder.setView(dialogView);

        alertDialogBuilder.setView(dialogView).setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
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
                final Button positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButton.setBackgroundResource(R.drawable.rounded_button);
                positiveButton.setTextColor(Color.WHITE);
                LinearLayout.LayoutParams positiveButtonLL = (LinearLayout.LayoutParams) positiveButton.getLayoutParams();
                positiveButtonLL.gravity = positiveButtonLL.width = ViewGroup.LayoutParams.MATCH_PARENT;
                positiveButton.setLayoutParams(positiveButtonLL);
            }
        });
        alertDialog.show();
    }

    public void dmInitial(View view) {
        Intent dm_initial = new Intent(getApplicationContext(), DM_Initial.class);
        dm_initial.putExtra("patient_id", patient_id);
        dm_initial.putExtra("gender", gender);
        startActivity(dm_initial);
        finish();
    }

    public void dmFollowup(View view) {
        Intent dm_followup = new Intent(getApplicationContext(), DM_FollowUp.class);
        dm_followup.putExtra("patient_id", patient_id);
        startActivity(dm_followup);
        finish();
    }

    /*
    public void forms(View view) {
        Intent forms = new Intent(getApplicationContext(), DM_HTN_Forms.class);
        forms.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        forms.putExtra("patient_id", patient_id);
        startActivity(forms);
        finish();
    }
    */


    public void transfer(View view) {

        Intent transfer = new Intent(getApplicationContext(), Transfer.class);
        transfer.putExtra("patient_id", patient_id);
        startActivity(transfer);
        finish();
    }

    public void deceased(View view) {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).setPositiveButton("SUBMIT", null).create();

        // Set Dialog Title
        alertDialog.setTitle("Mark Patient As Deceased");

        // Set Dialog Message
        final LinearLayout lp = new LinearLayout(this);
        lp.setOrientation(LinearLayout.VERTICAL);

        CheckBox checkBox = new CheckBox(this);
        checkBox.setOnCheckedChangeListener(this);
        checkBox.setId(R.id.checkBoxDeceased);
        checkBox.setText(R.string.deceased);

        TextView textView = new TextView(this);
        textView.setText(R.string.death_cause);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 30, 0, 30);
        textView.setLayoutParams(params);

        final TextView textViewError = new TextView(this);
        textViewError.setText(R.string.deceased_error);
        textViewError.setTextColor(getResources().getColor(R.color.red));
        textViewError.setLayoutParams(params);

        editTextDeathDate = new EditText(this);
        editTextDeathDate.setId(R.id.editTextDeath);
        editTextDeathDate.setInputType(InputType.TYPE_CLASS_DATETIME);
        editTextDeathDate.setHint("YYYY-MM-DD");
        editTextDeathDate.setFocusableInTouchMode(false);
        editTextDeathDate.setFocusable(false);
        DateCalendar.date(this, editTextDeathDate);

        final RadioGroup radioGroup = new RadioGroup(this);
        final RadioButton[] radioButtons = new RadioButton[3];
        radioGroup.setOrientation(RadioGroup.VERTICAL);

        for (int i = 0; i < 3; i++) {
            String text = "Other";
            if (i == 0) {
                text = "Diabetes Complication";
            } else if (i == 1) {
                text = "Hypertension Complication";
            }
            radioButtons[i] = new RadioButton(this);
            radioButtons[i].setText(text);
            radioButtons[i].setId(i);
            radioGroup.addView(radioButtons[i]);
        }


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                lp.removeView(textViewError);
                if (isChecked) {
                    isDeceased = "1";
                } else {
                    isDeceased = null;
                }
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                lp.removeView(textViewError);
                if (checkedId == 0) {
                    cause_of_death = "165211";
                } else if (checkedId == 1) {
                    cause_of_death = "165212";
                } else if (checkedId == 2) {
                    cause_of_death = "5622";
                }
            }
        });


        lp.addView(checkBox);
        lp.addView(textView);
        lp.addView(radioGroup);
        lp.addView(editTextDeathDate);
        lp.setPadding(50, 40, 50, 10);

        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {

            @Override
            public void onShow(DialogInterface dialogInterface) {

                Button button = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                button.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        if (isDeceased != null && cause_of_death != null && !editTextDeathDate.getText().toString().equals("")) {
                            alertDialog.dismiss();
                            killPatient();
                        } else {
                            lp.addView(textViewError);

                        }
                    }
                });
            }
        });


        alertDialog.setView(lp);

        // Show Alert Message
        alertDialog.show();

    }


    private void killPatient() {

        StringRequest req = new StringRequest(Request.Method.POST, Variables.PATIENT_DEATH_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObj = new JSONObject(response);
                    Toast.makeText(getApplicationContext(), jsonObj.getString("message"), Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        }) {

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<>();
                params.put("uuid", Objects.requireNonNull(AppController.getInstance().getSessionManager().getUserDetails().get("user_id")));
                params.put("patient_id", patient_id);
                params.put("dead", isDeceased);
                params.put("death_date", editTextDeathDate.getText().toString().trim());
                params.put("cause_of_death", cause_of_death);

                JSONObject JSONparams = new JSONObject(params);
                Log.d("Params", JSONparams.toString());

                return params;
            }

        };
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(req);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            isDeceased = "1";
        }
    }

}
