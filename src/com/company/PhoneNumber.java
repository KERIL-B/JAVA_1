package com.company;

//import com.sun.tools.javac.util.Convert;

import java.lang.reflect.Array;

public class PhoneNumber {

    private String number;
    private String comment;

    public PhoneNumber(String number)
    {
        this.number = number;
    }

    public String GetNumber()
    {return number;}

    public PhoneNumber(String number, String comment)
    {
        this.number = number;
        this.comment = comment;
    }

    public String ToString()
    {
        if (comment==null)
        return number;
        else
         return number+" ("+comment+")";
    }

}
