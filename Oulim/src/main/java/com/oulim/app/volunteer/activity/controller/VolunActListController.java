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

    private int parseIntSafe(String param) {
        if (param == null || param.trim().equals("") || param.trim().equals("0")) {
            return 0;
        }
        return Integer.parseInt(param.trim());
    }

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VolunteerActivityDAO dao = new VolunteerActivityDAO();
        VolunActivityDTO dto = new VolunActivityDTO();

        // 파라미터 받기
        String actType = request.getParameter("volunActActType");
        String ageGroup = request.getParameter("volunActAgeGroup");
        String recruitStatus = request.getParameter("recruitStatus");
        String keyword = request.getParameter("keyword");
        String searchType = request.getParameter("searchType");
        String organization = request.getParameter("organization");

        // DTO 세팅
        dto.setVolunActActType(parseIntSafe(actType));
        dto.setVolunActAgeGroup(parseIntSafe(ageGroup));
        dto.setRecruitStatus(recruitStatus == null ? "0" : recruitStatus.trim());
        dto.setKeyword(keyword == null ? "" : keyword.trim());
        dto.setSearchType(searchType == null ? "title" : searchType.trim());
        dto.setOrganization(organization == null ? "" : organization.trim());

        // 페이지 처리
        int page = parseIntSafe(request.getParameter("page"));
        if (page == 0) page = 1;

        int size = 10;

        int totalCount = dao.selectCount(dto);
        int totalPage = (int) Math.ceil((double) totalCount / size);

        int startRow = (page - 1) * size;
        int endRow = page * size;

        dto.setStartRow(startRow);
        dto.setEndRow(endRow);

        List<VolunActivityDTO> list = dao.selectVolActList(dto);

        // ⭐ 페이지 블록 처리
        int pageBlock = 5;
        int startPage = ((page - 1) / pageBlock) * pageBlock + 1;
        int endPage = startPage + pageBlock - 1;

        if (endPage > totalPage) {
            endPage = totalPage;
        }

        // 데이터 전달
        request.setAttribute("volunteerList", list);
        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);

        // ⭐ 핵심: search 객체로 전달
        request.setAttribute("search", dto);

        Result result = new Result();
        result.setPath("/app/volunteer-activity/volunAct-list.jsp");
        result.setRedirect(false);

        return result;
    }
}