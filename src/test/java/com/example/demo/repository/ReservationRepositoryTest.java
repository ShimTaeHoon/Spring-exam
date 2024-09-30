package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Reservation;

@SpringBootTest
public class ReservationRepositoryTest {

	@Autowired
	ReservationRepository repository;
	
	@Test
	public void 데이터등록() {
		
		LocalDate date1 = LocalDate.of(2024, 9, 5);
		LocalDate date2 = LocalDate.of(2024, 9, 5);
		LocalDate date3 = LocalDate.of(2024, 9, 10);
		
		Reservation reservation1 = Reservation.builder()
									.guestName("둘리")
									.guestPhone("010-1111-2222")
									.roomNo(201)
									.checkInDate(date1)
									.build();
		repository.save(reservation1);
		
		Reservation reservation2 = Reservation.builder()
				.guestName("또치")
				.guestPhone("010-3333-4444")
				.roomNo(202)
				.checkInDate(date2)
				.build();
		repository.save(reservation2);
		
		Reservation reservation3 = Reservation.builder()
				.guestName("도우너")
				.roomNo(201)
				.checkInDate(date3)
				.build();
		repository.save(reservation3);
		
	}
	
	@Test
	public void 데이터전체조회() {
		
		List<Reservation> list = repository.findAll();
		for(Reservation reservation : list) {
			System.out.println(reservation);
		}
		
	}
	
	@Test
	public void 데이터단건조회() {
		Optional<Reservation> result = repository.findById(1);
		if(result.isPresent()) {
			Reservation res = result.get();
			System.out.println(res);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Reservation> result = repository.findById(1);
		Reservation res = result.get();
		res.setGuestName("구마적");
		repository.save(res);
	}
	
	@Test
	public void 데이터삭제() {
		repository.deleteById(1);
	}
	
}
