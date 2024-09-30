package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.ReservationDTO;

@SpringBootTest
public class ReservationServiceTest {

	@Autowired
	ReservationService service;
	
	@Test
	public void 예약정보등록() {
		
		LocalDate date1 = LocalDate.of(2024, 9, 30);
		
		ReservationDTO dto = ReservationDTO.builder()
						.guestName("시라소니")
						.guestPhone("010-1234-5678")
						.roomNo(123)
						.checkInDate(date1)
						.build();
		int no = service.register(dto);
		System.out.println("새로운 게시물 번호: " + no);
	}
	
	@Test
	public void 예약정보목록조회() {
		List<ReservationDTO> list = service.getList();
		for(ReservationDTO dto : list) {
			System.out.println(dto);
		}
	}
	
	@Test
	public void 예약정보단건조회() {
		ReservationDTO dto = service.read(1);
		System.out.println(dto);
	}
}
