package com.archon;

import com.archon.handlers.AddArtist;
import com.archon.handlers.DefaultHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

/**
 * User: EJ
 * Date: 11/4/13
 * Time: 12:42 AM
 */
public class ArchonServer {

    final static int maxThreads = 500;
    final static int port = 8080;
    final static String host = "localhost";

    public static void main(String[] args) {
        QueuedThreadPool threadPool = new QueuedThreadPool();
        threadPool.setMaxThreads(ArchonServer.maxThreads);
        Server svr = new Server(threadPool);
        ServerConnector http = new ServerConnector(svr);
        http.setPort(ArchonServer.port);
        http.setHost(ArchonServer.host);
        http.setIdleTimeout(30000);
        svr.addConnector(http);


        ContextHandler def = new ContextHandler("/");
        def.setHandler(new DefaultHandler());
        ContextHandler add = new ContextHandler("/artist/add");
        add.setHandler(new AddArtist());
        ContextHandlerCollection contexts =  new ContextHandlerCollection();
        contexts.setHandlers(new Handler[]{ def, add });

        svr.setHandler(contexts);


        try {
            svr.start();
            svr.join();
        } catch (Exception e) {

        }
    }
}
