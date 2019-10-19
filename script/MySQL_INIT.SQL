-- ================================
-- cloudDB1
-- ================================
drop database if exists cloudDB01;
create database cloudDB01 character set UTF8;
use cloudDB01;

create table dept
(
  deptno bigint not null primary key auto_increment,
  dname varchar(60),
  db_source varchar(60)
);

insert into dept(dname,db_source) values ('人事部',database());
insert into dept(dname,db_source) values ('研发部',database());
insert into dept(dname,db_source) values ('财务部',database());
insert into dept(dname,db_source) values ('市场部',database());
insert into dept(dname,db_source) values ('运维部',database());

-- ================================
-- cloudDB2
-- ================================
drop database if exists cloudDB02;
create database cloudDB02 character set UTF8;
use cloudDB02;

create table dept
(
  deptno bigint not null primary key auto_increment,
  dname varchar(60),
  db_source varchar(60)
);

insert into dept(dname,db_source) values ('人事部',database());
insert into dept(dname,db_source) values ('研发部',database());
insert into dept(dname,db_source) values ('财务部',database());
insert into dept(dname,db_source) values ('市场部',database());
insert into dept(dname,db_source) values ('运维部',database());

-- ================================
-- cloudDB3
-- ================================
drop database if exists cloudDB03;
create database cloudDB03 character set UTF8;
use cloudDB03;

create table dept
(
  deptno bigint not null primary key auto_increment,
  dname varchar(60),
  db_source varchar(60)
);

insert into dept(dname,db_source) values ('人事部',database());
insert into dept(dname,db_source) values ('研发部',database());
insert into dept(dname,db_source) values ('财务部',database());
insert into dept(dname,db_source) values ('市场部',database());
insert into dept(dname,db_source) values ('运维部',database());