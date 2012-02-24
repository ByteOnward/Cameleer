package com.vanceinfo.cameleer.component.direct;

import com.vanceinfo.cameleer.Consumer;
import com.vanceinfo.cameleer.Processor;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public class DirectCusumer implements Consumer
{
	private Processor processor;

	public DirectCusumer(Processor processor)
	{
		this.processor = processor;
	}

	public Processor getProcessor()
	{
		return processor;
	}
}