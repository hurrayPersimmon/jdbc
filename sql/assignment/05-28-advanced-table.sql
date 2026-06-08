create database tabledb2;
use tabledb2;
drop table userTBL;

create table userTBL(
    userID char(8) primary key ,
    name varchar(10) not null ,
    birthyear int not null

);

drop table buyTBL;
create table buyTBL(
    num int auto_increment primary key,
    userID char(8) not null ,
    prodName char(6) not null,
    foreign key (userID) references userTBL(userID)
);

create table userTBL(
    userID char(8) primary key ,
    name varchar(10) not null ,
    birthyear int not null,
    email char(30) unique
);

create table userTBL(
    userID char(8) primary key ,
    name varchar(10) ,
    birthYear int check (birthYear between 1900 and 2023),
    mobile char(3) not null
);

drop table userTBL;

create table userTBL(
    userID char(8) primary key ,
    name varchar(10) not null ,
    birthYear int not null default -1,
    addr char(2) not null default '서울',
    mobile1 char(3) ,
    mobile2 char(8) ,
    height smallint default 170,
    mDate date
);

insert into userTBL (userID, name) values ('1', 'name');
select * from userTBL;

alter table userTBL drop column mobile1;
alter table userTBL rename column name to uName;
alter table userTBL drop primary key;

select * from userTBL;

use employees;

create or replace view EMPLOYEES_INFO as
    select e.emp_no, birth_date, first_name, last_name, gender, hire_date,
           title, t.from_date t_from, t.to_date t_to,
           salary, s.from_date s_from, s.to_date s_to
    from employees e
    join titles t on e.emp_no = t.emp_no
    join salaries s on e.emp_no = s.emp_no;

select * from EMPLOYEES_INFO;

select * from EMPLOYEES_INFO where s_to = '9999-01-01';


create or replace view EMP_DEPT_INFO as
    select emp_no, d.dept_no, dept_name, from_date, to_date
    from dept_emp d
    join departments de on d.dept_no = de.dept_no
    order by emp_no;

select * from EMP_DEPT_INFO;

select * from EMP_DEPT_INFO where to_date = '9999-01-01';