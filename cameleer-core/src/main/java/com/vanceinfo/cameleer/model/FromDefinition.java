package com.vanceinfo.cameleer.model;

import com.vanceinfo.cameleer.Endpoint;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public class FromDefinition
{
	private Endpoint endpoint;

	public FromDefinition(Endpoint endpoint)
	{
		this.endpoint = endpoint;
	}

	public Endpoint getEndpoint()
	{
		return endpoint;
	}
}