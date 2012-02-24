package com.vanceinfo.cameleer.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.vanceinfo.cameleer.CameleerContext;
import com.vanceinfo.cameleer.Component;
import com.vanceinfo.cameleer.Endpoint;
import com.vanceinfo.cameleer.ProducerTemplate;
import com.vanceinfo.cameleer.RouteBuilder;
import com.vanceinfo.cameleer.component.direct.DirectComponent;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public class DefaultCameleerContext implements CameleerContext
{
	private Map<String, Component> components = new HashMap<String, Component>();
	private Map<String, Endpoint> endpoints = new LinkedHashMap<String, Endpoint>();

	public DefaultCameleerContext()
	{
		this.components.put("direct", new DirectComponent());
	}

	private Component getComponent(String name)
	{
		return this.components.get(name);
	}

	/**
	 * @see com.vanceinfo.cameleer.CameleerContext#getEndpoint(java.lang.String)
	 */
	public Endpoint getEndpoint(String uri)
	{
		Endpoint answer = this.endpoints.get(uri);
		if (answer == null)
		{
			String[] splitUri = uri.split(":");
			Component component = this.getComponent(splitUri[0]);
			if (component != null)
			{
				answer = component.createEndpoint(uri);
				this.endpoints.put(uri, answer);
			}
		}
		return answer;
	}

	public void addRoute(RouteBuilder routeBuilder)
	{
		routeBuilder.addRouteToCameleerContext(this);
	}

	public ProducerTemplate createProducerTemplate()
	{
		return new DefaultProducerTemplate(this);
	}
}