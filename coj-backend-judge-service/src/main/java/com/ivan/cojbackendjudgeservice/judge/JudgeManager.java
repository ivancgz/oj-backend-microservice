package com.ivan.cojbackendjudgeservice.judge;


import com.ivan.cojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.ivan.cojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.ivan.cojbackendjudgeservice.judge.strategy.JudgeContext;
import com.ivan.cojbackendjudgeservice.judge.strategy.JudgeStrategy;
import com.ivan.cojbackendmodel.model.codesandbox.JudgeInfo;
import com.ivan.cojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理(简化调用)
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
