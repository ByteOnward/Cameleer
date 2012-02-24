package com.vanceinfo.cameleer.impl;

import com.vanceinfo.cameleer.Message;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public class DefaultMessage implements Message
{
	private Object body;

	/**
	 * @see com.vanceinfo.cameleer.Message#setBody(java.lang.Object)
	 */
	public void setBody(Object body)
	{
		this.body = body;
	}

	/**
	 * @see com.vanceinfo.cameleer.Message#getBody()
	 */
	public Object getBody()
	{
		return this.body;
	}

	public <T> T getBody(Class<T> type)
	{
		if (type.isInstance(this.body))
		{
			return type.cast(this.body);
		}
		return null;
	}
}
