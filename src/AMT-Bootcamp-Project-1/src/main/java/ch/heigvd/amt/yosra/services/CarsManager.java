/*
 *Author: Yosra Harbaoui
 *Date: October 2017
 *Description: class to manage cars: get, add, edit, delete, generate
*/

package ch.heigvd.amt.yosra.services;

import ch.heigvd.amt.yosra.model.Car;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
public class CarsManager implements CarsManagerLocal
{
    @Resource(lookup = "jdbc/sakila")
    private DataSource dataSource;
    
    private final Random randomGenerator = new Random();
    
    @Override
    public void generateRandomCars(int nb)
    {
        String[] brands = {"Ford", "Renault", "Ferrari", "Chevrolet", "BMW", "VW", "Seat", "Pontiac", "Honda", "Mazda","Mercedes-Benz","Toyota"};
        String[] models = {"Polo","Golf", "Clio","CX-5","Civic","Fiesta","Racing", "GT", "Van", "B-Class", "4x4"};
        String[] colors = {"Green","Blue","Red", "Black", "Yellow", "White","Grey","Orange","Indigo"};        
                
        for(int i = 0; i < nb; ++i)
        {
            int iBrands = randomGenerator.nextInt(brands.length);
            int iModels = randomGenerator.nextInt(models.length);
            int iColors = randomGenerator.nextInt(colors.length);

            createCar(new Car(brands[iBrands], models[iModels], colors[iColors]));           
        }
    }
    
    @Override
    public List<Car> getAllCars()
    {
        List<Car> cars = new ArrayList<>();
        
        try
        {
            Connection connection = dataSource.getConnection();
            
            PreparedStatement pstmt = connection.prepareStatement("SELECT * from cars");
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next())
            {
                int id = rs.getInt("id");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                String color = rs.getString("color");
                
                cars.add(new Car(id, brand, model, color));
            }
            
            connection.close();
        }
        catch (SQLException ex)
        {
            
        }
        
        return cars;
    }

    @Override
    public Car getCar(int id)
    {
        Car car = null;
        
        try
        {
            Connection connection = dataSource.getConnection();
            
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cars WHERE id = ?");
            
            statement.setInt(1, id);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next())
            {
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                String color = rs.getString("color");
                
                car = new Car(id, brand, model, color);
            }
            
            connection.close();
        }
        catch (SQLException ex)
        {
            
        }
        
        return car;
    }
    
    @Override
    public boolean createCar(Car car)
    {
        try
        {
            Connection connection = dataSource.getConnection();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO `cars` (`brand`, `model`, `color`) VALUES (?,?,?);");

            statement.setString(1, car.getBrand());
            statement.setString(2, car.getModel());
            statement.setString(3, car.getColor());

            statement.executeUpdate();   
            
            connection.close();
            
            return true;
        } 
        catch (SQLException e)
        {
            return false;
        }
    }

    @Override
    public boolean deleteCar(int id)
    {
        try
        {
            Connection connection = dataSource.getConnection();
            
            PreparedStatement statement = connection.prepareStatement("DELETE FROM cars WHERE id = ?;");
            
            statement.setInt(1, id);

            statement.executeUpdate();
            
            connection.close();

            return true;
        } 
        catch (SQLException e)
        {
            return false;
        }
    }

    @Override
    public boolean updateCar(Car car) 
    {
        try
        {
            Connection connection = dataSource.getConnection();
            
            PreparedStatement statement = connection.prepareStatement("UPDATE cars SET brand = '" + car.getBrand() + "', model = '" + car.getModel() + "', color = '" + car.getColor() + "' WHERE id = ?;");
            
            statement.setInt(1, car.getId());

            statement.executeUpdate();
            
            connection.close();

            return true;
        } 
        catch (SQLException e)
        {
            return false;
        }
    }
}