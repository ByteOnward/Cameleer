package com.vanceinfo.cameleer.impl;

import java.util.ArrayList;
import java.util.List;

import com.vanceinfo.cameleer.CameleerContext;
import com.vanceinfo.cameleer.Endpoint;
import com.vanceinfo.cameleer.RouteBuilder;
import com.vanceinfo.cameleer.model.FromDefinition;
import com.vanceinfo.cameleer.model.RouteDefinition;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public abstract class BaseRouteBuilder implements RouteBuilder
{
	private CameleerContext cameleerContext;
	private List<RouteDefinition> routeDefinitions = new ArrayList<RouteDefinition>();

	protected abstract void configure();

	protected RouteDefinition from(String uri)
	{
		Endpoint endpoint = this.cameleerContext.getEndpoint(uri);
		FromDefinition input = new FromDefinition(endpoint);
		RouteDefinition routeDefinition = new RouteDefinition(cameleerContext, input);
		this.routeDefinitions.add(routeDefinition);
		return routeDefinition;
	}

	public void addRouteToCameleerContext(CameleerContext cameleerContext)
	{
		this.cameleerContext = cameleerContext;
		this.configure();
		for (RouteDefinition routeDefinition : routeDefinitions)
		{
			routeDefinition.startRoute();
		}
	}
}