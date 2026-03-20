package com.oulim.app.common.util;

import java.util.UUID;

public class TokenUtil {
    public static String createToken() {
    	// 절대 안 겹치는 랜덤 문자열 만들려고 사용
        return UUID.randomUUID().toString();
    }
}