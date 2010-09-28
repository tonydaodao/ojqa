package org.ojqa.util;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * @author ybak
 *
 */
public final class ActmServer {


    public static final String CONTEXT = "/actm";
    public static final int PORT = 8181;

    private ActmServer() {
        super();
    }

    /**
     * @param port server port.
     * @param contextPath start with "/" e.g. "/actm".
     * @param args
     * @throws Exception
     */
    public static void startJetty(int port, String contextPath) throws Exception {
        Server server = new Server(port);
        WebAppContext webContext = new WebAppContext("src/main/webapp", contextPath);
        webContext.setClassLoader(Thread.currentThread().getContextClassLoader());
        webContext.setDescriptor("src/test/resources/jetty/web.xml");
        server.setHandler(webContext);
        server.setStopAtShutdown(true);
        server.start();
        server.join();
        System.err.println("end...");
    }
    
    public static void main(String[] args) throws Exception {
        startJetty(PORT, CONTEXT);
    }
}
