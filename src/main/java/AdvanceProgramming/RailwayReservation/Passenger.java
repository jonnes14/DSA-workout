package AdvanceProgramming.RailwayReservation;

import java.util.*;

public class Passenger {
    private final List<Integer> booking=new ArrayList<Integer>();
    private final List<String> seatbirth=Arrays.asList("L","M","U","SL");
    private final List<String> details=new ArrayList<String>();
    private final Queue<Integer> rac=new LinkedList<Integer>();

    public void BookTicket(Passenger passenger) {

    }
    public String AllocateBirth(String name,int age, String preference, String gender, boolean hasChild, boolean israc) {
        if(age<5) {
            details.add(name+","+age+","+gender);
            return "age is less than 5 no seat allocated";
        }
        if((age>60 || (gender.equalsIgnoreCase("female")&&hasChild)) &&seatbirth.contains("L")) {
            return "L";
        }
        if(seatbirth.contains(preference)) {
            return preference;
        }
        if(israc) {
            if(seatbirth.contains("SL")) {
                seatbirth.remove("SL");
            }
        }
        return seatbirth.get(0);
}
