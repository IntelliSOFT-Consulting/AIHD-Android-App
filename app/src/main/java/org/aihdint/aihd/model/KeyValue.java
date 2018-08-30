package org.aihdint.aihd.model;

/**
 * Developed by Rodney on 05/04/2018.
 */

public class KeyValue {

    private String id;
    private String name;

    public KeyValue(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //to display object as a string in spinner
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof KeyValue){
            KeyValue c = (KeyValue )obj;
            return c.getName().equals(name) && c.getId().equals(id);
        }

        return false;
    }
}
