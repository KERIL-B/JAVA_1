package com.company;

//import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
    Commands DO=new Commands();
    Scanner scan=new Scanner(System.in);



    System.out.println("If you want to exit type \"exit\"");
    System.out.println("Type \"?\" to see all commands");

    String newCommand;
    do {
        newCommand=scan.nextLine();
        switch (newCommand) {
            case "exit":
                break;
            case "?":
                System.out.println(DO.ShowAllCommands());
                 break;
            case"add_sub":
                System.out.println("Enter FIRSTNAME LASTNAME NUMBER1(2,3)");
                System.out.println(DO.AddSubscriber(scan.nextLine()));
                break;
            case"show_all":
                System.out.println(DO.ShowAll());
                 break;
            case"del_sub_id":
                System.out.println("Enter id");
                System.out.println(DO.DeleteById(scan.nextInt()));
                break;
            case"search_lastname":
                System.out.println("Enter last name");
                System.out.println(DO.SearchLastName(scan.next()));
                scan.nextLine();
                break;
            case"search_number":
                System.out.println("Enter number");
                System.out.println(DO.SearchNumber(scan.next()));
                scan.nextLine();
            case"save":
                System.out.println(DO.Save());
                break;
            case"load":
                System.out.println(DO.Load());
                break;
            default:
                System.out.println("Wrong command. Type \"?\" to see all commands");
                break;

        }


    }while (!newCommand.equals("exit"));


}}
