package com.company;


import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.nio.file.Paths;
import java.util.Scanner;

public class Commands {
    PhoneBook myPhoneBook;
    Gson gson;
    String fileName="myPhoneBookClass.txt";
    Long ID;

    public Commands()
    {
        myPhoneBook=new PhoneBook();
        gson=new GsonBuilder().create();
    }

    public String ShowAllCommands()
    {
        String info="\"add_sub\" - add new subscriber\n";
        info+="\"show_all\" - show all subscribers in your phone book\n";
        info+="\"del_sub_id\" - delete subscriber by id\n";
        info+="\"search_lastname\" - search subscriber by last name\n";
        info+="\"search_number\" - search subscriber by phone number\n";
        info+="\"save\" - save phone book";
        info+="\"load\" - load saved phone book";
        return info;
    }

    public String AddSubscriber(String subscriberInfo)
    {
        String[] subscriberInfoArr=subscriberInfo.split(" ");
        if (subscriberInfoArr.length>2 && subscriberInfoArr.length<6) {
            String fname = subscriberInfoArr[0];
            String lname = subscriberInfoArr[1];
            Subscrber newSub = new Subscrber(fname, lname, ID++);
            for (int i = 2; i < subscriberInfoArr.length; i++) {
                newSub.AddNumber(new PhoneNumber(subscriberInfoArr[i]));
            }
            myPhoneBook.AddSubscriber(newSub);
            return newSub.ShowInfo()+"added.\n";
        }
        else return "INPUT ERROR";

    }

    public String ShowAll()
    {
        return myPhoneBook.ShowPhoneBook();
    }

    public String DeleteById(int id)
    {
        if (myPhoneBook.DeleteSubscriberById(id))
            return "Deleted.\n";
        else return "Wrong ID.\n";
    }

    public String SearchLastName(String lastName)
    {
        return CreateListOfSubs(myPhoneBook.SearchByLastName(lastName));
    }

    public String SearchNumber(String number)
    {
        return CreateListOfSubs(myPhoneBook.SearchByPhoneNumber(number));
    }

    public String Save()
    {
        String classInString=gson.toJson(myPhoneBook);
        try {
            Files.write(Paths.get(fileName), classInString.getBytes());
        } catch (Exception e) {
            return e.toString();
        }

        return "Saved.\n";
    }

    public String Load()
    {
        String classInString="";
        Scanner scan=null;
        try {
            scan=new Scanner(Paths.get(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (scan.equals(null))
            return "File error";
        else
        classInString=scan.nextLine();

        PhoneBook loadedPhoneBook=gson.fromJson(classInString, PhoneBook.class);
        myPhoneBook=loadedPhoneBook;
        return "Loaded.\n"+myPhoneBook.ShowPhoneBook();
    }

    private String CreateListOfSubs(ArrayList<Subscrber> subs)
    {
        String info;
        if (subs.size()==0)
            info="Nobody found.\n";
        else {
            info="Founded:\n";
            for (Subscrber sub:subs
                    ) {
                info+=sub.ShowInfo()+"\n";
            }
        }
        return info;
    }
}
