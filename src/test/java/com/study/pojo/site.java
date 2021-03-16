package com.study.pojo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;


public class site implements Serializable
    {

        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private List<String> name;
        @SerializedName("age")
        @Expose
        private int age;
        @SerializedName("__v")
        @Expose
        private int v;
       private final static long serialVersionUID = -5896790449376003008L;

        /**
         * No args constructor for use in serialization
         *
         */
        public site() {
        }

        /**
         *  @param id
         * @param name
         * @param age
         * @param v
         */
        public site(String id, List<String> name, int age, int v) {
            super();
            this.id = id;
            this.name = name;
            this.age = age;
            this.v = v;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getName() {
            return name;
        }

        public void setName(List<String> name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("id", id).append("name", name).append("age", age).append("v", v).toString();
        }

    }


