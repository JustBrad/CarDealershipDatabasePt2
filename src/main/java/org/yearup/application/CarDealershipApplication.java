package org.yearup.application;

import org.yearup.data.MysqlVehicleDao;
import org.yearup.models.Vehicle;

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


}
