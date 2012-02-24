package com.vanceinfo.cameleer.example.helloworld;

import com.vanceinfo.cameleer.CameleerContext;
import com.vanceinfo.cameleer.Exchange;
import com.vanceinfo.cameleer.Message;
import com.vanceinfo.cameleer.Processor;
import com.vanceinfo.cameleer.ProducerTemplate;
import com.vanceinfo.cameleer.impl.BaseRouteBuilder;
import com.vanceinfo.cameleer.impl.DefaultCameleerContext;
import com.vanceinfo.cameleer.impl.DefaultMessage;

/**
 * @author <a href="mailto:huang_boke@vanceinfo.com">brook</a>
 */
public class Main
{
	public static void main(String[] args) throws Exception
	{
		CameleerContext cameleerContext = new DefaultCameleerContext();
		cameleerContext.addRoute(new BaseRouteBuilder()
			{
				protected void configure()
				{
					this.from("direct:helloworld").process(new Processor()
						{
							public void process(Exchange exchange) throws Exception
							{
								String rq = exchange.getIn().getBody(String.class);
								System.out.println("Receive request: " + rq);
								Message out = new DefaultMessage();
								out.setBody("Hello, " + rq);
								exchange.setOut(out);
							}
						}).to("direct:logResponse").process(new Processor()
						{
							public void process(Exchange exchange) throws Exception
							{
								String rs = exchange.getOut().getBody(String.class);
								System.out.println("Response: " + rs);
							}
						});
				}
			});

		ProducerTemplate producerTemplate = cameleerContext.createProducerTemplate();
		producerTemplate.sendBody("direct:helloworld", "Cameleer");
	}
}