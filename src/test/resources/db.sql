create database study;
show databases;

create table student(
	sid int primary key auto_increment,
	name varchar(20),
	email varchar(30)
)
insert into student(name,email) values('liuyalou','2462405721@qq.com');
insert into student(name,email) values('liuqian','1461618651@qq.com');
insert into student(name,email) values('zhouxiangqiong','1113600718@qq.com');
insert into student(name,email) values('yangxi','2462405721@qq.com');
insert into student(name,email) values('fengyun','2462405721@qq.com');
insert into student(name,email) values('meixin','2462405721@qq.com');
insert into student(name,email) values('dingting','2462405721@qq.com');
insert into student(name,email) values('lixutong','2462405721@qq.com');
insert into student(name,email) values('zhaoyun','2462405721@qq.com');
insert into student(name,email) values('guanyu','2462405721@qq.com');
insert into student(name,email) values('zhangfei','2462405721@qq.com');
insert into student(name,email) values('huangzhong','2462405721@qq.com');
insert into student(name,email) values('machao','2462405721@qq.com');
insert into student(name,email) values('zhugeliang','2462405721@qq.com');
insert into student(name,email) values('pangtong','2462405721@qq.com');
insert into student(name,email) values('weiyan','2462405721@qq.com');
insert into student(name,email) values('jianggwei','2462405721@qq.com');
insert into student(name,email) values('xuqu','2462405721@qq.com');
insert into student(name,email) values('zhangliao','2462405721@qq.com');
insert into student(name,email) values('dianwei','2462405721@qq.com');
insert into student(name,email) values('xuhuan','2462405721@qq.com');
drop table student;
select *from student order by sid desc limit 0,10;
