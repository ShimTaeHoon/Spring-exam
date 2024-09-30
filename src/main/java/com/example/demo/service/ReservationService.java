package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.entity.Reservation;

public interface ReservationService {
	
		int register(ReservationDTO dto);

		List<ReservationDTO> getList();

		ReservationDTO read(int no);
		
		default Reservation dtoToEntity(ReservationDTO dto) {
			
			Reservation entity = Reservation.builder()
					.no(dto.getNo())
					.guestName(dto.getGuestName())
					.guestPhone(dto.getGuestPhone())
					.roomNo(dto.getRoomNo())
					.checkInDate(dto.getCheckInDate())
					.build();
			return entity;
		}

		default ReservationDTO entityToDto(Reservation entity) {

			ReservationDTO dto = ReservationDTO.builder()
					.no(entity.getNo())
					.guestName(entity.getGuestName())
					.guestPhone(entity.getGuestPhone())
					.roomNo(entity.getRoomNo())
					.checkInDate(entity.getCheckInDate())
					.build();

			return dto;
		} 
	
}
