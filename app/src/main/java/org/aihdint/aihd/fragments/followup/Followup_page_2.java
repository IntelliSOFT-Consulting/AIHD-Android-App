package org.aihdint.aihd.fragments.followup;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

import org.aihdint.aihd.R;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Followup_page_2 extends Fragment {

    private String urination, thirst, hunger, weight_loss, fatigue, vision, impotence, numbness, cough, fever, noticable_weight_loss, night_sweats, indicator_history;
    private String sputum, gene, chest_xray, antiTB, invitation_contacts, eval_IPT;
    private EditText editTextUrination, editTextThirst, editTextHunger, editTextWeightLoss, editTextFatigue, editTextVision, editTextImpotence, editTextNumbness;
    private EditText editTextCough, editTextFever, editTextNoticableWeightLoss, editTextNightSweats;
    private EditText editTextSputum, editTextGene, editTextXray, editTextAntiTB, editTextInviteContact, editTextIPT;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_followup_fragment_2, container, false);

        urination = thirst = hunger = weight_loss = fatigue = vision = impotence = numbness =
                cough = fever = noticable_weight_loss = night_sweats = indicator_history =
                        sputum = gene = chest_xray = antiTB = invitation_contacts = eval_IPT = "";
        CheckBox checkBoxUrination = view.findViewById(R.id.checkbox_frequent_urinations);
        CheckBox checkBoxThirst = view.findViewById(R.id.checkbox_excessive_thirst);
        CheckBox checkBoxHunger = view.findViewById(R.id.checkbox_extreme_hunger);
        CheckBox checkBoxWeightLoss = view.findViewById(R.id.checkbox_unexplained_weight_loss);
        CheckBox checkBoxFatigue = view.findViewById(R.id.checkbox_increased_fatigue);
        CheckBox checkBoxVision = view.findViewById(R.id.checkbox_blurred_vision);
        CheckBox checkBoxImpotence = view.findViewById(R.id.checkbox_impotence);
        CheckBox checkBoxNumbness = view.findViewById(R.id.checkbox_numbness);

        CheckBox checkBoxCough = view.findViewById(R.id.checkbox_cough_duration);
        CheckBox checkBoxFever = view.findViewById(R.id.checkbox_fever);
        CheckBox checkBoxNoticableWeightLoss = view.findViewById(R.id.checkbox_noticable_weight_loss);
        CheckBox checkBoxNightSweats = view.findViewById(R.id.checkbox_night_sweats);

        checkBox(checkBoxUrination);
        checkBox(checkBoxThirst);
        checkBox(checkBoxHunger);
        checkBox(checkBoxWeightLoss);
        checkBox(checkBoxFatigue);
        checkBox(checkBoxVision);
        checkBox(checkBoxImpotence);
        checkBox(checkBoxNumbness);

        checkBox(checkBoxCough);
        checkBox(checkBoxFever);
        checkBox(checkBoxNoticableWeightLoss);
        checkBox(checkBoxNightSweats);

        editTextUrination = view.findViewById(R.id.frequent_urinations);
        editTextThirst = view.findViewById(R.id.excessive_thirst);
        editTextHunger = view.findViewById(R.id.extreme_hunger);
        editTextWeightLoss = view.findViewById(R.id.unexplained_weight_loss);
        editTextFatigue = view.findViewById(R.id.increased_fatigue);
        editTextVision = view.findViewById(R.id.blurred_vision);
        editTextImpotence = view.findViewById(R.id.impotence);
        editTextNumbness = view.findViewById(R.id.numbness);

        editTextCough = view.findViewById(R.id.cough);
        editTextFever = view.findViewById(R.id.fever);
        editTextNoticableWeightLoss = view.findViewById(R.id.noticable_weight_loss);
        editTextNightSweats = view.findViewById(R.id.night_sweats);


        editTextSputum = view.findViewById(R.id.date_sputum);
        editTextGene = view.findViewById(R.id.date_gene);
        editTextXray = view.findViewById(R.id.date_chest_xray);
        editTextAntiTB = view.findViewById(R.id.date_antiTB);
        editTextInviteContact = view.findViewById(R.id.date_invite_contacts);
        editTextIPT = view.findViewById(R.id.date_eval_IPT);

        RadioButton radioButtonIndicatorHistoryYes = view.findViewById(R.id.radio_history_contact_yes);
        RadioButton radioButtonIndicatorHistoryNo = view.findViewById(R.id.radio_history_contact_no);
        RadioButton radioButtonSputumYes = view.findViewById(R.id.radio_sputum_positive);
        RadioButton radioButtonSputumNo = view.findViewById(R.id.radio_sputum_negative);
        RadioButton radioButtonGeneYes = view.findViewById(R.id.radio_gene_positive);
        RadioButton radioButtonGeneNo = view.findViewById(R.id.radio_gene_negative);
        RadioButton radioButtonXrayYes = view.findViewById(R.id.radio_chest_normal);
        RadioButton radioButtonXrayNo = view.findViewById(R.id.radio_chest_suggestive);
        RadioButton radioButtonAntiTBYes = view.findViewById(R.id.radio_antiTB_yes);
        RadioButton radioButtonAntiTBNo = view.findViewById(R.id.radio_antiTB_no);
        RadioButton radioButtonInviteContactsYes = view.findViewById(R.id.radio_invite_contacts_yes);
        RadioButton radioButtonInviteContactsNo = view.findViewById(R.id.radio_invite_contacts_no);
        RadioButton radioButtonIPTYes = view.findViewById(R.id.radio_eval_IPT_yes);
        RadioButton radioButtonIPTNo = view.findViewById(R.id.radio_eval_IPT_no);

        radioButtonClicked(radioButtonIndicatorHistoryYes);
        radioButtonClicked(radioButtonIndicatorHistoryNo);
        radioButtonClicked(radioButtonSputumYes);
        radioButtonClicked(radioButtonSputumNo);
        radioButtonClicked(radioButtonGeneYes);
        radioButtonClicked(radioButtonGeneNo);
        radioButtonClicked(radioButtonXrayYes);
        radioButtonClicked(radioButtonXrayNo);
        radioButtonClicked(radioButtonAntiTBYes);
        radioButtonClicked(radioButtonAntiTBNo);
        radioButtonClicked(radioButtonInviteContactsYes);
        radioButtonClicked(radioButtonInviteContactsNo);
        radioButtonClicked(radioButtonIPTYes);
        radioButtonClicked(radioButtonIPTNo);


        return view;
    }




    public void radioButtonClicked(final RadioButton radioButton) {

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();
                switch (radioButton.getId()) {
                    case R.id.radio_history_contact_yes:
                        if (checked) {
                            indicator_history = "1065";
                        }
                        break;
                    case R.id.radio_history_contact_no:
                        if (checked) {
                            indicator_history = "1066";
                        }
                        break;
                    case R.id.radio_sputum_positive:
                        if (checked) {
                            sputum = "703";
                        }
                        break;
                    case R.id.radio_sputum_negative:
                        if (checked) {
                            sputum = "644";
                        }
                        break;
                    case R.id.radio_gene_positive:
                        if (checked) {
                            gene = "703";
                        }
                        break;
                    case R.id.radio_gene_negative:
                        if (checked) {
                            gene = "1066";
                        }
                        break;
                    case R.id.radio_chest_normal:
                        if (checked) {
                            chest_xray = "1115";
                        }
                        break;
                    case R.id.radio_chest_suggestive:
                        if (checked) {
                            chest_xray = "165152";
                        }
                        break;
                    case R.id.radio_antiTB_yes:
                        if (checked) {
                            antiTB = "1065";
                        }
                        break;
                    case R.id.radio_antiTB_no:
                        if (checked) {
                            antiTB = "1066";
                        }
                        break;
                    case R.id.radio_invite_contacts_yes:
                        if (checked) {
                            invitation_contacts = "1065";
                        }
                        break;
                    case R.id.radio_invite_contacts_no:
                        if (checked) {
                            invitation_contacts = "1066";
                        }
                        break;
                    case R.id.radio_eval_IPT_yes:
                        if (checked) {
                            eval_IPT = "1065";
                        }
                        break;
                    case R.id.radio_eval_IPT_no:
                        if (checked) {
                            eval_IPT = "1066";
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
                    case R.id.checkbox_frequent_urinations:
                        if (checked) {
                            urination = "137593";
                        } else {
                            urination = "";
                        }
                        break;
                    case R.id.checkbox_excessive_thirst:
                        if (checked) {
                            thirst = "140939";
                        } else {
                            thirst = "";
                        }
                        break;
                    case R.id.checkbox_extreme_hunger:
                        if (checked) {
                            hunger = "165095";
                        } else {
                            hunger = "";
                        }
                        break;
                    case R.id.checkbox_unexplained_weight_loss:
                        if (checked) {
                            weight_loss = "159214";
                        } else {
                            weight_loss = "";
                        }
                        break;
                    case R.id.checkbox_increased_fatigue:
                        if (checked) {
                            fatigue = "165096";
                        } else {
                            fatigue = "";
                        }
                        updateValues();
                        break;
                    case R.id.checkbox_blurred_vision:
                        if (checked) {
                            vision = "147104";
                        } else {
                            vision = "";
                        }
                        updateValues();
                        break;
                    case R.id.checkbox_impotence:
                        if (checked) {
                            impotence = "137679";
                        } else {
                            impotence = "";
                        }
                        break;
                    case R.id.checkbox_numbness:
                        if (checked) {
                            numbness = "165097";
                        } else {
                            numbness = "";
                        }
                        break;
                    case R.id.checkbox_cough_duration:
                        if (checked) {
                            cough = "159799";
                        } else {
                            cough = "";
                        }
                        break;
                    case R.id.checkbox_fever:
                        if (checked) {
                            fever = "140238";
                        } else {
                            fever = "";
                        }
                        break;
                    case R.id.checkbox_noticable_weight_loss:
                        if (checked) {
                            noticable_weight_loss = "150796";
                        } else {
                            noticable_weight_loss = "";
                        }
                        break;
                    case R.id.checkbox_night_sweats:
                        if (checked) {
                            night_sweats = "133027";
                        } else {
                            night_sweats = "";
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

        jsonArry.put(JSONFormBuilder.observations("1728", "", "valueCoded", urination, current_date, editTextUrination.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("1728", "", "valueCoded", thirst, current_date, editTextThirst.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("1728", "", "valueCoded", hunger, current_date, editTextHunger.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("1728", "", "valueCoded", weight_loss, current_date, editTextWeightLoss.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("1728", "", "valueCoded", fatigue, current_date, editTextFatigue.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("1728", "", "valueCoded", vision, current_date, editTextVision.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("1728", "", "valueCoded", impotence, current_date, editTextImpotence.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("1728", "", "valueCoded", numbness, current_date, editTextNumbness.getText().toString().trim()));

        jsonArry.put(JSONFormBuilder.observations("159800", "", "valueCoded", cough, current_date, editTextCough.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("159800", "", "valueCoded", fever, current_date, editTextFever.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("159800", "", "valueCoded", noticable_weight_loss, current_date, editTextNoticableWeightLoss.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("159800", "", "valueCoded", night_sweats, current_date, editTextNightSweats.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165193", "", "valueCoded", indicator_history, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("307", "", "valueCoded", sputum, current_date, editTextSputum.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("162202", "", "valueCoded", gene, current_date, editTextCough.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("12", "", "valueCoded", chest_xray, current_date, editTextXray.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("12", "", "valueCoded", antiTB, current_date, editTextAntiTB.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("164072", "", "valueCoded", invitation_contacts, current_date, editTextInviteContact.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("162275", "", "valueCoded", eval_IPT, current_date, editTextIPT.getText().toString().trim()));

        try {
            jsonArry = JSONFormBuilder.concatArray(jsonArry);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("JSON FollowUp Page 2", jsonArry.toString() + " ");

        FragmentModelFollowUp.getInstance().followUpTwo(jsonArry);
    }
}
