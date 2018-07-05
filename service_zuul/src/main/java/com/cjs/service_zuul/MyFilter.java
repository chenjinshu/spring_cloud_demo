package com.cjs.service_zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;       // 路由之前调用
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL()));
        Object token = request.getParameter("token");
        if(token == null) {
            logger.warn("token is empty!");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty!");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        logger.info("token is ok! token = {}", request.getParameter("token"));
        return null;
    }
}
