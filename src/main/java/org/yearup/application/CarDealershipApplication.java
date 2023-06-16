package org.yearup.application;

import org.yearup.data.MysqlLeaseContractDao;
import org.yearup.data.MysqlSalesContractDao;
import org.yearup.data.MysqlVehicleDao;
import org.yearup.models.LeaseContract;
import org.yearup.models.SalesContract;
import org.yearup.models.Vehicle;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class CarDealershipApplication
{
    private static final Scanner scanner = new Scanner(System.in);
    private MysqlVehicleDao vehicleDao;
    private MysqlSalesContractDao salesContractDao;
    private MysqlLeaseContractDao leaseContractDao;

    public CarDealershipApplication(MysqlVehicleDao vehicleDao, MysqlSalesContractDao salesContractDao, MysqlLeaseContractDao leaseContractDao)
    {
        this.vehicleDao = vehicleDao;
        this.salesContractDao = salesContractDao;
        this.leaseContractDao = leaseContractDao;
    }

    public void run()
    {
        while(true)
        {
            System.out.println("\n--- HOME ---\n");
            System.out.println("What do you want to do?\n");

            System.out.println("1) Display all vehicles");
            System.out.println("2) Display by price range");
            System.out.println("3) Display by make/model");
            System.out.println("4) Display by year range");
            System.out.println("5) Display by color");
            System.out.println("6) Display by mileage");
            System.out.println("7) Add a vehicle");
            System.out.println("8) Delete a vehicle");
            System.out.println("9) Admin Menu");

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
                case 7 ->
                {
                    addVehicle();
                }
                case 8 ->
                {
                    deleteVehicle();
                }
                case 9 ->
                {
                    String password = "password";
                    System.out.print("Enter password: ");
                    String guess = scanner.nextLine();
                    if(guess.equals(password))
                    {
                        displayAdminMenu();
                    }
                    else
                    {
                        System.out.println("\nACCESS DENIED");
                    }
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

    public void addVehicle()
    {
        System.out.print("\nEnter VIN: ");
        String vin = scanner.nextLine().strip().toUpperCase();
        System.out.print("Enter Make: ");
        String make = scanner.nextLine().strip();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine().strip();
        System.out.print("Enter Color: ");
        String color = scanner.nextLine().strip();
        System.out.print("Enter Year: ");
        int year = Integer.parseInt(scanner.nextLine().strip());
        System.out.print("Enter Mileage: ");
        int miles = Integer.parseInt(scanner.nextLine().strip());
        System.out.print("Enter Price: ");
        BigDecimal price = scanner.nextBigDecimal();
        scanner.nextLine();

        // Vehicle won't be sold instantly
        boolean sold = false;

        Vehicle vehicle = new Vehicle()
        {{
            setVin(vin);
            setMake(make);
            setModel(model);
            setColor(color);
            setYear(year);
            setMiles(miles);
            setPrice(price);
            setSold(sold);
        }};

        vehicleDao.add(vehicle);
        System.out.printf("\n%d %s %s was added to the database!\n", vehicle.getYear(), vehicle.getMake(), vehicle.getModel());

    }

    public void deleteVehicle()
    {
        displayAllVehicles();
        System.out.print("\nEnter VIN to delete: ");
        String vin = scanner.nextLine().strip().toUpperCase();

        System.out.println();
        Vehicle vehicle = vehicleDao.getVehicleByVin(vin);
        printVehicleHeader();
        printVehicle(vehicle);
        System.out.print("\nAre you sure? (y/n) ");
        String yesNo = scanner.nextLine().strip();
        if(yesNo.equalsIgnoreCase("Y"))
        {
            vehicleDao.delete(vin);

            System.out.printf("\n%d %s %s was removed from the database!\n", vehicle.getYear(), vehicle.getMake(), vehicle.getModel());
        }
    }

    public void displayAdminMenu()
    {
        while(true)
        {
            System.out.println("\n--- ADMIN MENU ---\n");
            System.out.println("What do you want to do?\n");

            System.out.println("1) Display all sales contracts");
            System.out.println("2) Display all lease contracts");

            System.out.println("\n0) Back\n");

            System.out.print("Enter an option: ");
            int option = Integer.parseInt(scanner.nextLine().strip());

            switch(option)
            {
                case 0 ->
                {
                    return;
                }
                case 1 ->
                {
                    displayAllSalesContracts();
                }
                case 2 ->
                {
                    displayAllLeaseContracts();
                }
            }
        }
    }

    public void printSalesContractHeader()
    {
        System.out.println();
        System.out.println(String.format("%-5s %-25s %-25s %-30s %-15s %-15s %-15s %-15s", "ID", "VIN", "NAME", "EMAIL", "PRICE", "REC. FEE", "PROC. FEE", "TAX"));
        System.out.println("-".repeat(144));
    }

    public void printSalesContract(SalesContract c)
    {
        System.out.printf("%-5d %-25s %-25s %-30s %-15.2f %-15.2f %-15.2f %-15.2f\n",
                c.getSalesId(),
                c.getVin(),
                c.getCustomerName(),
                c.getCustomerEmail(),
                c.getSalesPrice(),
                c.getRecordingFee(),
                c.getProcessingFee(),
                c.getSalesTax());
    }

    public void displayAllSalesContracts()
    {
        List<SalesContract> salesContracts = salesContractDao.getAll();
        printSalesContractHeader();
        for(var c : salesContracts)
        {
            printSalesContract(c);
        }
    }

    public void printLeaseContractHeader()
    {
        System.out.println();
        System.out.println(String.format("%-5s %-25s %-25s %-30s %-15s %-15s %-15s %-15s %-15s", "ID", "VIN", "NAME", "EMAIL", "PRICE", "END VAL.", "LEASE FEE", "TAX", "PYMNT"));
        System.out.println("-".repeat(159));
    }

    public void printLeaseContract(LeaseContract c)
    {
        System.out.printf("%-5d %-25s %-25s %-30s %-15.2f %-15.2f %-15.2f %-15.2f %-15.2f\n",
                c.getLeaseId(),
                c.getVin(),
                c.getCustomerName(),
                c.getCustomerEmail(),
                c.getSalesPrice(),
                c.getEndingValue(),
                c.getLeaseFee(),
                c.getSalesTax(),
                c.getMonthlyPayment());
    }

    public void displayAllLeaseContracts()
    {
        List<LeaseContract> leaseContracts = leaseContractDao.getAll();
        printLeaseContractHeader();
        for(var c : leaseContracts)
        {
            printLeaseContract(c);
        }
    }


}
