package com.nvim.packet.base;

import com.nvim.config.SysConstant;
import com.nvim.log.Logger;
import com.nvim.utils.SequenceNumberMaker;

public class DefaultHeader extends Header {

	private Logger logger = Logger.getLogger(DefaultHeader.class);

	public DefaultHeader(int serviceId, int commandId) {
		setVersion((short)SysConstant.PROTOCOL_VERSION);
		setServiceId(serviceId);
		setCommandId(commandId);
		short seqNo = SequenceNumberMaker.getInstance().make();
		setReserved(seqNo);

		logger.d("packet#construct Default Header -> serviceId:%d, commandId:%d, seqNo:%d", serviceId, commandId, seqNo);
	}
}
