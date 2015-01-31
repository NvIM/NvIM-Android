
package com.nvim.task.biz;

import android.app.Notification.Builder;

import com.nvim.packet.SocketMessageQueue;
import com.nvim.packet.action.Action;
import com.nvim.packet.action.ActionCallback;
import com.nvim.packet.base.Packet;
import com.nvim.task.BaseTask;

public class PushActionToQueueTask extends BaseTask {

    private Packet packet;
    private ActionCallback callback;

    public PushActionToQueueTask(Packet _packet, ActionCallback _callback)
    {
        packet = _packet;
        callback = _callback;
    }

    @Override
    public Object doTask() {
//        if (null == packet)
//            return null;
//        Builder builer = new Builder();
//        Action action = builer.setPacket(packet).setCallback(callback).build();
//        SocketMessageQueue.getInstance().submitAndEnqueue(action);
        return null;
    }
}
