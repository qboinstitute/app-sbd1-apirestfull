package com.qbo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaDto implements DtoEntity {

	private Integer idsala;
	private String descsala;
	private Integer asientos;
	
}
