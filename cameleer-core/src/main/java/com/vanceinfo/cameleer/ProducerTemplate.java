package com.vanceinfo.cameleer;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public interface ProducerTemplate
{
	void sendBody(String uri, Object body) throws Exception;
}