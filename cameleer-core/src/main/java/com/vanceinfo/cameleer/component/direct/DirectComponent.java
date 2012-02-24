package com.vanceinfo.cameleer.component.direct;

import com.vanceinfo.cameleer.Component;
import com.vanceinfo.cameleer.Endpoint;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public class DirectComponent implements Component
{
	public Endpoint createEndpoint(String uri)
	{
		DirectEndpoint endpoint = new DirectEndpoint(uri);
		return endpoint;
	}
}