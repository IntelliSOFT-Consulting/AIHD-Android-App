package org.aihdint.aihd.fragments.followup;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.aihdint.aihd.R;
import org.aihdint.aihd.common.DateCalendar;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.json.JSONArray;
import org.json.JSONException;

import static java.lang.Double.parseDouble;
import static org.aihdint.aihd.common.Common.checkAlert;
import static org.aihdint.aihd.forms.DM_Initial.gender;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Followup_page_4 extends Fragment {

    private View view;
    private EditText editTextRBS, editTextFBC, editTextHBA, editTextUrea, editTextSodium, editTextChloride, editTextPotassium, editTextCreatinine, editTextHDL, editTextLDL, editTextCholesterol,
            editTextTriglcerides, editTextAST, editTextALT, editTextTotalBilirubin, editTextDirectBilirubin, editTextGamma;

    private EditText editTextRBSDate;
    private EditText editTextFBCDate;
    private EditText editTextHBADate;
    private EditText editTextUreaDate;
    private EditText editTextSodiumDate;
    private EditText editTextChlorideDate;
    private EditText editTextPotassiumDate;
    private EditText editTextCreatinineDate;
    private EditText editTextHDLDate;
    private EditText editTextLDLDate;
    private EditText editTextCholesterolDate;
    private EditText editTextTriglceridesDate;
    private EditText editTextASTDate;
    private EditText editTextALTDate;
    private EditText editTextTotalBilirubinDate;
    private EditText editTextDirectBilirubinDate;
    private EditText editTextGammaDate;
    private EditText editTextGlucoseDate;
    private EditText editTextKetoneDate;
    private EditText editTextDeposits;
    private EditText editTextDepositsDate;
    private EditText editTextECGDate;
    private EditText editTextCXRDate;
    private EditText editTextUltraSound;
    private EditText editTextPDT;
    private EditText editTextPDTDate;

    private RadioGroup radioGroupGlucose, radioGroupProtein, radioGroupKetone;

    private String glucose, glucose_plus, protein, protein_plus, ketone, ketone_plus, ecg, cxr;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dm_followup_fragment_5, container, false);

        LinearLayout pdt = view.findViewById(R.id.linearLayoutPDT);

        if (gender != null && gender.equals("F")) {
            pdt.setVisibility(View.VISIBLE);
        }

        editTextRBS = view.findViewById(R.id.blood_work_rbs);
        editTextFBC = view.findViewById(R.id.blood_work_fbc);
        editTextHBA = view.findViewById(R.id.blood_work_hba);
        editTextUrea = view.findViewById(R.id.blood_work_urea);
        editTextSodium = view.findViewById(R.id.blood_work_sodium);
        editTextChloride = view.findViewById(R.id.blood_work_chloride);
        editTextPotassium = view.findViewById(R.id.blood_work_potassium);
        editTextCreatinine = view.findViewById(R.id.blood_work_creatinine);
        editTextHDL = view.findViewById(R.id.blood_work_hdl);
        editTextLDL = view.findViewById(R.id.blood_work_ldl);
        editTextCholesterol = view.findViewById(R.id.blood_work_cholesterol);
        editTextTriglcerides = view.findViewById(R.id.blood_work_triglycerides);
        editTextAST = view.findViewById(R.id.blood_work_ast);
        editTextALT = view.findViewById(R.id.blood_work_alt);
        editTextTotalBilirubin = view.findViewById(R.id.blood_work_bilirubin);
        editTextDirectBilirubin = view.findViewById(R.id.blood_work_direct_bilirubin);
        editTextGamma = view.findViewById(R.id.blood_work_gamma);

        editTextDeposits = view.findViewById(R.id.deposit_comment);
        editTextPDT = view.findViewById(R.id.comment_pdt);

        editTextRBSDate = view.findViewById(R.id.datetime_rbs);
        editTextFBCDate = view.findViewById(R.id.datetime_fbc);
        editTextHBADate = view.findViewById(R.id.datetime_hba);
        editTextUreaDate = view.findViewById(R.id.datetime_urea);
        editTextSodiumDate = view.findViewById(R.id.datetime_sodium);
        editTextChlorideDate = view.findViewById(R.id.datetime_chloride);
        editTextPotassiumDate = view.findViewById(R.id.datetime_potassium);
        editTextCreatinineDate = view.findViewById(R.id.datetime_creatinine);
        editTextHDLDate = view.findViewById(R.id.datetime_hdl);
        editTextLDLDate = view.findViewById(R.id.datetime_ldl);
        editTextCholesterolDate = view.findViewById(R.id.datetime_cholesterol);
        editTextTriglceridesDate = view.findViewById(R.id.datetime_triglycerides);
        editTextASTDate = view.findViewById(R.id.datetime_ast);
        editTextALTDate = view.findViewById(R.id.datetime_alt);
        editTextTotalBilirubinDate = view.findViewById(R.id.datetime_bilirubin);
        editTextDirectBilirubinDate = view.findViewById(R.id.datetime_direct_bilirubin);
        editTextGammaDate = view.findViewById(R.id.datetime_gamma);
        editTextUltraSound = view.findViewById(R.id.datetime_ultrasound);
        editTextPDTDate = view.findViewById(R.id.datetime_pdt);
        editTextGlucoseDate = view.findViewById(R.id.datetime_urinalysis_glucose);
        EditText editTextProteinDate = view.findViewById(R.id.datetime_urinalysis_protein);
        editTextKetoneDate = view.findViewById(R.id.datetime_urinalysis_ketone);
        editTextDepositsDate = view.findViewById(R.id.datetime_urinalysis_deposit);
        editTextECGDate = view.findViewById(R.id.datetime_ecg);
        editTextCXRDate = view.findViewById(R.id.datetime_cxr);

        editTextRBSDate.setText(DateCalendar.date());
        editTextFBCDate.setText(DateCalendar.date());
        editTextHBADate.setText(DateCalendar.date());
        editTextUreaDate.setText(DateCalendar.date());
        editTextSodiumDate.setText(DateCalendar.date());
        editTextChlorideDate.setText(DateCalendar.date());
        editTextPotassiumDate.setText(DateCalendar.date());
        editTextCreatinineDate.setText(DateCalendar.date());
        editTextHDLDate.setText(DateCalendar.date());
        editTextLDLDate.setText(DateCalendar.date());
        editTextCholesterolDate.setText(DateCalendar.date());
        editTextTriglceridesDate.setText(DateCalendar.date());
        editTextASTDate.setText(DateCalendar.date());
        editTextALTDate.setText(DateCalendar.date());
        editTextTotalBilirubinDate.setText(DateCalendar.date());
        editTextDirectBilirubinDate.setText(DateCalendar.date());
        editTextGammaDate.setText(DateCalendar.date());
        editTextGlucoseDate.setText(DateCalendar.date());
        editTextProteinDate.setText(DateCalendar.date());
        editTextKetoneDate.setText(DateCalendar.date());
        editTextDepositsDate.setText(DateCalendar.date());
        editTextECGDate.setText(DateCalendar.date());
        editTextCXRDate.setText(DateCalendar.date());

        DateCalendar.fulldate(getActivity(), editTextRBSDate);
        DateCalendar.fulldate(getActivity(), editTextFBCDate);
        DateCalendar.fulldate(getActivity(), editTextHBADate);
        DateCalendar.fulldate(getActivity(), editTextUreaDate);
        DateCalendar.fulldate(getActivity(), editTextSodiumDate);
        DateCalendar.fulldate(getActivity(), editTextChlorideDate);
        DateCalendar.fulldate(getActivity(), editTextPotassiumDate);
        DateCalendar.fulldate(getActivity(), editTextCreatinineDate);
        DateCalendar.fulldate(getActivity(), editTextHDLDate);
        DateCalendar.fulldate(getActivity(), editTextLDLDate);
        DateCalendar.fulldate(getActivity(), editTextCholesterolDate);
        DateCalendar.fulldate(getActivity(), editTextTriglceridesDate);
        DateCalendar.fulldate(getActivity(), editTextASTDate);
        DateCalendar.fulldate(getActivity(), editTextALTDate);
        DateCalendar.fulldate(getActivity(), editTextTotalBilirubinDate);
        DateCalendar.fulldate(getActivity(), editTextDirectBilirubinDate);
        DateCalendar.fulldate(getActivity(), editTextGammaDate);
        DateCalendar.fulldate(getActivity(), editTextUltraSound);
        DateCalendar.fulldate(getActivity(), editTextPDTDate);
        DateCalendar.fulldate(getActivity(), editTextGlucoseDate);
        DateCalendar.fulldate(getActivity(), editTextProteinDate);
        DateCalendar.fulldate(getActivity(), editTextKetoneDate);
        DateCalendar.fulldate(getActivity(), editTextDepositsDate);
        DateCalendar.fulldate(getActivity(), editTextECGDate);
        DateCalendar.fulldate(getActivity(), editTextCXRDate);

        textWatcher(editTextRBS, "rbs");
        textWatcher(editTextFBC, "fbc");
        textWatcher(editTextHBA, "hba");
        textWatcher(editTextUrea, "urea");
        textWatcher(editTextSodium, "sodium");
        textWatcher(editTextChloride, "chloride");
        textWatcher(editTextPotassium, "potassium");
        textWatcher(editTextCreatinine, "creatinine");
        textWatcher(editTextHDL, "hdl");
        textWatcher(editTextLDL, "ldl");
        textWatcher(editTextCholesterol, "cholesterol");
        textWatcher(editTextTriglcerides, "triglcerides");
        textWatcher(editTextAST, "ast");
        textWatcher(editTextALT, "alt");
        textWatcher(editTextTotalBilirubin, "tbilirubin");
        textWatcher(editTextDirectBilirubin, "dbilirubin");
        textWatcher(editTextGamma, "gamma");
        textWatcher(editTextDeposits, "");
        textWatcher(editTextPDT, "");

        textWatcher(editTextRBSDate, "");
        textWatcher(editTextFBCDate, "");
        textWatcher(editTextHBADate, "");
        textWatcher(editTextUreaDate, "");
        textWatcher(editTextSodiumDate, "");
        textWatcher(editTextChlorideDate, "");
        textWatcher(editTextPotassiumDate, "");
        textWatcher(editTextCreatinineDate, "");
        textWatcher(editTextHDLDate, "");
        textWatcher(editTextLDLDate, "");
        textWatcher(editTextCholesterolDate, "");
        textWatcher(editTextTriglceridesDate, "");
        textWatcher(editTextASTDate, "");
        textWatcher(editTextALTDate, "");
        textWatcher(editTextTotalBilirubinDate, "");
        textWatcher(editTextDirectBilirubinDate, "");
        textWatcher(editTextGammaDate, "");
        textWatcher(editTextUltraSound, "");
        textWatcher(editTextPDTDate, "");
        textWatcher(editTextGlucoseDate, "");
        textWatcher(editTextProteinDate, "");
        textWatcher(editTextKetoneDate, "");
        textWatcher(editTextDepositsDate, "");
        textWatcher(editTextECGDate, "");
        textWatcher(editTextCXRDate, "");

        radioGroupGlucose = view.findViewById(R.id.radiogroup_glucose);
        radioGroupProtein = view.findViewById(R.id.radiogroup_protein);
        radioGroupKetone = view.findViewById(R.id.radiogroup_ketone);

        RadioButton radioButtonGlucoseYes = view.findViewById(R.id.radio_glucose_yes);
        RadioButton radioButtonGlucoseNo = view.findViewById(R.id.radio_glucose_no);
        RadioButton radioButtonGlucose1 = view.findViewById(R.id.radio_glucose_plus);
        RadioButton radioButtonGlucose2 = view.findViewById(R.id.radio_glucose_plus2);
        RadioButton radioButtonGlucose3 = view.findViewById(R.id.radio_glucose_plus3);
        RadioButton radioButtonProteinYes = view.findViewById(R.id.radio_protein_yes);
        RadioButton radioButtonProteinNo = view.findViewById(R.id.radio_protein_no);
        RadioButton radioButtonProtein1 = view.findViewById(R.id.radio_protein_plus);
        RadioButton radioButtonProtein2 = view.findViewById(R.id.radio_protein_plus2);
        RadioButton radioButtonProtein3 = view.findViewById(R.id.radio_protein_plus3);
        RadioButton radioButtonKetoneYes = view.findViewById(R.id.radio_ketone_yes);
        RadioButton radioButtonKetoneNo = view.findViewById(R.id.radio_ketone_no);
        RadioButton radioButtonKetone1 = view.findViewById(R.id.radio_ketone_plus);
        RadioButton radioButtonKetone2 = view.findViewById(R.id.radio_ketone_plus2);
        RadioButton radioButtonKetone3 = view.findViewById(R.id.radio_ketone_plus3);
        RadioButton radioButtonECGNormal = view.findViewById(R.id.radio_ecg_normal);
        RadioButton radioButtonECGAbnormal = view.findViewById(R.id.radio_ecg_abnormal);
        RadioButton radioButtonCXRNormal = view.findViewById(R.id.radio_cxr_normal);
        RadioButton radioButtonCXRAbnormal = view.findViewById(R.id.radio_cxr_abnormal);

        radioButton(radioButtonGlucoseYes);
        radioButton(radioButtonGlucoseNo);
        radioButton(radioButtonGlucose1);
        radioButton(radioButtonGlucose2);
        radioButton(radioButtonGlucose3);
        radioButton(radioButtonProteinYes);
        radioButton(radioButtonProteinNo);
        radioButton(radioButtonProtein1);
        radioButton(radioButtonProtein2);
        radioButton(radioButtonProtein3);
        radioButton(radioButtonKetoneYes);
        radioButton(radioButtonKetoneNo);
        radioButton(radioButtonKetone1);
        radioButton(radioButtonKetone2);
        radioButton(radioButtonKetone3);
        radioButton(radioButtonECGNormal);
        radioButton(radioButtonECGAbnormal);
        radioButton(radioButtonCXRNormal);
        radioButton(radioButtonCXRAbnormal);

        return view;
    }

    public void textWatcher(final EditText editText, final String field) {

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(final Editable editable) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (editText.length() > 0 && !field.matches("")) {

                            double value = parseDouble(editable.toString().trim());
                            checkAlert(view, value, field);
                        }
                    }
                }, 3000);

                updateValues();
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



    public void urinalysisGlucose(String status) {
        if (status.matches("1066")) {
            radioGroupGlucose.setVisibility(View.GONE);
        } else {
            radioGroupGlucose.setVisibility(View.VISIBLE);
        }
    }

    public void urinalysisProtein(String status) {
        if (status.matches("1066")) {
            radioGroupProtein.setVisibility(View.GONE);
        } else {
            radioGroupProtein.setVisibility(View.VISIBLE);
        }
    }

    public void urinalysisKetone(String status) {
        if (status.matches("1066")) {
            radioGroupKetone.setVisibility(View.GONE);
        } else {
            radioGroupKetone.setVisibility(View.VISIBLE);
        }
    }

    public void radioButton(final RadioButton radioButton) {

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Is the button now checked?
                boolean checked = (buttonView).isChecked();

                // Check which radio button was clicked
                switch (radioButton.getId()) {
                    case R.id.radio_glucose_yes:
                        if (checked)
                            glucose = "1065";
                        urinalysisGlucose(glucose);
                        break;
                    case R.id.radio_glucose_no:
                        if (checked)
                            glucose = "1066";
                        urinalysisGlucose(glucose);
                        break;
                    case R.id.radio_glucose_plus:
                        if (checked)
                            glucose_plus = "1362";
                        break;
                    case R.id.radio_glucose_plus2:
                        if (checked)
                            glucose_plus = "1363";
                        break;
                    case R.id.radio_glucose_plus3:
                        if (checked)
                            glucose_plus = "1364";
                        break;
                    case R.id.radio_protein_yes:
                        if (checked)
                            protein = "1065";
                        urinalysisProtein(protein);
                        break;
                    case R.id.radio_protein_no:
                        if (checked)
                            protein = "1066";
                        urinalysisProtein(protein);
                        break;
                    case R.id.radio_protein_plus:
                        if (checked)
                            protein_plus = "1362";
                        break;
                    case R.id.radio_protein_plus2:
                        if (checked)
                            protein_plus = "1363";
                        break;
                    case R.id.radio_protein_plus3:
                        if (checked)
                            protein_plus = "1364";
                        break;
                    case R.id.radio_ketone_yes:
                        if (checked)
                            ketone = "1065";
                        urinalysisKetone(ketone);
                        break;
                    case R.id.radio_ketone_no:
                        if (checked)
                            ketone = "1066";
                        urinalysisKetone(ketone);
                        break;
                    case R.id.radio_ketone_plus:
                        if (checked)
                            ketone_plus = "1362";
                        break;
                    case R.id.radio_ketone_plus2:
                        if (checked)
                            ketone_plus = "1363";
                        break;
                    case R.id.radio_ketone_plus3:
                        if (checked)
                            ketone_plus = "1364";
                        break;
                    case R.id.radio_ecg_normal:
                        if (checked)
                            ecg = "1115";
                        break;
                    case R.id.radio_ecg_abnormal:
                        if (checked)
                            ecg = "1116";
                        break;
                    case R.id.radio_cxr_normal:
                        if (checked)
                            cxr = "1115";
                        break;
                    case R.id.radio_cxr_abnormal:
                        if (checked)
                            cxr = "1116";
                        break;
                }

                updateValues();
            }
        });

    }


    public void updateValues() {

        JSONArray jsonArry = new JSONArray();

        jsonArry.put(JSONFormBuilder.observations("887", "", "valueNumeric", editTextRBS.getText().toString().trim(), editTextRBSDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("160912", "", "valueNumeric", editTextFBC.getText().toString().trim(), editTextFBCDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("159644", "", "valueNumeric", editTextHBA.getText().toString().trim(), editTextHBADate.getText().toString().trim(), ""));

        jsonArry.put(JSONFormBuilder.observations("165297", "", "valueNumeric", editTextUrea.getText().toString().trim(), editTextUreaDate.getText().toString().trim(), ""));

        jsonArry.put(JSONFormBuilder.observations("165298", "", "valueNumeric", editTextSodium.getText().toString().trim(), editTextSodiumDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("165299", "", "valueNumeric", editTextChloride.getText().toString().trim(), editTextChlorideDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("165300", "", "valueNumeric", editTextPotassium.getText().toString().trim(), editTextPotassiumDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("164364", "", "valueNumeric", editTextCreatinine.getText().toString().trim(), editTextCreatinineDate.getText().toString().trim(), ""));

        jsonArry.put(JSONFormBuilder.observations("1007", "", "valueNumeric", editTextHDL.getText().toString().trim(), editTextHDLDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("1008", "", "valueNumeric", editTextLDL.getText().toString().trim(), editTextLDLDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("1006", "", "valueNumeric", editTextCholesterol.getText().toString().trim(), editTextCholesterolDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("1009", "", "valueNumeric", editTextTriglcerides.getText().toString().trim(), editTextTriglceridesDate.getText().toString().trim(), ""));

        jsonArry.put(JSONFormBuilder.observations("653", "", "valueNumeric", editTextAST.getText().toString().trim(), editTextASTDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("654", "", "valueNumeric", editTextALT.getText().toString().trim(), editTextALTDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("655", "", "valueNumeric", editTextTotalBilirubin.getText().toString().trim(), editTextTotalBilirubinDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("1297", "", "valueNumeric", editTextDirectBilirubin.getText().toString().trim(), editTextDirectBilirubinDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("159829", "", "valueNumeric", editTextGamma.getText().toString().trim(), editTextGammaDate.getText().toString().trim(), ""));

        jsonArry.put(JSONFormBuilder.observations("159733", "", "valueCoded", glucose, editTextGlucoseDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("159733", "", "valueCoded", glucose_plus, editTextGlucoseDate.getText().toString().trim(), ""));

        jsonArry.put(JSONFormBuilder.observations("128340", "", "valueCoded", protein, editTextGlucoseDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("128340", "", "valueCoded", protein_plus, editTextGlucoseDate.getText().toString().trim(), ""));

        jsonArry.put(JSONFormBuilder.observations("161442", "", "valueCoded", ketone, editTextKetoneDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("161442", "", "valueCoded", ketone_plus, editTextKetoneDate.getText().toString().trim(), ""));

        jsonArry.put(JSONFormBuilder.observations("165121", "", "valueText", editTextDeposits.getText().toString().trim(), editTextDepositsDate.getText().toString().trim(), ""));

        jsonArry.put(JSONFormBuilder.observations("159565", "", "valueCoded", ecg, editTextECGDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("12", "", "valueCoded", cxr, editTextCXRDate.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("165302", "", "valueText", editTextUltraSound.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165312", "", "valueText", editTextPDT.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165144", "", "valueDate", editTextPDTDate.getText().toString().trim(), DateCalendar.date(), ""));

        try {
            jsonArry = JSONFormBuilder.concatArray(jsonArry);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Log.d("JSON Initial Page 3", jsonArry.toString() + " ");

        FragmentModelFollowUp.getInstance().followUpFour(jsonArry);
    }

}