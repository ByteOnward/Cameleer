package com.vanceinfo.cameleer;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public interface Endpoint
{
	String getEndpointUri();

	Producer createProducer();

	Consumer createConsumer(Processor processor);

	Exchange createExchange();	
}