package models;

import java.util.ArrayList;

public class Squad {
    private String name;
    private String cause;
    private int size;
    private static ArrayList<Squad> instances = new ArrayList<>();
    private int id;

    public Squad(String name, String cause, int size, int id) {
        this.name = name;
        this.cause = cause;
        this.size = size;
        instances.add(this);
        this.id = instances.size();
    }

    public static int findById(int idOfPostToFind) {
            return idOfPostToFind;
       }
        public String getName(){
            return name;
        }

        public String getCause(){
            return cause;
        }

        public int getSize() {
            return size;
        }

        public static ArrayList<Squad> getThemAll(){
            return instances;
        }

        public int getId (){
            return id;
        }

        public static Squad FindById(int id){
            return instances.get(id-1);
        }
    }
