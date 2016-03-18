package org.server.log.mina.codec;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
*二进制流编码器.
 */
public class MessageToBytesEncoder extends ProtocolEncoderAdapter {

	private final static Logger LOGGER = LoggerFactory.getLogger(MessageToBytesEncoder.class);

	@Override
	public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {

	}

}
