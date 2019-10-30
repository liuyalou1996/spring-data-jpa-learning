package com.iboxpay.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.iboxpay.entity.Student;

public interface StudentDao extends PagingAndSortingRepository<Student, Long> {

}
