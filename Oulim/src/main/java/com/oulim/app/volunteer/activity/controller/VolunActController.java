package com.oulim.app.volunteer.activity.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.volunteer.dao.VolunteerActivityDAO;
import com.oulim.app.volunteer.dto.VolunteerActivityDTO;

public class VolunActController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		VolunteerActivityDAO volunteerDAO = new VolunteerActivityDAO();

        // 검색 파라미터 받기
        String actType = request.getParameter("actType");
        String ageGroup = request.getParameter("ageGroup");
        String recruitStatus = request.getParameter("recruitStatus");
        String volunDate = request.getParameter("volunDate");
        String searchType = request.getParameter("searchType");
        String keyword = request.getParameter("keyword");

        // Mapper로 전달할 파라미터 Map 생성
        
        Map<String, Object> param = new HashMap<>();
        param.put("actType", actType);
        param.put("ageGroup", ageGroup);
        param.put("recruitStatus", recruitStatus);
        param.put("volunDate", volunDate);
        param.put("searchType", searchType);
        param.put("keyword", keyword);
0
        // 봉사활동 목록 조회
        List<VolunteerActivityDTO> list = volunteerDAO.selectVolunteerList(param);

        // JSP로 데이터 전달
		request.setAttribute("volunteerList", list);

        // 봉사 목록 화면으로 이동

		return null;
	}
	

}
