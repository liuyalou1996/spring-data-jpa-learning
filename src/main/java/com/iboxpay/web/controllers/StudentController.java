package com.iboxpay.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iboxpay.dao.StudentDao;
import com.iboxpay.dao.StudentRepository;
import com.iboxpay.entity.Student;
import com.iboxpay.web.model.JsonModel;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/addStudent.action")
    @ResponseBody
    public String addNewStudent(@RequestParam("name") String name,
            @RequestParam("email") String email) {
        Student user = new Student();
        user.setName(name);
        user.setEmail(email);
        studentDao.save(user);
        return "Saved!";
    }

    @RequestMapping("/getAllStudentJsonModel.action")
    @ResponseBody
    public JsonModel<Student> getAllStudents() {
        JsonModel<Student> jm = new JsonModel<Student>();
        Sort sort = new Sort(Sort.Direction.DESC, "sid");
        Pageable pageable = new PageRequest(0, 10, sort);
        Page<Student> page = studentDao.findAll(pageable);
        jm.setRows(page.getContent());
        return jm;
    }

    @RequestMapping("/getAllStudentIterable.action")
    @ResponseBody
    public Iterable<Student> findAllStudent() {
        Iterable<Student> it = studentDao.findAll();
        return it;
    }

    @RequestMapping("/findAllStudentWithPagable.action")
    @ResponseBody
    public List<Student> findAllStudents(String name) {
        //查询第一页5条数据
        Pageable pageable = new PageRequest(0, 5, Sort.Direction.DESC, "sid");
        Page<Student> page = studentRepository.findAll(pageable);
        return page.getContent();
    }

    @RequestMapping("/getStudentByName.action")
    @ResponseBody
    public List<Student> getStudentByName(String name) {
        List<Student> list = studentRepository.findByName(name);
        return list;
    }

    @RequestMapping("/findAllByOrderBySidDesc.action")
    @ResponseBody
    public List<Student> findAllByOrderBySidDesc() {
        List<Student> list = studentRepository.findAllByOrderBySidDesc();
        return list;
    }

    @RequestMapping("/findFirstByOrderBySidDesc.action")
    @ResponseBody
    public Student findFirstByOrderBySidDesc() {
        Student student = studentRepository.findFirstByOrderBySidDesc();
        return student;
    }

    @RequestMapping("/findTop10.action")
    @ResponseBody
    public List<Student> findTop10() {
        Sort sort = new Sort(Direction.DESC, "sid");
        List<Student> list = studentRepository.findTop10By(sort);
        return list;
    }

    @RequestMapping("/findAllOrderBySidAsc.action")
    @ResponseBody
    public List<Student> findAllOrderBySidAsc(Pageable pageable) {
        Page<Student> page = studentRepository.findAll(pageable);
        return page.getContent();
    }

    @RequestMapping("/findStudents.action")
    @ResponseBody
    public List<Student> findStudentBySid(Integer sid) {
        List<Student> list = studentRepository.findAllStudent();
        return list;
    }

    @RequestMapping("/findStudentBySid.action")
    @ResponseBody
    public Student findStudentBySid(int sid) {
        Student student = studentRepository.findStudentBySid(sid);
        return student;
    }

    @RequestMapping("/findStudentByNameWithRawSql.action")
    @ResponseBody
    public Student findStudentByNameWithRawSql(String name) {
        Student student = studentRepository.findStudentByName(name);
        return student;
    }

    @RequestMapping("/findStudentBySidWithNamedPatameters.action")
    @ResponseBody
    public Student findStudentBySidWithNamedPatameters(int sid) {
        Student student =
                studentRepository.findStudentBySidWithNamedPatameters(sid);
        return student;
    }

    @RequestMapping("/findStudentListWithRawSql.action")
    @ResponseBody
    public JsonModel<Student> findStudentList() {
        Pageable pageable = new PageRequest(0, 10, Direction.DESC, "sid");
        Page<Student> page = studentRepository.findStudentPage(pageable);
        JsonModel<Student> jm = new JsonModel<Student>();
        jm.setRows(page.getContent());
        jm.setTotal((int) page.getTotalElements());
        return jm;
    }

}
