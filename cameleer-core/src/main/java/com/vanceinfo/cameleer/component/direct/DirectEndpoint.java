package com.vanceinfo.cameleer.component.direct;

import com.vanceinfo.cameleer.Consumer;
import com.vanceinfo.cameleer.Endpoint;
import com.vanceinfo.cameleer.Exchange;
import com.vanceinfo.cameleer.Processor;
import com.vanceinfo.cameleer.Producer;
import com.vanceinfo.cameleer.impl.DefaultExchange;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public class DirectEndpoint implements Endpoint
{
	private String endpointUri;
	private Consumer consumer;
	private Producer producer;

	public DirectEndpoint(String endpointUri)
	{
		this.endpointUri = endpointUri;
	}

	public String getEndpointUri()
	{
		return this.endpointUri;
	}

	public Producer createProducer()
	{
		if (this.producer == null)
		{
			this.producer = new DirectProducer(this);
		}
		return this.producer;
	}

	public Consumer createConsumer(Processor processor)
	{
		if (this.consumer == null)
		{
			this.consumer = new DirectCusumer(processor);
		}
		return this.consumer;
	}

	public Consumer getConsumer()
	{
		return this.consumer;
	}

	public Exchange createExchange()
	{
		return new DefaultExchange();
	}
}
