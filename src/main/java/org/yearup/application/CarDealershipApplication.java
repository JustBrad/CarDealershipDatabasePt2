package org.yearup.application;

import org.yearup.data.MysqlVehicleDao;
import org.yearup.models.Vehicle;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class CarDealershipApplication
{
    private static final Scanner scanner = new Scanner(System.in);
    private MysqlVehicleDao vehicleDao;

    public CarDealershipApplication(MysqlVehicleDao vehicleDao)
    {
        this.vehicleDao = vehicleDao;
    }

    public void run()
    {
        while(true)
        {
            System.out.println("\nWhat do you want to do?\n");

            System.out.println("1) Display all vehicles");
            System.out.println("2) Display by price range");
            System.out.println("3) Display by make/model");
            System.out.println("4) Display by year range");
            System.out.println("5) Display by color");
            System.out.println("6) Display by mileage");

            System.out.println("\n0) Exit\n");

            System.out.print("Enter an option: ");

            int option = Integer.parseInt(scanner.nextLine().strip());
            switch(option)
            {
                case 0 ->
                {
                    System.out.println("\nGoodbye!");
                    System.exit(0);
                }
                case 1 ->
                {
                    displayAllVehicles();
                }
                case 2 ->
                {
                    displayByPriceRange();
                }
                case 3 ->
                {
                    displayByMakeModel();
                }
                case 4 ->
                {
                    displayByYearRange();
                }
                case 5 ->
                {
                    displayByColor();
                }
                case 6 ->
                {
                    displayByMileage();
                }
            }
        }
    }

    public void printVehicleHeader()
    {
        System.out.println();
        System.out.println(String.format("%-20s %-15s %-15s %-15s %-10s %-15s %-15s %-10s", "VIN", "MAKE", "MODEL", "COLOR", "YEAR", "MILES", "PRICE", "SOLD"));
        System.out.println("-".repeat(117));
    }
    public void printVehicle(Vehicle v)
    {
        System.out.printf("%-20s %-15s %-15s %-15s %-10d %-15d %-15.2f %-10b\n", v.getVin(), v.getMake(), v.getModel(), v.getColor(), v.getYear(), v.getMiles(), v.getPrice(), v.isSold());
    }

    public void displayAllVehicles()
    {
        List<Vehicle> vehicles = vehicleDao.getAll();
        printVehicleHeader();
        for(var v : vehicles)
        {
            printVehicle(v);
        }
    }

    public void displayByPriceRange()
    {
        System.out.print("\nEnter minimum price: ");
        BigDecimal min = scanner.nextBigDecimal();
        scanner.nextLine();

        System.out.print("Enter maximum price: ");
        BigDecimal max = scanner.nextBigDecimal();
        scanner.nextLine();

        List<Vehicle> vehicles = vehicleDao.getByPriceRange(min, max);
        printVehicleHeader();
        for(var v : vehicles)
        {
            printVehicle(v);
        }
    }

    public void displayByMakeModel()
    {
        System.out.print("\nEnter make: ");
        String make = scanner.nextLine().strip();

        System.out.print("Enter model: ");
        String model = scanner.nextLine().strip();

        List<Vehicle> vehicles = vehicleDao.getByMakeModel(make, model);
        printVehicleHeader();
        for(var v : vehicles)
        {
            printVehicle(v);
        }
    }

    public void displayByYearRange()
    {
        System.out.print("\nEnter minimum year: ");
        int min = Integer.parseInt(scanner.nextLine().strip());

        System.out.print("Enter maximum year: ");
        int max = Integer.parseInt(scanner.nextLine().strip());

        List<Vehicle> vehicles = vehicleDao.getByYearRange(min, max);
        printVehicleHeader();
        for(var v : vehicles)
        {
            printVehicle(v);
        }
    }

    public void displayByColor()
    {
        System.out.print("\nEnter color: ");
        String color = scanner.nextLine().strip();

        List<Vehicle> vehicles = vehicleDao.getByColor(color);
        printVehicleHeader();
        for(var v : vehicles)
        {
            printVehicle(v);
        }
    }

    public void displayByMileage()
    {
        System.out.print("\nEnter minimum mileage: ");
        int min = Integer.parseInt(scanner.nextLine().strip());

        System.out.print("Enter maximum mileage: ");
        int max = Integer.parseInt(scanner.nextLine().strip());

        List<Vehicle> vehicles = vehicleDao.getByMileRange(min, max);
        printVehicleHeader();
        for(var v : vehicles)
        {
            printVehicle(v);
        }
    }


}
