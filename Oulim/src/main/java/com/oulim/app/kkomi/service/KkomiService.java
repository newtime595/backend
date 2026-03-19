package com.oulim.app.kkomi.service;

import java.util.HashMap;
import java.util.Map;

public class KkomiService {
	// 레벨별 경험치를 저장할 맵
	Map<Integer,Integer> kkomiLevExpMap = new HashMap<>();
	final int EXP_BASE = 2000;
	public KkomiService() {
		// 1 ~ 9까지 경험치 설정
		// 요구 경험치 변동은 각 레벨 단계당 
		for(int i = 1 ; i < 10; i++) {
			kkomiLevExpMap.put(i, (i - 1) * (int)Math.pow(2, (i - 1))*EXP_BASE);
		}
	}
	
	
}
