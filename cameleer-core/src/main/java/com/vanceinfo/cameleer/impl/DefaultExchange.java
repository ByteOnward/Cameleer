package com.vanceinfo.cameleer.impl;

import com.vanceinfo.cameleer.Exchange;
import com.vanceinfo.cameleer.Message;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public class DefaultExchange implements Exchange
{
	private Message in;
	private Message out;

	/**
	 * @see com.vanceinfo.cameleer.Exchange#setIn(com.vanceinfo.cameleer.Message)
	 */
	public void setIn(Message in)
	{
		this.in = in;
	}

	/**
	 * @see com.vanceinfo.cameleer.Exchange#getIn()
	 */
	public Message getIn()
	{
		return this.in;
	}

	/**
	 * @see com.vanceinfo.cameleer.Exchange#setOut(com.vanceinfo.cameleer.Message)
	 */
	public void setOut(Message out)
	{
		this.out = out;
	}

	/**
	 * @see com.vanceinfo.cameleer.Exchange#getOut()
	 */
	public Message getOut()
	{
		return this.out;
	}
}
