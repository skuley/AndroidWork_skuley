package com.lec.android.a008_practice;

import java.util.ArrayList;
import java.util.List;

public class DogAdapter {

    List<DogProfile> profile = new ArrayList<DogProfile>();

    // 데이터를 다루기 위한 메소드들
    // ArrayList 의 메소드들 사용
    public void addProfile(DogProfile p){ profile.add(p);}
    public void addProfile(int position, DogProfile p){profile.add(position, p);}
    public DogProfile getProfile(int position, DogProfile p){return profile.get(position);}

}
