package com.universe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universe.entity.OperationLog;

public interface OperationLogRepository extends JpaRepository<OperationLog, Long> {

}
