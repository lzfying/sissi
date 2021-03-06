package com.sissi.server;

import com.sissi.write.Transfer;

/**
 * @author kim 2013年12月22日
 */
public interface ExchangerContext {

	public Exchanger join(String host, Transfer transfer);
	
	public Exchanger leave(String host);

	public boolean exists(String host);
}
