package models;

import java.util.ArrayList;

public class Squad {
    private String sname;
    private String cause;
    private int size;
    private static ArrayList<Squad> instances = new ArrayList<>();
    private int id;

    public Squad(String sname, String cause, int size) {
        this.sname = sname;
        this.cause = cause;
        this.size = size;
        instances.add(this);
        this.id = instances.size();
    }

    public String getSname() {
        return sname;
    }

    public String getCause() {
        return cause;
    }

    public int getSize() {
        return size;
    }

    public static ArrayList<Squad> getInstances() {
        return instances;
    }

    public int getId() {
        return id;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static void setInstances(ArrayList<Squad> instances) {
        Squad.instances = instances;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ArrayList<Squad> getThemAll(){
        return instances;
    }
}