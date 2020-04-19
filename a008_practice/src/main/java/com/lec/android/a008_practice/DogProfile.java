package com.lec.android.a008_practice;

import android.widget.EditText;
import android.widget.RadioGroup;

public class DogProfile {

    String name;
    int age;
    String sex;

    public DogProfile(String name) {    }

    public DogProfile(int image, String name, int age, String sex) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
