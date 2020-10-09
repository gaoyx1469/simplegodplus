CREATE TABLE `SGP_LOG`
(
    SL_ID             VARCHAR(32) PRIMARY KEY COMMENT '日志ID',
    SL_VISIT_TIME     VARCHAR(30) COMMENT '用户请求时间',
    SL_USERNAME       VARCHAR(64) COMMENT '用户昵称',
    SL_IP             VARCHAR(30) COMMENT '用户IP',
    SL_URL            VARCHAR(256) COMMENT '用户请求URL',
    SL_EXECUTION_TIME INT COMMENT '请求执行时间（毫秒）',
    SL_METHOD         VARCHAR(256) COMMENT '用户请求方法',
    SL_STT            VARCHAR(2) COMMENT '请求状态（50-请求中；90-请求成功；91-请求失败；99-交易状态未知）',
    SL_ERROR_CODE     VARCHAR(16) COMMENT '错误信息',
    SL_ERROR_MESSAGE  VARCHAR(256) COMMENT '错误码'
);