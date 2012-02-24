package com.vanceinfo.cameleer;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public interface Processor
{
	void process(Exchange exchange) throws Exception;
}