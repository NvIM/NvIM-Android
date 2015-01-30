package com.nvim.cache;

import com.nvim.entity.MessageInfo;

/**
 * @author seishuchen
 */
public interface Dispatcher {
	void dispatch(MessageInfo messageInfo);

	void init();
}
