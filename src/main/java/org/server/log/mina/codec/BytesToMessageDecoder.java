package org.server.log.mina.codec;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
*二进制流解码器.
 */
public class BytesToMessageDecoder extends CumulativeProtocolDecoder {
	private final static Logger LOGGER = LoggerFactory.getLogger(BytesToMessageDecoder.class);

	public BytesToMessageDecoder() {
	}

	@Override
	protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {

		LOGGER.info(String.format("[%d]收到数据:%s", session.getId(), in.getHexDump()));
		byte [] data=new byte[in.remaining()];
		in.get(data,in.position(),in.remaining());
		out.write(data);
		return true;
	}

}
