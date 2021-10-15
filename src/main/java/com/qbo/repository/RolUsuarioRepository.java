package com.qbo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qbo.model.security.RolUsuario;

public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Long> {

	@Query(value = "{call sp_RolxUsuario(:idusuario)}",
			nativeQuery = true)
	public List<RolUsuario> listarRolesPorUsuario(
			@Param("idusuario")Long idusuario);
}
