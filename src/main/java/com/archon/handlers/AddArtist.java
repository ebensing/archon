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
 * Time: 10:45 PM
 */
public class AddArtist extends AbstractHandler {

    public AddArtist() {

    }

    @Override
    public void handle(String uri, Request request, HttpServletRequest httpServletRequest, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("application/json");

        String name = uri.replace("/", "");
        if (uri.equals("")) {
            //fail
        }

        res.setStatus(HttpServletResponse.SC_OK);
        request.setHandled(true);

        JsonObject jres = Json.createObjectBuilder()
                .add("artist-name", name).build();

        res.getWriter().write(jres.toString());
    }
}
