package org.aihdint.aihd.fragments.initial;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import org.aihdint.aihd.common.Common;
import org.aihdint.aihd.common.DateCalendar;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.aihdint.aihd.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import customfonts.TextView_Roboto_Bold;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Initial_page_2 extends Fragment {

    private View view;
    private LinearLayout linearLayoutPastCurrentMedication, linearLayoutOtherPastCurrentMedication, linearLayoutExamOther, linearLayoutExtremities;

    private EditText editTextMetformin, editTextGlibenclamide, editTextInsulin, editTextNPH, editTextSolubleInsulin, editTextEnalapril, editTextHCTZ,
            editTextLosartan, editTextNifedipine, editTextAtenolol, editTextMedicationOther, editTextAdhereSpecify, editTextAllergySpecify;

    private EditText editTextTemp, editTextPulseRate, editTextSystolicOne, editTextDiastolicOne, editTextSystolicTwo, editTextDiastolicTwo, editTextWaist,
            editTextHip, editTextHeight, editTextWeight, editTextRespiratoryRate, editTextExamOther, editTextVisual, editTextCVS, editTextRS, editTextPA, editTextCNS,
            editTextMonofilamentRF, editTextMonofilamentLF, editTextFootRiskComments, editTextFootExamComments;

    private TextView_Roboto_Bold bmi, waist_hip_ratio;

    private String medication_none, medication_metformin, medication_glibenclamide, medication_insulin, medication_nph, medication_soluble_insulin,
            medication_enalapril, medication_hctz, medication_losartan, medication_nifedipine, medication_atenolol, medication_other, adhere_medication, allergies;

    private String general_exam, pallor, jaundice, cyanosis, lymphadenopathy, oedema, dehydration, exam_other, visual_impairment, cvs, rs, pa, cns, extremities;
    private String ulcers, callouses, hardened_nails, fungus, cellulitis, edema, dry;
    private String peripheral_neuropathy, ulcers_foot, amputation, acute_joint, low_current_risk, at_risk, high_risk, ulcerated_foot, foot_emergency;

    private String pedal_pulse, peripheral_neuropathy_exam, deformity, foot_ulcer, amputation_exam, acute_joint_exam, sensation_loss;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dm_initial_fragment_2, container, false);

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

        editTextFootRiskComments = view.findViewById(R.id.foot_risk_comments);
        editTextFootExamComments = view.findViewById(R.id.foot_exam_comments);

        textWatcher(editTextTemp, "temp");
        textWatcher(editTextPulseRate, "pulseRate");
        textWatcher(editTextSystolicOne, "blood_pressure");
        textWatcher(editTextSystolicTwo, "blood_pressure");
        textWatcher(editTextDiastolicOne, "blood_pressure");
        textWatcher(editTextDiastolicTwo, "blood_pressure");
        textWatcher(editTextHeight, "bmi");
        textWatcher(editTextWeight, "bmi");
        textWatcher(editTextWaist, "whr");
        textWatcher(editTextHip, "whr");
        textWatcher(editTextRespiratoryRate, "respiratoryRate");
        textWatcher(editTextExamOther, "");
        textWatcher(editTextVisual, "");
        textWatcher(editTextCVS, "");
        textWatcher(editTextRS, "");
        textWatcher(editTextPA, "");
        textWatcher(editTextCNS, "");
        textWatcher(editTextMonofilamentRF, "monofilament");
        textWatcher(editTextMonofilamentLF, "monofilament");
        textWatcher(editTextFootRiskComments, "");
        textWatcher(editTextFootExamComments, "");

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

        RadioButton radioButtonTreatmentPedalPulse = view.findViewById(R.id.radio_foot_exam_treatment_pedal_pulse);
        RadioButton radioButtonResolvedPedalPulse = view.findViewById(R.id.radio_foot_exam_resolved_pedal_pulse);
        RadioButton radioButtonReferralPedalPulse = view.findViewById(R.id.radio_foot_exam_referral_pedal_pulse);
        RadioButton radioButtonFootSavedPedalPulse = view.findViewById(R.id.radio_foot_exam_saved_pedal_pulse);

        RadioButton radioButtonTreatmentPeripheralNeuropathy = view.findViewById(R.id.radio_foot_exam_treatment_peripheral_neuropathy);
        RadioButton radioButtonResolvedPeripheralNeuropathy = view.findViewById(R.id.radio_foot_exam_resolved_peripheral_neuropathy);
        RadioButton radioButtonReferralPeripheralNeuropathy = view.findViewById(R.id.radio_foot_exam_referral_peripheral_neuropathy);
        RadioButton radioButtonFootSavedPPeripheralNeuropathy = view.findViewById(R.id.radio_foot_exam_saved_peripheral_neuropathy);

        RadioButton radioButtonTreatmentDeformity = view.findViewById(R.id.radio_foot_exam_treatment_deformity);
        RadioButton radioButtonResolvedDeformity = view.findViewById(R.id.radio_foot_exam_resolved_deformity);
        RadioButton radioButtonReferralDeformity = view.findViewById(R.id.radio_foot_exam_referral_deformity);
        RadioButton radioButtonFootSavedDeformity = view.findViewById(R.id.radio_foot_exam_saved_deformity);

        RadioButton radioButtonTreatmentFootUcler = view.findViewById(R.id.radio_foot_exam_treatment_foot_ulcer);
        RadioButton radioButtonResolvedFootUcler = view.findViewById(R.id.radio_foot_exam_resolved_foot_ulcer);
        RadioButton radioButtonReferralFootUcler = view.findViewById(R.id.radio_foot_exam_referral_foot_ulcer);
        RadioButton radioButtonFootSavedFootUcler = view.findViewById(R.id.radio_foot_exam_saved_foot_ulcer);

        RadioButton radioButtonTreatmentAmputation = view.findViewById(R.id.radio_foot_exam_treatment_amputation);
        RadioButton radioButtonResolvedAmputation = view.findViewById(R.id.radio_foot_exam_resolved_amputation);
        RadioButton radioButtonReferralAmputation = view.findViewById(R.id.radio_foot_exam_referral_amputation);
        RadioButton radioButtonFootSavedAmputation = view.findViewById(R.id.radio_foot_exam_saved_amputation);

        RadioButton radioButtonTreatmentAcuteJoint = view.findViewById(R.id.radio_foot_exam_treatment_acute_joint);
        RadioButton radioButtonResolvedAcuteJoint = view.findViewById(R.id.radio_foot_exam_resolved_acute_joint);
        RadioButton radioButtonReferralAcuteJoint = view.findViewById(R.id.radio_foot_exam_referral_acute_joint);
        RadioButton radioButtonFootSavedAcuteJoint = view.findViewById(R.id.radio_foot_exam_saved_acute_joint);

        RadioButton radioButtonTreatmentSensationLoss = view.findViewById(R.id.radio_foot_exam_treatment_sensation_loss);
        RadioButton radioButtonResolvedSensationLoss = view.findViewById(R.id.radio_foot_exam_resolved_sensation_loss);
        RadioButton radioButtonReferralSensationLoss = view.findViewById(R.id.radio_foot_exam_referral_sensation_loss);
        RadioButton radioButtonFootSavedSensationLoss = view.findViewById(R.id.radio_foot_exam_saved_sensation_loss);

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

        radioButton(radioButtonTreatmentPedalPulse);
        radioButton(radioButtonResolvedPedalPulse);
        radioButton(radioButtonReferralPedalPulse);
        radioButton(radioButtonFootSavedPedalPulse);

        radioButton(radioButtonTreatmentPeripheralNeuropathy);
        radioButton(radioButtonResolvedPeripheralNeuropathy);
        radioButton(radioButtonReferralPeripheralNeuropathy);
        radioButton(radioButtonFootSavedPPeripheralNeuropathy);

        radioButton(radioButtonTreatmentDeformity);
        radioButton(radioButtonResolvedDeformity);
        radioButton(radioButtonReferralDeformity);
        radioButton(radioButtonFootSavedDeformity);

        radioButton(radioButtonTreatmentFootUcler);
        radioButton(radioButtonResolvedFootUcler);
        radioButton(radioButtonReferralFootUcler);
        radioButton(radioButtonFootSavedFootUcler);

        radioButton(radioButtonTreatmentAmputation);
        radioButton(radioButtonResolvedAmputation);
        radioButton(radioButtonReferralAmputation);
        radioButton(radioButtonFootSavedAmputation);

        radioButton(radioButtonTreatmentAcuteJoint);
        radioButton(radioButtonResolvedAcuteJoint);
        radioButton(radioButtonReferralAcuteJoint);
        radioButton(radioButtonFootSavedAcuteJoint);

        radioButton(radioButtonTreatmentSensationLoss);
        radioButton(radioButtonResolvedSensationLoss);
        radioButton(radioButtonReferralSensationLoss);
        radioButton(radioButtonFootSavedSensationLoss);


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

        CheckBox checkboxPeripheralNeuropathy = view.findViewById(R.id.checkbox_peripheral_neuropathy);
        CheckBox checkboxUlcers = view.findViewById(R.id.checkbox_ulcers);
        CheckBox checkboxAmputation = view.findViewById(R.id.checkbox_amputation);
        CheckBox checkboxAcuteJoint = view.findViewById(R.id.checkbox_acute_joint);
        CheckBox checkboxLowRisk = view.findViewById(R.id.checkbox_low_risk);
        CheckBox checkboxAtRisk = view.findViewById(R.id.checkbox_at_risk);
        CheckBox checkboxHighRisk = view.findViewById(R.id.checkbox_high_risk);
        CheckBox checkboxUlceratedFoot = view.findViewById(R.id.checkbox_ulcerated_foot);
        CheckBox checkboxFootEmergency = view.findViewById(R.id.checkbox_foot_emergency);


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

        checkBox(checkboxPeripheralNeuropathy);
        checkBox(checkboxUlcers);
        checkBox(checkboxAmputation);
        checkBox(checkboxAcuteJoint);
        checkBox(checkboxLowRisk);
        checkBox(checkboxAtRisk);
        checkBox(checkboxHighRisk);
        checkBox(checkboxUlceratedFoot);
        checkBox(checkboxFootEmergency);

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

            @Override
            public void afterTextChanged(final Editable editable) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        switch (check) {
                            case "temp":
                                Common.checkTemp(linearLayoutPastCurrentMedication, editable.toString());
                                break;
                            case "pulseRate":
                                Common.checkPR(linearLayoutPastCurrentMedication, editable.toString());
                                break;
                            case "respiratoryRate":
                                Common.checkRespiratory(linearLayoutPastCurrentMedication, editable.toString());
                                break;
                            case "blood_pressure":
                                if (editTextSystolicTwo != null && editTextDiastolicTwo != null) {
                                    Common.checkBP(view, editTextSystolicTwo, editTextDiastolicTwo);
                                }

                                if (editTextSystolicOne != null && editTextDiastolicOne != null) {
                                    Common.checkBP(view, editTextSystolicOne, editTextDiastolicOne);
                                }
                                break;
                            case "bmi":
                                Common.bmi(getContext(), editTextHeight, editTextWeight, bmi);
                                break;
                            case "whr":
                                Common.whr(editTextWaist, editTextHip, waist_hip_ratio);
                                break;
                            case "monofilament":
                                Common.monofilament(view, editable.toString());
                                break;
                            case "Monofilament":
                                Common.monofilament(view, editable.toString());
                                break;
                            default:
                                break;
                        }
                    }
                }, 4000);

                updateValues();
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                /*Check text Change before typing*/
                // TODO: No current action
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                /*Check text Change while typing*/
                // TODO: No current action
            }
        });
    }


    public void metformin(String status) {
        if (!status.matches("79651")) {
            editTextMetformin.setVisibility(View.GONE);
        } else {
            editTextMetformin.setVisibility(View.VISIBLE);
            editTextMetformin.setText("");
        }
    }

    public void glibenclamide(String status) {
        if (!status.matches("77071")) {
            editTextGlibenclamide.setVisibility(View.GONE);
        } else {
            editTextGlibenclamide.setVisibility(View.VISIBLE);
            editTextGlibenclamide.setText("");
        }
    }

    public void insulin(String status) {
        if (!status.matches("159459")) {
            editTextInsulin.setVisibility(View.GONE);
        } else {
            editTextInsulin.setVisibility(View.VISIBLE);
            editTextInsulin.setText("");
        }
    }

    public void nph(String status) {
        if (!status.matches("78068")) {
            editTextNPH.setVisibility(View.GONE);
        } else {
            editTextNPH.setVisibility(View.VISIBLE);
            editTextNPH.setText("");
        }
    }

    public void solubleInsulin(String status) {
        if (!status.matches("282")) {
            editTextSolubleInsulin.setVisibility(View.GONE);
        } else {
            editTextSolubleInsulin.setVisibility(View.VISIBLE);
            editTextSolubleInsulin.setText("");
        }
    }

    public void enalapril(String status) {
        if (!status.matches("75633")) {
            editTextEnalapril.setVisibility(View.GONE);
        } else {
            editTextEnalapril.setVisibility(View.VISIBLE);
            editTextEnalapril.setText("");
        }
    }

    public void hctz(String status) {
        if (!status.matches("77696")) {
            editTextHCTZ.setVisibility(View.GONE);
        } else {
            editTextHCTZ.setVisibility(View.VISIBLE);
            editTextHCTZ.setText("");
        }
    }

    public void losartan(String status) {
        if (!status.matches("79074")) {
            editTextLosartan.setVisibility(View.GONE);
        } else {
            editTextLosartan.setVisibility(View.VISIBLE);
            editTextLosartan.setText("");
        }
    }

    public void nifedipine(String status) {
        if (!status.matches("80637")) {
            editTextNifedipine.setVisibility(View.GONE);
        } else {
            editTextNifedipine.setVisibility(View.VISIBLE);
            editTextNifedipine.setText("");
        }
    }

    public void atenolol(String status) {
        if (!status.matches("71652")) {
            editTextAtenolol.setVisibility(View.GONE);
        } else {
            editTextAtenolol.setVisibility(View.VISIBLE);
            editTextAtenolol.setText("");
        }
    }


    public void checkBox(final CheckBox checkBox) {

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();
                int value = checkBox.getId();

                //Check which checkbox was clicked
                switch (value) {
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
                        metformin(medication_metformin);
                        break;
                    case R.id.checkbox_medication_glibenclamide:
                        if (checked) {
                            medication_glibenclamide = "77071";
                        } else {
                            medication_glibenclamide = "";
                        }
                        glibenclamide(medication_glibenclamide);
                        break;
                    case R.id.checkbox_medication_insulin:
                        if (checked) {
                            medication_insulin = "159459";
                        } else {
                            medication_insulin = "";
                        }
                        insulin(medication_insulin);
                        break;
                    case R.id.checkbox_medication_nph:
                        if (checked) {
                            medication_nph = "78068";
                        } else {
                            medication_nph = "";
                        }
                        nph(medication_nph);
                        break;
                    case R.id.checkbox_medication_soluble_insulin:
                        if (checked) {
                            medication_soluble_insulin = "282";
                        } else {
                            medication_soluble_insulin = "";
                        }
                        solubleInsulin(medication_soluble_insulin);
                        break;
                    case R.id.checkbox_medication_enalapril:
                        if (checked) {
                            medication_enalapril = "75633";
                        } else {
                            medication_enalapril = "";
                        }
                        enalapril(medication_enalapril);
                        break;
                    case R.id.checkbox_medication_hctz:
                        if (checked) {
                            medication_hctz = "77696";
                        } else {
                            medication_hctz = "";
                        }
                        hctz(medication_hctz);
                        break;
                    case R.id.checkbox_medication_losartan:
                        if (checked) {
                            medication_losartan = "79074";
                        } else {
                            medication_losartan = "";
                        }
                        losartan(medication_losartan);
                        break;
                    case R.id.checkbox_medication_nifedipine:
                        if (checked) {
                            medication_nifedipine = "80637";
                        } else {
                            medication_nifedipine = "";
                        }
                        nifedipine(medication_nifedipine);
                    case R.id.checkbox_medication_atenolol:
                        if (checked) {
                            medication_atenolol = "71652";
                        } else {
                            medication_atenolol = "";
                        }
                        atenolol(medication_atenolol);
                        break;
                    case R.id.checkbox_medication_other:
                        if (checked) {
                            medication_other = "5622";
                        } else {
                            medication_other = "";
                        }
                        medicationOther(medication_other);
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
                    case R.id.checkbox_peripheral_neuropathy:
                        if (checked) {
                            peripheral_neuropathy = "118983";
                        } else {
                            peripheral_neuropathy = "";
                        }
                        break;
                    case R.id.checkbox_ulcers:
                        if (checked) {
                            ulcers_foot = "123919";
                        } else {
                            ulcers_foot = "";
                        }
                        break;
                    case R.id.checkbox_amputation:
                        if (checked) {
                            amputation = "164009";
                        } else {
                            amputation = "";
                        }
                        break;
                    case R.id.checkbox_acute_joint:
                        if (checked) {
                            acute_joint = "165317";
                        } else {
                            acute_joint = "";
                        }
                        break;
                    case R.id.checkbox_low_risk:
                        if (checked) {
                            low_current_risk = "165338";
                        } else {
                            low_current_risk = "";
                        }
                        break;
                    case R.id.checkbox_at_risk:
                        if (checked) {
                            at_risk = "165321";
                        } else {
                            at_risk = "";
                        }
                        break;
                    case R.id.checkbox_high_risk:
                        if (checked) {
                            high_risk = "165320";
                        } else {
                            high_risk = "";
                        }
                        break;
                    case R.id.checkbox_ulcerated_foot:
                        if (checked) {
                            ulcerated_foot = "163411";
                        } else {
                            ulcerated_foot = "";
                        }
                        break;
                    case R.id.checkbox_foot_emergency:
                        if (checked) {
                            foot_emergency = "165319";
                        } else {
                            foot_emergency = "";
                        }
                        break;
                        default:
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
                int value = radioButton.getId();

                // Check which radio button was clicked
                switch (value) {
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

                    case R.id.radio_foot_exam_treatment_pedal_pulse:
                        if (checked)
                            pedal_pulse = "160749";
                        break;
                    case R.id.radio_foot_exam_resolved_pedal_pulse:
                        if (checked)
                            pedal_pulse = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_pedal_pulse:
                        if (checked)
                            pedal_pulse = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_pedal_pulse:
                        if (checked)
                            pedal_pulse = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_peripheral_neuropathy:
                        if (checked)
                            peripheral_neuropathy_exam = "160749";
                        break;
                    case R.id.radio_foot_exam_resolved_peripheral_neuropathy:
                        if (checked)
                            peripheral_neuropathy_exam = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_peripheral_neuropathy:
                        peripheral_neuropathy_exam = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_peripheral_neuropathy:
                        if (checked)
                            peripheral_neuropathy_exam = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_deformity:
                        if (checked)
                            deformity = "160749";
                        break;
                    case R.id.radio_foot_exam_resolved_deformity:
                        if (checked)
                            deformity = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_deformity:
                        if (checked)
                            deformity = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_deformity:
                        if (checked)
                            deformity = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_foot_ulcer:
                        if (checked)
                            foot_ulcer = "160749";
                        break;

                    case R.id.radio_foot_exam_resolved_foot_ulcer:
                        if (checked)
                            foot_ulcer = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_foot_ulcer:
                        if (checked)
                            foot_ulcer = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_foot_ulcer:
                        if (checked)
                            foot_ulcer = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_amputation:
                        if (checked)
                            amputation_exam = "160749";
                        break;

                    case R.id.radio_foot_exam_resolved_amputation:
                        if (checked)
                            amputation_exam = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_amputation:
                        if (checked)
                            amputation_exam = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_amputation:
                        if (checked)
                            amputation_exam = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_acute_joint:
                        if (checked)
                            acute_joint_exam = "160749";
                        break;

                    case R.id.radio_foot_exam_resolved_acute_joint:
                        if (checked)
                            acute_joint_exam = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_acute_joint:
                        if (checked)
                            acute_joint_exam = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_acute_joint:
                        if (checked)
                            acute_joint_exam = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_sensation_loss:
                        if (checked)
                            sensation_loss = "160749";
                        break;

                    case R.id.radio_foot_exam_resolved_sensation_loss:
                        if (checked)
                            sensation_loss = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_sensation_loss:
                        if (checked)
                            sensation_loss = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_sensation_loss:
                        if (checked)
                            sensation_loss = "165329";
                        break;


                }

                updateValues();
            }
        });

    }


    public void updateValues() {

        JSONArray jsonArry = new JSONArray();
        JSONArray jsonGroup = new JSONArray();

        JSONArray jsonArry1 = new JSONArray();
        JSONArray jsonArry2 = new JSONArray();
        JSONArray jsonArry3 = new JSONArray();
        JSONArray jsonArry4 = new JSONArray();
        JSONArray jsonArry5 = new JSONArray();
        JSONArray jsonArry6 = new JSONArray();
        JSONArray jsonArry7 = new JSONArray();
        JSONArray jsonArry8 = new JSONArray();
        JSONArray jsonArry9 = new JSONArray();
        JSONArray jsonArry10 = new JSONArray();
        JSONArray jsonArry11 = new JSONArray();

        jsonArry.put(JSONFormBuilder.observations("159460", "", "valueCoded", medication_none, DateCalendar.date(), ""));

        jsonArry1.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_metformin, DateCalendar.date(), ""));
        jsonArry2.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_glibenclamide, DateCalendar.date(), ""));
        jsonArry3.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_insulin, DateCalendar.date(), ""));
        jsonArry4.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_nph, DateCalendar.date(), ""));
        jsonArry5.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_soluble_insulin, DateCalendar.date(), ""));
        jsonArry6.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_enalapril, DateCalendar.date(), ""));
        jsonArry7.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_hctz, DateCalendar.date(), ""));
        jsonArry8.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_losartan, DateCalendar.date(), ""));
        jsonArry9.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_nifedipine, DateCalendar.date(), ""));
        jsonArry10.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_atenolol, DateCalendar.date(), ""));
        jsonArry11.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_other, DateCalendar.date(), ""));

        jsonArry1.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextMetformin.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry2.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextGlibenclamide.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry3.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextInsulin.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry4.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextNPH.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry5.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextSolubleInsulin.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry6.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextEnalapril.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry7.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextHCTZ.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry8.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextLosartan.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry9.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextNifedipine.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry10.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextAtenolol.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165157", "", "valueText", editTextMedicationOther.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165108", "", "valueCoded", adhere_medication, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165109", "", "valueText", editTextAdhereSpecify.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165146", "", "valueCoded", allergies, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165166", "", "valueText", editTextAllergySpecify.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("5088", "", "valueNumeric", editTextTemp.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5087", "", "valueNumeric", editTextPulseRate.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("5085", "", "valueNumeric", editTextSystolicOne.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5086", "", "valueNumeric", editTextDiastolicOne.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165111", "", "valueNumeric", editTextSystolicTwo.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165110", "", "valueNumeric", editTextDiastolicTwo.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("163081", "", "valueNumeric", editTextHip.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("163080", "", "valueNumeric", editTextWaist.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5090", "", "valueNumeric", editTextHeight.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5089", "", "valueNumeric", editTextWeight.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5242", "", "valueNumeric", editTextRespiratoryRate.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165190", "", "valueText", "", DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", general_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", pallor, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", jaundice, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", cyanosis, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", lymphadenopathy, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", oedema, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", dehydration, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", exam_other, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("163042", "", "valueText", editTextExamOther.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165206", "", "valueCoded", visual_impairment, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165175", "", "valueText", editTextVisual.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", cvs, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165158", "", "valueText", editTextCVS.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1123", "", "valueCoded", rs, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165159", "", "valueText", editTextRS.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("139549", "", "valueCoded", pa, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165160", "", "valueText", editTextPA.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("163109", "", "valueCoded", cns, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165161", "", "valueText", editTextCNS.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", extremities, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", ulcers, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", callouses, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", hardened_nails, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", fungus, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", cellulitis, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", edema, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", dry, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165116", "", "valueNumeric", editTextMonofilamentRF.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165117", "", "valueNumeric", editTextMonofilamentLF.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165316", "", "valueCoded", peripheral_neuropathy, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165316", "", "valueCoded", ulcers_foot, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165316", "", "valueCoded", amputation, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165316", "", "valueCoded", acute_joint, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165337", "", "valueText", editTextFootRiskComments.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", low_current_risk, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", at_risk, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", high_risk, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", ulcerated_foot, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", foot_emergency, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165339", "", "valueCoded", pedal_pulse, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165324", "", "valueCoded", peripheral_neuropathy_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165325", "", "valueCoded", deformity, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165326", "", "valueCoded", foot_ulcer, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165340", "", "valueCoded", amputation_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165327", "", "valueCoded", acute_joint_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165328", "", "valueCoded", sensation_loss, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165337", "", "valueText", editTextFootExamComments.getText().toString().trim(), DateCalendar.date(), ""));

        try {


            jsonArry = JSONFormBuilder.concatArray(jsonArry);

            JSONFormBuilder.checkLength(JSONFormBuilder.concatArray(jsonArry1), jsonGroup);
            JSONFormBuilder.checkLength(JSONFormBuilder.concatArray(jsonArry2), jsonGroup);
            JSONFormBuilder.checkLength(JSONFormBuilder.concatArray(jsonArry3), jsonGroup);
            JSONFormBuilder.checkLength(JSONFormBuilder.concatArray(jsonArry4), jsonGroup);
            JSONFormBuilder.checkLength(JSONFormBuilder.concatArray(jsonArry5), jsonGroup);
            JSONFormBuilder.checkLength(JSONFormBuilder.concatArray(jsonArry6), jsonGroup);
            JSONFormBuilder.checkLength(JSONFormBuilder.concatArray(jsonArry7), jsonGroup);
            JSONFormBuilder.checkLength(JSONFormBuilder.concatArray(jsonArry8), jsonGroup);
            JSONFormBuilder.checkLength(JSONFormBuilder.concatArray(jsonArry9), jsonGroup);
            JSONFormBuilder.checkLength(JSONFormBuilder.concatArray(jsonArry10), jsonGroup);
            JSONFormBuilder.checkLength(JSONFormBuilder.concatArray(jsonArry11), jsonGroup);

            if (jsonGroup.length() > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("groups", jsonGroup);

                jsonArry.put(jsonObject);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("JSON Initial Page 2", jsonArry.toString() + "");

        FragmentModelInitial.getInstance().initialTwo(jsonArry);
    }
}
