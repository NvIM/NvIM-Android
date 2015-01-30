package com.nvim.proto;

import java.util.ArrayList;
import java.util.List;

import com.mogujie.tt.config.ProtocolConstant;
import com.mogujie.tt.config.SysConstant;
import com.mogujie.tt.log.Logger;
import com.mogujie.tt.packet.base.DataBuffer;
import com.mogujie.tt.packet.base.DefaultHeader;
import com.mogujie.tt.packet.base.Header;
import com.mogujie.tt.packet.base.Packet;

/**
 * MsgServerPacket:请求(返回)登陆消息服务器 yugui 2014-05-04
 */

public class DepartmentPacket extends Packet {

	private Logger logger = Logger.getLogger(DepartmentPacket.class);

	public DepartmentPacket() {
		mRequest = new PacketRequest();
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

		int headLength = headerBuffer.readableBytes();
		int bodyLength = bodyBuffer.readableBytes();

		DataBuffer buffer = new DataBuffer(headLength + bodyLength);
		buffer.writeDataBuffer(headerBuffer);
		buffer.writeDataBuffer(bodyBuffer);

		return buffer;
	}

	@Override
	public void decode(DataBuffer buffer) {

		if (null == buffer)
			return;
		try {
			PacketResponse res = new PacketResponse();

			Header header = new Header();
			header.decode(buffer);
			res.setHeader(header);

			// starts filling from here
			int cnt = buffer.readInt();
			for (int i = 0; i < cnt; ++i) {
				DepartmentEntity entity = new DepartmentEntity();
				entity.id = buffer.readString();
				entity.title = buffer.readString();
				entity.description = buffer.readString();
				entity.parentId = buffer.readString();
				entity.leaderId = buffer.readString();
				entity.status = buffer.readInt();

				res.entityList.add(entity);
			}

			mResponse = res;
		} catch (Exception e) {
			logger.e(e.getMessage());
		}

	}

	public static class PacketRequest extends Request {
		public PacketRequest() {

			Header header = new DefaultHeader(ProtocolConstant.SID_BUDDY_LIST,
					ProtocolConstant.CID_BUDDY_LIST_DEPARTMENT_REQUEST);

			int contentLength = 0;
			header.setLength(SysConstant.PROTOCOL_HEADER_LENGTH + contentLength);

			setHeader(header);
		}
	}

	
	public static class PacketResponse extends Response {

		public List<DepartmentEntity> entityList = new ArrayList<DepartmentEntity>();
	}
}
