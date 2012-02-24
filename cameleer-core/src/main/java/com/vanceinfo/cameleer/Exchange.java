package com.vanceinfo.cameleer;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public interface Exchange
{
	void setIn(Message in);

	Message getIn();

	void setOut(Message out);

	Message getOut();
}