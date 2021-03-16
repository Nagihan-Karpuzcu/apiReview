package com.study.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Person {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private  String  name;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("__v")
    @Expose
    private Character v;

    public Person() {


    }
    public Person(String id ,String name, Integer age,Character v) {
this.id=id;
this.name=name;
this.age=age;
this.v=v;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName(){
         return name;
    }
     public void setName(String name){
         this.name=name;

     }
     public Integer getAge(){
         return age;
     }
     public void SetAge(Integer age){
        this.age=age;
     }
     public Character getV(){
        return v;
     }
     public  void SetV(Character v){
        this.v=v;
     }

     @Override
     public  String toString(){
        return "Person{" + "id:"+ id + "name:" +name + "age:" +age+ "v:"  + v+"}";

     }
}
