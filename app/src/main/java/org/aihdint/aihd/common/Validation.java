package org.aihdint.aihd.common;

import org.json.JSONArray;

public class Validation {

    public static String initialValidation(JSONArray jsonArray) {

        StringBuilder error = new StringBuilder(1000);

        try {

            if (jsonArray.length() > 0) {

                if (!jsonArray.toString().contains("1712")) {
                    error.append("Page(1) Education Level is required \n\n");
                }
                if (!jsonArray.toString().contains("1542")) {
                    error.append("Page(1) Occupation is required \n\n");
                }
                if (!jsonArray.toString().contains("165086")) {
                    error.append("Page(1) Diabetes Status is required \n\n");
                }
                if (!jsonArray.toString().contains("140228")) {
                    error.append("Page(1) Diabetes runs in the family is required \n\n");
                }
                if (!jsonArray.toString().contains("165091")) {
                    error.append("Page(1) Hypertension status is required \n\n");
                }
                if (!jsonArray.toString().contains("165191")) {
                    error.append("Page(1) Hypertension runs in the family question is required \n\n");
                }
                if (!jsonArray.toString().contains("138405")) {
                    error.append("Page(1) HIV Status is required \n\n");
                }
                if (!jsonArray.toString().contains("1917")) {
                    error.append("Page(1) NHIF status is required \n\n");
                }
                if (!jsonArray.toString().contains("1648")) {
                    error.append("Page(1) Patient referral status is required \n\n");
                }
                if (!jsonArray.toString().contains("165208")) {
                    error.append("Page(1) Do you exercise question is required \n\n");
                }
                if (!jsonArray.toString().contains("165207")) {
                    error.append("Page(1) Do you follow a balanced diet question is required \n\n");
                }
                if (!jsonArray.toString().contains("152722")) {
                    error.append("Page(1) Do you smoke cigarettes question is required \n\n");
                }
                if (!jsonArray.toString().contains("159449")) {
                    error.append("Page(1) Do you drink alcohol question is required \n\n");
                }
                if (!jsonArray.toString().contains("1380")) {
                    error.append("Page(4) Nutrition counselling/education is required \n\n");
                }
                if (!jsonArray.toString().contains("159364")) {
                    error.append("Page(4) Physical activity counselling/education is required \n\n");

                }
            }

        } catch (Exception e) {
            // hiding the progress bar
            e.printStackTrace();
        }

        return error.toString();
    }


}
