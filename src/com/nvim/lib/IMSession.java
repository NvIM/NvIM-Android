package com.nvim.lib;

import com.nvim.entity.MessageInfo;
import com.nvim.log.Logger;
import com.nvim.proto.ContactEntity;
import com.nvim.proto.GroupEntity;
import com.nvim.ui.utils.IMServiceHelper;

public class IMSession {
	public static final int SESSION_ERROR = -1;
	public static final int SESSION_P2P = 0;
	public static final int SESSION_GROUP = 1;
	public static final int SESSION_TEMP_GROUP = 2; // 讨论组

	private static Logger logger = Logger.getLogger(IMSession.class);

	private int type;
	// for p2p, sessionid is the peer id
	// for group and temp group, it is the real session id
	private String sessionId = "";

	private IMServiceHelper imServiceHelper;

	public IMSession(IMServiceHelper imServiceHelper) {
		this.imServiceHelper = imServiceHelper;
	}

	public int getSessionType() {
		return type;
	}

	public void setType(int type) {
		logger.d("chat#setSessionType:%d", type);
		this.type = type;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		logger.d("chat#setSessionId:%s", sessionId);

		this.sessionId = sessionId;
	}

	public void sendText(int sessionType, MessageInfo msgInfo) {
		// todo eric location:send here
		// todo eric should check imservice is ok or not

		// todo only need check imservice is ok or not
		if (imServiceHelper == null) {
			return;
		}

		// imServiceHelper
		// .getIMService()
		// .getMessageManager()
		// .sendText(sessionId, msgInfo.getMsgContent(), sessionType,
		// msgInfo);
	}

	public ContactEntity getSessionContact(String contactId) {

		if (imServiceHelper == null) {
			return null;
		}

		// ContactEntity contact = imServiceHelper.getIMService()
		// .getContactManager().findContact(contactId);
		return null;
	}

	public GroupEntity getSessionGroup() {
		if (type != SESSION_GROUP || type != SESSION_TEMP_GROUP) {
			return null;
		}

		if (imServiceHelper == null) {
			return null;
		}

//		GroupEntity group = imServiceHelper.getIMService().getGroupManager().findGroup(sessionId);
		return null;
	}

	public ContactEntity getLoginContact() {
//		return imServiceHelper.getIMService().getContactManager().getLoginContact();
		return null;
	}
}
