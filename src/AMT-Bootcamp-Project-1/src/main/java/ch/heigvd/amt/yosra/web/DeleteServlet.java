/*
 *Author: Yosra Harbaoui
 *Date: October 2017
*/

package ch.heigvd.amt.yosra.web;

import ch.heigvd.amt.yosra.model.Car;
import ch.heigvd.amt.yosra.services.CarsManagerLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet
{    
    @EJB
    CarsManagerLocal carsManager;   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("id");
        
        boolean result = false;
                       
        if(id != null && !id.equals(""))
        {
            Car car = carsManager.getCar(Integer.parseInt(id));

            if(car != null)
            {              
                boolean res = carsManager.deleteCar(Integer.parseInt(id));

                if(res)
                {       
                    result = true;
                }
            }
        }
        else
        {
            response.sendRedirect("cars");
            
            return;
        }
        
        if(result)
        {
            request.setAttribute("success", "Car successfully deleted !");
        }
        else
        {
            request.setAttribute("error", "Error deleting the car !");
        }
        
        request.getRequestDispatcher("/WEB-INF/delete.jsp").forward(request, response);
    }
}