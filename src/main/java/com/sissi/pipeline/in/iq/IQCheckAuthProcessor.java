package com.sissi.pipeline.in.iq;

import com.sissi.context.JIDContext;
import com.sissi.pipeline.Input;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.error.ServerError;
import com.sissi.protocol.error.element.BadRequest;

/**
 * @author kim 2014年1月14日
 */
public class IQCheckAuthProcessor implements Input {

	private final String ERROR_TEXT = "Please auth first";

	@Override
	public Boolean input(JIDContext context, Protocol protocol) {
		return context.isAuth() ? true : this.writeAndReturn(context, protocol);
	}

	private Boolean writeAndReturn(JIDContext context, Protocol protocol) {
		context.write(protocol.reply().setError(new ServerError().add(BadRequest.DETAIL, context.getLang(), ERROR_TEXT)));
		return false;
	}
}
