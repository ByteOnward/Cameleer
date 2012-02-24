package com.vanceinfo.cameleer.model;

import com.vanceinfo.cameleer.Endpoint;
import com.vanceinfo.cameleer.Processor;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public class SendProcessorDefinition extends ProcessorDefinition
{
	private Endpoint endpoint;

	public SendProcessorDefinition(Endpoint endpoint)
	{
		this.endpoint = endpoint;
	}

	@Override
	protected Processor createProcessor()
	{
		return this.endpoint.createProducer();
	}
}
