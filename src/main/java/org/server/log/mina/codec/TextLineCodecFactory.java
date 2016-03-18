package org.server.log.mina.codec;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.BufferDataException;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineDecoder;
import org.apache.mina.filter.codec.textline.TextLineEncoder;

/**
 * 编解码器工厂类.
 * 
 * @author 刘源
 */

public class TextLineCodecFactory implements ProtocolCodecFactory {

	private final TextLineEncoder encoder;
	private final TextLineDecoder decoder;
	

	/**
	 * Creates a new instance with the current default {@link Charset}.
	 */
	public TextLineCodecFactory() {
		this(Charset.defaultCharset(),1024);
	}

	/**
	 * Creates a new instance with the specified {@link Charset}. The encoder uses a UNIX {@link LineDelimiter} and the
	 * decoder uses the AUTO {@link LineDelimiter}.
	 * 
	 * @param charset
	 *            The charset to use in the encoding and decoding
	 */
	public TextLineCodecFactory(Charset charset,Integer maxLineLength) {
		encoder = new TextLineEncoder(Charset.forName("GB2312"), LineDelimiter.UNIX);
		decoder = new TextLineDecoder(Charset.forName("GB2312"), LineDelimiter.CRLF);
		setDecoderMaxLineLength(maxLineLength*1024);
		setEncoderMaxLineLength(maxLineLength*1024);
	}

	/**
	 * Creates a new instance of TextLineCodecFactory. This constructor provides more flexibility for the developer.
	 * 
	 * @param charset
	 *            The charset to use in the encoding and decoding
	 * @param encodingDelimiter
	 *            The line delimeter for the encoder
	 * @param decodingDelimiter
	 *            The line delimeter for the decoder
	 */
	public TextLineCodecFactory(Charset charset, String encodingDelimiter, String decodingDelimiter) {
		encoder = new TextLineEncoder(charset, encodingDelimiter);
		decoder = new TextLineDecoder(charset, decodingDelimiter);
	}

	/**
	 * Creates a new instance of TextLineCodecFactory. This constructor provides more flexibility for the developer.
	 * 
	 * @param charset
	 *            The charset to use in the encoding and decoding
	 * @param encodingDelimiter
	 *            The line delimeter for the encoder
	 * @param decodingDelimiter
	 *            The line delimeter for the decoder
	 */
	public TextLineCodecFactory(Charset charset, LineDelimiter encodingDelimiter, LineDelimiter decodingDelimiter) {
		encoder = new TextLineEncoder(charset, encodingDelimiter);
		decoder = new TextLineDecoder(charset, decodingDelimiter);
	}

	public ProtocolEncoder getEncoder(IoSession session) {
		return encoder;
	}

	public ProtocolDecoder getDecoder(IoSession session) {
		return decoder;
	}

	/**
	 * Returns the allowed maximum size of the encoded line. If the size of the encoded line exceeds this value, the
	 * encoder will throw a {@link IllegalArgumentException}. The default value is {@link Integer#MAX_VALUE}.
	 * <p>
	 * This method does the same job with {@link TextLineEncoder#getMaxLineLength()}.
	 */
	public int getEncoderMaxLineLength() {
		return encoder.getMaxLineLength();
	}

	/**
	 * Sets the allowed maximum size of the encoded line. If the size of the encoded line exceeds this value, the
	 * encoder will throw a {@link IllegalArgumentException}. The default value is {@link Integer#MAX_VALUE}.
	 * <p>
	 * This method does the same job with {@link TextLineEncoder#setMaxLineLength(int)}.
	 */
	public void setEncoderMaxLineLength(int maxLineLength) {
		encoder.setMaxLineLength(maxLineLength);
	}

	/**
	 * Returns the allowed maximum size of the line to be decoded. If the size of the line to be decoded exceeds this
	 * value, the decoder will throw a {@link BufferDataException}. The default value is <tt>1024</tt> (1KB).
	 * <p>
	 * This method does the same job with {@link TextLineDecoder#getMaxLineLength()}.
	 */
	public int getDecoderMaxLineLength() {
		return decoder.getMaxLineLength();
	}

	/**
	 * Sets the allowed maximum size of the line to be decoded. If the size of the line to be decoded exceeds this
	 * value, the decoder will throw a {@link BufferDataException}. The default value is <tt>1024</tt> (1KB).
	 * <p>
	 * This method does the same job with {@link TextLineDecoder#setMaxLineLength(int)}.
	 */
	public void setDecoderMaxLineLength(int maxLineLength) {
		decoder.setMaxLineLength(maxLineLength);
	}



}
