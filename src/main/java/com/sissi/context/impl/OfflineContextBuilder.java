package com.sissi.context.impl;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;

import com.sissi.context.JID;
import com.sissi.context.JIDContext;
import com.sissi.context.JIDContextBuilder;
import com.sissi.context.JIDContextParam;
import com.sissi.context.Status;
import com.sissi.pipeline.Output;
import com.sissi.protocol.Element;

/**
 * @author kim 2013-11-19
 */
public class OfflineContextBuilder implements JIDContextBuilder {

	private final Integer priority = 0;

	private final Status status = OfflineStatus.STATUS;

	private final JIDContext context = new OfflineContext();

	private final SocketAddress address = new InetSocketAddress(InetAddress.getByName("0.0.0.0"), 0);

	private final String lang;

	private final String domain;

	private final Output output;

	public OfflineContextBuilder(String lang, String domain, Output output) throws Exception {
		super();
		this.lang = lang;
		this.domain = domain;
		this.output = output;
	}

	@Override
	public JIDContext build(JID jid, JIDContextParam param) {
		return this.context;
	}

	private class OfflineContext implements JIDContext {

		private final JID jid = OfflineJID.JID;

		public Long getIndex() {
			return null;
		}

		@Override
		public JIDContext setAuth(Boolean canAccess) {
			return this;
		}

		@Override
		public Boolean isAuth() {
			return false;
		}

		public Boolean isAuthRetry() {
			return false;
		}

		public Boolean isBinding() {
			return false;
		}

		public JIDContext setBinding(Boolean isBinding) {
			return this;
		}

		@Override
		public JIDContext setJid(JID jid) {
			return this;
		}

		@Override
		public JID getJid() {
			return this.jid;
		}

		@Override
		public Status getStatus() {
			return OfflineContextBuilder.this.status;
		}

		@Override
		public JIDContext setPriority(Integer priority) {
			return this;
		}

		@Override
		public Integer getPriority() {
			return OfflineContextBuilder.this.priority;
		}

		public JIDContext setDomain(String domain) {
			return this;
		}

		public JIDContext setLang(String lang) {
			return this;
		}

		public String getLang() {
			return OfflineContextBuilder.this.lang;
		}

		public String getDomain() {
			return OfflineContextBuilder.this.domain;
		}

		public SocketAddress getAddress() {
			return OfflineContextBuilder.this.address;
		}

		@Override
		public Boolean setTls() {
			return false;
		}

		public Boolean isTls() {
			return false;
		}

		public JIDContext setPresence() {
			return this;
		}

		public Boolean isPresence() {
			return false;
		}

		public Boolean closePrepare() {
			return false;
		}

		public Boolean closeTimeout() {
			return false;
		}

		@Override
		public Boolean close() {
			return false;
		}

		public JIDContext reset() {
			return this;
		}

		public JIDContext ping() {
			return this;
		}

		public JIDContext pong(Element element) {
			return this;
		}

		@Override
		public JIDContext write(Element element) {
			OfflineContextBuilder.this.output.output(this, element);
			return this;
		}

		public JIDContext write(Collection<Element> elements) {
			for (Element element : elements) {
				this.write(element);
			}
			return this;
		}
	}

}
