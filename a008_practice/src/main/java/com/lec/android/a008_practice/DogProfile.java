package com.lec.android.a008_practice;

import android.widget.EditText;
import android.widget.RadioGroup;

public class DogProfile {

    String name;
    String age;
    String sex;

    public DogProfile(String name) {    }

    public DogProfile(String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
