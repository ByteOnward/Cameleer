package com.vanceinfo.cameleer.model;

import java.util.ArrayList;
import java.util.List;

import com.vanceinfo.cameleer.CameleerContext;
import com.vanceinfo.cameleer.Endpoint;
import com.vanceinfo.cameleer.Processor;
import com.vanceinfo.cameleer.impl.Pipeline;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public class RouteDefinition
{
	private CameleerContext cameleerContext;
	private FromDefinition input;
	private List<ProcessorDefinition> outputs = new ArrayList<ProcessorDefinition>();

	public RouteDefinition(CameleerContext cameleerContext, FromDefinition input)
	{
		this.cameleerContext = cameleerContext;
		this.input = input;
	}

	public void setCameleerContext(CameleerContext cameleerContext)
	{
		this.cameleerContext = cameleerContext;
	}

	public RouteDefinition to(String uri)
	{
		Endpoint endpoint = this.cameleerContext.getEndpoint(uri);
		return this.to(endpoint);
	}

	public RouteDefinition to(Endpoint endpoint)
	{
		ProcessorDefinition output = new SendProcessorDefinition(endpoint);
		this.outputs.add(output);
		return this;
	}

	public RouteDefinition process(Processor processor)
	{
		ProcessorDefinition output = new ProcessorDefinition(processor);
		this.outputs.add(output);
		return this;
	}

	public void startRoute()
	{
		List<Processor> processors = new ArrayList<Processor>();
		for (ProcessorDefinition output : this.outputs)
		{
			processors.add(output.getProcessor());
		}
		Processor processor = new Pipeline(processors);
		this.input.getEndpoint().createConsumer(processor);
	}
}