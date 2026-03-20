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

        // ===== 파라미터수집 =====
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

        // ===== 페이징 =====
        int page = 1;
        int size = 5;

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        int offset = (page - 1) * size;

        dto.setPage(page);
        dto.setSize(size);
        dto.setOffset(offset);

        // ===== 조회 =====
        List<VolunActivityDTO> list = dao.selectVolActList(dto);
        int totalCount = dao.selectCount(dto);

        int totalPage = (int)Math.ceil((double)totalCount / size);

        // ===== 전달 =====
        request.setAttribute("volunteerList", list);
        request.setAttribute("search", dto);
        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);

        Result result = new Result();
        result.setPath("/app/volunteer-activity/volunAct-list.jsp");
        result.setRedirect(false);

        return result;
    }
}