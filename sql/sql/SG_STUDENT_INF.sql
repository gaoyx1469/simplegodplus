CREATE TABLE `SG_STUDENT_INF`
(
    SSI_ID     int(30) PRIMARY KEY,-- 学生ID
    SSI_NAME   varchar(20),-- 学生姓名
    SSI_AGE    int(10),-- 学生年龄
    SSI_GENDER varchar(20),-- 学生性别
    SSI_CID    int(10),-- 班级ID
    CONSTRAINT FK_STUID_CLASSID FOREIGN KEY (SSI_CID) REFERENCES SG_CLASS_INF (SCI_ID)
);
INSERT INTO `SG_STUDENT_INF` (SSI_ID, SSI_NAME, SSI_AGE, SSI_GENDER, SSI_CID)
VALUES (1000000001, '小明', 15, '男', 10001);
INSERT INTO `SG_STUDENT_INF` (SSI_ID, SSI_NAME, SSI_AGE, SSI_GENDER, SSI_CID)
VALUES (1000000002, '小白', 14, '男', 10001);
INSERT INTO `SG_STUDENT_INF` (SSI_ID, SSI_NAME, SSI_AGE, SSI_GENDER, SSI_CID)
VALUES (1000000003, '小花', 15, '女', 10002);
INSERT INTO `SG_STUDENT_INF` (SSI_ID, SSI_NAME, SSI_AGE, SSI_GENDER, SSI_CID)
VALUES (1000000004, '李雷', 15, '男', 10003);
INSERT INTO `SG_STUDENT_INF` (SSI_ID, SSI_NAME, SSI_AGE, SSI_GENDER, SSI_CID)
VALUES (1000000005, '韩梅梅', 14, '女', 10003);