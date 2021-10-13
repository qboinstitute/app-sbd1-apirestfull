package com.qbo.service;

import java.util.List;
import java.util.Optional;
import com.qbo.model.response.*;

public interface BaseService<E> {

	public List<E> obtenerTodo();
	
	public Optional<E> obtenerPorId(Integer id);
	
	public E guardar(E entity);
	
	public MessageResponse eliminarPorId(Integer id);
	
}
