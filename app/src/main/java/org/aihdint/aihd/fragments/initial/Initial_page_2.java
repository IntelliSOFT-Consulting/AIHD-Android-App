package org.aihdint.aihd.fragments.initial;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
//import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import org.aihdint.aihd.common.Common;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.aihdint.aihd.R;
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

public class Initial_page_2 extends Fragment {

    private LinearLayout linearLayoutPastCurrentMedication, linearLayoutOtherPastCurrentMedication, linearLayoutExamOther, linearLayoutExtremities;

    private EditText editTextMetformin, editTextGlibenclamide, editTextInsulin, editTextNPH, editTextSolubleInsulin, editTextEnalapril, editTextHCTZ,
            editTextLosartan, editTextNifedipine, editTextAtenolol, editTextMedicationOther, editTextAdhereSpecify, editTextAllergySpecify;

    private EditText editTextTemp, editTextPulseRate, editTextSystolicOne, editTextDiastolicOne, editTextSystolicTwo, editTextDiastolicTwo, editTextWaist,
            editTextHip, editTextHeight, editTextWeight, editTextRespiratoryRate, editTextExamOther, editTextVisual, editTextCVS, editTextRS, editTextPA, editTextCNS,
            editTextMonofilamentRF, editTextMonofilamentLF;

    private TextView_Roboto_Bold bmi, waist_hip_ratio;

    private String medication_none, medication_metformin, medication_glibenclamide, medication_insulin, medication_nph, medication_soluble_insulin,
            medication_enalapril, medication_hctz, medication_losartan, medication_nifedipine, medication_atenolol, medication_other, adhere_medication, allergies;

    private String general_exam, pallor, jaundice, cyanosis, lymphadenopathy, oedema, dehydration, exam_other, visual_impairment, cvs, rs, pa, cns, extremities;
    private String ulcers, callouses, hardened_nails, fungus, cellulitis, edema, dry;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_2, container, false);

        linearLayoutPastCurrentMedication = view.findViewById(R.id.past_current_medication);
        linearLayoutOtherPastCurrentMedication = view.findViewById(R.id.other_past_current_medication);
        linearLayoutExamOther = view.findViewById(R.id.linearLayoutExamOther);
        linearLayoutExtremities = view.findViewById(R.id.extremitiesLinearLayout);

        CheckBox checkBoxNone = view.findViewById(R.id.checkbox_medication_none);
        CheckBox checkBoxMetformin = view.findViewById(R.id.checkbox_medication_metformin);
        CheckBox checkBoxGlibenclamide = view.findViewById(R.id.checkbox_medication_glibenclamide);
        CheckBox checkBoxInsulin = view.findViewById(R.id.checkbox_medication_insulin);
        CheckBox checkBoxNPH = view.findViewById(R.id.checkbox_medication_nph);
        CheckBox checkBoxSoluble_insulin = view.findViewById(R.id.checkbox_medication_soluble_insulin);
        CheckBox checkBoxEnalapril = view.findViewById(R.id.checkbox_medication_enalapril);
        CheckBox checkBoxHCTZ = view.findViewById(R.id.checkbox_medication_hctz);
        CheckBox checkBoxLosartan = view.findViewById(R.id.checkbox_medication_losartan);
        CheckBox checkBoxNifedipine = view.findViewById(R.id.checkbox_medication_nifedipine);
        CheckBox checkBoxAtenolol = view.findViewById(R.id.checkbox_medication_atenolol);
        CheckBox checkBoxMedicationOther = view.findViewById(R.id.checkbox_medication_other);

        checkBox(checkBoxNone);
        checkBox(checkBoxMetformin);
        checkBox(checkBoxGlibenclamide);
        checkBox(checkBoxInsulin);
        checkBox(checkBoxNPH);
        checkBox(checkBoxSoluble_insulin);
        checkBox(checkBoxEnalapril);
        checkBox(checkBoxHCTZ);
        checkBox(checkBoxLosartan);
        checkBox(checkBoxNifedipine);
        checkBox(checkBoxAtenolol);
        checkBox(checkBoxMedicationOther);

        editTextMetformin = view.findViewById(R.id.medication_metformin);
        editTextGlibenclamide = view.findViewById(R.id.medication_glibenclamide);
        editTextInsulin = view.findViewById(R.id.medication_insulin);
        editTextNPH = view.findViewById(R.id.medication_nph);
        editTextSolubleInsulin = view.findViewById(R.id.medication_soluble_insulin);
        editTextEnalapril = view.findViewById(R.id.medication_enalapril);
        editTextHCTZ = view.findViewById(R.id.medication_hctz);
        editTextLosartan = view.findViewById(R.id.medication_losartan);
        editTextNifedipine = view.findViewById(R.id.medication_nifedipine);
        editTextAtenolol = view.findViewById(R.id.medication_atenolol);
        editTextMedicationOther = view.findViewById(R.id.medication_other);
        editTextAdhereSpecify = view.findViewById(R.id.adhere_specify);
        editTextAllergySpecify = view.findViewById(R.id.allergy_specify);

        textWatcher(editTextMetformin, "");
        textWatcher(editTextGlibenclamide, "");
        textWatcher(editTextInsulin, "");
        textWatcher(editTextNPH, "");
        textWatcher(editTextSolubleInsulin, "");
        textWatcher(editTextEnalapril, "");
        textWatcher(editTextHCTZ, "");
        textWatcher(editTextLosartan, "");
        textWatcher(editTextNifedipine, "");
        textWatcher(editTextAtenolol, "");
        textWatcher(editTextMedicationOther, "");
        textWatcher(editTextAdhereSpecify, "");
        textWatcher(editTextAllergySpecify, "");

        RadioButton radioButtonAdhereMedicationYes = view.findViewById(R.id.radio_adhere_yes);
        RadioButton radioButtonAdhereMedicationNo = view.findViewById(R.id.radio_adhere_no);
        RadioButton radioButtonAdhereMedicationNA = view.findViewById(R.id.radio_adhere_na);
        RadioButton radioButtonAllergiesYes = view.findViewById(R.id.radio_allergies_yes);
        RadioButton radioButtonAllergiesNo = view.findViewById(R.id.radio_allergies_no);

        radioButton(radioButtonAdhereMedicationYes);
        radioButton(radioButtonAdhereMedicationNo);
        radioButton(radioButtonAdhereMedicationNA);
        radioButton(radioButtonAllergiesYes);
        radioButton(radioButtonAllergiesNo);

        editTextTemp = view.findViewById(R.id.temp);
        editTextPulseRate = view.findViewById(R.id.pulse_rate);

        editTextSystolicOne = view.findViewById(R.id.bp_systolic_one);
        editTextDiastolicOne = view.findViewById(R.id.bp_diastolic_one);
        editTextSystolicTwo = view.findViewById(R.id.bp_systolic_two);
        editTextDiastolicTwo = view.findViewById(R.id.bp_diastolic_two);

        editTextWaist = view.findViewById(R.id.waist_circ);
        editTextHip = view.findViewById(R.id.hip_circ);
        editTextHeight = view.findViewById(R.id.height);
        editTextWeight = view.findViewById(R.id.weight);
        editTextRespiratoryRate = view.findViewById(R.id.respiratory_rate);
        editTextExamOther = view.findViewById(R.id.other_general_exam);

        editTextVisual = view.findViewById(R.id.describe_visual_impairment);
        editTextCVS = view.findViewById(R.id.describe_cvs);
        editTextRS = view.findViewById(R.id.describe_rs);
        editTextPA = view.findViewById(R.id.describe_pa);
        editTextCNS = view.findViewById(R.id.describe_cns);
        editTextMonofilamentRF = view.findViewById(R.id.monofilament_rf);
        editTextMonofilamentLF = view.findViewById(R.id.monofilament_lf);

        bmi = view.findViewById(R.id.bmi);
        waist_hip_ratio = view.findViewById(R.id.waist_hip_ratio);

        textWatcher(editTextTemp, "editTextTemp");
        textWatcher(editTextPulseRate, "editTextPulseRate");
        textWatcher(editTextSystolicOne, "");
        textWatcher(editTextSystolicTwo, "blood_pressure");
        textWatcher(editTextDiastolicOne, "");
        textWatcher(editTextDiastolicTwo, "blood_pressure");
        textWatcher(editTextHeight, "bmi");
        textWatcher(editTextWeight, "bmi");
        textWatcher(editTextWaist, "whr");
        textWatcher(editTextHip, "whr");
        textWatcher(editTextRespiratoryRate, "");
        textWatcher(editTextExamOther, "");
        textWatcher(editTextVisual, "");
        textWatcher(editTextCVS, "");
        textWatcher(editTextRS, "");
        textWatcher(editTextPA, "");
        textWatcher(editTextCNS, "");
        textWatcher(editTextMonofilamentRF, "");
        textWatcher(editTextMonofilamentLF, "");

        RadioButton radioButtonExamFair = view.findViewById(R.id.radio_exam_fair);
        RadioButton radioButtonExamGood = view.findViewById(R.id.radio_exam_good);
        RadioButton radioButtonExamSick = view.findViewById(R.id.radio_exam_sick);
        RadioButton radioButtonVisualYes = view.findViewById(R.id.radio_visual_impairment_yes);
        RadioButton radioButtonVisualNo = view.findViewById(R.id.radio_visual_impairment_no);
        RadioButton radioButtonCVSNormal = view.findViewById(R.id.radio_cvs_normal);
        RadioButton radioButtonCVSAbnormal = view.findViewById(R.id.radio_cvs_abnormal);
        RadioButton radioButtonRSNormal = view.findViewById(R.id.radio_rs_normal);
        RadioButton radioButtonRSAbnormal = view.findViewById(R.id.radio_rs_abnormal);
        RadioButton radioButtonPANormal = view.findViewById(R.id.radio_pa_normal);
        RadioButton radioButtonPAAbnormal = view.findViewById(R.id.radio_pa_abnormal);
        RadioButton radioButtonCNSNormal = view.findViewById(R.id.radio_cns_normal);
        RadioButton radioButtonCNSAbnormal = view.findViewById(R.id.radio_cns_abnormal);
        RadioButton radioButtonExtremitiesNormal = view.findViewById(R.id.radio_extremities_normal);
        RadioButton radioButtonExtremitiesAbnormal = view.findViewById(R.id.radio_extremities_abnormal);

        radioButton(radioButtonExamFair);
        radioButton(radioButtonExamGood);
        radioButton(radioButtonExamSick);
        radioButton(radioButtonVisualYes);
        radioButton(radioButtonVisualNo);
        radioButton(radioButtonCVSNormal);
        radioButton(radioButtonCVSAbnormal);
        radioButton(radioButtonRSNormal);
        radioButton(radioButtonRSAbnormal);
        radioButton(radioButtonPANormal);
        radioButton(radioButtonPAAbnormal);
        radioButton(radioButtonCNSNormal);
        radioButton(radioButtonCNSAbnormal);
        radioButton(radioButtonExtremitiesNormal);
        radioButton(radioButtonExtremitiesAbnormal);

        CheckBox checkBoxPallor = view.findViewById(R.id.checkbox_exam_pallor);
        CheckBox checkBoxJaundice = view.findViewById(R.id.checkbox_exam_jaundice);
        CheckBox checkBoxCyanosis = view.findViewById(R.id.checkbox_exam_cyanosis);
        CheckBox checkBoxLymphadenopathy = view.findViewById(R.id.checkbox_exam_lymphadenopathy);
        CheckBox checkBoxOedema = view.findViewById(R.id.checkbox_exam_oedema);
        CheckBox checkBoxDehydration = view.findViewById(R.id.checkbox_exam_dehydration);
        CheckBox checkBoxExamOther = view.findViewById(R.id.checkbox_exam_other);

        CheckBox checkBoxUlcers = view.findViewById(R.id.checkbox_extremities_ulcers);
        CheckBox checkBoxCallouses = view.findViewById(R.id.checkbox_extremities_callouses);
        CheckBox checkBoxHardenedNails = view.findViewById(R.id.checkbox_extremities_nails);
        CheckBox checkBoxFungus = view.findViewById(R.id.checkbox_extremities_fungus);
        CheckBox checkBoxCellutis = view.findViewById(R.id.checkbox_extremities_cellulitis);
        CheckBox checkBoxEdema = view.findViewById(R.id.checkbox_extremities_edema);
        CheckBox checkBoxDry = view.findViewById(R.id.checkbox_extremities_dry);

        checkBox(checkBoxPallor);
        checkBox(checkBoxJaundice);
        checkBox(checkBoxCyanosis);
        checkBox(checkBoxLymphadenopathy);
        checkBox(checkBoxOedema);
        checkBox(checkBoxDehydration);
        checkBox(checkBoxExamOther);

        checkBox(checkBoxUlcers);
        checkBox(checkBoxCallouses);
        checkBox(checkBoxHardenedNails);
        checkBox(checkBoxFungus);
        checkBox(checkBoxCellutis);
        checkBox(checkBoxEdema);
        checkBox(checkBoxDry);

        return view;
    }


    public void medicationNone(String status) {
        if (status.matches("1107")) {
            linearLayoutPastCurrentMedication.setVisibility(View.GONE);
        } else {
            linearLayoutPastCurrentMedication.setVisibility(View.VISIBLE);
        }
    }

    public void medicationOther(String status) {
        if (status.matches("5622")) {
            linearLayoutOtherPastCurrentMedication.setVisibility(View.VISIBLE);
        } else {
            linearLayoutOtherPastCurrentMedication.setVisibility(View.GONE);
        }
    }

    public void examOther(String status) {
        if (status.matches("161602")) {
            linearLayoutExamOther.setVisibility(View.VISIBLE);
        } else {
            linearLayoutExamOther.setVisibility(View.GONE);
        }
    }

    public void extremitiesStatus(String status) {
        if (status.matches("1116")) {
            linearLayoutExtremities.setVisibility(View.VISIBLE);
        } else {
            linearLayoutExtremities.setVisibility(View.GONE);
        }
    }


    public void textWatcher(EditText editText, final String check) {

        editText.addTextChangedListener(new TextWatcher() {

            private Timer timer = new Timer();
            private final long DELAY = 1500; // milliseconds

            @Override
            public void afterTextChanged(final Editable editable) {
                timer.cancel();
                timer = new Timer();

                final Runnable checkRunnable = new Runnable() {
                    public void run() {
                        if (check.matches("editTextTemp")) {
                            Common.checkTemp(getContext(), editable.toString());
                        } else if (check.matches("editTextPulseRate")) {
                            Common.checkPR(getContext(), editable.toString());
                        } else if (check.matches("blood_pressure")) {
                            if (editTextSystolicTwo != null && editTextDiastolicTwo != null) {
                                Common.checkBP(getContext(), editTextSystolicOne, editTextDiastolicOne, editTextSystolicTwo, editTextDiastolicTwo);
                            } else if (editTextSystolicOne != null && editTextDiastolicOne != null) {
                                Common.checkBP(getContext(), editTextSystolicOne, editTextDiastolicOne, editTextSystolicTwo, editTextDiastolicTwo);
                            }
                        } else if (check.matches("bmi")) {
                            Common.bmi(getActivity(), getContext(), editTextHeight, editTextWeight, bmi);
                        } else if (check.matches("whr")) {
                            Common.whr(getActivity(), editTextWaist, editTextHip, waist_hip_ratio);
                        } else if (check.matches("editTextmMonofilamentLF")) {
                            Common.monofilament(getContext(), editable.toString());
                        } else if (check.matches("editTextmMonofilamentRF")) {
                            Common.monofilament(getContext(), editable.toString());
                        }
                    }
                };

                TimerTask task = new TimerTask() {
                    public void run() {
                        try {
                            getActivity().runOnUiThread(checkRunnable);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };

                timer.schedule(task, DELAY);

                updateValues();
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                /*Check text Change before typing*/
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                /*Check text Change while typing*/
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
                    case R.id.checkbox_medication_none:
                        if (checked) {
                            medication_none = "1107";
                            medicationNone(medication_none);
                        } else {
                            medication_none = "";
                            medicationNone(medication_none);
                        }
                        break;
                    case R.id.checkbox_medication_metformin:
                        if (checked) {
                            medication_metformin = "79651";
                        } else {
                            medication_metformin = "";
                        }
                        break;
                    case R.id.checkbox_medication_glibenclamide:
                        if (checked) {
                            medication_glibenclamide = "77071";
                        } else {
                            medication_glibenclamide = "";
                        }
                        break;
                    case R.id.checkbox_medication_insulin:
                        if (checked) {
                            medication_insulin = "159459";
                        } else {
                            medication_insulin = "";
                        }
                        break;
                    case R.id.checkbox_medication_nph:
                        if (checked) {
                            medication_nph = "78068";
                        } else {
                            medication_nph = "";
                        }
                        break;
                    case R.id.checkbox_medication_soluble_insulin:
                        if (checked) {
                            medication_soluble_insulin = "282";
                        } else {
                            medication_soluble_insulin = "";
                        }
                        break;
                    case R.id.checkbox_medication_enalapril:
                        if (checked) {
                            medication_enalapril = "75633";
                        } else {
                            medication_enalapril = "";
                        }
                        break;
                    case R.id.checkbox_medication_hctz:
                        if (checked) {
                            medication_hctz = "77696";
                        } else {
                            medication_hctz = "";
                        }
                        break;
                    case R.id.checkbox_medication_losartan:
                        if (checked) {
                            medication_losartan = "79074";
                        } else {
                            medication_losartan = "";
                        }
                        break;
                    case R.id.checkbox_medication_nifedipine:
                        if (checked) {
                            medication_nifedipine = "80637";
                        } else {
                            medication_nifedipine = "";
                        }
                    case R.id.checkbox_medication_atenolol:
                        if (checked) {
                            medication_atenolol = "71652";
                        } else {
                            medication_atenolol = "";
                        }
                        break;
                    case R.id.checkbox_medication_other:
                        if (checked) {
                            medication_other = "5622";
                            medicationOther(medication_other);
                        } else {
                            medication_other = "";
                            medicationOther(medication_other);
                        }
                        break;
                    case R.id.checkbox_exam_pallor:
                        if (checked) {
                            pallor = "5245";
                        } else {
                            pallor = "";
                        }
                        break;
                    case R.id.checkbox_exam_jaundice:
                        if (checked) {
                            jaundice = "136443";
                        } else {
                            jaundice = "";
                        }
                        break;
                    case R.id.checkbox_exam_cyanosis:
                        if (checked) {
                            cyanosis = "143050";
                        } else {
                            cyanosis = "";
                        }
                        break;
                    case R.id.checkbox_exam_lymphadenopathy:
                        if (checked) {
                            lymphadenopathy = "135488";
                        } else {
                            lymphadenopathy = "";
                        }
                        break;
                    case R.id.checkbox_exam_oedema:
                        if (checked) {
                            oedema = "460";
                        } else {
                            oedema = "";
                        }
                        break;
                    case R.id.checkbox_exam_dehydration:
                        if (checked) {
                            dehydration = "142630";
                        } else {
                            dehydration = "";
                        }
                        break;
                    case R.id.checkbox_exam_other:
                        if (checked) {
                            exam_other = "161602";
                            examOther(exam_other);
                        } else {
                            exam_other = "";
                            examOther(exam_other);
                        }
                        break;
                    case R.id.checkbox_extremities_ulcers:
                        if (checked) {
                            ulcers = "123919";
                        } else {
                            ulcers = "";
                        }
                        break;
                    case R.id.checkbox_extremities_callouses:
                        if (checked) {
                            callouses = "120943";
                        } else {
                            callouses = "";
                        }
                        break;
                    case R.id.checkbox_extremities_nails:
                        if (checked) {
                            hardened_nails = "165113";
                        } else {
                            hardened_nails = "";
                        }
                        break;
                    case R.id.checkbox_extremities_fungus:
                        if (checked) {
                            fungus = "165114";
                        } else {
                            fungus = "";
                        }
                        break;
                    case R.id.checkbox_extremities_cellulitis:
                        if (checked) {
                            cellulitis = "134";
                        } else {
                            cellulitis = "";
                        }
                        break;
                    case R.id.checkbox_extremities_edema:
                        if (checked) {
                            edema = "156113";
                        } else {
                            edema = "";
                        }
                        break;
                    case R.id.checkbox_extremities_dry:
                        if (checked) {
                            dry = "165115";
                        } else {
                            dry = "";
                        }
                        break;
                }

                updateValues();
            }
        });
    }


    public void radioButton(final RadioButton radioButton) {

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Is the button now checked?
                boolean checked = (buttonView).isChecked();

                // Check which radio button was clicked
                switch (radioButton.getId()) {
                    case R.id.radio_adhere_yes:
                        if (checked)
                            adhere_medication = "1065";
                        break;
                    case R.id.radio_adhere_no:
                        if (checked)
                            adhere_medication = "1066";
                        break;
                    case R.id.radio_adhere_na:
                        if (checked)
                            adhere_medication = "1175";
                        break;
                    case R.id.radio_allergies_yes:
                        if (checked)
                            allergies = "1065";
                        break;
                    case R.id.radio_allergies_no:
                        if (checked)
                            allergies = "1066";
                        break;
                    case R.id.radio_exam_fair:
                        if (checked)
                            general_exam = "162133";
                        break;
                    case R.id.radio_exam_good:
                        if (checked)
                            general_exam = "1855";
                        break;
                    case R.id.radio_exam_sick:
                        if (checked)
                            general_exam = "163293";
                        break;
                    case R.id.radio_visual_impairment_yes:
                        if (checked)
                            visual_impairment = "1065";
                        break;
                    case R.id.radio_visual_impairment_no:
                        if (checked)
                            visual_impairment = "1066";
                        break;
                    case R.id.radio_cvs_normal:
                        if (checked)
                            cvs = "1115";
                        break;
                    case R.id.radio_cvs_abnormal:
                        if (checked)
                            cvs = "1116";
                        break;
                    case R.id.radio_rs_normal:
                        if (checked)
                            rs = "1115";
                        break;
                    case R.id.radio_rs_abnormal:
                        if (checked)
                            rs = "1116";
                        break;
                    case R.id.radio_pa_normal:
                        if (checked)
                            pa = "1115";
                        break;
                    case R.id.radio_pa_abnormal:
                        if (checked)
                            pa = "1116";
                        break;
                    case R.id.radio_cns_normal:
                        if (checked)
                            cns = "1115";
                        break;
                    case R.id.radio_cns_abnormal:
                        if (checked)
                            cns = "1116";
                        break;
                    case R.id.radio_extremities_normal:
                        if (checked)
                            extremities = "1115";
                        extremitiesStatus(extremities);
                        break;
                    case R.id.radio_extremities_abnormal:
                        if (checked)
                            extremities = "1116";
                        extremitiesStatus(extremities);
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

        jsonArry.put(JSONFormBuilder.observations("159460", "", "valueCoded", medication_none, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_metformin, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_glibenclamide, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_insulin, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_nph, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_soluble_insulin, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_enalapril, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_hctz, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_losartan, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_nifedipine, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_atenolol, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_other, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1443", "1442", "valueNumeric", editTextMetformin.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "1442", "valueNumeric", editTextGlibenclamide.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "1442", "valueNumeric", editTextInsulin.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "1442", "valueNumeric", editTextNPH.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "1442", "valueNumeric", editTextSolubleInsulin.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "1442", "valueNumeric", editTextEnalapril.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "1442", "valueNumeric", editTextHCTZ.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "1442", "valueNumeric", editTextLosartan.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "1442", "valueNumeric", editTextNifedipine.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "1442", "valueNumeric", editTextAtenolol.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165157", "1442", "valueText", editTextMedicationOther.getText().toString().trim(), current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("165108", "", "valueCoded", adhere_medication, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165109", "", "valueText", editTextAdhereSpecify.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165146", "", "valueCoded", allergies, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165166", "", "valueText", editTextAllergySpecify.getText().toString().trim(), current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("5088", "", "valueNumeric", editTextTemp.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("5087", "", "valueNumeric", editTextPulseRate.getText().toString().trim(), current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("5085", "", "valueNumeric", editTextSystolicOne.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("5086", "", "valueNumeric", editTextDiastolicOne.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165111", "", "valueNumeric", editTextSystolicTwo.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165110", "", "valueNumeric", editTextDiastolicTwo.getText().toString().trim(), current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("163081", "", "valueCoded", editTextHip.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("163080", "", "valueCoded", editTextWaist.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("5090", "", "valueCoded", editTextHeight.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("5089", "", "valueCoded", editTextWeight.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("5242", "", "valueCoded", editTextRespiratoryRate.getText().toString().trim(), current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", general_exam, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", pallor, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", jaundice, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", cyanosis, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", lymphadenopathy, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", oedema, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", dehydration, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", exam_other, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("163042", "", "valueCoded", editTextExamOther.getText().toString().trim(), current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("165206", "", "valueCoded", visual_impairment, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165175", "", "valueCoded", editTextVisual.getText().toString().trim(), current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", cvs, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165158", "", "valueCoded", editTextCVS.getText().toString().trim(), current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1123", "", "valueCoded", rs, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165159", "", "valueCoded", editTextRS.getText().toString().trim(), current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("139549", "", "valueCoded", pa, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165160", "", "valueCoded", editTextPA.getText().toString().trim(), current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("163109", "", "valueCoded", cns, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165161", "", "valueCoded", editTextCNS.getText().toString().trim(), current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", extremities, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", ulcers, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", callouses, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", hardened_nails, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", fungus, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", cellulitis, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", edema, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", dry, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("165165", "", "valueNumeric", editTextMonofilamentRF.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165165", "", "valueNumeric", editTextMonofilamentLF.getText().toString().trim(), current_date, ""));

        try {
            jsonArry = JSONFormBuilder.concatArray(jsonArry);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Log.d("JSON Initial Page 2", jsonArry.toString() + " ");

        FragmentModelInitial.getInstance().initialTwo(jsonArry);
    }
}
