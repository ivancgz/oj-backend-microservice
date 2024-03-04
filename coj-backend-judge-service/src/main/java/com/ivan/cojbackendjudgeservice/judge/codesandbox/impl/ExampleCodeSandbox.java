package com.ivan.cojbackendjudgeservice.judge.codesandbox.impl;


import com.ivan.cojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.ivan.cojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.ivan.cojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import com.ivan.cojbackendmodel.model.codesandbox.JudgeInfo;
import com.ivan.cojbackendmodel.model.enums.JudgeInfoMessageEnum;
import com.ivan.cojbackendmodel.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * 示例代码沙箱 (仅为了跑通业务流程)
 */
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();

        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCESS.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        
        return executeCodeResponse;
    }
}
