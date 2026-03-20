package com.oulim.app.volunteer.activity.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.volunteer.dao.VolunteerActivityDAO;
import com.oulim.app.volunteer.dto.VolunActivityDTO;

public class VolunActListController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VolunteerActivityDAO dao = new VolunteerActivityDAO();
        VolunActivityDTO dto = new VolunActivityDTO();

        // ===================== 파라미터수집 ======================
        String actType = request.getParameter("actType");
        String ageGroup = request.getParameter("ageGroup");
        String recruitStatus = request.getParameter("recruitStatus");
        String keyword = request.getParameter("keyword");
        String searchType = request.getParameter("searchType");
        String organization = request.getParameter("organization");

        if (actType != null && !actType.isEmpty()) {
            dto.setVolunActActType(Integer.parseInt(actType));
        }

        if (ageGroup != null && !ageGroup.isEmpty()) {
            dto.setVolunActAgeGroup(Integer.parseInt(ageGroup));
        }

        if (recruitStatus != null && !recruitStatus.isEmpty()) {
            dto.setRecruitStatus(recruitStatus);
        }

        if (keyword != null && !keyword.trim().isEmpty()) {
            dto.setKeyword(keyword);
        }

        if (searchType != null && !searchType.isEmpty()) {
            dto.setSearchType(searchType);
        }

        if (organization != null && !organization.trim().isEmpty()) {
            dto.setOrganization(organization);
            
        }
        
        
        

     // ======================== 페이징 ====================
        int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
        int size = 10;

        // 전체 데이터 개수
        int totalCount = dao.selectCount(dto);

        // 전체 페이지 수
        int totalPage = (int)Math.ceil((double) totalCount / size);

        // 시작 / 끝 페이지 (블록 기준)
        int pageBlock = 5;
        int startPage = ((page - 1) / pageBlock) * pageBlock + 1;
        int endPage = startPage + pageBlock - 1;

        if (endPage > totalPage) {
            endPage = totalPage;
        }

        // ROWNUM용
        int startRow = (page - 1) * size;
        int endRow = page * size;

        dto.setStartRow(startRow);
        dto.setEndRow(endRow);
        
        System.out.println("totalCount = " + totalCount);
        System.out.println("totalPage = " + totalPage);
        System.out.println("page = " + page);
        System.out.println("startRow = " + startRow);
        System.out.println("endRow = " + endRow);
        // ===== 조회 =====
        List<VolunActivityDTO> list = dao.selectVolActList(dto);

        // ===== 전달 =====
        request.setAttribute("volunteerList", list);
        request.setAttribute("search", dto);
        request.setAttribute("page", page);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("totalPage", totalPage);

        Result result = new Result();
        result.setPath("/app/volunteer-activity/volunAct-list.jsp");
        result.setRedirect(false);

        return result;
    }
}