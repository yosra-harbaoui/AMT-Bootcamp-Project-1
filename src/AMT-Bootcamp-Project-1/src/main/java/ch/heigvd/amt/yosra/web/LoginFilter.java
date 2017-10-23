/*
 *Author: Yosra Harbaoui
 *Date: October 2017
*/

package ch.heigvd.amt.yosra.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException
    {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        
        HttpSession session = request.getSession(false);
        
        boolean loggedIn = session != null && session.getAttribute("session") != null;
        
        if(!loggedIn) 
        {
            ((HttpServletResponse) servletResponse).sendRedirect("login");
        } 
        else
        {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }    
    
    @Override
    public void init(FilterConfig config) throws ServletException
    {
        
    }
    
    @Override
    public void destroy()
    {
    }
}