package com.company;

//import com.sun.tools.javac.util.List;

import java.util.ArrayList;

public class Subscrber {

    private Long id;
    private String firstName;
    private String lastName;
    private ArrayList<PhoneNumber> phoneNumbersList=new ArrayList<PhoneNumber>(3);

    public Subscrber(String firstName, String lastName, Long id)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.id=id;
    }

    public boolean AddNumber(PhoneNumber phoneNumber)
    {
        if (phoneNumbersList.contains(phoneNumber))
        {
            return false;
        }
        else
            if (phoneNumbersList.size()>2)
                return false;
            else{
            phoneNumbersList.add(phoneNumber);
            return true;
        }
    }

    public Long GetID()
    {return id;}

    public String ShowInfo()
    {
        String info=firstName+" "+lastName+" (id:"+id+")\n";
        for (PhoneNumber number:phoneNumbersList)
        {
            info+=number.ToString()+"\n";
        }
        return info;
    }

    public boolean SameLastName(String lastName)
    {
        if(this.lastName.equals(lastName))
            return true;
        else return false;
    }

    public boolean SamePhoneNumber(String phoneNumberString)
    {
        boolean rez=false;
        for (PhoneNumber number:phoneNumbersList) {
            if(number.GetNumber().equals(phoneNumberString))
                rez=true;
        }
        return rez;
    }

    public String StringForCompare()
    {
        String numbers="";
        for (PhoneNumber number:phoneNumbersList
             ) {
            numbers+=number.GetNumber();
        }
        return firstName+lastName+numbers;
    }
}

