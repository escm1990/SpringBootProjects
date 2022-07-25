package com.millicom.resourcemanager.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.millicom.resourcemanager.adapter.dto.Parameters;


@Repository	
public interface ParametersRepository extends JpaRepository<Parameters,Integer> {

	@Query(value = "select p.valor from resource_manager_regional.parameters p "
			+ "where codigo = ?1 and grupo = 'ADAPTER_OM'", nativeQuery = true)
	public String findValorByCodigo(String codigo);

}
