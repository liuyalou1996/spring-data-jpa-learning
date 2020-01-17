package com.universe.test;

import com.universe.Application;
import com.universe.entity.OperationLog;
import com.universe.repository.OperationLogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class OperationLogTest {

	@Autowired
	private OperationLogRepository repository;

	@Test
	public void queryOperationLog() {
		List<OperationLog> list = repository.findAllOperationLog(PageRequest.of(0, 1));
		System.out.println(list);
	}

	@Test
	public void insertRecord() {
		OperationLog log = new OperationLog();
		log.setId(1);
		log.setOpType(1);
		log.setOpContent("修改用户");
		log.setUserId(1);
		log.setCreateTime(new Date());
		repository.save(log);
		// save执行时会自动为持久化对象设置主键值
		System.err.println(log.getId());

	}

}
