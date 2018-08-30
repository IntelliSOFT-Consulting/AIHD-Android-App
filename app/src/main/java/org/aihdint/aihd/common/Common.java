package org.aihdint.aihd.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.orm.query.Condition;
import com.orm.query.Select;

import org.aihdint.aihd.R;
import org.aihdint.aihd.model.Concepts;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Common {

    public static void checkBP(final Context mContext, final EditText editTextSystolicOne, final EditText editTextDiastolicOne, final EditText editTextSystolicTwo, final EditText editTextDiastolicTwo) {

        int systolic_1 = 0;
        int diastolic_1 = 0;
        int systolic_2 = 0;
        int diastolic_2 = 0;

        if (editTextSystolicOne.getText().toString().trim().length() > 0) {
            systolic_1 = Integer.parseInt(editTextSystolicOne.getText().toString().trim());
        }

        if (editTextDiastolicOne.getText().toString().trim().length() > 0) {
            diastolic_1 = Integer.parseInt(editTextDiastolicOne.getText().toString().trim());
        }

        if (editTextSystolicTwo != null && editTextSystolicTwo.getText() != null && !editTextSystolicTwo.getText().toString().matches("")) {
            systolic_2 = Integer.parseInt(editTextSystolicTwo.getText().toString().trim());
        }

        if (editTextDiastolicTwo != null && editTextDiastolicTwo.getText() != null && !editTextDiastolicTwo.getText().toString().matches("")) {
            diastolic_2 = Integer.parseInt(editTextDiastolicTwo.getText().toString().trim());
        }


        if (diastolic_1 > 0 && systolic_1 > 0) {

            int systolic = systolic_1;
            int diastolic = diastolic_1;

            if (diastolic_2 > 0 && systolic_2 > 0) {
                systolic = (systolic_1 + systolic_2) / 2;
                diastolic = (diastolic_1 + diastolic_2) / 2;
            }

            Log.d("Values BP", systolic + "/" + diastolic);
            if ((systolic > 89 && systolic < 129)
                    && (diastolic > 59 && diastolic < 84)) {
                Alerts.alert_msg(mContext, "Blood Pressure ", "Normal BP");
            } else if ((diastolic > 84 && diastolic < 89)
                    && (systolic > 129 && systolic < 139)) {
                Alerts.alert_msg(mContext, "Blood Pressure ", "High Normal BP");
            } else if ((diastolic > 89 && diastolic < 99)
                    && (systolic > 139 && systolic < 159)) {
                Alerts.alert_msg(mContext, "Blood Pressure ", "Mild Hypertention");
            } else if ((diastolic > 99 && diastolic < 109)
                    && (systolic > 159 && systolic < 179)) {
                Alerts.alert_msg(mContext, "Blood Pressure ", "Moderate Hypertention");
            } else if ((diastolic > 109 && diastolic < 1000)
                    && (systolic > 179 && systolic < 1000)) {
                Alerts.alert_msg(mContext, "Blood Pressure ", "Severe Hypertention");
            }
        }


    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public static void whr(final Activity activity, final EditText editTextWaist, final EditText editTextHip, final TextView textViewWaistHipRatio) {


        double wst = 0;
        double hp = 0;

        if (editTextWaist.getText().toString().trim().length() > 0) {
            wst = Integer.parseInt(editTextWaist.getText().toString().trim());
        }

        if (editTextHip.getText().toString().trim().length() > 0) {
            hp = Integer.parseInt(editTextHip.getText().toString().trim());
        }

        if (wst > 0 && hp > 0) {
            double whr_value = wst / hp;

            textViewWaistHipRatio.setText(String.format("%.1f", whr_value));

        }


    }

    public static void bmi(final Activity activity, final Context mContext, final EditText editTextHeight, final EditText editTextWeight, final TextView textViewBMI) {


        double hght = 0;
        double wght = 0;
        String category = "";

        if (editTextHeight.getText().toString().trim().length() > 0) {
            hght = Integer.parseInt(editTextHeight.getText().toString().trim());
            hght = hght / 100;
        }

        if (editTextWeight.getText().toString().trim().length() > 0) {
            wght = Integer.parseInt(editTextWeight.getText().toString().trim());
        }

        if (hght > 0 && wght > 0) {
            double textViewBMI_value = wght / (hght * hght);
            if (textViewBMI_value < 18.5) {
                textViewBMI.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));
                category = " Underweight";
            } else if (textViewBMI_value > 18.5 && textViewBMI_value < 25) {
                textViewBMI.setTextColor(ContextCompat.getColor(mContext, R.color.green));
                category = " Normal Weight";
            } else if (textViewBMI_value > 25 && textViewBMI_value < 30) {
                textViewBMI.setTextColor(ContextCompat.getColor(mContext, R.color.orange));
                category = " Overweight";
            } else if (textViewBMI_value > 30) {
                textViewBMI.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));
                category = " Obese";
            }
            textViewBMI.setText(String.format("%.1f", textViewBMI_value) + category);
        }

    }

    public static void checkTemp(Context mContext, String temp) {
        if (temp.length() != 0) {
            if (Double.parseDouble(temp) < 35 || Double.parseDouble(temp) > 40) {
                Alerts.alert_msg(mContext, "Temperature", "Kindly confirm if the Temperature entered is correct.");
            } else if (Double.parseDouble(temp) < 36.1) {
                Alerts.alert_msg(mContext, "Temperature", "Patient has hypothermia.");
            } else if (Double.parseDouble(temp) > 37.1) {
                Alerts.alert_msg(mContext, "Temperature", "Patient has a Fever.");
            }
        }
    }

    public static void checkPR(Context mContext, String pr) {
        if (pr.length() != 0) {
            if (Double.parseDouble(pr) < 60 || Double.parseDouble(pr) > 100) {
                Alerts.alert_msg(mContext, "Temperature", "Kindly confirm if the Pulse Rate entered is correct.");
            }
        }
    }

    public static void monofilament(Context mContext, String value) {
        if (value.length() != 0) {
            if (Double.parseDouble(value) > 5) {
                Alerts.alert_msg(mContext, "Monofilament", "Abnormal Monofilament");
            }
        }
    }

    public static String conceptAnswer(JSONObject concept, String concept_id) {
        String value = "";
        try {
            if (concept.getString("concept_id").equals(concept_id)) {
                List<Concepts> answer = Select.from(Concepts.class)
                        .where(Condition.prop("conceptid").eq(concept.getString("concept_answer")))
                        .limit("1")
                        .list();

                for (Concepts cpts : answer) {
                    // adding each child node to HashMap key => value
                    value = cpts.getConcept_answer();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }


    public static String time() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        return timeFormat.format(new Date());
    }

    public static String date() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
