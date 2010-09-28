package org.ojqa.ui.tomcat;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.servlets.DefaultServlet;

/**
 * rewrite get path method to get static file from static folder.
 * 
 * @author ybak
 * 
 */
public class StaticDefaultServlet extends DefaultServlet {

    private static final long serialVersionUID = 8185149279166237714L;

    @Override
    protected String getRelativePath(HttpServletRequest request) {
        return request.getServletPath() + super.getRelativePath(request);
    }

}
