CREATE TABLE `SGP_ROLE_PERMISSION_REL`
(
    SRPR_RID VARCHAR(10) COMMENT '角色ID',
    SRPR_PID VARCHAR(10) COMMENT 'PID',
    PRIMARY KEY (SRPR_RID, SRPR_PID),
    CONSTRAINT FK_REL_ROLE_SGPRP FOREIGN KEY (SRPR_RID) REFERENCES SGP_ROLE (SR_ID),
    CONSTRAINT FK_REL_PERMISSION_SGPRP FOREIGN KEY (SRPR_PID) REFERENCES SGP_PERMISSION (SP_ID)
);
INSERT INTO `SGP_ROLE_PERMISSION_REL` (SRPR_RID, SRPR_PID)
VALUES ('1001', '1001');