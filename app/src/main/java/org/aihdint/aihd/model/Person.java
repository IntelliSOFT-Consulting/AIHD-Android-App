package org.aihdint.aihd.model;

import com.orm.SugarRecord;

/**
 * Developed by Rodney on 15/02/2018.
 */

public class Person extends SugarRecord {
    //private variables
    private String person_id;
    private String family_name;
    private String given_name;
    private String gender;
    private String birthdate;
    private String birthdate_estimated;
    private String telephone;
    private String identifier_type;
    private String location_id;
    private String address1,address2,address3,county_district,city_village;
    private String supporter;
    private String supporter_address;
    private String supporter_number;
    private String _status;
    private String isDead;

    private String isReport;

    // Empty constructor
    public Person(){

    }

    // constructor
    public Person(String person_id, String name) {
        this.person_id = person_id;
        this.family_name = name;
    }

    // constructor
    public Person(String family_name, String given_name, String gender, String birthdate, String birthdate_estimated,
                  String telephone, String identifier_type, String location_id,
                  String address1, String address2, String address3, String county_district, String city_village, String supporter, String supporter_address, String supporter_number, String status) {
        //this._id = id;
        this.family_name = family_name;
        this.given_name = given_name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.birthdate_estimated = birthdate_estimated;
        this.telephone = telephone;
        this.identifier_type = identifier_type;
        this.location_id = location_id;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.county_district = county_district;
        this.city_village = city_village;
        this.supporter = supporter;

        this.supporter_address = supporter_address;
        this.supporter_number = supporter_number;
        this._status = status;
    }


    public String get_id() {
        return person_id;
    }

    public void set_id(String person_id) {
        this.person_id = person_id;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthdate_estimated() {
        return birthdate_estimated;
    }

    public void setBirthdate_estimated(String birthdate_estimated) {
        this.birthdate_estimated = birthdate_estimated;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIdentifier_type() {
        return identifier_type;
    }

    public void setIdentifier_type(String identifier_type) {
        this.identifier_type = identifier_type;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCounty_district() {
        return county_district;
    }

    public void setCounty_district(String county_district) {
        this.county_district = county_district;
    }

    public String getCity_village() {
        return city_village;
    }

    public void setCity_village(String city_village) {
        this.city_village = city_village;
    }

    public String getSupporter() {
        return supporter;
    }

    public void setSupporter(String supporter) {
        this.supporter = supporter;
    }

    public String getSupporter_address() {
        return supporter_address;
    }

    public void setSupporter_address(String supporter_address) {
        this.supporter_address = supporter_address;
    }

    public String getSupporter_number() {
        return supporter_number;
    }

    public void setSupporter_number(String supporter_number) {
        this.supporter_number = supporter_number;
    }

    public String get_status() {
        return _status;
    }

    public void set_status(String _status) {
        this._status = _status;
    }

    public String getIsDead() {
        return isDead;
    }

    public void setIsDead(String isDead) {
        this.isDead = isDead;
    }

    public String getIsReport() {
        return isReport;
    }

    public void setIsReport(String isReport) {
        this.isReport = isReport;
    }






}
