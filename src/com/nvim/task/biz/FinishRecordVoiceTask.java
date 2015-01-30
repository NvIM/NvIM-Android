
package com.nvim.task.biz;

import com.nvim.config.TaskConstant;
import com.nvim.task.MAsyncTask;

public class FinishRecordVoiceTask extends MAsyncTask {

    @Override
    public int getTaskType() {
        return TaskConstant.TASK_FINISH_RECORD_VOICE;
    }

    @Override
    public Object doTask() {
        return null;
    }

}
