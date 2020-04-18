package com.lec.android.a008_practice;

public class DogProfile {

    String image;
    String name;
    int age;
    boolean sex;

    public DogProfile(String name) {    }

    public DogProfile(String image, String name, int age, boolean sex) {
        this.image = image;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
