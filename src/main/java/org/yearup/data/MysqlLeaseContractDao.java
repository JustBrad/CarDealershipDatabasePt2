package org.yearup.data;

import org.yearup.models.LeaseContract;
import org.yearup.models.SalesContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MysqlLeaseContractDao
{
    private DataSource dataSource;

    public MysqlLeaseContractDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public List<LeaseContract> getAll()
    {
        List<LeaseContract> leaseContracts = new ArrayList<>();

        String sql = """
                SELECT *
                FROM lease_contracts;
                """;

        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement())
        {
            ResultSet row = statement.executeQuery(sql);

            while(row.next())
            {
                LeaseContract leaseContract = new LeaseContract()
                {{
                    setLeaseId(row.getInt("lease_id"));
                    setVin(row.getString("vin"));
                    setCustomerName(row.getString("customer_name"));
                    setCustomerEmail(row.getString("customer_email"));
                    setSalesPrice(row.getBigDecimal("sales_price"));
                    setEndingValue(row.getBigDecimal("ending_value"));
                    setLeaseFee(row.getBigDecimal("lease_fee"));
                    setSalesTax(row.getBigDecimal("sales_tax"));
                    setMonthlyPayment(row.getBigDecimal("monthly_payment"));
                }};

                leaseContracts.add(leaseContract);
            }
        }
        catch(SQLException ignored){}

        return leaseContracts;
    }
}
