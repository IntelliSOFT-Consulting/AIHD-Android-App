package org.aihdint.aihd.fragments.followup;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import org.aihdint.aihd.R;
import org.aihdint.aihd.common.DateCalendar;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.aihdint.aihd.common.checkboxes.CheckBoxInterface;
import org.aihdint.aihd.common.json.JsonDrugs;
import org.aihdint.aihd.common.spinners.SpinnerInterface;
import org.aihdint.aihd.common.variables.DrugsDose;
import org.json.JSONArray;

import static org.aihdint.aihd.common.checkboxes.CheckBoxDrugs.checkBoxTreatment;
import static org.aihdint.aihd.common.spinners.SpinnerDose.spinnerDoseData;
import static org.aihdint.aihd.common.spinners.SpinnerFrequency.spinnerDataFrequency;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Followup_page_5 extends Fragment implements CheckBoxInterface, SpinnerInterface {

    private DrugsDose drugsDose;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_followup_fragment_5, container, false);

        LinearLayout testLinearLayout = view.findViewById(R.id.testLinearLayout);
        testLinearLayout.setVisibility(View.GONE);

        drugsDose = new DrugsDose(getContext());
        drugsDose.initializeDrugs(view);

        drugsDose.editTextReturnDate = view.findViewById(R.id.followup_date);
        drugsDose.editTextReferralLocation = view.findViewById(R.id.referral_place);
        drugsDose.editTextReferralDate = view.findViewById(R.id.referral_date);
        drugsDose.editTextReferralNote = view.findViewById(R.id.referral_note);
        drugsDose.editTextClinician = view.findViewById(R.id.clinician);

        DateCalendar.date(getActivity(), drugsDose.editTextReturnDate);
        DateCalendar.date(getActivity(), drugsDose.editTextReferralDate);

        textWatcher(drugsDose.editTextComment);
        textWatcher(drugsDose.editTextReturnDate);
        textWatcher(drugsDose.editTextReferralLocation);
        textWatcher(drugsDose.editTextReferralDate);
        textWatcher(drugsDose.editTextReferralNote);
        textWatcher(drugsDose.editTextClinician);

        CheckBox checkBoxMetformin = view.findViewById(R.id.treatment_metformin);
        CheckBox checkBoxGlibenclamide = view.findViewById(R.id.treatment_glibenclamide);

        CheckBox checkBoxAtenolol = view.findViewById(R.id.treatment_atenolol);
        CheckBox checkBoxLabetolol = view.findViewById(R.id.treatment_labetolol);
        CheckBox checkBoxPropranolol = view.findViewById(R.id.treatment_propranolol);
        CheckBox checkBoxCarvedilol = view.findViewById(R.id.treatment_carvedilol);
        CheckBox checkBoxNebivolol = view.findViewById(R.id.treatment_nebivolol);
        CheckBox checkBoxMetoprolol = view.findViewById(R.id.treatment_metoprolol);
        CheckBox checkBoxBisoprolol = view.findViewById(R.id.treatment_bisoprolol);

        CheckBox checkBoxAmlodipine = view.findViewById(R.id.treatment_amlodipine);
        CheckBox checkBoxFelodipine = view.findViewById(R.id.treatment_felodipine);
        CheckBox checkBoxNifedipine = view.findViewById(R.id.treatment_nifedipine);

        CheckBox checkBoxChlorthalidone = view.findViewById(R.id.treatment_chlorthalidone);
        CheckBox checkBoxHydrochlorothia = view.findViewById(R.id.treatment_hydrochlorothia);
        CheckBox checkBoxIndapamide = view.findViewById(R.id.treatment_indapamide);

        CheckBox checkBoxMethyldopa = view.findViewById(R.id.treatment_methyldopa);
        CheckBox checkBoxHydralazine = view.findViewById(R.id.treatment_hydralazine);
        CheckBox checkBoxPrazocin = view.findViewById(R.id.treatment_prazocin);

        CheckBox checkBoxInsulin = view.findViewById(R.id.treatment_insulin);
        CheckBox checkBoxSolubleInsulin = view.findViewById(R.id.treatment_soluble_insulin);
        CheckBox checkBoxNPH = view.findViewById(R.id.treatment_nph);
        CheckBox checkBoxNPH2 = view.findViewById(R.id.treatment_nph_2);

        CheckBox checkBoxDiet = view.findViewById(R.id.treatment_diet);
        CheckBox checkBoxHerbal = view.findViewById(R.id.treatment_herbal);
        CheckBox checkBoxExercise = view.findViewById(R.id.treatment_physical_exercise);
        CheckBox checkBoxOther = view.findViewById(R.id.treatment_other);

        CheckBox checkBoxContinueCare = view.findViewById(R.id.followup_continue);

        checkBoxTreatment(drugsDose, checkBoxMetformin, this);
        checkBoxTreatment(drugsDose, checkBoxGlibenclamide, this);

        checkBoxTreatment(drugsDose, drugsDose.checkBoxCaptopril, this);
        checkBoxTreatment(drugsDose, drugsDose.checkBoxEnalapril, this);
        checkBoxTreatment(drugsDose, drugsDose.checkBoxLisinopril, this);
        checkBoxTreatment(drugsDose, drugsDose.checkBoxPerindopril, this);
        checkBoxTreatment(drugsDose, drugsDose.checkBoxRamipril, this);

        checkBoxTreatment(drugsDose, drugsDose.checkBoxCandesartan, this);
        checkBoxTreatment(drugsDose, drugsDose.checkBoxIrbesartan, this);
        checkBoxTreatment(drugsDose, drugsDose.checkBoxLosartan, this);
        checkBoxTreatment(drugsDose, drugsDose.checkBoxTelmisartan, this);
        checkBoxTreatment(drugsDose, drugsDose.checkBoxValsartan, this);
        checkBoxTreatment(drugsDose, drugsDose.checkBoxOlmesartan, this);

        checkBoxTreatment(drugsDose, checkBoxAtenolol, this);
        checkBoxTreatment(drugsDose, checkBoxLabetolol, this);
        checkBoxTreatment(drugsDose, checkBoxPropranolol, this);
        checkBoxTreatment(drugsDose, checkBoxCarvedilol, this);
        checkBoxTreatment(drugsDose, checkBoxNebivolol, this);
        checkBoxTreatment(drugsDose, checkBoxMetoprolol, this);
        checkBoxTreatment(drugsDose, checkBoxBisoprolol, this);

        checkBoxTreatment(drugsDose, checkBoxAmlodipine, this);
        checkBoxTreatment(drugsDose, checkBoxFelodipine, this);
        checkBoxTreatment(drugsDose, checkBoxNifedipine, this);

        checkBoxTreatment(drugsDose, checkBoxChlorthalidone, this);
        checkBoxTreatment(drugsDose, checkBoxHydrochlorothia, this);
        checkBoxTreatment(drugsDose, checkBoxIndapamide, this);

        checkBoxTreatment(drugsDose, checkBoxMethyldopa, this);
        checkBoxTreatment(drugsDose, checkBoxHydralazine, this);
        checkBoxTreatment(drugsDose, checkBoxPrazocin, this);

        checkBoxTreatment(drugsDose, checkBoxInsulin, this);
        checkBoxTreatment(drugsDose, checkBoxSolubleInsulin, this);
        checkBoxTreatment(drugsDose, checkBoxNPH, this);
        checkBoxTreatment(drugsDose, checkBoxNPH2, this);

        checkBoxTreatment(drugsDose, checkBoxDiet, this);
        checkBoxTreatment(drugsDose, checkBoxHerbal, this);
        checkBoxTreatment(drugsDose, checkBoxExercise, this);
        checkBoxTreatment(drugsDose, checkBoxOther, this);

        checkBoxTreatment(drugsDose, checkBoxContinueCare, this);

        //SpinnerDosage
        Spinner spinnerDrugMetformin = view.findViewById(R.id.spinnerDrugMetformin);
        Spinner spinnerDrugGlibenclamide = view.findViewById(R.id.spinnerDrugGlibenclamide);

        Spinner spinnerDrugCaptopril = view.findViewById(R.id.spinnerDrugCaptopril);
        Spinner spinnerDrugEnalapril = view.findViewById(R.id.spinnerDrugEnalapril);
        Spinner spinnerDrugLisinopril = view.findViewById(R.id.spinnerDrugLisinopril);
        Spinner spinnerDrugPerindopril = view.findViewById(R.id.spinnerDrugPerindopril);
        Spinner spinnerDrugRamipril = view.findViewById(R.id.spinnerDrugRamipril);

        Spinner spinnerDrugCandesartan = view.findViewById(R.id.spinnerDrugCandesartan);
        Spinner spinnerDrugIrbesartan = view.findViewById(R.id.spinnerDrugIrbesartan);
        Spinner spinnerDrugLosartan = view.findViewById(R.id.spinnerDrugLosartan);
        Spinner spinnerDrugTelmisartan = view.findViewById(R.id.spinnerDrugTelmisartan);
        Spinner spinnerDrugValsartan = view.findViewById(R.id.spinnerDrugValsartan);
        Spinner spinnerDrugOlmesartan = view.findViewById(R.id.spinnerDrugOlmesartan);

        Spinner spinnerDrugAtenolol = view.findViewById(R.id.spinnerDrugAtenolol);
        Spinner spinnerDrugLabetolol = view.findViewById(R.id.spinnerDrugLabetolol);
        Spinner spinnerDrugPropranolol = view.findViewById(R.id.spinnerDrugPropranolol);
        Spinner spinnerDrugCarvedilol = view.findViewById(R.id.spinnerDrugCarvedilol);
        Spinner spinnerDrugNebivolol = view.findViewById(R.id.spinnerDrugNebivolol);
        Spinner spinnerDrugMetoprolol = view.findViewById(R.id.spinnerDrugMetoprolol);
        Spinner spinnerDrugBisoprolol = view.findViewById(R.id.spinnerDrugBisoprolol);

        Spinner spinnerDrugAmlodipine = view.findViewById(R.id.spinnerDrugAmlodipine);
        Spinner spinnerDrugFelodipine = view.findViewById(R.id.spinnerDrugFelodipine);
        Spinner spinnerDrugNifedipine = view.findViewById(R.id.spinnerDrugNifedipine);

        Spinner spinnerDrugChlorthalidone = view.findViewById(R.id.spinnerDrugChlorthalidone);
        Spinner spinnerDrugHydrochlorothia = view.findViewById(R.id.spinnerDrugHydrochlorothia);
        Spinner spinnerDrugIndapamide = view.findViewById(R.id.spinnerDrugIndapamide);

        Spinner spinnerDrugMethyldopa = view.findViewById(R.id.spinnerDrugMethyldopa);
        Spinner spinnerDrugHydralazine = view.findViewById(R.id.spinnerDrugHydralazine);
        Spinner spinnerDrugPrazocin = view.findViewById(R.id.spinnerDrugPrazocin);

        //Spinners Frequency
        Spinner spinnerDrugCaptoprilFrq = view.findViewById(R.id.spinnerDrugCaptoprilFrq);
        Spinner spinnerDrugEnalaprilFrq = view.findViewById(R.id.spinnerDrugEnalaprilFrq);
        Spinner spinnerDrugLisinoprilFrq = view.findViewById(R.id.spinnerDrugLisinoprilFrq);
        Spinner spinnerDrugPerindoprilFrq = view.findViewById(R.id.spinnerDrugPerindoprilFrq);
        Spinner spinnerDrugRamiprilFrq = view.findViewById(R.id.spinnerDrugRamiprilFrq);

        Spinner spinnerDrugCandesartanFrq = view.findViewById(R.id.spinnerDrugCandesartanFrq);
        Spinner spinnerDrugIrbesartanFrq = view.findViewById(R.id.spinnerDrugIrbesartanFrq);
        Spinner spinnerDrugLosartanFrq = view.findViewById(R.id.spinnerDrugLosartanFrq);
        Spinner spinnerDrugTelmisartanFrq = view.findViewById(R.id.spinnerDrugTelmisartanFrq);
        Spinner spinnerDrugValsartanFrq = view.findViewById(R.id.spinnerDrugValsartanFrq);
        Spinner spinnerDrugOlmesartanFrq = view.findViewById(R.id.spinnerDrugOlmesartanFrq);

        Spinner spinnerDrugAtenololFrq = view.findViewById(R.id.spinnerDrugAtenololFrq);
        Spinner spinnerDrugLabetololFrq = view.findViewById(R.id.spinnerDrugLabetololFrq);
        Spinner spinnerDrugPropranololFrq = view.findViewById(R.id.spinnerDrugPropranololFrq);
        Spinner spinnerDrugCarvedilolFrq = view.findViewById(R.id.spinnerDrugCarvedilolFrq);
        Spinner spinnerDrugNebivololFrq = view.findViewById(R.id.spinnerDrugNebivololFrq);
        Spinner spinnerDrugMetoprololFrq = view.findViewById(R.id.spinnerDrugMetoprololFrq);
        Spinner spinnerDrugBisoprololFrq = view.findViewById(R.id.spinnerDrugBisoprololFrq);

        Spinner spinnerDrugAmlodipineFrq = view.findViewById(R.id.spinnerDrugAmlodipineFrq);
        Spinner spinnerDrugFelodipineFrq = view.findViewById(R.id.spinnerDrugFelodipineFrq);
        Spinner spinnerDrugNifedipineFrq = view.findViewById(R.id.spinnerDrugNifedipineFrq);

        Spinner spinnerDrugChlorthalidoneFrq = view.findViewById(R.id.spinnerDrugChlorthalidoneFrq);
        Spinner spinnerDrugHydrochlorothiaFrq = view.findViewById(R.id.spinnerDrugHydrochlorothiaFrq);
        Spinner spinnerDrugIndapamideFrq = view.findViewById(R.id.spinnerDrugIndapamideFrq);

        Spinner spinnerDrugMethyldopaFrq = view.findViewById(R.id.spinnerDrugMethyldopaFrq);
        Spinner spinnerDrugHydralazineFrq = view.findViewById(R.id.spinnerDrugHydralazineFrq);
        Spinner spinnerDrugPrazocinFrq = view.findViewById(R.id.spinnerDrugPrazocinFrq);

        Spinner spinnerDrugMetforminFrq = view.findViewById(R.id.spinnerDrugMetforminFrq);
        Spinner spinnerDrugGlibenclamideFrq = view.findViewById(R.id.spinnerDrugGlibenclamideFrq);

        Spinner spinnerDrugInsulinFrq = view.findViewById(R.id.spinnerDrugInsulinFrq);
        Spinner spinnerDrugSolubleInsulinFrq = view.findViewById(R.id.spinnerDrugSolubleInsulinFrq);
        Spinner spinnerDrugNPHFrq = view.findViewById(R.id.spinnerDrugNPH1Frq);
        Spinner spinnerDrugNPH2Frq = view.findViewById(R.id.spinnerDrugNPH2Frq);

        //Set Dosage
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugCaptopril, DrugsDose.arraySpinnerCaptopril, "Captopril", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugEnalapril, DrugsDose.arraySpinnerEnalapril, "Enalapril", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugLisinopril, DrugsDose.arraySpinnerLisinopril, "Lisinopril", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugPerindopril, DrugsDose.arraySpinnerPerindopril, "Perindopril", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugRamipril, DrugsDose.arraySpinnerRamipril, "Ramipril", this);

        spinnerDoseData(getActivity(), drugsDose, spinnerDrugCandesartan, DrugsDose.arraySpinnerCandesartan, "Candesartan", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugIrbesartan, DrugsDose.arraySpinnerIrbesartan, "Irbesartan", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugLosartan, DrugsDose.arraySpinnerLosartan, "Losartan", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugTelmisartan, DrugsDose.arraySpinnerTelmisartan, "Telmisartan", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugValsartan, DrugsDose.arraySpinnerValsartan, "Valsartan", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugOlmesartan, DrugsDose.arraySpinnerOlmesartan, "Olmesartan", this);

        spinnerDoseData(getActivity(), drugsDose, spinnerDrugAtenolol, DrugsDose.arraySpinnerAtenolol, "Atenolol", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugLabetolol, DrugsDose.arraySpinnerLabetolol, "Labetolol", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugPropranolol, DrugsDose.arraySpinnerPropranolol, "Propranolol", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugCarvedilol, DrugsDose.arraySpinnerCarvedilol, "Carvedilol", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugNebivolol, DrugsDose.arraySpinnerNebivolol, "Nebivolol", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugMetoprolol, DrugsDose.arraySpinnerMetoprolol, "Metoprolol", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugBisoprolol, DrugsDose.arraySpinnerBisoprolol, "Bisoprolol", this);

        spinnerDoseData(getActivity(), drugsDose, spinnerDrugAmlodipine, DrugsDose.arraySpinnerAmlodipine, "Amlodipine", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugFelodipine, DrugsDose.arraySpinnerFelodipine, "Felodipine", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugNifedipine, DrugsDose.arraySpinnerNifedipine, "Nifedipine", this);

        spinnerDoseData(getActivity(), drugsDose, spinnerDrugChlorthalidone, DrugsDose.arraySpinnerChlorthalidone, "Chlorthalidone", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugHydrochlorothia, DrugsDose.arraySpinnerHydrochlorothia, "Hydrochlorothia", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugIndapamide, DrugsDose.arraySpinnerIndapamide, "Indapamide", this);

        spinnerDoseData(getActivity(), drugsDose, spinnerDrugMethyldopa, DrugsDose.arraySpinnerMethyldopa, "Methyldopa", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugHydralazine, DrugsDose.arraySpinnerHydralazine, "Hydralazine", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugPrazocin, DrugsDose.arraySpinnerPrazocin, "Prazocin", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugMetformin, DrugsDose.arraySpinnerMetformin, "Metformin", this);
        spinnerDoseData(getActivity(), drugsDose, spinnerDrugGlibenclamide, DrugsDose.arraySpinnerGlibenclamide, "Glibenclamide", this);

        //Spinner set Frequency
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugCaptoprilFrq, "Captopril", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugEnalaprilFrq, "Enalapril", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugLisinoprilFrq, "Lisinopril", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugPerindoprilFrq, "Perindopril", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugRamiprilFrq, "Ramipril", this);

        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugCandesartanFrq, "Candesartan", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugIrbesartanFrq, "Irbesartan", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugLosartanFrq, "Losartan", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugTelmisartanFrq, "Telmisartan", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugValsartanFrq, "Valsartan", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugOlmesartanFrq, "Olmesartan", this);

        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugAtenololFrq, "Atenolol", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugLabetololFrq, "Labetolol", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugPropranololFrq, "Propranolol", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugCarvedilolFrq, "Carvedilol", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugNebivololFrq, "Nebivolol", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugMetoprololFrq, "Metoprolol", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugBisoprololFrq, "Bisoprolol", this);

        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugAmlodipineFrq, "Amlodipine", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugFelodipineFrq, "Felodipine", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugNifedipineFrq, "Nifedipine", this);

        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugChlorthalidoneFrq, "Chlorthalidone", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugHydrochlorothiaFrq, "Hydrochlorothia", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugIndapamideFrq, "Indapamide", this);

        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugMethyldopaFrq, "Methyldopa", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugHydralazineFrq, "Hydralazine", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugPrazocinFrq, "Prazocin", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugMetforminFrq, "Metformin", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugGlibenclamideFrq, "Glibenclamide", this);

        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugInsulinFrq, "Insulin", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugSolubleInsulinFrq, "SolubleInsulin", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugNPHFrq, "NPH", this);
        spinnerDataFrequency(getContext(), drugsDose, spinnerDrugNPH2Frq, "NPH2", this);

        return view;
    }

    public void textWatcher(EditText editText) {

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(final Editable editable) {
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


    @Override
    public void checkBoxClick() {
        updateValues();
    }

    @Override
    public void spinnerClick() {
        updateValues();
    }

    public void updateValues() {

        JSONArray jsonArry = new JSONArray();

        try {
            jsonArry = JsonDrugs.jsonArrayDrugs(drugsDose, jsonArry);

            jsonArry.put(JSONFormBuilder.observations("165122", "", "valueCoded", drugsDose.continueCare, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("5096", "", "valueDate", drugsDose.editTextReturnDate.getText().toString(), DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("161562", "", "valueText", drugsDose.editTextReferralLocation.getText().toString().trim(), DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("163181", "", "valueDate", drugsDose.editTextReferralDate.getText().toString().trim(), DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("165189", "", "valueText", drugsDose.editTextReferralNote.getText().toString().trim(), DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1473", "", "valueText", drugsDose.editTextClinician.getText().toString().trim(), DateCalendar.date(), ""));


            jsonArry = JSONFormBuilder.concatArray(jsonArry);

            Log.d("JSON FollowUp Page 4", jsonArry.toString() + " ");

            FragmentModelFollowUp.getInstance().followUpFive(jsonArry);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}