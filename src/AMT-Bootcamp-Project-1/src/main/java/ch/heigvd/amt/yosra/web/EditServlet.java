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

public class EditServlet extends HttpServlet
{
    @EJB
    CarsManagerLocal carsManager;   
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {       
        String id = request.getParameter("id");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String color = request.getParameter("color");
        
        if(id.equals("") || brand.equals("") || model.equals("") || color.equals(""))
        {
            request.setAttribute("error", "One of the fields is empty !");
            
            doGet(request, response); 
            
            return;
        }
              
        boolean res = carsManager.updateCar(new Car(Integer.parseInt(id), brand, model, color));
        
        if(res)
        {
            request.setAttribute("success", "Car successfully edited !");
        }
        else
        {
            request.setAttribute("error", "Error while editing the car !");
        }
                
        doGet(request, response); 
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("id");
        
        boolean result = false;
        
        if(id != null && !id.equals(""))
        {
            Car car = carsManager.getCar(Integer.parseInt(id));
            
            if (car != null)
            {
                request.setAttribute("car", car);
                
                result = true;
            }            
        }
        
        if(!result)
        {
            response.sendRedirect("cars");
            
            return;
        }
        
        request.getRequestDispatcher("/WEB-INF/edit.jsp").forward(request, response);
    }
}