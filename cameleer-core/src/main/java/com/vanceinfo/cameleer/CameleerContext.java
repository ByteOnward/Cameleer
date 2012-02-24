package com.vanceinfo.cameleer;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public interface CameleerContext
{
	Endpoint getEndpoint(String uri);

	void addRoute(RouteBuilder routeBuilder);

	ProducerTemplate createProducerTemplate();
}