CREATE TABLE `SG_STUDENT_INF`
(
    SSI_ID     int(30) PRIMARY KEY,-- 学生ID
    SSI_NAME   varchar(20),-- 学生姓名
    SSI_AGE    int(10),-- 学生年龄
    SSI_GENDER varchar(20),-- 学生性别
    SSI_CID    int(10),-- 班级ID
    CONSTRAINT FK_STUID_CLASSID FOREIGN KEY (SSI_CID) REFERENCES SG_CLASS_INF (SCI_ID)
);