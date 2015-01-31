package com.nvim.lib.network;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.MessageEvent;

import com.nvim.lib.IMLoginManager;
import com.nvim.lib.IMPacketDispatcher;

public class LoginServerHandler extends BaseServerHandler {

	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		super.channelConnected(ctx, e);

		IMLoginManager.instance().onLoginServerConnected();
	}

	@Override
	public void channelDisconnected(ChannelHandlerContext ctx,
			ChannelStateEvent e) throws Exception {
		super.channelDisconnected(ctx, e);

		IMLoginManager.instance().onLoginServerDisconnected();
	}

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		super.messageReceived(ctx, e);

		IMPacketDispatcher.dispatch((ChannelBuffer) e.getMessage());
	}

	@Override
	protected void channelUnconnected() {
    	IMLoginManager.instance().onLoginServerUnconnected();

	}

}
