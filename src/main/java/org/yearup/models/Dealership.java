package org.yearup.models;

public class Dealership
{
    private int dealershipId;
    private String name;
    private String address;
    private String phone;

    public Dealership(){}

    public int getDealershipId()
    {
        return dealershipId;
    }

    public void setDealershipId(int dealershipId)
    {
        this.dealershipId = dealershipId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }
}
