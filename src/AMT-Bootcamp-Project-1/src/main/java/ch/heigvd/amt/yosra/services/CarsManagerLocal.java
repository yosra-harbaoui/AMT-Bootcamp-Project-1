/*
 *Author: Yosra Harbaoui
 *Date: October 2017
 *Description: CarManager Interface
*/

package ch.heigvd.amt.yosra.services;

import ch.heigvd.amt.yosra.model.Car;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CarsManagerLocal
{
    public List<Car> getAllCars();   
    public Car getCar(int id);
    public boolean createCar(Car car);
    public boolean deleteCar(int id);
    public boolean updateCar(Car car);
    public void generateRandomCars(int nb);
}