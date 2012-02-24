package com.vanceinfo.cameleer.component.direct;

import com.vanceinfo.cameleer.Consumer;
import com.vanceinfo.cameleer.Exchange;
import com.vanceinfo.cameleer.Producer;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public class DirectProducer implements Producer
{
	private DirectEndpoint endpoint;

	public DirectProducer(DirectEndpoint endpoint)
	{
		this.endpoint = endpoint;
	}

	/**
	 * @see com.vanceinfo.cameleer.Processor#process(com.vanceinfo.cameleer.Exchange)
	 */
	public void process(Exchange exchange) throws Exception
	{
		Consumer consumer = this.endpoint.getConsumer();
		if (consumer != null)
		{
			consumer.getProcessor().process(exchange);
		}
	}
}