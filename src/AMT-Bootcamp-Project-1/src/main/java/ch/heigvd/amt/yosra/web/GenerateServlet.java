/*
 *Author: Yosra Harbaoui
 *Date: October 2017
*/
package ch.heigvd.amt.yosra.web;

import ch.heigvd.amt.yosra.services.CarsManagerLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GenerateServlet extends HttpServlet
{
    @EJB
    CarsManagerLocal carsManager;   
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {       
        String nbs = request.getParameter("nb");
        
        boolean result = false;
                       
        if(nbs != null && !nbs.equals(""))
        {
            int nb = Integer.parseInt(nbs);
                
            carsManager.generateRandomCars(nb);
            
            request.setAttribute("success", nbs + " cars successfully generated !");
        }
        else
        {
            request.setAttribute("error", "The field is empty !");
        }
        
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {       
        request.getRequestDispatcher("/WEB-INF/generate.jsp").forward(request, response);
    }
}
