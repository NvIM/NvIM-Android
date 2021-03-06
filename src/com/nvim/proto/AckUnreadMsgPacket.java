package com.nvim.proto;

import java.util.ArrayList;
import java.util.List;

import com.nvim.config.ProtocolConstant;
import com.nvim.config.SysConstant;
import com.nvim.log.Logger;
import com.nvim.packet.base.DataBuffer;
import com.nvim.packet.base.DefaultHeader;
import com.nvim.packet.base.Header;
import com.nvim.packet.base.Packet;

/**
 * MsgServerPacket:请求(返回)登陆消息服务器 yugui 2014-05-04
 */

public class AckUnreadMsgPacket extends Packet {

	private Logger logger = Logger.getLogger(AckUnreadMsgPacket.class);

	public AckUnreadMsgPacket(String contactId) {
		mRequest = new PacketRequest(contactId);
		setNeedMonitor(true);
	}

	public AckUnreadMsgPacket() {
		setNeedMonitor(true);
	}

	@Override
	public DataBuffer encode() {

		Header header = mRequest.getHeader();
		DataBuffer headerBuffer = header.encode();
		DataBuffer bodyBuffer = new DataBuffer();

		PacketRequest req = (PacketRequest) mRequest;
		if (null == req)
			return null;

		bodyBuffer.writeString(req.contactId);

		int headLength = headerBuffer.readableBytes();
		int bodyLength = bodyBuffer.readableBytes();

		DataBuffer buffer = new DataBuffer(headLength + bodyLength);
		buffer.writeDataBuffer(headerBuffer);
		buffer.writeDataBuffer(bodyBuffer);

		return buffer;
	}

	@Override
	public void decode(DataBuffer buffer) {

//		if (null == buffer)
//			return;
//		try {
//			PacketResponse res = new PacketResponse();
//
//			Header header = new Header();
//			header.decode(buffer);
//			res.setHeader(header);
//
//			// starts filling from here
//			String sessionId = buffer.readString();
//			int cnt = buffer.readInt();
//			for (int i = 0; i < cnt; ++i) {
//				MessageEntity entity = new MessageEntity();
//
//				String id = buffer.readString();
//				String name = buffer.readString();
//				String nickName = buffer.readString();
//				String avatarUrl = buffer.readString();
//				int createTime = buffer.readInt();
//				byte msgType = buffer.readByte();
//				int msgLen = buffer.readInt();
//				byte[] msgContent = null;
//				if (msgLen > 0) {
//					msgContent = buffer.readBytes(msgLen);
//				}
//
//				entity.fromId = id;
//				entity.toId = IMLoginManager.instance().getLoginId();
//				entity.createTime = createTime;
//				entity.msgType = msgType;
//				entity.msgLen = msgLen;
//				entity.msgData = msgContent;
//				entity.sessionId = id;
//				entity.offline = false;
//
//				logger.d("unread#1");
//				logger.d("unread#got unreadmsg:%s", entity);
//				res.entityList.add(entity);
//			}
//
//			mResponse = res;
//		} catch (Exception e) {
//			logger.e(e.getMessage());
//		}

	}

	public static class PacketRequest extends Request {
		public String contactId;

		public PacketRequest(String contactId) {
			this.contactId = contactId;
			Header header = new DefaultHeader(ProtocolConstant.SID_MSG,
					ProtocolConstant.CID_MSG_READ_ACK);

			int contentLength = getUtf8Bytes(contactId).length;
			header.setLength(SysConstant.PROTOCOL_HEADER_LENGTH + (4 + contentLength));

			setHeader(header);
		}
	}

	public static class PacketResponse extends Response {

		public List<MessageEntity> entityList = new ArrayList<MessageEntity>();
	}
}
