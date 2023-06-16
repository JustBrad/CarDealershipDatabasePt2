package org.yearup.data;

import org.yearup.models.Vehicle;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlVehicleDao
{
    private DataSource dataSource;

    public MysqlVehicleDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public List<Vehicle> getAll()
    {
        List<Vehicle> vehicles = new ArrayList<>();

        String sql = """
                SELECT * FROM vehicles;
                """;

        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();)
        {
            ResultSet row = statement.executeQuery(sql);

            while(row.next())
            {
                Vehicle vehicle = new Vehicle()
                {{
                    setVin(row.getString("vin"));
                    setMake(row.getString("make"));
                    setModel(row.getString("model"));
                    setColor(row.getString("color"));
                    setYear(row.getInt("year"));
                    setMiles(row.getInt("miles"));
                    setPrice(row.getBigDecimal("price"));
                    setSold(row.getBoolean("sold"));
                }};

                vehicles.add(vehicle);
            }
        }
        catch(SQLException ignored){}

        return vehicles;
    }

    public List<Vehicle> getByPriceRange(BigDecimal min, BigDecimal max)
    {
        List<Vehicle> vehicles = new ArrayList<>();

        String sql = """
                SELECT * FROM vehicles
                WHERE price BETWEEN ? AND ?
                ORDER BY price;
                """;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setBigDecimal(1, min);
            statement.setBigDecimal(2, max);

            ResultSet row = statement.executeQuery();

            while(row.next())
            {
                Vehicle vehicle = new Vehicle()
                {{
                    setVin(row.getString("vin"));
                    setMake(row.getString("make"));
                    setModel(row.getString("model"));
                    setColor(row.getString("color"));
                    setYear(row.getInt("year"));
                    setMiles(row.getInt("miles"));
                    setPrice(row.getBigDecimal("price"));
                    setSold(row.getBoolean("sold"));
                }};

                vehicles.add(vehicle);
            }
        }
        catch(SQLException ignored){}

        return vehicles;
    }

    public List<Vehicle> getByMakeModel(String make, String model)
    {
        List<Vehicle> vehicles = new ArrayList<>();

        String sql = """
                SELECT * FROM vehicles
                WHERE make = ? AND model = ?;
                """;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, make);
            statement.setString(2, model);

            ResultSet row = statement.executeQuery();

            while(row.next())
            {
                Vehicle vehicle = new Vehicle()
                {{
                    setVin(row.getString("vin"));
                    setMake(row.getString("make"));
                    setModel(row.getString("model"));
                    setColor(row.getString("color"));
                    setYear(row.getInt("year"));
                    setMiles(row.getInt("miles"));
                    setPrice(row.getBigDecimal("price"));
                    setSold(row.getBoolean("sold"));
                }};

                vehicles.add(vehicle);
            }
        }
        catch(SQLException ignored){}

        return vehicles;
    }

    public List<Vehicle> getByYearRange(int min, int max)
    {
        List<Vehicle> vehicles = new ArrayList<>();

        String sql = """
                SELECT * FROM vehicles
                WHERE year BETWEEN ? AND ?
                ORDER BY year;
                """;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1, min);
            statement.setInt(2, max);

            ResultSet row = statement.executeQuery();

            while(row.next())
            {
                Vehicle vehicle = new Vehicle()
                {{
                    setVin(row.getString("vin"));
                    setMake(row.getString("make"));
                    setModel(row.getString("model"));
                    setColor(row.getString("color"));
                    setYear(row.getInt("year"));
                    setMiles(row.getInt("miles"));
                    setPrice(row.getBigDecimal("price"));
                    setSold(row.getBoolean("sold"));
                }};

                vehicles.add(vehicle);
            }
        }
        catch(SQLException ignored){}

        return vehicles;
    }

    public List<Vehicle> getByColor(String color)
    {
        List<Vehicle> vehicles = new ArrayList<>();

        String sql = """
                SELECT * FROM vehicles
                WHERE color = ?;
                """;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, color);

            ResultSet row = statement.executeQuery();

            while(row.next())
            {
                Vehicle vehicle = new Vehicle()
                {{
                    setVin(row.getString("vin"));
                    setMake(row.getString("make"));
                    setModel(row.getString("model"));
                    setColor(row.getString("color"));
                    setYear(row.getInt("year"));
                    setMiles(row.getInt("miles"));
                    setPrice(row.getBigDecimal("price"));
                    setSold(row.getBoolean("sold"));
                }};

                vehicles.add(vehicle);
            }
        }
        catch(SQLException ignored){}

        return vehicles;
    }

    public List<Vehicle> getByMileRange(int min, int max)
    {
        List<Vehicle> vehicles = new ArrayList<>();

        String sql = """
                SELECT * FROM vehicles
                WHERE miles BETWEEN ? AND ?
                ORDER BY miles;
                """;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1, min);
            statement.setInt(2, max);

            ResultSet row = statement.executeQuery();

            while(row.next())
            {
                Vehicle vehicle = new Vehicle()
                {{
                    setVin(row.getString("vin"));
                    setMake(row.getString("make"));
                    setModel(row.getString("model"));
                    setColor(row.getString("color"));
                    setYear(row.getInt("year"));
                    setMiles(row.getInt("miles"));
                    setPrice(row.getBigDecimal("price"));
                    setSold(row.getBoolean("sold"));
                }};

                vehicles.add(vehicle);
            }
        }
        catch(SQLException ignored){}

        return vehicles;
    }

    public List<Vehicle> getByType(String type)
    {
        List<Vehicle> vehicles = new ArrayList<>();

        return vehicles;
    }

    public Vehicle add(Vehicle vehicle)
    {
        return null;
    }

    void delete(int id)
    {

    }
}
