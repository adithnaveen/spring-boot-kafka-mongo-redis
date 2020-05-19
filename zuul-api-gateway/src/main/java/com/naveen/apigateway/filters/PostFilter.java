package com.naveen.apigateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PostFilter extends ZuulFilter {
	
	private static Logger LOGGER = LoggerFactory.getLogger(PostFilter.class.getClass());
	
	@Override
	public Object run() throws ZuulException {
		RequestContext requestCtx = RequestContext.getCurrentContext();
		LOGGER.info(">>>> Response -> {}", requestCtx.getResponseDataStream());
		
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	// pre or post
	@Override
	public String filterType() {
		return "post";
	}
	
}
