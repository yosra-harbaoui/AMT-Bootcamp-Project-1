/*
 *Author: Yosra Harbaoui
 *Date: October 2017
*/

package ch.heigvd.amt.yosra.web;

import ch.heigvd.amt.yosra.services.UsersManagerLocal;
import ch.heigvd.amt.yosra.utils.SaltedMD5;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet
{
    @EJB
    UsersManagerLocal usersManager;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        String securePassword = SaltedMD5.getSecurePassword(password);
                                 
        if (usersManager.validateUser(username, securePassword))
        {
            HttpSession session = request.getSession(true);
                      
            session.setAttribute("session", usersManager.getUserId(username));
                 
            //In order to keep  the current session's attributes,
            //you have to put an absolute url/path and not just the relative one
            response.sendRedirect(request.getContextPath() + "/index");
        }
        else 
        {
            request.setAttribute("error", "Incorrect password or username !");
                        
            doGet(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        
        Object value = session.getAttribute("session");
        
        if(value != null)
        {
            response.sendRedirect(request.getContextPath() + "/index");
            
            return;
        }
        
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}