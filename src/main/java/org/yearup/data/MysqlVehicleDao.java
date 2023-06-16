package org.yearup.data;

import org.yearup.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class MysqlVehicleDao
{
    public List<Vehicle> getAll()
    {
        List<Vehicle> vehicles = new ArrayList<>();

        return vehicles;
    }

    public List<Vehicle> getByPriceRange(double min, double max)
    {
        List<Vehicle> vehicles = new ArrayList<>();

        return vehicles;
    }

    public List<Vehicle> getByMakeModel(String make, String model)
    {
        List<Vehicle> vehicles = new ArrayList<>();

        return vehicles;
    }

    public List<Vehicle> getByYearRange(int min, int max)
    {
        List<Vehicle> vehicles = new ArrayList<>();

        return vehicles;
    }

    public List<Vehicle> getByColor(String color)
    {
        List<Vehicle> vehicles = new ArrayList<>();

        return vehicles;
    }

    public List<Vehicle> getByMileRange(double min, double max)
    {
        List<Vehicle> vehicles = new ArrayList<>();

        return vehicles;
    }

    public List<Vehicle> getByType(String type)
    {
        List<Vehicle> vehicles = new ArrayList<>();

        return vehicles;
    }

    public Vehicle getById(int id)
    {
        return null;
    }

    public Vehicle add(Vehicle vehicle)
    {
        return null;
    }

    void delete(int id)
    {

    }
}
