package com.example.demo.config;

import java.util.Random;

public class GenerateRandomString {
    /**
     * 랜덤 문자열 생성
     * @param length
     * @return
     */
    public static String generateRandomString(int length) {
        // 대문자 영문자와 숫자를 사용하는 문자열
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        // 랜덤한 문자열을 저장할 StringBuilder 객체 생성
        StringBuilder randomStringBuilder = new StringBuilder(length);

        // 랜덤한 문자열 생성
        for (int i = 0; i < length; i++) {
            // characters 문자열에서 랜덤한 인덱스를 얻어서 해당 문자를 StringBuilder에 추가
            randomStringBuilder.append(characters.charAt(new Random().nextInt(characters.length())));
        }

        return randomStringBuilder.toString();
    }
}
