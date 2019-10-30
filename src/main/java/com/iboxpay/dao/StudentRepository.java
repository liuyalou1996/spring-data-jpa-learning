package com.iboxpay.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.iboxpay.entity.Student;

public interface StudentRepository extends Repository<Student, Long> {

    public Student findFirstByOrderBySidDesc();

    public List<Student> findByName(String name);

    //有Pageable参数返回值类型只能为Page,不能为List
    public Page<Student> findAll(Pageable pageable);

    //由于第一个By为界限符，By前面只能是find或findAll等关键字，所以一定要在前面再加上一个By
    public List<Student> findAllByOrderBySidDesc();

    //这里必须在最后写一个By，前面只能find或findAll
    public List<Student> findTop10By(Sort sort);

    @Query("select sid,name,email from Student")
    public List<Student> findAllStudent();

    //使用HQL语句from后面的字段为实体类名
    @Query("select stu from Student stu where sid=?1")
    public Student findStudentBySid(int sid);

    //使用命名参数
    @Query("select stu from Student stu where stu.sid=:sid")
    public Student findStudentBySidWithNamedPatameters(@Param("sid") int sid);

    //如果要使用原生sql的话，将nativeQuery属性设置为true
    @Query(value = "select *from student where name=?1", nativeQuery = true)
    public Student findStudentByName(String name);

    //原生sql要支持分页查询的话，必须要手动加上统计查询语句，注意要条件要保持一致
    @Query(value = "select *from student", countQuery = "select count(sid) from student", nativeQuery = true)
    public Page<Student> findStudentPage(Pageable pageable);

}
