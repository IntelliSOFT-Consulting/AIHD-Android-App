package org.aihdint.aihd.model;

import com.orm.SugarRecord;

/**
 * Developed by Rodney on 11/04/2018.
 */

public class Location extends SugarRecord {

    //private variables
    private String _id;
    private String _name;
    private String _mfl_code;

    public Location(){
    }

    // constructor
    public Location(String id, String name, String mfl_code) {
        this._id = id;
        this._name = name;
        this._mfl_code = mfl_code;
    }

    // getting ID
    public String  getID(){
        return this._id;
    }

    // setting id
    public void setID(String id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    public String get_mfl_code() {
        return _mfl_code;
    }

    public void set_mfl_code(String _mfl_code) {
        this._mfl_code = _mfl_code;
    }

}
