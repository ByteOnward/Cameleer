package com.vanceinfo.cameleer.impl;

import java.util.List;

import com.vanceinfo.cameleer.Exchange;
import com.vanceinfo.cameleer.Processor;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public class Pipeline implements Processor
{
	private List<Processor> processors;

	public Pipeline(List<Processor> processors)
	{
		this.processors = processors;
	}

	/**
	 * @see com.vanceinfo.cameleer.Processor#process(com.vanceinfo.cameleer.Exchange)
	 */
	public void process(Exchange exchange) throws Exception
	{
		if (this.processors == null)
		{
			return;
		}

		for (Processor processor : this.processors)
		{
			processor.process(exchange);
		}
	}
}
