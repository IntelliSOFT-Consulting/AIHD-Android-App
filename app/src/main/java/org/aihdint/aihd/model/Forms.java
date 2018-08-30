package org.aihdint.aihd.model;

import com.orm.SugarRecord;

public class Forms extends SugarRecord {

    private String form_id;
    private String form_name;
    private String creator;
    private String patient_id;
    private String form_type;
    private String date;
    public String status;

    public Forms() {
    }

    public Forms(String form_id, String form_name, String creator, String patient_id, String form_type, String date, String status) {
        this.form_id = form_id;
        this.form_name = form_name;
        this.creator = creator;
        this.patient_id = patient_id;
        this.form_type = form_type;
        this.date = date;
        this.status = status;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public String getForm_name() {
        return form_name;
    }

    public void setForm_name(String form_name) {
        this.form_name = form_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getForm_type() {
        return form_type;
    }

    public void setForm_type(String form_type) {
        this.form_type = form_type;
    }

}
