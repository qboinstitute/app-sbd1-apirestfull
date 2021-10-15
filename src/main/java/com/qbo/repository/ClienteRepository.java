package com.qbo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qbo.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	/*@Query(
			value = "SELECT c FROM cliente c WHERE c.dnicliente = :dnicliente",
			nativeQuery = true
			)*/
	@Query(
			value = "SELECT * FROM cliente WHERE cliente.dnicliente = :dnicliente",
			nativeQuery = true
			)
	Optional<Cliente> buscarClientePorDNI(@Param("dnicliente") String dnicliente);
	
	@Query(
			value = "SELECT * FROM cliente WHERE cliente.nomcliente LIKE %:nomcliente%",
			nativeQuery = true,
			countQuery = "SELECT count(*) FROM cliente"
			)
	Page<Cliente> buscarClientePorNombre(@Param("nomcliente") String nomcliente,
			Pageable pageable);
	
	
}
