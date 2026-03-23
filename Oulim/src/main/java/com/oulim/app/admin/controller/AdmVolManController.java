package com.oulim.app.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.admin.dao.AdmVolMangDAO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.common.util.DefineType;
import com.oulim.app.volunteer.dto.VolunActivityDTO;

public class AdmVolManController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AdmVolMangDAO dao = new AdmVolMangDAO();
        VolunActivityDTO dto = new VolunActivityDTO();

        // =========================
        // 1. 파라미터 수집
        // =========================
        String recruitStatus = request.getParameter("recruitStatus");
        String keyword = request.getParameter("keyword");
        String searchType = request.getParameter("searchType");
        String begin = request.getParameter("volunActProcBegin");
        String end = request.getParameter("volunActProcEnd");
        
        // =========================
        // 2. DTO에 세팅 (DB 조회용)
        // =========================
        dto.setRecruitStatus(recruitStatus);
        dto.setKeyword(keyword);
        dto.setSearchType(searchType);
        dto.setVolunActProcBegin(begin);
        dto.setVolunActProcEnd(end);

        // 페이징 (임시)
		String temp = request.getParameter("page");
        int page = (temp == null) ? 1 : Integer.valueOf(temp);
		if(page <1) page = 1;

		int startRow = (page - 1) * DefineType.ROWCOUNT_PER_PAGE + 1;
		int endRow = startRow + DefineType.ROWCOUNT_PER_PAGE - 1;

        dto.setStartRow(startRow);
        dto.setEndRow(endRow);
        
        int total = dao.selectAdminVolunCount(dto);

       int realEndPage = (int) (Math.ceil(total / (double) DefineType.ROWCOUNT_PER_PAGE));
       int endPage = (int) (Math.ceil(page / (double) DefineType.MAX_PAGE_COUNT) * DefineType.MAX_PAGE_COUNT);
       
       int startPage = endPage - (DefineType.MAX_PAGE_COUNT - 1);
       
       endPage = Math.min(endPage,  realEndPage);
       
       boolean prev = startPage > 1;
       boolean next = endPage < realEndPage;
       
        // =========================
        // 3. DB 조회
        // =========================
        List<VolunActivityDTO> list = dao.selectAdminVolunList(dto);
        System.out.println("리스트 개수: " + list.size());

        // =========================
        // 4. JSP로 데이터 전달 (검색 유지용)
        // =========================
        request.setAttribute("volunList", list);

        // 검색 유지
        request.setAttribute("keyword", keyword);
        request.setAttribute("searchType", searchType);
        request.setAttribute("recruitStatus", recruitStatus);
        request.setAttribute("volunActProcBegin", begin);
        request.setAttribute("volunActProcEnd", end);

        // 페이지 정보
        request.setAttribute("page", page);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("prev", prev);
        request.setAttribute("next", next);
        // =========================
        // 5. 페이지 이동 (forward)
        // =========================
        Result result = new Result();
        result.setPath("/app/admin/jsp/volunteer-manage/volun-list.jsp");

        result.setRedirect(false);

        return result;
    }
}