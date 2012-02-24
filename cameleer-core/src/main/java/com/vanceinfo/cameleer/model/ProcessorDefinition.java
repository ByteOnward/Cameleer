package com.vanceinfo.cameleer.model;

import com.vanceinfo.cameleer.Processor;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public class ProcessorDefinition
{
	private Processor processor;

	public ProcessorDefinition()
	{}

	public ProcessorDefinition(Processor processor)
	{
		this.processor = processor;
	}

	public Processor getProcessor()
	{
		if (this.processor == null)
		{
			this.processor = this.createProcessor();
		}
		return this.processor;
	}

	protected Processor createProcessor()
	{
		throw new IllegalArgumentException("Must given one processor.");
	}
}