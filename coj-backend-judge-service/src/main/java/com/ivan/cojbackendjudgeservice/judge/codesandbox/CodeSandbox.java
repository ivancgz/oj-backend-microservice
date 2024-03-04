package com.ivan.cojbackendjudgeservice.judge.codesandbox;


import com.ivan.cojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.ivan.cojbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {

    /**
     * 执行代码
     * @param executeCodeRequest 执行请求体
     * @return ExecuteCodeResponse 执行响应体
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
