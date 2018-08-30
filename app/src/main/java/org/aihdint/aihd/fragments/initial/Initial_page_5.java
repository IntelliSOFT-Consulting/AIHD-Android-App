package org.aihdint.aihd.fragments.initial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;

import org.aihdint.aihd.common.Common;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.aihdint.aihd.R;
import org.aihdint.aihd.model.KeyValue;
import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Initial_page_5 extends Fragment {

    private CheckBox checkBoxEnalapril, checkBoxCaptopril, checkBoxLisinopril, checkBoxPerindopril, checkBoxRamipril;
    private CheckBox checkBoxCandesartan, checkBoxIrbesartan, checkBoxLosartan, checkBoxTelmisartan, checkBoxValsartan, checkBoxOlmesartan;

    private String Metformin, Glibenclamide, Insulin, SolubleInsulin, NPH, Captopril, Enalapril, Lisinopril, Perindopril, Ramipril, Candesartan, Irbesartan, Losartan,
            Telmisartan, Valsartan, Olmesartan, Atenolol, Labetolol, Propranolol, Carvedilol, Nebivolol, Metoprolol, Bisoprolol, Amlodipine, Felodipine, Nifedipine,
            Chlorthalidone, Hydrochlorothia, Indapamide, Methyldopa, Hydralazine, Prazocin, Diet, PhysicalExercise, Herbal, TreatmentOther;

    private String doseMetformin, doseGlibenclamide, doseCaptopril, doseEnalapril, doseLisinopril, dosePerindopril, doseRamipril, doseCandesartan, doseIrbesartan, doseLosartan,
            doseTelmisartan, doseValsartan, doseOlmesartan, doseAtenolol, doseLabetolol, dosePropranolol, doseCarvedilol, doseNebivolol, doseMetoprolol, doseBisoprolol,
            doseAmlodipine, doseFelodipine, doseNifedipine, doseChlorthalidone, doseHydrochlorothia, doseIndapamide, doseMethyldopa, doseHydralazine, dosePrazocin;

    private String frequencyMetformin, frequencyGlibenclamide, frequencyCaptopril, frequencyEnalapril, frequencyLisinopril, frequencyPerindopril, frequencyRamipril,
            frequencyCandesartan, frequencyIrbesartan, frequencyLosartan, frequencyTelmisartan, frequencyValsartan, frequencyOlmesartan, frequencyAtenolol, frequencyLabetolol,
            frequencyPropranolol, frequencyCarvedilol, frequencyNebivolol, frequencyMetoprolol, frequencyBisoprolol, frequencyAmlodipine, frequencyFelodipine,
            frequencyNifedipine, frequencyChlorthalidone, frequencyHydrochlorothia, frequencyIndapamide, frequencyMethyldopa, frequencyHydralazine, frequencyPrazocin;

    private String urinalysis, hba, microalbumin, creatinine, potassium, ecg, treatmentTest;

    private EditText editTextDiet, editTextPhysicalExercise, editTextHerbal, editTextTreatmentOther, editTextComment;

    private String support_group, designation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_5, container, false);

        editTextDiet = view.findViewById(R.id.treatment_diet_specify);
        editTextPhysicalExercise = view.findViewById(R.id.treatment_physical_exercise_specify);
        editTextHerbal = view.findViewById(R.id.treatment_herbal_specify);
        editTextTreatmentOther = view.findViewById(R.id.treatment_other_specify);
        editTextComment = view.findViewById(R.id.treatment_comment);

        CheckBox checkBoxMetformin = view.findViewById(R.id.treatment_metformin);
        CheckBox checkBoxGlibenclamide = view.findViewById(R.id.treatment_glibenclamide);

        checkBoxEnalapril = view.findViewById(R.id.treatment_enalapril);
        checkBoxCaptopril = view.findViewById(R.id.treatment_captopril);
        checkBoxLisinopril = view.findViewById(R.id.treatment_lisinopril);
        checkBoxPerindopril = view.findViewById(R.id.treatment_perindopril);
        checkBoxRamipril = view.findViewById(R.id.treatment_ramipril);

        checkBoxCandesartan = view.findViewById(R.id.treatment_candesartan);
        checkBoxIrbesartan = view.findViewById(R.id.treatment_irbesartan);
        checkBoxLosartan = view.findViewById(R.id.treatment_losartan);
        checkBoxTelmisartan = view.findViewById(R.id.treatment_telmisartan);
        checkBoxValsartan = view.findViewById(R.id.treatment_valsartan);
        checkBoxOlmesartan = view.findViewById(R.id.treatment_olmesartan);

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

        checkBoxTreatment(checkBoxMetformin);
        checkBoxTreatment(checkBoxGlibenclamide);

        checkBoxTreatment(checkBoxCaptopril);
        checkBoxTreatment(checkBoxEnalapril);
        checkBoxTreatment(checkBoxLisinopril);
        checkBoxTreatment(checkBoxPerindopril);
        checkBoxTreatment(checkBoxRamipril);

        checkBoxTreatment(checkBoxCandesartan);
        checkBoxTreatment(checkBoxIrbesartan);
        checkBoxTreatment(checkBoxLosartan);
        checkBoxTreatment(checkBoxTelmisartan);
        checkBoxTreatment(checkBoxValsartan);
        checkBoxTreatment(checkBoxOlmesartan);

        checkBoxTreatment(checkBoxAtenolol);
        checkBoxTreatment(checkBoxLabetolol);
        checkBoxTreatment(checkBoxPropranolol);
        checkBoxTreatment(checkBoxCarvedilol);
        checkBoxTreatment(checkBoxNebivolol);
        checkBoxTreatment(checkBoxMetoprolol);
        checkBoxTreatment(checkBoxBisoprolol);

        checkBoxTreatment(checkBoxAmlodipine);
        checkBoxTreatment(checkBoxFelodipine);
        checkBoxTreatment(checkBoxNifedipine);

        checkBoxTreatment(checkBoxChlorthalidone);
        checkBoxTreatment(checkBoxHydrochlorothia);
        checkBoxTreatment(checkBoxIndapamide);

        checkBoxTreatment(checkBoxMethyldopa);
        checkBoxTreatment(checkBoxHydralazine);
        checkBoxTreatment(checkBoxPrazocin);

        CheckBox checkBoxUrinalysis = view.findViewById(R.id.treatment_urinalysis);
        CheckBox checkBoxHBA = view.findViewById(R.id.treatment_hba);
        CheckBox checkBoxMicroalbumin = view.findViewById(R.id.treatment_microalbumin);
        CheckBox checkBoxCreatinine = view.findViewById(R.id.treatment_creatinine);
        CheckBox checkBoxPotassium = view.findViewById(R.id.treatment_potassium);
        CheckBox checkBoxECG = view.findViewById(R.id.treatment_ecg);
        CheckBox checkBoxTestOther = view.findViewById(R.id.treatment_followup_other);

        checkBoxTreatment(checkBoxUrinalysis);
        checkBoxTreatment(checkBoxHBA);
        checkBoxTreatment(checkBoxMicroalbumin);
        checkBoxTreatment(checkBoxCreatinine);
        checkBoxTreatment(checkBoxPotassium);
        checkBoxTreatment(checkBoxECG);
        checkBoxTreatment(checkBoxTestOther);

        CheckBox checkBoxManagementDM = view.findViewById(R.id.followup_further_management_dm);
        CheckBox checkBoxManagementHTN = view.findViewById(R.id.followup_further_management_htn);
        CheckBox checkBoxEyeReview = view.findViewById(R.id.followup_eye_review);
        CheckBox checkBoxSurgicalReview = view.findViewById(R.id.followup_surgical_review);
        CheckBox checkBoxRenalReview = view.findViewById(R.id.followup_renal_review);
        CheckBox checkBoxCVDReview = view.findViewById(R.id.followup_cvd_review);
        CheckBox checkBoxNutrition = view.findViewById(R.id.followup_nutrition);
        CheckBox checkBoxPhysiotherapy = view.findViewById(R.id.followup_physiotherapy);
        CheckBox checkBoxFollowUpOther = view.findViewById(R.id.followup_other);

        checkBoxTreatment(checkBoxManagementDM);
        checkBoxTreatment(checkBoxManagementHTN);
        checkBoxTreatment(checkBoxEyeReview);
        checkBoxTreatment(checkBoxSurgicalReview);
        checkBoxTreatment(checkBoxRenalReview);
        checkBoxTreatment(checkBoxCVDReview);
        checkBoxTreatment(checkBoxNutrition);
        checkBoxTreatment(checkBoxPhysiotherapy);
        checkBoxTreatment(checkBoxFollowUpOther);

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

        //SpinnerDose
        String[] arraySpinnerCaptopril = new String[]{"Select", "25mg", "50mg"};
        String[] arraySpinnerEnalapril = new String[]{"Select", "10mg", "20mg "};
        String[] arraySpinnerLisinopril = new String[]{"Select", "20mg ", "40mg "};
        String[] arraySpinnerPerindopril = new String[]{"Select", "2mg ", "4mg", "5mg", "8mg", "10mg"};
        String[] arraySpinnerRamipril = new String[]{"Select", "1.25mg", "2.5mg ", "10mg "};

        String[] arraySpinnerCandesartan = new String[]{"Select", "4mg", "8mg ", "16mg", "32mg "};
        String[] arraySpinnerIrbesartan = new String[]{"Select", "75mg", "150mg ", "300mg "};
        String[] arraySpinnerLosartan = new String[]{"Select", "50mg ", "100mg "};
        String[] arraySpinnerTelmisartan = new String[]{"Select", "20mg", "40mg ", "80mg "};
        String[] arraySpinnerValsartan = new String[]{"Select", "40mg", "80mg ", "160mg ", "320mg"};
        String[] arraySpinnerOlmesartan = new String[]{"Select", "5mg", "20mg ", "40mg "};

        String[] arraySpinnerAtenolol = new String[]{"Select", "25mg ", "50mg", "100mg "};
        String[] arraySpinnerLabetolol = new String[]{"Select", "100mg", "200mg ", "300mg "};
        String[] arraySpinnerPropranolol = new String[]{"Select", "40mg ", "80mg "};
        String[] arraySpinnerCarvedilol = new String[]{"Select", "3.125mg", "6.25mg ", "12.5mg", "10mg", "20mg", "25mg ", "40mg", "80mg"};
        String[] arraySpinnerNebivolol = new String[]{"Select", "2.5mg ", "5mg ", "10mg", "20mg"};
        String[] arraySpinnerMetoprolol = new String[]{"Select", "25mg ", "37.5mg", "50mg", "75mg", "100mg ", "200mg"};
        String[] arraySpinnerBisoprolol = new String[]{"Select", "5mg ", "10mg "};

        String[] arraySpinnerAmlodipine = new String[]{"Select", "2.5mg", "5mg ", "10mg "};
        String[] arraySpinnerFelodipine = new String[]{"Select", "2.5mg", "5mg ", "10mg "};
        String[] arraySpinnerNifedipine = new String[]{"Select", "10mg ", "20mg "};

        String[] arraySpinnerChlorthalidone = new String[]{"Select", "25mg ", "50mg "};
        String[] arraySpinnerHydrochlorothia = new String[]{"Select", "12.5mg ", "25mg"};
        String[] arraySpinnerIndapamide = new String[]{"Select", "1.5mg ", "2.5mg ", "5mg "};

        String[] arraySpinnerMethyldopa = new String[]{"Select", "250mg", "500mg"};
        String[] arraySpinnerHydralazine = new String[]{"Select", "25mg ",};
        String[] arraySpinnerPrazocin = new String[]{"Select", "0.5mg ", "1mg "};

        String[] arraySpinnerMetformin = new String[]{"Select", "500mg", "850mg", "1000mg"};
        String[] arraySpinnerGlibenclamide = new String[]{"Select", "5mg",};

        spinnerDoseData(spinnerDrugCaptopril, arraySpinnerCaptopril, "Captopril");
        spinnerDoseData(spinnerDrugEnalapril, arraySpinnerEnalapril, "Enalapril");
        spinnerDoseData(spinnerDrugLisinopril, arraySpinnerLisinopril, "Lisinopril");
        spinnerDoseData(spinnerDrugPerindopril, arraySpinnerPerindopril, "Perindopril");
        spinnerDoseData(spinnerDrugRamipril, arraySpinnerRamipril, "Ramipril");

        spinnerDoseData(spinnerDrugCandesartan, arraySpinnerCandesartan, "Candesartan");
        spinnerDoseData(spinnerDrugIrbesartan, arraySpinnerIrbesartan, "Irbesartan");
        spinnerDoseData(spinnerDrugLosartan, arraySpinnerLosartan, "Losartan");
        spinnerDoseData(spinnerDrugTelmisartan, arraySpinnerTelmisartan, "Telmisartan");
        spinnerDoseData(spinnerDrugValsartan, arraySpinnerValsartan, "Valsartan");
        spinnerDoseData(spinnerDrugOlmesartan, arraySpinnerOlmesartan, "Olmesartan");

        spinnerDoseData(spinnerDrugAtenolol, arraySpinnerAtenolol, "Atenolol");
        spinnerDoseData(spinnerDrugLabetolol, arraySpinnerLabetolol, "Labetolol");
        spinnerDoseData(spinnerDrugPropranolol, arraySpinnerPropranolol, "Propranolol");
        spinnerDoseData(spinnerDrugCarvedilol, arraySpinnerCarvedilol, "Carvedilol");
        spinnerDoseData(spinnerDrugNebivolol, arraySpinnerNebivolol, "Nebivolol");
        spinnerDoseData(spinnerDrugMetoprolol, arraySpinnerMetoprolol, "Metoprolol");
        spinnerDoseData(spinnerDrugBisoprolol, arraySpinnerBisoprolol, "Bisoprolol");

        spinnerDoseData(spinnerDrugAmlodipine, arraySpinnerAmlodipine, "Amlodipine");
        spinnerDoseData(spinnerDrugFelodipine, arraySpinnerFelodipine, "Felodipine");
        spinnerDoseData(spinnerDrugNifedipine, arraySpinnerNifedipine, "Nifedipine");

        spinnerDoseData(spinnerDrugChlorthalidone, arraySpinnerChlorthalidone, "Chlorthalidone");
        spinnerDoseData(spinnerDrugHydrochlorothia, arraySpinnerHydrochlorothia, "Hydrochlorothia");
        spinnerDoseData(spinnerDrugIndapamide, arraySpinnerIndapamide, "Indapamide");

        spinnerDoseData(spinnerDrugMethyldopa, arraySpinnerMethyldopa, "Methyldopa");
        spinnerDoseData(spinnerDrugHydralazine, arraySpinnerHydralazine, "Hydralazine");
        spinnerDoseData(spinnerDrugPrazocin, arraySpinnerPrazocin, "Prazocin");
        spinnerDoseData(spinnerDrugMetformin, arraySpinnerMetformin, "Metformin");
        spinnerDoseData(spinnerDrugGlibenclamide, arraySpinnerGlibenclamide, "Glibenclamide");

        //SpinnerFrequency
        spinnerDataFrequency(spinnerDrugCaptoprilFrq, "Captopril");
        spinnerDataFrequency(spinnerDrugEnalaprilFrq, "Enalapril");
        spinnerDataFrequency(spinnerDrugLisinoprilFrq, "Lisinopril");
        spinnerDataFrequency(spinnerDrugPerindoprilFrq, "Perindopril");
        spinnerDataFrequency(spinnerDrugRamiprilFrq, "Ramipril");

        spinnerDataFrequency(spinnerDrugCandesartanFrq, "Candesartan");
        spinnerDataFrequency(spinnerDrugIrbesartanFrq, "Irbesartan");
        spinnerDataFrequency(spinnerDrugLosartanFrq, "Losartan");
        spinnerDataFrequency(spinnerDrugTelmisartanFrq, "Telmisartan");
        spinnerDataFrequency(spinnerDrugValsartanFrq, "Valsartan");
        spinnerDataFrequency(spinnerDrugOlmesartanFrq, "Olmesartan");

        spinnerDataFrequency(spinnerDrugAtenololFrq, "Atenolol");
        spinnerDataFrequency(spinnerDrugLabetololFrq, "Labetolol");
        spinnerDataFrequency(spinnerDrugPropranololFrq, "Propranolol");
        spinnerDataFrequency(spinnerDrugCarvedilolFrq, "Carvedilol");
        spinnerDataFrequency(spinnerDrugNebivololFrq, "Nebivolol");
        spinnerDataFrequency(spinnerDrugMetoprololFrq, "Metoprolol");
        spinnerDataFrequency(spinnerDrugBisoprololFrq, "Bisoprolol");

        spinnerDataFrequency(spinnerDrugAmlodipineFrq, "Amlodipine");
        spinnerDataFrequency(spinnerDrugFelodipineFrq, "Felodipine");
        spinnerDataFrequency(spinnerDrugNifedipineFrq, "Nifedipine");

        spinnerDataFrequency(spinnerDrugChlorthalidoneFrq, "Chlorthalidone");
        spinnerDataFrequency(spinnerDrugHydrochlorothiaFrq, "Hydrochlorothia");
        spinnerDataFrequency(spinnerDrugIndapamideFrq, "Indapamide");

        spinnerDataFrequency(spinnerDrugMethyldopaFrq, "Methyldopa");
        spinnerDataFrequency(spinnerDrugHydralazineFrq, "Hydralazine");
        spinnerDataFrequency(spinnerDrugPrazocinFrq, "Prazocin");
        spinnerDataFrequency(spinnerDrugMetforminFrq, "Metformin");
        spinnerDataFrequency(spinnerDrugGlibenclamideFrq, "Glibenclamide");

        Spinner spinnerSupportGroup = view.findViewById(R.id.spinnerSupportGroup);
        Spinner spinnerDesignation = view.findViewById(R.id.spinnerDesignation);

        spinnerData(spinnerSupportGroup, "support_group");
        spinnerData(spinnerDesignation, "designation");

        return view;
    }

    public void spinnerData(final Spinner spinner, final String data) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        if (data.matches("support_group")) {
            // adding each child node to HashMap key => value
            keyvalue.add(new KeyValue("", "Select Support Group"));
            keyvalue.add(new KeyValue("1065", "Yes"));
            keyvalue.add(new KeyValue("1066", "No"));
            keyvalue.add(new KeyValue("5622", "Unknown"));
        } else if (data.matches("designation")) {
            keyvalue.add(new KeyValue("", "Select Designation"));
            keyvalue.add(new KeyValue("", "Consultant"));
            keyvalue.add(new KeyValue("", "Medical officer"));
            keyvalue.add(new KeyValue("", "Clinical Officer"));
            keyvalue.add(new KeyValue("", "Nurse"));
        }

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //occupationSpinner.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue value = (KeyValue) parent.getSelectedItem();
                switch (spinner.getId()) {
                    case R.id.spinnerSupportGroup:
                        if (data.matches("support_group")) {
                            support_group = value.getId();
                        }
                        break;
                    case R.id.spinnerDesignation:
                        if (data.matches("designation")) {
                            designation = value.getId();
                        }
                        break;
                    default:
                        break;
                }
                updateValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


    public void spinnerDataFrequency(final Spinner spinner, final String drug) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        // adding each child node to HashMap key => value
        keyvalue.add(new KeyValue("", "Select"));
        keyvalue.add(new KeyValue("160862", "OD"));
        keyvalue.add(new KeyValue("160858", "BD"));
        keyvalue.add(new KeyValue("160866", "TDS"));

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //occupationSpinner.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue keyValue = (KeyValue) parent.getSelectedItem();

                if (!keyValue.getId().isEmpty()) {

                    switch (spinner.getId()) {
                        case R.id.spinnerDrugMetforminFrq:
                            if (drug.matches("Metformin")) {
                                frequencyMetformin = keyValue.getId();
                            } else {
                                frequencyMetformin = "";
                            }
                            break;
                        case R.id.spinnerDrugGlibenclamideFrq:
                            if (drug.matches("Glibenclamide")) {
                                frequencyGlibenclamide = keyValue.getId();
                            } else {
                                frequencyGlibenclamide = "";
                            }
                            break;
                        case R.id.spinnerDrugEnalaprilFrq:
                            if (drug.matches("Enalapril")) {
                                frequencyEnalapril = keyValue.getId();
                            } else {
                                frequencyEnalapril = "";
                            }
                            break;
                        case R.id.spinnerDrugCaptoprilFrq:
                            if (drug.matches("Captopril")) {
                                frequencyCaptopril = keyValue.getId();
                            } else {
                                frequencyCaptopril = "";
                            }
                            break;
                        case R.id.spinnerDrugLisinoprilFrq:
                            if (drug.matches("Lisinopril")) {
                                frequencyLisinopril = keyValue.getId();
                            } else {
                                frequencyLisinopril = "";
                            }
                            break;
                        case R.id.spinnerDrugPerindoprilFrq:
                            if (drug.matches("Perindopril")) {
                                frequencyPerindopril = keyValue.getId();
                            } else {
                                frequencyPerindopril = "";
                            }
                            break;
                        case R.id.spinnerDrugRamiprilFrq:
                            if (drug.matches("Ramipril")) {
                                frequencyRamipril = keyValue.getId();
                            } else {
                                frequencyRamipril = "";
                            }
                            break;
                        case R.id.spinnerDrugCandesartanFrq:
                            if (drug.matches("Candesartan")) {
                                frequencyCandesartan = keyValue.getId();
                            } else {
                                frequencyCandesartan = "";
                            }
                            break;
                        case R.id.spinnerDrugIrbesartanFrq:
                            if (drug.matches("Irbesartan")) {
                                frequencyIrbesartan = keyValue.getId();
                            } else {
                                frequencyIrbesartan = "";
                            }
                            break;
                        case R.id.spinnerDrugLosartanFrq:
                            if (drug.matches("Losartan")) {
                                frequencyLosartan = keyValue.getId();
                            } else {
                                frequencyLosartan = "";
                            }
                            break;
                        case R.id.spinnerDrugTelmisartanFrq:
                            if (drug.matches("Telmisartan")) {
                                frequencyTelmisartan = keyValue.getId();
                            } else {
                                frequencyTelmisartan = "";
                            }
                            break;
                        case R.id.spinnerDrugValsartanFrq:
                            if (drug.matches("Valsartan")) {
                                frequencyValsartan = keyValue.getId();
                            } else {
                                frequencyValsartan = "";
                            }
                            break;
                        case R.id.spinnerDrugOlmesartanFrq:
                            if (drug.matches("Olmesartan")) {
                                frequencyOlmesartan = keyValue.getId();
                            } else {
                                frequencyOlmesartan = "";
                            }
                            break;
                        case R.id.spinnerDrugAtenololFrq:
                            if (drug.matches("Atenolol")) {
                                frequencyAtenolol = keyValue.getId();
                            } else {
                                frequencyAtenolol = "";
                            }
                            break;
                        case R.id.spinnerDrugLabetololFrq:
                            if (drug.matches("Labetolol")) {
                                frequencyLabetolol = keyValue.getId();
                            } else {
                                frequencyLabetolol = "";
                            }
                            break;
                        case R.id.spinnerDrugPropranololFrq:
                            if (drug.matches("Propranolol")) {
                                frequencyPropranolol = keyValue.getId();
                            } else {
                                frequencyPropranolol = "";
                            }
                            break;
                        case R.id.spinnerDrugCarvedilolFrq:
                            if (drug.matches("Carvedilol")) {
                                frequencyCarvedilol = keyValue.getId();
                            } else {
                                frequencyCarvedilol = "";
                            }
                            break;
                        case R.id.spinnerDrugNebivololFrq:
                            if (drug.matches("Nebivolol")) {
                                frequencyNebivolol = keyValue.getId();
                            } else {
                                frequencyNebivolol = "";
                            }
                            break;
                        case R.id.spinnerDrugMetoprololFrq:
                            if (drug.matches("Metoprolol")) {
                                frequencyMetoprolol = keyValue.getId();
                            } else {
                                frequencyMetoprolol = "";
                            }
                            break;
                        case R.id.spinnerDrugBisoprololFrq:
                            if (drug.matches("Bisoprolol")) {
                                frequencyBisoprolol = keyValue.getId();
                            } else {
                                frequencyBisoprolol = "";
                            }
                            break;
                        case R.id.spinnerDrugAmlodipineFrq:
                            if (drug.matches("Amlodipine")) {
                                frequencyAmlodipine = keyValue.getId();
                            } else {
                                frequencyAmlodipine = "";
                            }
                            break;
                        case R.id.spinnerDrugFelodipineFrq:
                            if (drug.matches("Felodipine")) {
                                frequencyFelodipine = keyValue.getId();
                            } else {
                                frequencyFelodipine = "";
                            }
                            break;
                        case R.id.spinnerDrugNifedipineFrq:
                            if (drug.matches("Nifedipine")) {
                                frequencyNifedipine = keyValue.getId();
                            } else {
                                frequencyNifedipine = "";
                            }
                            break;
                        case R.id.spinnerDrugMethyldopaFrq:
                            if (drug.matches("Methyldopa")) {
                                frequencyMethyldopa = keyValue.getId();
                            } else {
                                frequencyMethyldopa = "";
                            }

                            break;
                        case R.id.spinnerDrugHydralazineFrq:
                            if (drug.matches("Hydralazine")) {
                                frequencyHydralazine = keyValue.getId();
                            } else {
                                frequencyHydralazine = "";
                            }
                            break;
                        case R.id.spinnerDrugPrazocinFrq:
                            if (drug.matches("Prazocin")) {
                                frequencyPrazocin = keyValue.getId();
                            } else {
                                frequencyPrazocin = "";
                            }
                            break;
                        case R.id.spinnerDrugChlorthalidoneFrq:
                            if (drug.matches("Chlorthalidone")) {
                                frequencyChlorthalidone = keyValue.getId();
                            } else {
                                frequencyChlorthalidone = "";
                            }
                            break;
                        case R.id.spinnerDrugHydrochlorothiaFrq:
                            if (drug.matches("Hydrochlorothia")) {
                                frequencyHydrochlorothia = keyValue.getId();
                            } else {
                                frequencyHydrochlorothia = "";
                            }
                            break;
                        case R.id.spinnerDrugIndapamideFrq:
                            if (drug.matches("Indapamide")) {
                                frequencyIndapamide = keyValue.getId();
                            } else {
                                frequencyIndapamide = "";
                            }
                            break;
                        default:
                            break;
                    }


                    updateValues();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }


    public void spinnerDoseData(final Spinner spinner, String[] arraySpinner, final String drug) {
        //fill data in spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, arraySpinner);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //KeyValue value = (KeyValue) parent.getSelectedItem();
                String dose = parent.getSelectedItem().toString().replace("Select", "");
                dose = dose.replace("mg", "");
                dose = dose.replaceAll("\\s+", " ");

                if (!dose.isEmpty()) {
                    Log.d("Dose", dose + " ");

                    switch (spinner.getId()) {
                        case R.id.spinnerDrugMetformin:
                            if (drug.matches("Metformin")) {
                                doseMetformin = dose;
                            } else {
                                doseMetformin = "";
                            }
                            break;
                        case R.id.spinnerDrugGlibenclamide:
                            if (drug.matches("Glibenclamide")) {
                                doseGlibenclamide = dose;
                            } else {
                                doseGlibenclamide = "";
                            }
                            break;
                        case R.id.spinnerDrugEnalapril:
                            if (drug.matches("Enalapril")) {
                                doseEnalapril = dose;
                            } else {
                                doseEnalapril = "";
                            }
                            break;
                        case R.id.spinnerDrugCaptopril:
                            if (drug.matches("Captopril")) {
                                doseCaptopril = dose;
                            } else {
                                doseCaptopril = "";
                            }
                            break;
                        case R.id.spinnerDrugLisinopril:
                            if (drug.matches("Lisinopril")) {
                                doseLisinopril = dose;
                            } else {
                                doseLisinopril = "";
                            }
                            break;
                        case R.id.spinnerDrugPerindopril:
                            if (drug.matches("Perindopril")) {
                                dosePerindopril = dose;
                            } else {
                                dosePerindopril = "";
                            }
                            break;
                        case R.id.spinnerDrugRamipril:
                            if (drug.matches("Ramipril")) {
                                doseRamipril = dose;
                            } else {
                                doseRamipril = "";
                            }
                            break;
                        case R.id.spinnerDrugCandesartan:
                            if (drug.matches("Candesartan")) {
                                doseCandesartan = dose;
                            } else {
                                doseCandesartan = "";
                            }
                            break;
                        case R.id.spinnerDrugIrbesartan:
                            if (drug.matches("Irbesartan")) {
                                doseIrbesartan = dose;
                            } else {
                                doseIrbesartan = "";
                            }
                            break;
                        case R.id.spinnerDrugLosartan:
                            if (drug.matches("Losartan")) {
                                doseLosartan = dose;
                            } else {
                                doseLosartan = "";
                            }
                            break;
                        case R.id.spinnerDrugTelmisartan:
                            if (drug.matches("Telmisartan")) {
                                doseTelmisartan = dose;
                            } else {
                                doseTelmisartan = "";
                            }
                            break;
                        case R.id.spinnerDrugValsartan:
                            if (drug.matches("Valsartan")) {
                                doseValsartan = dose;
                            } else {
                                doseValsartan = "";
                            }
                            break;
                        case R.id.spinnerDrugOlmesartan:
                            if (drug.matches("Olmesartan")) {
                                doseOlmesartan = dose;
                            } else {
                                doseOlmesartan = "";
                            }
                            break;
                        case R.id.spinnerDrugAtenolol:
                            if (drug.matches("Atenolol")) {
                                doseAtenolol = dose;
                            } else {
                                doseAtenolol = "";
                            }
                            break;
                        case R.id.spinnerDrugLabetolol:
                            if (drug.matches("Labetolol")) {
                                doseLabetolol = dose;
                            } else {
                                doseLabetolol = "";
                            }
                            break;
                        case R.id.spinnerDrugPropranolol:
                            if (drug.matches("Propranolol")) {
                                dosePropranolol = dose;
                            } else {
                                dosePropranolol = "";
                            }
                            break;
                        case R.id.spinnerDrugCarvedilol:
                            if (drug.matches("Carvedilol")) {
                                doseCarvedilol = dose;
                            } else {
                                doseCarvedilol = "";
                            }
                            break;
                        case R.id.spinnerDrugNebivolol:
                            if (drug.matches("Nebivolol")) {
                                doseNebivolol = dose;
                            } else {
                                doseNebivolol = "";
                            }
                            break;
                        case R.id.spinnerDrugMetoprolol:
                            if (drug.matches("Metoprolol")) {
                                doseMetoprolol = dose;
                            } else {
                                doseMetoprolol = "";
                            }
                            break;
                        case R.id.spinnerDrugBisoprolol:
                            if (drug.matches("Bisoprolol")) {
                                doseBisoprolol = dose;
                            } else {
                                doseBisoprolol = "";
                            }
                            break;
                        case R.id.spinnerDrugAmlodipine:
                            if (drug.matches("Amlodipine")) {
                                doseAmlodipine = dose;
                            } else {
                                doseAmlodipine = "";
                            }
                            break;
                        case R.id.spinnerDrugFelodipine:
                            if (drug.matches("Felodipine")) {
                                doseFelodipine = dose;
                            } else {
                                doseFelodipine = "";
                            }
                            break;
                        case R.id.spinnerDrugNifedipine:
                            if (drug.matches("Nifedipine")) {
                                doseNifedipine = dose;
                            } else {
                                doseNifedipine = "";
                            }
                            break;
                        case R.id.spinnerDrugMethyldopa:
                            if (drug.matches("Methyldopa")) {
                                doseMethyldopa = dose;
                            } else {
                                doseMethyldopa = "";
                            }

                            break;
                        case R.id.spinnerDrugHydralazine:
                            if (drug.matches("Hydralazine")) {
                                doseHydralazine = dose;
                            } else {
                                doseHydralazine = "";
                            }
                            break;
                        case R.id.spinnerDrugPrazocin:
                            if (drug.matches("Prazocin")) {
                                dosePrazocin = dose;
                            } else {
                                dosePrazocin = "";
                            }
                            break;
                        case R.id.spinnerDrugChlorthalidone:
                            if (drug.matches("Chlorthalidone")) {
                                doseChlorthalidone = dose;
                            } else {
                                doseChlorthalidone = "";
                            }
                            break;
                        case R.id.spinnerDrugHydrochlorothia:
                            if (drug.matches("Hydrochlorothia")) {
                                doseHydrochlorothia = dose;
                            } else {
                                doseHydrochlorothia = "";
                            }
                            break;
                        case R.id.spinnerDrugIndapamide:
                            if (drug.matches("Indapamide")) {
                                doseIndapamide = dose;
                            } else {
                                doseIndapamide = "";
                            }
                            break;
                        default:
                            break;


                    }

                    updateValues();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public void hideGroup(String group) {
        if (group.matches("ace")) {
            checkBoxCandesartan.setChecked(false);
            checkBoxIrbesartan.setChecked(false);
            checkBoxLosartan.setChecked(false);
            checkBoxTelmisartan.setChecked(false);
            checkBoxValsartan.setChecked(false);
            checkBoxOlmesartan.setChecked(false);
        } else if (group.matches("arb")) {
            checkBoxEnalapril.setChecked(false);
            checkBoxCaptopril.setChecked(false);
            checkBoxLisinopril.setChecked(false);
            checkBoxPerindopril.setChecked(false);
            checkBoxRamipril.setChecked(false);
        }

    }

    public void checkBoxTreatment(final CheckBox checkBox) {

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();

                //Check which checkbox was clicked
                switch (checkBox.getId()) {
                    case R.id.treatment_metformin:
                        if (checked) {
                            Metformin = "79651";
                        } else {
                            Metformin = "";
                        }
                        break;
                    case R.id.treatment_glibenclamide:
                        if (checked) {
                            Glibenclamide = "77071";
                        } else {
                            Glibenclamide = "";
                        }
                        break;
                    case R.id.treatment_insulin:
                        if (checked) {
                            Insulin = "159459";
                        } else {
                            Insulin = "";
                        }
                        break;
                    case R.id.treatment_soluble_insulin:
                        if (checked) {
                            SolubleInsulin = "282";
                        } else {
                            SolubleInsulin = "";
                        }
                        break;
                    case R.id.treatment_nph:
                        if (checked) {
                            NPH = "78068";
                        } else {
                            NPH = "";
                        }
                        break;
                    case R.id.treatment_captopril:
                        if (checked) {
                            Captopril = "72806";
                            hideGroup("ace");
                        } else {
                            Captopril = "";
                        }
                        break;
                    case R.id.treatment_enalapril:
                        if (checked) {
                            Enalapril = "75633";
                            hideGroup("ace");
                        } else {
                            Enalapril = "";
                        }
                        break;
                    case R.id.treatment_lisinopril:
                        if (checked) {
                            Lisinopril = "78945";
                            hideGroup("ace");
                        } else {
                            Lisinopril = "";
                        }
                        break;
                    case R.id.treatment_perindopril:
                        if (checked) {
                            Perindopril = "81822";
                            hideGroup("ace");
                        } else {
                            Perindopril = "";
                        }
                        break;
                    case R.id.treatment_ramipril:
                        if (checked) {
                            Ramipril = "83067";
                            hideGroup("ace");
                        } else {
                            Ramipril = "";
                        }
                        break;
                    case R.id.treatment_candesartan:
                        if (checked) {
                            Candesartan = "72758";
                            hideGroup("arb");
                        } else {
                            Candesartan = "";
                        }
                        break;
                    case R.id.treatment_irbesartan:
                        if (checked) {
                            Irbesartan = "78210";
                            hideGroup("arb");
                        } else {
                            Irbesartan = "";
                        }
                        break;
                    case R.id.treatment_losartan:
                        if (checked) {
                            Losartan = "79074";
                            hideGroup("arb");
                        } else {
                            Losartan = "";
                        }
                        break;
                    case R.id.treatment_telmisartan:
                        if (checked) {
                            Telmisartan = "84764";
                            hideGroup("arb");
                        } else {
                            Telmisartan = "";
                        }
                        break;
                    case R.id.treatment_valsartan:
                        if (checked) {
                            Valsartan = "86056";
                            hideGroup("arb");
                        } else {
                            Valsartan = "";
                        }
                        break;
                    case R.id.treatment_olmesartan:
                        if (checked) {
                            Olmesartan = "165229";
                            hideGroup("arb");
                        } else {
                            Olmesartan = "";
                        }
                        break;
                    case R.id.treatment_atenolol:
                        if (checked) {
                            Atenolol = "71652";
                        } else {
                            Atenolol = "";
                        }
                        break;
                    case R.id.treatment_labetolol:
                        if (checked) {
                            Labetolol = "78599";
                        } else {
                            Labetolol = "";
                        }
                        break;
                    case R.id.treatment_propranolol:
                        if (checked) {
                            Propranolol = "82732";
                        } else {
                            Propranolol = "";
                        }
                        break;
                    case R.id.treatment_carvedilol:
                        if (checked) {
                            Carvedilol = "72944";
                        } else {
                            Carvedilol = "";
                        }
                        break;
                    case R.id.treatment_nebivolol:
                        if (checked) {
                            Nebivolol = "80470";
                        } else {
                            Nebivolol = "";
                        }
                        break;
                    case R.id.treatment_metoprolol:
                        if (checked) {
                            Metoprolol = "79764";
                        } else {
                            Metoprolol = "";
                        }
                        break;
                    case R.id.treatment_bisoprolol:
                        if (checked) {
                            Bisoprolol = "72247";
                        } else {
                            Bisoprolol = "";
                        }
                        break;
                    case R.id.treatment_amlodipine:
                        if (checked) {
                            Amlodipine = "71137";
                        } else {
                            Amlodipine = "";
                        }
                        break;
                    case R.id.treatment_felodipine:
                        if (checked) {
                            Felodipine = "76211";
                        } else {
                            Felodipine = "";
                        }
                        break;
                    case R.id.treatment_nifedipine:
                        if (checked) {
                            Nifedipine = "80637";
                        } else {
                            Nifedipine = "";
                        }
                        break;
                    case R.id.treatment_methyldopa:
                        if (checked) {
                            Methyldopa = "79723";
                        } else {
                            Methyldopa = "";
                        }
                        break;
                    case R.id.treatment_hydralazine:
                        if (checked) {
                            Hydralazine = "77675";
                        } else {
                            Hydralazine = "";
                        }
                        break;
                    case R.id.treatment_prazocin:
                        if (checked) {
                            Prazocin = "77985";
                        } else {
                            Prazocin = "";
                        }
                        break;
                    case R.id.treatment_chlorthalidone:
                        if (checked) {
                            Chlorthalidone = "73338";
                        } else {
                            Chlorthalidone = "";
                        }
                        break;
                    case R.id.treatment_hydrochlorothia:
                        if (checked) {
                            Hydrochlorothia = "77696";
                        } else {
                            Hydrochlorothia = "";
                        }
                        break;
                    case R.id.treatment_indapamide:
                        if (checked) {
                            Indapamide = "77985";
                        } else {
                            Indapamide = "";
                        }
                        break;
                    case R.id.treatment_diet:
                        if (checked) {
                            Diet = "165200";
                        } else {
                            Diet = "";
                        }
                        break;
                    case R.id.treatment_physical_exercise:
                        if (checked) {
                            PhysicalExercise = "159364";
                        } else {
                            PhysicalExercise = "";
                        }
                        break;
                    case R.id.treatment_herbal:
                        if (checked) {
                            Herbal = "165203";
                        } else {
                            Herbal = "";
                        }
                        break;
                    case R.id.treatment_other:
                        if (checked) {
                            TreatmentOther = "165205";
                        } else {
                            TreatmentOther = "";
                        }
                        break;
                    case R.id.treatment_urinalysis:
                        if (checked) {
                            urinalysis = "302";
                        } else {
                            urinalysis = "";
                        }
                        break;
                    case R.id.treatment_hba:
                        if (checked) {
                            hba = "159644";
                        } else {
                            hba = "";
                        }
                        break;
                    case R.id.treatment_microalbumin:
                        if (checked) {
                            microalbumin = "164938";
                        } else {
                            microalbumin = "";
                        }
                        break;
                    case R.id.treatment_creatinine:
                        if (checked) {
                            creatinine = "1011";
                        } else {
                            creatinine = "";
                        }
                        break;
                    case R.id.treatment_potassium:
                        if (checked) {
                            potassium = "159659";
                        } else {
                            potassium = "";
                        }
                        break;
                    case R.id.treatment_ecg:
                        if (checked) {
                            ecg = "161157";
                        } else {
                            ecg = "";
                        }
                        break;
                    case R.id.treatment_followup_other:
                        if (checked) {
                            treatmentTest = "5622";
                        } else {
                            treatmentTest = "";
                        }
                        break;

                }

                updateValues();
            }
        });

    }

    public void updateValues() {

        JSONArray jsonArry = new JSONArray();

        jsonArry.put(JSONFormBuilder.observations("1282", "165280", "valueCoded", Metformin, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165280", "valueNumeric", doseMetformin, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165280", "valueCoded", frequencyMetformin, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165281", "valueCoded", Glibenclamide, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165281", "valueNumeric", doseGlibenclamide, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165281", "valueCoded", frequencyGlibenclamide, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165282", "valueCoded", Insulin, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165282", "valueText", "", Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165283", "valueCoded", SolubleInsulin, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165283", "valueText", "", Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165284", "valueCoded", NPH, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165284", "valueText", "", Common.date(), ""));

        //ACE
        jsonArry.put(JSONFormBuilder.observations("1282", "165253", "valueCoded", Captopril, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165253", "valueNumeric", doseCaptopril, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165253", "valueCoded", frequencyCaptopril, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165254", "valueCoded", Enalapril, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165254", "valueNumeric", doseEnalapril, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165254", "valueCoded", frequencyEnalapril, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165255", "valueCoded", Lisinopril, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165255", "valueNumeric", doseLisinopril, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165255", "valueCoded", frequencyLisinopril, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165256", "valueCoded", Perindopril, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165256", "valueNumeric", dosePerindopril, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165256", "valueCoded", frequencyPerindopril, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165257", "valueCoded", Ramipril, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165257", "valueNumeric", doseRamipril, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165257", "valueCoded", frequencyRamipril, Common.date(), ""));

        //ARB
        jsonArry.put(JSONFormBuilder.observations("1282", "165258", "valueCoded", Candesartan, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165258", "valueNumeric", doseCandesartan, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165258", "valueCoded", frequencyCandesartan, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165259", "valueCoded", Irbesartan, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165259", "valueNumeric", doseIrbesartan, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165259", "valueCoded", frequencyIrbesartan, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165260", "valueCoded", Losartan, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165260", "valueNumeric", doseLosartan, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165260", "valueCoded", frequencyLosartan, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165261", "valueCoded", Telmisartan, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165261", "valueNumeric", doseTelmisartan, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165261", "valueCoded", frequencyTelmisartan, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165262", "valueCoded", Valsartan, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165262", "valueNumeric", doseValsartan, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165262", "valueCoded", frequencyValsartan, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165263", "valueCoded", Olmesartan, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165263", "valueNumeric", doseOlmesartan, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165263", "valueCoded", frequencyOlmesartan, Common.date(), ""));

        //Beta Blockers
        jsonArry.put(JSONFormBuilder.observations("1282", "165264", "valueCoded", Atenolol, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165264", "valueNumeric", doseAtenolol, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165264", "valueCoded", frequencyAtenolol, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165265", "valueCoded", Labetolol, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165265", "valueNumeric", doseLabetolol, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165265", "valueCoded", frequencyLabetolol, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165266", "valueCoded", Propranolol, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165266", "valueNumeric", dosePropranolol, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165266", "valueCoded", frequencyPropranolol, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165267", "valueCoded", Carvedilol, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165267", "valueNumeric", doseCarvedilol, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165267", "valueCoded", frequencyCarvedilol, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165268", "valueCoded", Nebivolol, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165268", "valueNumeric", doseNebivolol, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165268", "valueCoded", frequencyNebivolol, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165269", "valueCoded", Metoprolol, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165269", "valueNumeric", doseMetoprolol, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165269", "valueCoded", frequencyMetoprolol, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165270", "valueCoded", Bisoprolol, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165270", "valueNumeric", doseBisoprolol, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165270", "valueCoded", frequencyBisoprolol, Common.date(), ""));

        //Long Acting CCB
        jsonArry.put(JSONFormBuilder.observations("1282", "165271", "valueCoded", Amlodipine, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165271", "valueCoded", doseAmlodipine, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165271", "valueCoded", frequencyAmlodipine, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165272", "", Felodipine, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165272", "valueNumeric", doseFelodipine, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165272", "", frequencyFelodipine, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165273", "valueCoded", Nifedipine, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165273", "valueNumeric", doseNifedipine, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165273", "valueCoded", frequencyNifedipine, Common.date(), ""));

        //AntiHypersensitives
        jsonArry.put(JSONFormBuilder.observations("1282", "165277", "valueCoded", Methyldopa, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165277", "valueNumeric", doseMethyldopa, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165277", "valueCoded", frequencyMethyldopa, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165278", "valueCoded", Hydralazine, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165278", "valueNumeric", doseHydralazine, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165278", "valueCoded", frequencyHydralazine, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165279", "valueCoded", Prazocin, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165279", "valueNumeric", dosePrazocin, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165279", "valueCoded", frequencyPrazocin, Common.date(), ""));

        //Thizide
        jsonArry.put(JSONFormBuilder.observations("1282", "165274", "valueCoded", Chlorthalidone, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165274", "valueNumeric", doseChlorthalidone, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165274", "valueCoded", frequencyChlorthalidone, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165275", "valueCoded", Hydrochlorothia, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165275", "valueNumeric", doseHydrochlorothia, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165275", "valueCoded", frequencyHydrochlorothia, Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165276", "valueCoded", Indapamide, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1443", "165276", "valueNumeric", doseIndapamide, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160855", "165276", "valueCoded", frequencyIndapamide, Common.date(), ""));

        //Other
        jsonArry.put(JSONFormBuilder.observations("1282", "165307", "valueCoded", Diet, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165201", "165307", "valueText", editTextDiet.getText().toString(), Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165308", "valueCoded", PhysicalExercise, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165202", "165308", "valueText", editTextPhysicalExercise.getText().toString(), Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165309", "valueCoded", Herbal, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165203", "165309", "valueText", editTextHerbal.getText().toString(), Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1282", "165310", "valueCoded", TreatmentOther, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165204", "165310", "valueText", editTextTreatmentOther.getText().toString(), Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("161011", "", "valueText", editTextComment.getText().toString().trim(), Common.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1271", "", "valueCoded", urinalysis, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1271", "", "valueCoded", hba, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1271", "", "valueCoded", microalbumin, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1271", "", "valueCoded", creatinine, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1271", "", "valueCoded", potassium, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1271", "", "valueCoded", ecg, Common.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1271", "", "valueCoded", treatmentTest, Common.date(), ""));

        try {
            jsonArry = JSONFormBuilder.concatArray(jsonArry);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Log.d("JSON Initial Page 5", jsonArry.toString() + " ");

        FragmentModelInitial.getInstance().initialFive(jsonArry);
    }

}
