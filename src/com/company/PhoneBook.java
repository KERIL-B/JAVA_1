package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class PhoneBook {

    private ArrayList<Subscrber> subscrbersList = new ArrayList<Subscrber>();

    public String ShowPhoneBook() {
        String phoneBookINFO = "";

        for (int i = 0; i < subscrbersList.size(); i++) {
            phoneBookINFO += String.valueOf(i) + ". " + subscrbersList.get(i).ShowInfo() + "\n";
        }

        return phoneBookINFO;
    }

    public void AddSubscriber(Subscrber newSubscriber) {
        subscrbersList.add(newSubscriber);

        Comparator<Subscrber> myComparator = new Comparator<Subscrber>() {
            @Override
            public int compare(Subscrber o1, Subscrber o2) {
                return o1.StringForCompare().compareTo(o2.StringForCompare());

            }
        };

        subscrbersList.sort(myComparator);
    }

    public boolean DeleteSubscriberById(int id) {
        boolean rez = false;
        for (Subscrber sub : subscrbersList
                ) {
            if (sub.GetID().equals(id)) {
                subscrbersList.remove(sub);
                rez = true;
            }
        }
        return rez;
    }

    public ArrayList<Subscrber> SearchByLastName(String lastName) {
        ArrayList<Subscrber> foundSubscribers = new ArrayList<Subscrber>();

        for (Subscrber sub : subscrbersList) {
            if (sub.SameLastName(lastName)) {
                foundSubscribers.add(sub);
            }
        }
        return foundSubscribers;
    }

    public ArrayList<Subscrber> SearchByPhoneNumber(String phoneNumberString) {
        ArrayList<Subscrber> foundSubscribers = new ArrayList<Subscrber>();

        for (Subscrber sub : subscrbersList) {
            if (sub.SamePhoneNumber(phoneNumberString)) {
                foundSubscribers.add(sub);
            }
        }
        return foundSubscribers;
    }
}
