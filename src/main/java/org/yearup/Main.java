package org.yearup;

import org.apache.commons.dbcp2.BasicDataSource;
import org.yearup.application.CarDealershipApplication;
import org.yearup.data.MysqlLeaseContractDao;
import org.yearup.data.MysqlSalesContractDao;
import org.yearup.data.MysqlVehicleDao;

public class Main
{
    public static void main(String[] args)
    {
        String baseUrl = "jdbc:mysql://localhost:3306/car_dealership";
        String username = "root";
        String password = "P@ssw0rd";

        BasicDataSource dataSource = new BasicDataSource()
        {{
            setUrl(baseUrl);
            setUsername(username);
            setPassword(password);
        }};

        MysqlVehicleDao vehicleDao = new MysqlVehicleDao(dataSource);
        MysqlSalesContractDao salesContractDao = new MysqlSalesContractDao(dataSource);
        MysqlLeaseContractDao leaseContractDao = new MysqlLeaseContractDao(dataSource);

        CarDealershipApplication app = new CarDealershipApplication(vehicleDao, salesContractDao, leaseContractDao);
        app.run();
    }
}