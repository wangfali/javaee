SELECT * FROM EMP;
SELECT * FROM EMP WHERE EMPNO>8000
SELECT EMPNO,ENAME,SAL,COMM FROM EMP WHERE SAL<COMM
SELECT DEPTNO,COUNT(*)FORM EMP GROUP BY DEPTNO
SELECT DEPTNO,SUM(SAL)TOTAL_SAL FROM EMP WHERE JOB='MANAGER' GROUP BY DEPTNO
SELECT DEPTNO,SUM(SAL)TOTAL_SAL FROM EMP WHERE JOB='MANAGER'GROUP BY DEPTNO
SELECT JOB, COUNT(DISTINCT DEPTNO) FROM EMP WHERE MGR IS NOT NULL GROUP BY JOB ORDER BY JOB
SELECT JOB,COUNT(DISTINCT DEPTNO)FROM EMP WHERE MGR IS NOT NULL GROUP BY JOB ORDER BY COUNT(DISTINCT DEPTNO)DESC JOD;
SELECT DEPTNO,TO_CHAR(HIREDATE,'yyyy'),COUNT(*)FROM EMP GROUP BY DEPTNO,TO_CHAR(HIREDATE,'yyyy')
SELECT DEPTNO,TO_CHAR(HIREDATE,'yyyy'),COUNT(*)FROM EMP GROUP BY DEPTNO,2;
SELECT DEPTNO,TO_CHAR(HIREDATE,'yyyy'),COUNT(*)FROM EMP GROUP BY DEPTNO,2;
SELECT DEPTNO,TO_CHAR(HIREDATE,'yyyy')HIREYEAR,COUNT(*)FROM EMP GROUP BY DEPTNO,HIREYEAR;
SELECT DEPTNO,TO_CHAR(HIREDATE,'yyyy'),COUNT(*)FROM EMP GROUP BY TO_CHAR(HIREDATE,'yyyy') DEPTNO;
SELECT DEPTNO,TO_CHAR(HIREDATE,'yyyy')HIREYEAR,COUNT(*)FROM EMP GROUP BY DEPTNO,TO_CHAR(HIREYEAR,'yyyy') ORDER BY DEPTNO,HIREYEAR;
--SELECT select_list FROM table/view [where_clause][group_by_clause][order_by_clause]
/*经典语法格式*/
--认识亚表
SELECT SYSDATE FROM DUAL;
SELECT USER FROM DUAL;
SELECT 1+3 FROM DUAL;
SELECT 7*5 FROM DAUL;
SELECT POWER(2,10)FROM DUAL;
SELECT TO_CHAR(SYSDATE,'yyyy-MM-DD')FROM DUAL;
CREATE SEQUENCE JPBS2013;
SELECT JPBS2013.NEXTVAL FROM DUAL;
SELECT JPBS2013.CURRVAL FROM DAUL;
DROP SEQUENCE JPBS2013
SELECT EMPNO,ENAME FROM EMP WHERE MGR IN
	(SELECT EMPNO FROM EMP WHERE JOB='MANAGER')
SELECT * FROM DEPT WHERE DEPTNO NOT IN (SELECT DISTINCT DEPTNO FROM EMP);
SELECT * FROM DEPT WHERE DEPTNO NOT IN (SELECT DEPTNO FROM EMP);
SELECT EMPNO,ENAME,SAL FROM EMP WHERE
 MGR=(SELECT EMPNO FROM EMP WHERE ENAME='SCOTT')
 SELECT *FROM EMP WHERE SAL >1.4*(SELECT AVG(SAL)FROM EMP);
 INSERT INTO DEPT(DEPTNO,DNAME,LOC)SELECT50,'TRAINING','PEKING'FROM DUAL;
 UPDATE EMP SET SAL=SAL*1.2 WHERE EXISTS(SELECT 1 FROM DEPT WHERE DEPTNO=EMP.DEPTNO AND LOC='DALLAS');
--层次查询
--start_with_clause connect by prior_expr
SELECT LEVEL,T.* FROM EMP T START WITH EMPNO=7788 connect BY PRIOR EMPNO=MGR; 
SELECT PAGESIZE 1000;
DESC DEPT--SQLPLUSE
--NUMBER数字类型 VARCHAR2 字符串
/*
	SELECT *|列名 from 表名
*/
--UNIONB并集 INTERSECT交集 MINUS 补集
--等值连接
SELECT DNAME,LOC,EMPNO,ENAME FROM EMP A,DEPT B WHERE A.DEPTNO=B.DEPTNO AND B.DEPTNO=20;
--自连接 起别名 列名+空格+别名
SELECT A.EMPNO,A.SAL,B.EMPNO,B.ENAME,B.SAL FROM EMP A,EMP B WHERE A.MGR=B.EMPNO AND A.ENAME='SCOTT';
--内连接
SELECT EMPNO,ENAME,SAL,GRADE FROM EMP,SALGRADE WHERE DEPTNO=10 AND SAL BETWEEN LOSAL AND HISAL
SELECT EMPNO,ENAME,SAL,GRADE FROM EMP INNER JOIN SALGRADE ON DEPTNO=10 AND SAL BETWEEN LOSAL AND HISAL;
--反连接
SELECT ENAME,SAL*12 AS 年薪 FROM EMP;
SELECT * FROM EMP WHERE DEPTNO NOT IN(SELECT DEPTNO FROM DEPT WHERE LOC IN('NEW YORK','DALLAS'));
SELECT * FROM DEPT WHERE DEPTNO NOT IN(SELECT DEPTNO FROM EMP);
SELECT * FROM EMP,DEPT WHERE EMP.DEPTNO=DEPT.DEPTNO AND DEPT.LOC='NEW YORK';
--半连接
SELECT * FORM EMP A WHERE EXISTS(SELECT 1 FROM DEPT B WHERE LOC='NEW YORK' AND A.DEPTNO=B.DEPTNO) 
SELECT A.* FROM EMP A,DEPT B WHERE LOC='NEW YORK' AND A.DEPTNO=B.DEPTNO;
SELECT *FROM DEPT A WHERE EXISTS(SELECT 1 FROM EMP B WHERE A.DEPTNO=B.DEPTNO AND B.SAL>2900);
SELECT A.* FROM DEPT A,EMP B WHERE A.DEPTNO=B.DEPTNO AND B.SAL>2900;
SELECT DISTINCT A.* FROM DEPT A,EMP B WHERE A.DEPTNO=B.DEPTNO AND B.SAL>2900
--外连接 (+)left outer\rigth outer join\full outer join
SELECT B.DEPTNO,B.DNAME,A.* FROM EMP A,DEPT B WHERE A.DEPTNO(+)=B.DEPTNO;
--SELECT ENAME||JOB 连接符
--常量 ''号表示字符串 数字类型直接写
SELECT '员工姓名:'|| ENAME，||'员工职位:' JOB FROM EMP
SELECT B.DEPTNO,B.DNAME,A.* FROM EMP A,DEPT B WHERE A.DEPTNO(+)=B.DEPTNO;
SELECT B.DEPTNO,COUNT(*) FROM EMP A,DEPT B WHERE A.DEPTNO(+)=B.DEPTNO GROUP BY B.DEPTNO;
SELECT B.DEPTNO,COUNT(EMPNO)FROM EMP A,DEPT B WHERE A.DEPTNO(+)=B.DEPTNO GROUP BY B.DEPTNO;
SELECT B.DEPTNO,COUNT(EMPNO)FROM EMP A,DEPT B WHERE A.DEPTNO(+)=B.DEPTNO GROUP BY B.DEPTNO;
SELECT B.DEPTNO,COUNT(EMPNO)FROM EMP A,DEPT B WHERE A.DEPTNO(+)=B.DEPTNO AND A.JOB(+)='MANAGER'GROUP BY B.DEPTNO;
SELECT B.* FROM EMP A,DEPT B WHERE A.DEPTNO(+)=B.DEPTNO AND A.EMPNO IS NULL;
--SQL语句支持大小写， 值是严格区分大小写
SELECT B.DEPTNO,B.DNAME,A.* FROM EMP A RIGTH JOIN DEPT B ON A.DEPTNO=B.DEPTNO;
SELECT B.* FROM EMP A RIGTH outer JOIN DEPT B ON A.DEPTNO=B.DEPTNO WHERE .EMPNO IS NULL;
WITH A AS (SELECT 1 FROM DUAL UNION ALL SELECT 1 FROM DUAL)
SELECT ROWNUM FROM A,A,A,A,A,A;
WITH A AS (SELECT 1 FROM DUAL UNION ALL SELECT 1 FROM DUAL)
SELECT ASCII('A')FROM DUAL;
SELECT TO_DATE('2014-07-01 22:15','yyyy-mm-dd hh24:mi') FROM DUAL
SELECT TRUNC(1.01)FROM DUAL;
SELECT DEPTNO,MAX(SAL)FROM EMP GROUP BY DEPTNO;
SELECT MAX(HIREDATE)FROM;
SELECT MAX(HIREDATE) FROM EMP
SELECT EMPNO,ENAME,SAL,SUM(SAL)OVER(ORDER BY EMPNO)FROM EMP ORDER BY EMPNO;
SELECT * FROM EMP WHERE SAL!=1500;
SELECT * FROM EMP WHERE SAL<2000;
SELECT ENAME,DEPTNO FROM EMP WHERE SAL >= 3000;
SELECT * FROM EMP WHERE COMM> SAL;
SELECT * FROM EMP WHERE SAL<=1000 ;
SELECT * FROM EMP WHERE SAL>1200 AND SAL<2000;
SELECT * FROM EMP WHERE SAL BETWEEN 1200 AND 2000;SELE
SELECT * FROM EMP WHERE JOB!='CLERK' OR JOB!='SALESMAN';
SELECT * FROM EMP WHERE JOB NOT IN('CLERK','SALESMAN') AND SAL >1500
SELECT * FROM EMP WHERE HIREDATE BETWEEN DATE '1985-01-20' AND DATE '1988-12-25';
SELECT * FROM EMP WHERE COMM IS NOT NULL;
SELECT * FROM EMP WHERE COMM =0;
SELECT * FROM EMP WHERE MGR IS NULL;
SELECT * FROM EMP WHERE EMPNO IN(7639,7651,7689);
SELECT * FROM EMP WHERE EMPNO=7639 OR EMPNO=7651 OR EMPNO;
--模糊查询 _ 匹配一个字符、% 匹配0个或多个
SELECT * FROM EMP WHERE ENAME LIKE '_S%';
SELECT * FROM EMP WHERE ENAME LIKE 'S%';
SELECT * FROM EMP WHERE HIREDATE LIKE DATE '1981-1-01';
SELECT * FROM EMP WHERE SAL LIKE '%1%';
SELECT * FROM EMP WHERE JOB LIKE '%MA%';
SELECT * FROM EMP WHERE ENAME LIKE '%S%' AND HIREDATE LIKE '%5%' AND SAL LIKE '%5%';
--优化，能过滤大部分数据库写在语句前面，（ORACLE会自动帮助我们优化）
--排序 升序 ASC 降序 DESC ORDER BY  默认是升序的
/*
	SELRCT * | 3
	FROM     1
	WHERE    2
	ORDER BY  4
	涉及到运算的时候注意要使用别名
*/
SELECT * FROM EMP ORDER BY COMM DESC;
SELECT * FROM EMP ORDER BY HIREDATE ASC;
SELECT * FROM EMP ORDER BY SAL*12 DESC;
SELECT * FROM EMP ORDER BY SAL,HIREDATE DESC 
SELECT * FROM EMP ORDER BY SAL DESC,HIREDATE ASC;



SELECT * FROM EMP ORDER BY HIREDATE ASC;
SELECT ENAME,JOB, SAL*12 AS INCOME FROM EMP ORDER BY INCOME;  
--强制转换类型函数  not in null 语法不允许
SELECT CAST('1234' AS NUMBER(9))FROM DUAL;
SELECT CAST(12 AS NUMBER(2))FROM DAUL;
SELECT CAST(12 AS NUMBER(9)) FROM DUAL;
SELECT CAST(1.2345E4 AS NUMBER(9))FROM DUAL;
SELECT CAST(1.2345E8 AS NUMBER(8)) FROM DUAL;
--NVL() 任意类型
SELECT ENAME,SAL*12+NVL(COMM,0) FORM EMP;
--如果a不为NULL，取b值，否则取c值
SELECT ENAME,SAL*12+NVL2(COMM,COMM,0) FROM EMP;
--如果a与b相同，返回NULL否则返回a
SELECT NULLIF(10,'10') FROM DUAL;
SELECT ENAME "姓名",JOB "职位",SAL "涨前工资",
	CASE JOB 
		WHEN 'ANALYST' THEN SAL+1000
		WHEN 'MANAGER' THEN SAL+800
		ELSE SAL+400
	END "涨后工资"
FROM EMP;
--DECODE(字段，条件1，表达式1，条件2，表达式2，。。表达式n)
SELECT ENAME "姓名",JOB "职位",SAL "涨前工资"
	DECODE(JOB,'ANALYST',SAL+1000,'MANAGER',SAL+800,SAL+400) "涨后工资"
FROM EMP;

SELECT COUNT(*) FROM EMP;
SELECT COUNT(DISTINCT DEPTNO)FROM EMP;
SELECT COUNT(COMM) FROM EMP;
--四舍五入
SELECT SUM(SAL)"总工资",ROUND(AVG(SAL),0)"平均工资" FROM EMP;
SELECT MAX(HIREDATE) "最晚入职时间",MIN(HIREDATE) "最早入职时间" FROM EMP;
SELECT MAX(SAL)"最高工资",MIN(SAL) "最低工资" FROM EMP;
--多行函数count/sum/avg/max/min
SELECT DEPTNO "部门编号",TRUNC(AVG(SAL),0)"部门平均工资" FROM EMP 
GROUP BY DEPTNO HAVING TRUNC(AVG(SAL),0)>2000;

SELECT DEPTNO "部门编号",TRUNC(AVG(SAL),0)"部门平均工资" FROM EMP
GROUP BY DEPTNO
HAVING TRUNC(AVG(SAL),0) >2000
ORDER BY 2 DESC;

SELECT DEPTNO,AVG(SAL) FROM EMP GROUP BY DEPTNO HAVING DEPTNO<>10;

SELECT DEPTNO,AVG(SAL) FROM EMP WHERE DEPTNO<>10 GROUP BY DEPTNO;

SELECT MAX(AVG(AVG)) "部门平均工资的最大值" FROM EMP GROUP BY DEPTNO;
/*GROUP BY子句的细节：
1、在select子句中出现的非多行函数的所有列 必须出现在group by子句中
在group by子句中出现的所有列（不一定）在select子句中

having 是针对分组之后的记录
*/ 
SELECT EMP.ENAME,DEPT.DNAME FROM EMP, DEPT;

SELECT EMP.EMPNO,EMP.ENAME,DEPT.DNAME,DEPT.DEPTNO FROM EMP,DEPT WHERE EMP.DEPTNO=DEPT.DEPTNO;

SELECT E.EMPNO,E.ENAME,E.SAL,S.GRADE FROM EMP E,SALGRADE S WHERE E.SAL BETWEEN S.HISAL;

SELECT DEPT.DEPTNO "部门号",DEPT.DNAME "部门名",COUNT (EMP.EMPNO) "人数"
FROM DEPT,EMP
WHERE DEPT.DEPTNO=EMP.DEPTNO(+) GROUP BY DEPT.DEPTNO,DEPT.DNAME;

SELECT DEPT.DEPTNO "部门号",DEPT.DNAME "部门名",COUNT (EMP.EMPNO)"人数"
WHERE DEPT.DEPTNO(+)=EMP.DEPTNO GROUP BY DEPT.DEPTNO,DEPT.DNAME;

SELECT DEPT.DEPTNO "部门号",DEPT.DNAME "部门名",COUNT(EMP.EMPNO) "人数"
FROM DEPT,EMP
WHERE DEPT.DEPTNO=EMP.DEPTNO(+)
GROUP BY DEPT.DEPTNO,DEPT.DNAME
ORDER BY 3 DESC;

SELECT A1.ENAME,A2.ENAME FROM EMP A1,EMP A2 WHERE A1.MGR=A2.EMPNO;

SELECT SAL FROM EMP WHERE ENAME='WARD';

SELECT * FROM EMP WHERE SAL>1250;

SELECT * FROM EMP SAL>(SELECT SAL FROM EMP WHERE ENAME='WARD')

SELECT DEPTNO FROM DEPT WHERE DNAME='SALES';
SELECT * FROM EMP WHERE DEPTNO=30

SELECT * FROM EMP WHERE DEPTNO =(SELECT DEPTNO FROM DEPT WHERE DNAME='SALES' );

SELECT EMP.* FROM EMP,DEPT WHERE DEPT.DNAME='SALES' AND DEPT.DEPTNO=EMP.DEPTNO;

SELECT EMP.EMPNO,EMP.ENAME,EMP.DEPTNO,SALGRADE.GRADE FROM 
EMP,DEPT,SALGRADE
WHERE EMP.DEPTNO=DEPT.DEPTNO AND (EMP.SAL BETWEEN SALGRADE.LOSAL AND SALGRADE.HISAL);

SELECT MIN(SAL)FROM EMP;
SELECT * FROM EMP WHERE SAL =800;
SELECT * FROM EMP WHERE SAL=(SELECT MIN(SAL) FROM EMP);

SELECT * FROM EMP WHERE DNAME IN (SELECT DNAME FROM DEPT WHERE DNAME IN ('ACCOUNTING','SALES'));

SELECT * FROM EMP WHERE SAL < ALL(SELECT * FROM EMP WHERE DEPTNO=10);
--UNION AND UNION ALL 
SELECT * FROM EMP WHERE DEPTNO=20 UNION SELECT * FROM EMP WHERE DEPTNO=30;
SELECT * FROM EMP WHERE SAL BETWEEN 1000 AND 2000
INTERSECT
SELECT * FROM EMP WHERE SAL BETWEEN 1500 AND 2500;
SELECT * FROM EMP WHERE(SAL BETWEEN 1000 AND 2000) AND (SAL BETWEEN 1500 AND 2500)
--差集
SELECT * FROM EMP WHERE SAL BETWEEN 1000 AND 2000
MINUS
SELECT * FROM EMP WHERE SAL BETWEEN 1500 AND 2000
SELECT * FROM EMP WHERE (SAL BETWEEN 1000 AND 2000) AND (SAL NOT BETWEEN 1500 AND 2500)
--集合操作时，必须保证集合列类型对应相同
--集合操作时，必须保证集合列数相同
--当多个集合操作时，结果的列名由第一集合列名决定
SELECT EMPNO "编号",ENAME "姓名",SAL "薪水" FROM EMP WHERE DEPTNO=20
UNION 
SELECT EMPNO,ENAME,SAL FROM EMP WHERE DEPTNO=10;

SELECT * FROM USERS LIMIT 0,2
SELECT * FROM USERS LIMIT 2;

SELECT * FROM USERS LIMIT 0,3;
SELECT * FROM USERS LIMIT 3;

SELECT * FROM USERS LIMIT 1,3;
--DDL
DROP TABLE IF EXISTS USERS;
--MYSQL
CREATE TABLE IF NOT EXISTS USERS(
	ID INT(5) AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(4) NOT NULL,
	BIRTHDAY DATE DEFAULT '2015-4-27'
);
--ORACLE
CREATE TABLE USERS(
	ID NUMBER(5) PRIMARY KEY,
	NAME VARCHAR2(8) NOT NULL UNIQUE,
	SAL NUMBER(6,2) NOT NULL,
	BIRTHDAY DATE DEFAULT SYSDATE
);
--回收站
DROP TABLE USERS;
SHOW RECYCLEBIN;
--ALTER TABLE
ALTER TABLE EMP ADD IMAGE BOLD;
ALTER TABLE EMP MODIFY ENAME VARCHAR2(20);
ALTER TABLE EMP DROP COLUMN IMAGE;
ALTER TABLE EMP RENAME COLUMN ENAME TO USERNAME;
RENAME EMP TO EMPS;
ALTER TABLE EMP DROP COLUMN SAL;
ALTER TABLE EMP ADD SAL NUMBER(6) DEFAULT 0;
--PRIMARY KEY /NOT NULL /UNIQUE /DEFAULT /FOREIGN KEY
DELETE FROM CUESTOMER WHERE ID =1;

CREATE TABLE CUESTOMER(
	ID NUMBER(3) PRIMARY KEY,
	NAME VARCHAR2(4) NOT NULL UNIQUE
);
INSERT INTO CUESTOMER(ID,NAME) VALUES(1,'A');
INSERT INTO CUESTOMER(ID,NAME) VALUES(2,'B');

CREATE TABLE ORDERS(
	ID NUMBER(3) PRIMARY KEY,
	ISBN VARCHAR2(6) NOT NULL UNIQUE,
	PRICE NUMBER(3) NOT NULL,
	CID NUMBER(3),
	--删除置空
	CONSTRAINT CID_FK FOREIGN KEY(CID) REFERENCES CUESTOMER(ID) ON DELETE SET NULL
	--删除级联
	CONSTRAINT CID_FK FOREIGN KEY(CID) REFERENCES CUESTOMER(ID) ON DELETE CASCADE
);
INSERT INTO ORDERS(ID,ISDN,PRICE,CID) VALUES(1,'ISDN10',10,1);
INSERT INTO ORDERS(ID,ISDN,PRICE,CID) VALUES(2,'ISDN20',20,1);
INSERT INTO ORDERS(ID,ISDN,PRICE,CID) VALUES(2,'ISDN30',20,1);
INSERT INTO ORDERS(ID,ISDN,PRICE,CID) VALUES(2,'ISDN40',20,1);
SELECT SYSDATE
	MONTHS_BETWEEN(SYSDATE,TO_DATE('2006-01-01','yyyy-MM-DD')),
	MONTHS_BETWEEN(SYSDATE,TO_DATE('2016-01-01','yyyy-MM-DD'))FROM DUAL

CREATE TABLE STUDENTS(
	ID NUMBER(3) PRIMARY KEY,
	NAME VARCHAR2(4) NOT NULL UNIQUE,
	GENDER VARCHAR2(2)NOT NULL CHECK(GENDER IN('男','女')),
	SALARY NUMBER(6)NOT NULL CHECK(SALARY BETWEEN 6000 AND 8000)
);
INSERT INTO STUDENTS(ID,NAME,GENDER,SALARY) VALUES(1,'SD','W',6000);
--复制表
CREATE TABLE XXX_EMP AS SELECT * FROM EMP;

SELECT TO_CHAR(SYSDATE,'yyyy-MM-DD hh24:MI:SS') FROM DUAL;
INSERT INTO EMP VALUES(1111,'JACK','IT',7788,SYSDATE,1000,100,40);
INSERT INTO EMP(ENAME,EMPNO,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO)
 VALUES(1111,'JACK','IT',7788,SYSDATE,1000,100,40);

SELECT TO_DATE('2017-8-2','yyyy-MM-DD') FROM DUAL;
INSERT INTO EMP VALUES(3333,'SISI','IT',MGR,HIREDATE,SAL,DEPTNO)
VALUES('SOSO',4444,'IT',7788,SYSDATE,1000,40);
/*
	SELECT *|列名[别名]... FROM 表名1[别名],表名2[别名]...
	WHERE 条件
	ORDER BY 列名[ASC|DESC]
*/
CREATE INDEX EMP_NO_INDEX ON EMP(EMPNO);

SELECT ENAME,EMPNO,LOC
FROM EMP,DEPT;
--多列索引
CREATE INDEX EMP_ENAME_JOB ON EMP(ENAME,JOB);
--CREATE INDEX 索引名 ON 表名（字段,...）
CREATE INDEX EMP_EMPNO_IDX ON EMP(EMPNO);
--删除索引
DROP INDEX EMP_EMPNO_IDX;
DROP INDEX EMP_ENAME_JOB_IDX;
--CREATE SEQUENCE 序列名     创建序列
CREATE SEQUENCE EMP_EMPNO_SQE;
--DROP SEQUENCE 序列名
DROP SEQUENCE EMP_EMPNO_SQE;
--序列查询
SELECT EMP_EMPNO_SQE.NEXTVAL FROM DUAL;
SELECT EMP_EMPNO_SQE.CURRVAL FROM DUAL;
INSERT INTO EMP(EMPNO) VALUES(EMP_EMPNO_SQE.NEXTVAL);
INSERT INTO EMP(EMPNO) VALUES(EMP_EMPNO_SQE.NEXTVAL);
INSERT INTO EMP(EMPNO) VALUES(EMP_EMPNO_SQE.NEXTVAL);
INSERT INTO EMP(ENAME,EMPNO,JOB,MGR,HIREDATE,SAL,DEPTNO)
VALUES('SOSO',4444,'IT',7788,SYSDATE,1000,40);

CREATE VIEW EMP_VIEW_1 
AS
SELECT * FROM EMP;

GRANT CREATE VIEW TO SCOTT;
REVOKE CREATE VIEW FROM SCOTT;

/*
	ORCALE特有的语法格式  
		select * |列名[别名]...
		from 表名1[别名]，表2[别名]
	where 表1.列名(+)=表2.列名
	
	SQL99
	SELECT * |列名[别名]...
	FROM 表1[别名] RIGTH OUTER HION 表2[别名]
	
	ON 表示去笛卡尔积的条件相当于 where e.关联字段=d.关联字段
	USING (DEPTNO)就是去笛卡儿积的条件  
		注意：关联字段的列名要一致，不能带有别名，不能和自然连接一起使用
	全链接：
		SELECT * 
		FROM EMP A FULL
		OUTER JOIN DEPT D
		ON(E.DEPTNO=D.DEPTNO);
	返回两个表中不满足条件的所有记录

	连接数据库的方式
		等值连接
		交叉连接（Coress JION）
		外连接 左外连接（显示左边的列名），右外连接（显示右变得列名），全连接
	自然连接 
		自己去找关联去掉笛卡儿积
		SELECT * FROM EMP NATURAL JION DEPT
			使用自然连接的条件
				1、两个关联字段的名称要一致
				2、类型要一致
				3、不允许关联字段使用前缀
INSERT INTO 表名 SELECT ...语法
*/
INSERT INTO EMP SELECT * FROM XXX_EMP WHERE DEPTNO=20;

UPDATE EMP SET SAL=SAL*1.2 WHERE ENAME=UPPER('SMITH');

SELECT AVG(SAL) FROM EMP WHERE DEPTNO=20;
--SELECT * FROM 表名1[别名]，表名2[别名] WHERE 条件（） order by 列名1[升序|降序]
/*
	如何解决笛卡尔积 一对一，一对多，多对一，多对多
		等值连接，非等值连接，外连接（左外连接，右外连接），
	左外连接的语法：SELECT * FROM 表1，表2 FROM 表1.关键字段=表2.关键字段（+）
					SELECT * FROM 表1，表2 FROM 表1.关键字段（+）=表2.关键字段
					SELECT * FROM 表1 LEFT [OUTER] JION 表2 ON|USING
					SELECT * FROM 表1 RIGTH [OUTER] JION 表2 ON|USING
	分组查询  聚合函数、对一组有共性数据的处理。
	函数分类：单行函数、多行函数
	分组函数：多行函数、聚合函数
	MAX(DISTINCT|ALL 列名)
	MIN(DISTINCT| ALL列名)
	COUNT(DISTINCT|ALL列名)
	
	SELECT *|列名[别名]，列名[别名]
	FROM 表[别名]，表[别名]
	[WHERE 条件]
	[GROUP BY 分组自段]
	[ORDER BY 字段[asc|DESC]

	对多行函数计算并返回一个行数
	count(*)求所有的数据条数，不需要考率null值
	count(列名)忽略null值
	MAX,MIN,AVG,SUM ,
	分组统计查询，单表、单条件、单字段
	SELECT 中出现的列名，必须在GROUP BY 中出现，否则在分组函数中使用
		1、在group by 中出现的不一定在列名中出现
		2、GROUP BY 后面不能接列的别名
		3、group by 后面不能接数组
	过滤作用
		HAVIG 过滤分组
	SELECT * |列名[别名]
	FROM 表名 
	WHERE 条件
	GRUOP BY 字段
	HAVING 条件
	OEDER BY 字段 示例代码	

	WHERE 条件里面是不允许有分组函数的
	MIN MAX NVL NVL2 COUNT SUM AVG 

	SELECT *|列名[别名]
	FROM  表名[别名]
	WHERE  条件
	GROUP BY 分组字段
	HAVING 条件
	ORDER BY 排序字段
	
	ORDER BY 不能使用子查询
*/ 
BEGIN
	DBMS_OUTPUT.PUT_LINE('HELLO 你好！')
END;
--使用基本类型变量，常量和注释 求10+100的和
DECLARE
	MYSUM NUMBER(3):=0;
	TIP VARCHAR2(10):='结果是';
BEGIN
END;
--表名.字段名%type  表示取类型
DECLARE
	PENAME EMP.ENAME%TYPE;
	PSAL EMP.SAL%TYPE;
BEGIN
	SELECT ENAME,SAL,FROM EMP WHERE EMPNO=7092;
	SELECT ENAME,SAL INTO PENAME,PSAL FROM EMP WHERE EMPNO=7092;
	DBMS_OUTPUT.PUT_LINE('7369号员工的姓名是'||PENAME||'薪水是'||PSAL);
END;

DECLARE
	EMP_RECORD EMP%ROWTYPE;
BEGIN
	SELECT * INTO EMP_RECORD FROM EMP WHERE EMPNO=7788;
	DBMS_OUTPUT.PUT_LINE('7788号员工的姓名是'||EMP_RECORD.ENAME||'薪水是'||EMP_RECORD.SAL);
END;

DECLARE
	PDAY VARCHAR2(10);
BEGIN
	SELECT TO_CHAR(SYSDATE,'DAY') INTO PDAY FROM DUAL;
	DBMS_OUTPUT.PUT_LINE('今天是'||PDAY);
	IF PDAY IN ('星期六','星期天') THEN
		DBMS_OUTPUT.PUT_LINE('休息日');
	ELSE
		DBMS_OUTPUT.PUT_LINE('工作日');
	END IF;
END;

DECLARE
	AGE NUMBER(3):=&AGE;
BEGIN
	IF AGE<16 THEN
		DBMS_OUTPUT.PUT_LINE
END;
/*
	子查询 可以放在SELECT ,FROM , WHERE DAVING 
	IN 任何一个，ANY任意一个
	ALL 所有
	exists 返回值是布尔值

	返回单行多列
		（列名，列名，列名。。。）=

	返回多行单列

	(列名，列名，列名)in(值1，值2，值3)

	SELECT * FROM EMP WHERE(SAL,COMM)=(SELECT )

	SELECT * FROM EMP WHERE (SAL,JOB) IN()

	单行单列 = <
	in any all exists

	单行多列 （列名，列名）=（值1，值2）
	多行多列 （列名，列名）in（值1，值2）
	
	如果子查询出现在from语句当中的时候，其返回的接口一般都是多行多列
	
	SELECT *| 列名[]
	from 表名，子查询
	where 
	group by  having 
	order by 
		< = != not in
	伪列

	select yy.*
	from (select rownum ids,emp.* from emp where rownum<=9) yy
	where ids>=5;

	INSERT INTO 表名（列名，列名）VALUAS(值1，值2)

	UPDATE 表名 set 键值对、键值对
	where 

	delect from emp where 

	CLOD 4G
	BLOB BINARY FILE
	DATA 包含年月日时分秒
	timestamp

	时间、数字、字符串、char\
*/

DECLARE
 	AGE NUMBER (3) :&AGE;
BEGIN
	IF AGE<16 THEN
		DBMS_OUTPUT.PUT_LINE('你未成年人');
	ELSE IF AGE < 30 THEN
		DBMS_OUTPUT.PUT_LINE('你是青年人');
	ELSE IF AGE < 60 THEN
		DBMS_OUTPUT.PUT_LINE('你是奋斗人');
	ELSE IF AGE < 80 THEN
		DBMS_OUTPUT.PUT_LINE('你是享受人');
	ELSE 
		DBMS_OUTPUT.PUT_LINE('未完待续');
	END IF;
END;

--使用loop循环显示1-10
DECLARE
	I NUMBER(2) :=1;
BEGIN
	LOOP
		--判断条件 
		EXIT WHEN I>10;
		--输出值
		DBMS_OUTPUT.PUT_LINE(I);
		--变量自加
		I := I + 1;
	END LOOP;
END;
--使用while循环显示
DECLARE
  i number(2):=1;
BEGIN
	WHILE I<11
	LOOP
		DBMS_OUTPUT.PUT_LINE(I);
		I:= I + 1;
	END LOOP;
END;

--使用while循环，向emp表中插入999条记录
DECLARE
	I NUMBER(4) :=1;
BEGIN
	WHILE(I<1000)
	LOOP
		INSERT INTO EMP(EMPNO,ENAME) VALUES (I,'哈哈');
		I := I+1;
	END LOOP;
END;

--使用while循环，从emp表中删除999条记录
DECLARE
	I NUMBER(4) :=1;
BEGIN
	WHILE I <1000
	LOOP
		DELETE FROM EMP WHERE EMPNO=I;
	END LOOP;
END; 

--使用的for循环显示20-30
DECLARE
	I NUMBER(2) :=20;
BEGIN
	FOR I IN 20..30
	LOOP
		DBMS_OUTPUT.PUT_LINE(I);
	END LOOP;
END;

--游标
DECLARE 
	--定义游标
	CURSOR CEMP ID SELECT ENAME,SAL FROM EMP;
	--定义变量
	VENAME EMP.ENAME%TYPE;
	VSAL EMP.SAL*TYPE;
BEGIN
	--打开游标，这时游标位于第一条记录之前
	OPEN CEMP;
	--循环
	LOOP
	--向下移动游标一次
		FETCH CEMP INTO VENAME,VSAL;
	--退出循环，当游标下移一次后，找不到记录时，则退出循环
		EXIT WHEN CEMP%NOTFOUND;
	--输出结果
		DBMS_OUTPUT.PUT_LINE(VENAME||'-------'||VSAL);
	END LOOP
	CLOSE CEMP;
END;

使用带参光标cursor，查询10号部门的员工姓名和工资
declare
    cursor cemp(pdeptno emp.deptno%type) is select ename,sal from emp where deptno=pdeptno;
    pename emp.ename%type;
    psal emp.sal%type; 
begin 
    open cemp(&deptno);
    loop
        fetch cemp into pename,psal;	 
        exit when cemp%notfound;
        dbms_output.put_line(pename||'的薪水是'||psal);
    end loop;
    close cemp;
end;
/

使用无参光标cursor，真正给员工涨工资，ANALYST涨1000，MANAGER涨800，其它涨400，要求显示编号，姓名，职位，薪水
declare
    cursor cemp is select empno,ename,job,sal from emp;
    pempno emp.empno%type;
    pename emp.ename%type;
    pjob   emp.job%type;
    psal   emp.sal%type;
begin
    open cemp;
    loop
        fetch cemp into pempno,pename,pjob,psal;
        --循环退出条件一定要写
        exit when cemp%notfound;
        if pjob='ANALYST' then
            update emp set sal = sal + 1000 where empno = pempno;
        elsif pjob='MANAGER' then
            update emp set sal = sal + 800 where empno = pempno;
        else 
	    update emp set sal = sal + 400 where empno = pempno;
        end if;
    end loop;
    commit;
    close cemp;
end;
使用oracle系统内置例外，演示除0例外【zero_divide】
declare
    myresult number;
begin
    myresult := 1/0;
    dbms_output.put_line(myresult);
exception
    when zero_divide then 
	 dbms_output.put_line('除数不能为0');
	 delete from emp;  
end;
/

使用oracle系统内置例外，查询100号部门的员工姓名，演示没有找到数据【no_data_found】
declare
    pename varchar2(20);
begin
    select ename into pename from emp where deptno = 100;
    dbms_output.put_line(pename);
exception
    when NO_DATA_FOUND then 
	 dbms_output.put_line('查无该部门员工');
	 insert into emp(empno,ename) values(1111,'ERROR');
end;

--存储过程：create or replace procedure 过程名 as PLSQL程序


