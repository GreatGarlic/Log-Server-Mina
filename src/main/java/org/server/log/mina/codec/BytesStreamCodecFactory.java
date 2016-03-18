package org.server.log.mina.codec;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * 类的相关描述
 */

public class BytesStreamCodecFactory implements ProtocolCodecFactory {

	private ProtocolDecoder decoder;

	private ProtocolEncoder encoder;

	@Override
	public ProtocolEncoder getEncoder(IoSession session) throws Exception {
		return encoder;
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession session) throws Exception {
		return decoder;
	}

	public void setDecoder(ProtocolDecoder decoder) {
		this.decoder = decoder;
	}

	public void setEncoder(ProtocolEncoder encoder) {
		this.encoder = encoder;
	}
}
