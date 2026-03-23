package com.oulim.app.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.admin.dao.AdmVolunDetaDAO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.common.util.DefineType;
import com.oulim.app.volunteer.dao.VolunteerMangementDAO;
import com.oulim.app.volunteer.dto.VolunActivityDTO;
import com.oulim.app.volunteer.dto.VolunApplyDTO;

public class AdmVolManDetaController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("========== [AdmVolManDetaController START] ==========");

        Result result = new Result();

        // DAO
        VolunteerMangementDAO volunDAO = new VolunteerMangementDAO();  // 조회
        AdmVolunDetaDAO adminDAO = new AdmVolunDetaDAO();              // 삭제

        // =========================
        // 1. 파라미터
        // =========================
        int volunActNo = Integer.parseInt(request.getParameter("volunActNo"));
        String userNoParam = request.getParameter("userNo");

        System.out.println("volunActNo: " + volunActNo);
        System.out.println("userNoParam: " + userNoParam);
	
	     // =========================
	     // 2. 삭제
	     // =========================
	     if (userNoParam != null && !userNoParam.isEmpty()) {
	         int userNo = Integer.parseInt(userNoParam);
	
	         Map<String, Integer> paramMap = new HashMap<>();
	         paramMap.put("volunActNo", volunActNo);
	         paramMap.put("userNo", userNo);
	
	         adminDAO.deleteApplyUser(paramMap);
	
	         System.out.println("삭제 완료 userNo=" + userNo);
	
	         //  redirect로 재조회
	         result.setRedirect(true);
	         result.setPath(request.getContextPath()
	             + "/admin/volundetail.adm?volunActNo=" + volunActNo);
	
	         return result; 
	     }

        // =========================
        // 3. 봉사 상세
        // =========================
        VolunActivityDTO detail = volunDAO.selectVolManageDetail(volunActNo);

        System.out.println("detail: " + detail);

        if (detail == null) {
            System.out.println(" detail null");
            result.setPath("/error/404.jsp");
            return result;
        }

        // =========================
        // 4. 신청 인원 수
        // =========================
        int applyCount = volunDAO.selectApplyCount(volunActNo);
        System.out.println("applyCount: " + applyCount);

        // =========================
        // 5. 페이징
        // =========================
        int page = 1;

        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {
            page = 1;
        }

		int startRow = (page - 1) * DefineType.ROWCOUNT_PER_PAGE + 1;
		int endRow = startRow + DefineType.ROWCOUNT_PER_PAGE - 1;

		detail.setStartRow(startRow);
		detail.setEndRow(endRow);
        
        int total = applyCount;

       int realEndPage = (int) (Math.ceil(total / (double) DefineType.ROWCOUNT_PER_PAGE));
       int endPage = (int) (Math.ceil(page / (double) DefineType.MAX_PAGE_COUNT) * DefineType.MAX_PAGE_COUNT);
       
       int startPage = endPage - (DefineType.MAX_PAGE_COUNT - 1);
       
       endPage = Math.min(endPage,  realEndPage);
       
       boolean prev = startPage > 1;
       boolean next = endPage < realEndPage;
        // =========================
        // 6. 신청자 리스트
        // =========================
        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("volunActNo", volunActNo);
        pageMap.put("startRow", startRow);
        pageMap.put("endRow", endRow);

        List<VolunApplyDTO> volunList = volunDAO.applyVolSelectPage(pageMap);

        System.out.println("volunList size: " + (volunList != null ? volunList.size() : "null"));

        // =========================
        // 7. request 세팅
        // =========================
        request.setAttribute("detail", detail);
        request.setAttribute("applyCount", applyCount);
        request.setAttribute("volunList", volunList);
        request.setAttribute("page", page);
        request.setAttribute("volunActNo", volunActNo);
        
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("prev", prev);
        request.setAttribute("next", next);

        // =========================
        // 8. 이동
        // =========================
        result.setPath("/app/admin/jsp/volunteer-manage/volun-detail.jsp");
        result.setRedirect(false);
        
        System.out.println("path: " + result.getPath());
        System.out.println("redirect: " + result.isRedirect());
        System.out.println("userNoParam: " + userNoParam);
        System.out.println("========== [AdmVolManDetaController END] ==========");

        return result;
    }
}