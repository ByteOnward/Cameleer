package com.vanceinfo.cameleer;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public interface Message
{
	void setBody(Object body);

	Object getBody();

	<T> T getBody(Class<T> type);
}