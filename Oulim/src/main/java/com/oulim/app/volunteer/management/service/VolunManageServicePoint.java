package com.oulim.app.volunteer.management.service;

import com.oulim.app.volunteer.dao.VolunteerMangementDAO;
import com.oulim.app.volunteer.dto.PointJoinDTO;
import com.oulim.app.volunteer.dto.VolunApplyDTO;

public class VolunManageServicePoint  {

	public void attendanceProcess(PointJoinDTO pointJoinDTO, String[] userNos, int volunActNo, int attendanceStatus) {
		VolunteerMangementDAO volunteerMangementDAO = new VolunteerMangementDAO();

		for (String userNoStr : userNos) {
			int userNo = Integer.parseInt(userNoStr);

			VolunApplyDTO volunApplyDTO = new VolunApplyDTO();
			volunApplyDTO.setVolunActNo(volunActNo);
			volunApplyDTO.setUserNo(userNo);
			volunApplyDTO.setVolunActAttendance(attendanceStatus);

			int updateCount = volunteerMangementDAO.updateAttendanceStatus(volunApplyDTO);

			if (updateCount > 0 && attendanceStatus == 1) {
				pointJoinDTO.setUserNo(userNo);
				pointJoinDTO.setCurrencyId(1);
				pointJoinDTO.setLogReason("봉사 출석 포인트 지급");

				volunteerMangementDAO.updateCurrency(pointJoinDTO);
				volunteerMangementDAO.insertPointLog(pointJoinDTO);
			}
		}
		
	}
}