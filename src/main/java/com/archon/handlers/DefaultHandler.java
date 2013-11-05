package com.archon.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import javax.json.Json;
import javax.json.JsonObject;

/**
 * User: EJ
 * Date: 11/4/13
 * Time: 10:25 PM
 */
public class DefaultHandler extends AbstractHandler{

    public DefaultHandler() {

    }

    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("application/json");
        res.setStatus(HttpServletResponse.SC_OK);
        request.setHandled(true);

        JsonObject jres = Json.createObjectBuilder()
                .add("status", "ok").build();

        res.getWriter().println(jres.toString());
    }
}
