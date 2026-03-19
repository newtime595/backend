package com.oulim.app.volunteer.management.service;

import com.oulim.app.volunteer.dao.VolunteerMangementDAO;
import com.oulim.app.volunteer.dto.VolunActivityDTO;

public class VolunManageInsertService {

	public void insertVolunteer(VolunActivityDTO dto) {
		if (dto.getVolunActTitle() == null || dto.getVolunActTitle().trim().isEmpty()) {
			throw new IllegalArgumentException("봉사 제목을 입력해주세요.");
		}

		if (dto.getVolunActRecruBegin() == null || dto.getVolunActRecruBegin().trim().isEmpty()) {
			throw new IllegalArgumentException("모집 시작일을 입력해주세요.");
		}

		if (dto.getVolunActRecruEnd() == null || dto.getVolunActRecruEnd().trim().isEmpty()) {
			throw new IllegalArgumentException("모집 종료일을 입력해주세요.");
		}

		if (dto.getVolunActProcBegin() == null || dto.getVolunActProcBegin().trim().isEmpty()) {
			throw new IllegalArgumentException("봉사 시작일을 입력해주세요.");
		}

		if (dto.getVolunActProcEnd() == null || dto.getVolunActProcEnd().trim().isEmpty()) {
			throw new IllegalArgumentException("봉사 종료일을 입력해주세요.");
		}

		if (dto.getVolunActAddress() == null || dto.getVolunActAddress().trim().isEmpty()) {
			throw new IllegalArgumentException("봉사 장소를 입력해주세요.");
		}

		if (dto.getVolunActPoint() == 0) {
			throw new IllegalArgumentException("포인트를 입력해주세요.");
		}

		if (dto.getVolunActBeginTime() == 0) {
			throw new IllegalArgumentException("봉사 시작 시간을 입력해주세요.");
		}

		if (dto.getVolunActEndTime() == 0) {
			throw new IllegalArgumentException("봉사 종료 시간을 입력해주세요.");
		}

		VolunteerMangementDAO dao = new VolunteerMangementDAO();
		dao.volActivityInsert(dto);
	}
}