package com.vanceinfo.cameleer.impl;

import com.vanceinfo.cameleer.CameleerContext;
import com.vanceinfo.cameleer.Endpoint;
import com.vanceinfo.cameleer.Exchange;
import com.vanceinfo.cameleer.Message;
import com.vanceinfo.cameleer.Producer;
import com.vanceinfo.cameleer.ProducerTemplate;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public class DefaultProducerTemplate implements ProducerTemplate
{
	private CameleerContext context;

	public DefaultProducerTemplate(CameleerContext context)
	{
		super();
		this.context = context;
	}

	public void sendBody(String uri, Object body) throws Exception
	{
		Endpoint endpoint = this.resolveMandatoryEndpoint(uri);
		Producer producer = endpoint.createProducer();
		Exchange exchange = endpoint.createExchange();
		Message in = new DefaultMessage();
		in.setBody(body);
		exchange.setIn(in);
		producer.process(exchange);
	}

	private Endpoint resolveMandatoryEndpoint(String endpointUri)
	{
		Endpoint endpoint = this.context.getEndpoint(endpointUri);
		if (endpoint == null)
		{
			throw new NoSuchFieldError(endpointUri);
		}
		return endpoint;
	}
}
