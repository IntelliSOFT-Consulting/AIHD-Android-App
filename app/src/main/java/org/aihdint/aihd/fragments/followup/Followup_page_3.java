package org.aihdint.aihd.fragments.followup;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;


import org.aihdint.aihd.common.Common;
import org.aihdint.aihd.R;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import customfonts.TextView_Roboto_Bold;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Followup_page_3 extends Fragment {

    private EditText editTextSystolic, editTextDiastolic;
    private EditText editTextWaist, editTextHip, editTextHeight, editTextWeight, editTextNutrition;
    private TextView_Roboto_Bold textViewBMI, textViewWaistHipRatio;
    private String foot_exam, eye_exam, dental_exam, eye_checkup;
    private String cardiovascular_disease, high_blood_pressure, high_cholestrol, peripheral_vascular_disease,
            peripheral_neuropathy, autonomic_neuropathy, retinopathy, kidney_disease, asthma_COPD,
            arthritis, assesment_other, foot_amputation;
    private EditText editTextCardiovascularDisease, editTextHBP, editTextHighCholestrol, editTextVascularDisease, editTextPNeuropathy, editTextANeuropathy,
            editTextRetinopathy, editTextKidneyDisease, editTextAsthma, editTextArthritis, editTextOther;
    private EditText editTextFBS, editTextRBS, editTextHBA, editTextHDL, editTextLDL, editTextTriglycerides, editTextUEC, editTextUrinalysis;
    private EditText editTextDateFBS, editTextDateRBS, editTextDateHBA, editTextDateHDL, editTextDateLDL, editTextDateTriglycerides, editTextDateUEC, editTextDateUrinalysis;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_followup_fragment_3, container, false);

        editTextSystolic = view.findViewById(R.id.followup_systolic);
        editTextDiastolic = view.findViewById(R.id.followup_diastolic);

        editTextWaist = view.findViewById(R.id.followup_waist_circ);
        editTextHip = view.findViewById(R.id.followup_hip_circ);
        editTextHeight = view.findViewById(R.id.followup_height);
        editTextWeight = view.findViewById(R.id.followup_weight);
        editTextNutrition = view.findViewById(R.id.followup_nutrition);

        editTextCardiovascularDisease = view.findViewById(R.id.details_cardiovascular_disease);
        editTextHBP = view.findViewById(R.id.details_high_bp);
        editTextHighCholestrol = view.findViewById(R.id.details_high_cholestrol);
        editTextVascularDisease = view.findViewById(R.id.details_peripheral_vascular_disease);
        editTextPNeuropathy = view.findViewById(R.id.details_peripheral_neuropathy);
        editTextANeuropathy = view.findViewById(R.id.details_autonomic_neuropathy);
        editTextRetinopathy = view.findViewById(R.id.details_retinopathy);
        editTextKidneyDisease = view.findViewById(R.id.details_kidney_disease);
        editTextAsthma = view.findViewById(R.id.details_asthma_COPD);
        editTextArthritis = view.findViewById(R.id.details_arthritis);
        editTextOther = view.findViewById(R.id.details_assesment_other);

        editTextFBS = view.findViewById(R.id.followup_fbs);
        editTextRBS = view.findViewById(R.id.followup_rbs);
        editTextHBA = view.findViewById(R.id.followup_hba);
        editTextHDL = view.findViewById(R.id.followup_hdl);
        editTextLDL = view.findViewById(R.id.followup_ldl);
        editTextTriglycerides = view.findViewById(R.id.followup_triglycerides);
        editTextUEC = view.findViewById(R.id.followup_uec);
        editTextUrinalysis = view.findViewById(R.id.followup_urinalysis);

        editTextDateFBS = view.findViewById(R.id.date_fbs);
        editTextDateRBS = view.findViewById(R.id.date_rbs);
        editTextDateHBA = view.findViewById(R.id.date_hba);
        editTextDateHDL = view.findViewById(R.id.date_hdl);
        editTextDateLDL = view.findViewById(R.id.date_ldl);
        editTextDateTriglycerides = view.findViewById(R.id.date_triglycerides);
        editTextDateUEC = view.findViewById(R.id.date_uec);
        editTextDateUrinalysis = view.findViewById(R.id.date_urinalysis);

        textWatcher(editTextSystolic, "blood_pressure");
        textWatcher(editTextDiastolic, "blood_pressure");

        textViewBMI = view.findViewById(R.id.followup_bmi);
        textViewWaistHipRatio = view.findViewById(R.id.followup_hip_waist_ratio);

        textWatcher(editTextSystolic, "blood_pressure");
        textWatcher(editTextDiastolic, "blood_pressure");

        textWatcher(editTextHeight, "textViewBMI");
        textWatcher(editTextWeight, "textViewBMI");
        textWatcher(editTextWaist, "whr");
        textWatcher(editTextHip, "whr");

        textWatcher(editTextCardiovascularDisease, "");
        textWatcher(editTextHBP, "");
        textWatcher(editTextHighCholestrol, "");
        textWatcher(editTextVascularDisease, "");
        textWatcher(editTextPNeuropathy, "");
        textWatcher(editTextANeuropathy, "");
        textWatcher(editTextRetinopathy, "");
        textWatcher(editTextKidneyDisease, "");
        textWatcher(editTextAsthma, "");
        textWatcher(editTextArthritis, "");
        textWatcher(editTextOther, "");

        textWatcher(editTextFBS, "");
        textWatcher(editTextRBS, "");
        textWatcher(editTextHBA, "");
        textWatcher(editTextHDL, "");
        textWatcher(editTextLDL, "");
        textWatcher(editTextTriglycerides, "");
        textWatcher(editTextUEC, "");
        textWatcher(editTextUrinalysis, "");

        textWatcher(editTextDateFBS, "");
        textWatcher(editTextDateRBS, "");
        textWatcher(editTextDateHBA, "");
        textWatcher(editTextDateHDL, "");
        textWatcher(editTextDateLDL, "");
        textWatcher(editTextDateTriglycerides, "");
        textWatcher(editTextDateUEC, "");
        textWatcher(editTextDateUrinalysis, "");


        textViewBMI = view.findViewById(R.id.followup_bmi);
        textViewWaistHipRatio = view.findViewById(R.id.followup_hip_waist_ratio);

        CheckBox checkBoxCardiovascularDisease = view.findViewById(R.id.checkbox_cardiovascular_disease);
        CheckBox checkBoxHBP = view.findViewById(R.id.checkbox_high_BP);
        CheckBox checkBoxHighCholestrol = view.findViewById(R.id.checkbox_high_cholestrol);
        CheckBox checkBoxVascularDisease = view.findViewById(R.id.checkbox_peripheral_vascular_disease);
        CheckBox checkBoxPNeuropathy = view.findViewById(R.id.checkbox_peripheral_neuropathy);
        CheckBox checkBoxANeuropathy = view.findViewById(R.id.checkbox_autonomic_neuropathy);
        CheckBox checkBoxRetinopathy = view.findViewById(R.id.checkbox_retinopathy);
        CheckBox checkBoxKidneyDisease = view.findViewById(R.id.checkbox_kidney_disease);
        CheckBox checkBoxAsthma = view.findViewById(R.id.checkbox_asthma_COPD);
        CheckBox checkBoxArthritis = view.findViewById(R.id.checkbox_arthritis);
        CheckBox checkBoxOther = view.findViewById(R.id.checkbox_assesment_other);

        checkBox(checkBoxCardiovascularDisease);
        checkBox(checkBoxHBP);
        checkBox(checkBoxHighCholestrol);
        checkBox(checkBoxVascularDisease);
        checkBox(checkBoxPNeuropathy);
        checkBox(checkBoxANeuropathy);
        checkBox(checkBoxRetinopathy);
        checkBox(checkBoxKidneyDisease);
        checkBox(checkBoxAsthma);
        checkBox(checkBoxArthritis);
        checkBox(checkBoxOther);

        RadioButton radioButtonFootAmputationYes = view.findViewById(R.id.radio_foot_amputations_yes);
        RadioButton radioButtonFootAmputationNo = view.findViewById(R.id.radio_foot_amputations_no);

        radioButtonClicked(radioButtonFootAmputationYes);
        radioButtonClicked(radioButtonFootAmputationNo);


        return view;
    }

    public void textWatcher(EditText editText, final String check) {

        editText.addTextChangedListener(new TextWatcher() {

            private Timer timer = new Timer();
            private final long DELAY = 1500; // milliseconds

            @Override
            public void afterTextChanged(final Editable editable) {

                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        timer.cancel();
                        timer = new Timer();

                        final Runnable checkRunnable = new Runnable() {
                            public void run() {

                                if (check.matches("blood_pressure")) {
                                    if (editTextSystolic != null && editTextDiastolic != null) {
                                        Common.checkBP(getContext(), editTextSystolic, editTextDiastolic, null, null);
                                    }
                                } else if (check.matches("textViewBMI")) {
                                    Common.bmi(getActivity(), getContext(), editTextHeight, editTextWeight, textViewBMI);
                                } else if (check.matches("whr")) {
                                    Common.whr(getActivity(), editTextWaist, editTextHip, textViewWaistHipRatio);
                                } else {
                                    updateValues();
                                }
                            }
                        };

                        TimerTask task = new TimerTask() {
                            public void run() {
                                getActivity().runOnUiThread(checkRunnable);
                            }
                        };

                        timer.schedule(task, DELAY);

                    }
                });

            }


            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });
    }




    public void radioButtonClicked(final RadioButton radioButton) {

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();
                switch (radioButton.getId()) {
                    case R.id.radio_foot_amputations_yes:
                        if (checked) {
                            foot_amputation = "1065";
                        }
                        break;
                    case R.id.radio_foot_amputations_no:
                        if (checked) {
                            foot_amputation = "1066";
                        }
                        break;
                }
                updateValues();
            }
        });
    }


    public void checkBox(final CheckBox checkBox) {

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();

                //Check which checkbox was clicked
                switch (checkBox.getId()) {
                    case R.id.checkbox_foot_exam:
                        if (checked) {
                            foot_exam = "165099";
                        } else {
                            foot_exam = "";
                        }
                        break;
                    case R.id.checkbox_eye_exam:
                        if (checked) {
                            eye_exam = "165100";
                        } else {
                            eye_exam = "";
                        }
                        break;
                    case R.id.checkbox_dental_exam:
                        if (checked) {
                            dental_exam = "165101";
                        } else {
                            dental_exam = "";
                        }
                        break;
                    case R.id.checkbox_eye_check_up:
                        if (checked) {
                            eye_checkup = "165102";
                        } else {
                            eye_checkup = "";
                        }
                        break;
                    case R.id.checkbox_cardiovascular_disease:
                        if (checked) {
                            cardiovascular_disease = "137593";
                        } else {
                            cardiovascular_disease = "";
                        }
                        break;
                    case R.id.checkbox_high_BP:
                        if (checked) {
                            high_blood_pressure = "117399";
                        } else {
                            high_blood_pressure = "";
                        }
                        break;
                    case R.id.checkbox_high_cholestrol:
                        if (checked) {
                            high_cholestrol = "117460";
                        } else {
                            high_cholestrol = "";
                        }
                        break;
                    case R.id.checkbox_peripheral_vascular_disease:
                        if (checked) {
                            peripheral_vascular_disease = "114212";
                        } else {
                            peripheral_vascular_disease = "";
                        }
                        break;
                    case R.id.checkbox_peripheral_neuropathy:
                        if (checked) {
                            peripheral_neuropathy = "118983";
                        } else {
                            peripheral_neuropathy = "";
                        }
                        break;
                    case R.id.checkbox_autonomic_neuropathy:
                        if (checked) {
                            autonomic_neuropathy = "155215";
                        } else {
                            autonomic_neuropathy = "";
                        }
                        break;
                    case R.id.checkbox_retinopathy:
                        if (checked) {
                            retinopathy = "113257";
                        } else {
                            retinopathy = "";
                        }
                        break;
                    case R.id.checkbox_kidney_disease:
                        if (checked) {
                            kidney_disease = "6033";
                        } else {
                            kidney_disease = "";
                        }
                        break;
                    case R.id.checkbox_asthma_COPD:
                        if (checked) {
                            asthma_COPD = "121375";
                        } else {
                            asthma_COPD = "";
                        }
                        break;
                    case R.id.checkbox_arthritis:
                        if (checked) {
                            arthritis = "148432";
                        } else {
                            arthritis = "";
                        }
                        break;
                    case R.id.checkbox_assesment_other:
                        if (checked) {
                            assesment_other = "5622";
                        } else {
                            assesment_other = "";
                        }
                        break;

                }

                updateValues();

            }
        });
    }

    public void updateValues() {

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current_date = dateFormat.format(new Date());

        JSONArray jsonArry = new JSONArray();

        jsonArry.put(JSONFormBuilder.observations("5090", "", "valueNumeric", editTextHeight.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("5089", "", "valueNumeric", editTextWeight.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("5085", "", "valueNumeric", editTextSystolic.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("5086", "", "valueNumeric", editTextDiastolic.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("163081", "", "valueNumeric", editTextHip.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("163080", "", "valueNumeric", editTextWaist.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165190", "", "valueText", editTextNutrition.getText().toString().trim(), current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1391", "", "valueCoded", foot_exam, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1391", "", "valueCoded", eye_exam, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1391", "", "valueCoded", dental_exam, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1391", "", "valueCoded", eye_checkup, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", cardiovascular_disease, current_date, editTextCardiovascularDisease.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", high_blood_pressure, current_date, editTextHBP.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", high_cholestrol, current_date, editTextHighCholestrol.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", peripheral_vascular_disease, current_date, editTextVascularDisease.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", peripheral_neuropathy, current_date, editTextPNeuropathy.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", autonomic_neuropathy, current_date, editTextANeuropathy.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", retinopathy, current_date, editTextRetinopathy.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", kidney_disease, current_date, editTextKidneyDisease.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", asthma_COPD, current_date, editTextAsthma.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", arthritis, current_date, editTextArthritis.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", assesment_other, current_date, editTextOther.getText().toString().trim()));

        jsonArry.put(JSONFormBuilder.observations("165104", "", "valueCoded", foot_amputation, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("160912", "161487", "valueText", editTextFBS.getText().toString().trim(), editTextDateFBS.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("887", "161487", "valueText", editTextRBS.getText().toString().trim(), editTextDateRBS.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("159644", "161487", "valueText", editTextHBA.getText().toString().trim(), editTextDateHBA.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("1007", "161487", "valueText", editTextHDL.getText().toString().trim(), editTextDateHDL.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("1008", "161487", "valueText", editTextLDL.getText().toString().trim(), editTextDateLDL.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("1009", "161487", "valueText", editTextTriglycerides.getText().toString().trim(), editTextDateTriglycerides.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("164364", "161487", "valueText", editTextUEC.getText().toString().trim(), editTextDateUEC.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("", "161487", "valueText", editTextUrinalysis.getText().toString().trim(), editTextDateUrinalysis.getText().toString().trim(), ""));

        try {
            jsonArry = JSONFormBuilder.concatArray(jsonArry);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("JSON FollowUp Page 3", jsonArry.toString() + " ");

        FragmentModelFollowUp.getInstance().followUpThree(jsonArry);
    }

}
