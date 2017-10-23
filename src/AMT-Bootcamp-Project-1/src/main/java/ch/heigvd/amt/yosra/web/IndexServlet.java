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

public class IndexServlet extends HttpServlet
{
    @EJB
    CarsManagerLocal carsManager;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int size = carsManager.getAllCars().size();
        
        request.setAttribute("size", size);
        
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}