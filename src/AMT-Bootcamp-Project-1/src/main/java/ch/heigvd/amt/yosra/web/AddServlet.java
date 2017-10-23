/*
 *Author: Yosra Harbaoui
 *Date: October 2017
 *Description: Add a new car
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

public class AddServlet extends HttpServlet
{
    @EJB
    CarsManagerLocal carsManager;    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {       
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String color = request.getParameter("color");
                
        if(brand.equals("") || model.equals("") || color.equals(""))
        {
            request.setAttribute("error", "One of the fields is empty !");
            
            doGet(request, response); 
            
            return;
        }
        
        boolean res = carsManager.createCar(new Car(brand, model, color));
                
        if(res)
        {
            request.setAttribute("success", "Car successfully added !");
        }
        else
        {
            request.setAttribute("error", "Error while adding the car !");
        }
        
        doGet(request, response); 
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/add.jsp").forward(request, response);
    } 
}