/*
 *Author: Yosra Harbaoui
 *Date: October 2017 
*/
package ch.heigvd.amt.yosra.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Object session = request.getSession().getAttribute("session");

        if(session != null) 
        {
            request.getSession().invalidate();
        } 
        
        response.sendRedirect("index");   
    }    
}
