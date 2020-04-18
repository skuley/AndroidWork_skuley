package com.lec.android.a008_practice;

public class DogProfile {

    int image;
    String name;
    int age;
    boolean sex;

    public DogProfile(String name) {    }

    public DogProfile(int image, String name, int age, boolean sex) {
        this.image = image;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
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
