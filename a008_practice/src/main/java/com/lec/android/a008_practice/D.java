package com.lec.android.a008_practice;

public class D {
    public static int [] FACEID = {
            R.drawable.dog01,
            R.drawable.dog02,
            R.drawable.dog03,
            R.drawable.dog04,
            R.drawable.dog05,
            R.drawable.dog06,
            R.drawable.dog07
    };

    private static int idx = 0;

    // 반복 메소드
    public static int next(){
        idx = idx % FACEID.length;
        return idx++; // idx 값 리턴하고 1증가
    }


}
