package AdvanceProgramming.RailwayReservation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Passenger {
    List<Integer> booking=new ArrayList<Integer>();
    List<String> seatbirth= Arrays.asList("L","M","U");

    public void BookTicket(Passenger passenger) {

    }
    public String AllocateBirth(String name,int age, String gender) {
        if(age>60 && gender.equalsIgnoreCase("female") ) {
            seatbirth.get(0);
        }
        if(age<5) {
            return "ags is less than 5 no seat allocated";
        }
        return name;

    }
}
