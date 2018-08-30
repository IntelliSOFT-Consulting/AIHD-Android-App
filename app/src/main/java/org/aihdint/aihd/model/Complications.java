package org.aihdint.aihd.model;

public class Complications {

    private String complication;
    private String diagnosis;
    private String date;
    private String comment;

    public Complications() {
    }

    public Complications(String complication, String diagnosis, String date, String comment) {
        this.complication = complication;
        this.diagnosis = diagnosis;
        this.date = date;
        this.comment = comment;
    }

    public String getComplication() {
        return complication;
    }

    public void setComplication(String complication) {
        this.complication = complication;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
