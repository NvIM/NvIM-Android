
package com.nvim.lib.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.nvim.R;
import com.nvim.conn.NetStateManager;
import com.nvim.socket.SocketStateManager;
import com.nvim.ui.widget.PinkToast;
import com.nvim.utils.CommonUtil;

public class ConnectionChangeReceiver extends BroadcastReceiver {

    private boolean bDisconnected = false;
    private NetStateManager nsmInstance = NetStateManager.getInstance();
    private SocketStateManager ssmInstance = SocketStateManager.getInstance();

    @Override
    public void onReceive(Context context, Intent intent) {

        boolean success = false;
        try {
            // 获得网络连接服务
            ConnectivityManager cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (null != cm) {
                NetworkInfo ni = cm.getActiveNetworkInfo();
                if (null != ni && ni.isAvailable()) {
                    success = true;
                }
            }

        } catch (Exception e) {
            success = false;
        }

        if (!success) {
            bDisconnected = true;
            if (CommonUtil.isInIm(context)) {
                PinkToast.makeText(context,
                        context.getString(R.string.network_has_disconnected),
                        Toast.LENGTH_LONG).show();
            }
            nsmInstance.setState(false);
            ssmInstance.setState(false);
        } else {
            if (bDisconnected) {
                nsmInstance.setState(true);
            }
            bDisconnected = false;
        }

    }
}
