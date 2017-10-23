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

public class CarsServlet extends HttpServlet
{
    @EJB
    CarsManagerLocal carsManager;    
    
    @Override
    public void doGet(HttpServletRequest request,  HttpServletResponse response)  throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("cars", carsManager.getAllCars());
        request.getRequestDispatcher("/WEB-INF/cars.jsp").forward(request, response);
    }
}