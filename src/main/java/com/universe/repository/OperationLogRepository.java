package com.universe.repository;

import com.universe.entity.OperationLog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OperationLogRepository extends JpaRepository<OperationLog, Long> {

	@Query("select t from OperationLog t")
	List<OperationLog> findAllOperationLog(Pageable pageable);
}
