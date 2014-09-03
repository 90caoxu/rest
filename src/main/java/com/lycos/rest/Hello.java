package com.lycos.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.resource.Singleton;

/**
 * @ClassName: Hello
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Lycos
 * @date 2014年9月2日 下午10:38:47
 */
@Singleton
@Path("/helloworld")
public class Hello {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String say() {
        return "Hello, world!";
    }
}
