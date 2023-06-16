package org.yearup.data;

import org.yearup.models.SalesContract;
import org.yearup.models.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlSalesContractDao
{
    private DataSource dataSource;

    public MysqlSalesContractDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public List<SalesContract> getAll()
    {
        List<SalesContract> salesContracts = new ArrayList<>();

        String sql = """
                SELECT *
                FROM sales_contracts;
                """;

        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement())
        {
            ResultSet row = statement.executeQuery(sql);

            while(row.next())
            {
                SalesContract salesContract = new SalesContract()
                {{
                    setSalesId(row.getInt("sales_id"));
                    setVin(row.getString("vin"));
                    setCustomerName(row.getString("customer_name"));
                    setCustomerEmail(row.getString("customer_email"));
                    setSalesPrice(row.getBigDecimal("sales_price"));
                    setRecordingFee(row.getBigDecimal("recording_fee"));
                    setProcessingFee(row.getBigDecimal("processing_fee"));
                    setSalesTax(row.getBigDecimal("sales_tax"));
                }};

                salesContracts.add(salesContract);
            }
        }
        catch(SQLException ignored){}

        return salesContracts;
    }
}
