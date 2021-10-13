package com.qbo.convertdto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.qbo.dto.SalaDto;
import com.qbo.model.Sala;

@Component
public class SalaConvert {

	public SalaDto salaToDto(Sala sala) {
		ModelMapper mapper = new ModelMapper();
		SalaDto map = mapper.map(sala, SalaDto.class);
		return map;
	}
	
}
