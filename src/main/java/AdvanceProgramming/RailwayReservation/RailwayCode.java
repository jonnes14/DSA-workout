package AdvanceProgramming.RailwayReservation;

import java.util.*;

public class RailwayCode {
    private final List<String> booking=new ArrayList<String>();
    private final List<String> seatbirth= new  ArrayList<>(Arrays.asList("L","M","U","SL"));
    private final List<Passenger> conformedpassenger=new ArrayList<>();
    private final Queue<Passenger> rac=new LinkedList<>();
    private final List<Integer> lower=new ArrayList<>();
    private final List<Integer> upper=new ArrayList<>();
    private final List<Integer> middle=new ArrayList<>();
    private final List<Integer> sidelower=new ArrayList<>();
    public void BookTicket(String name, int age,String gender,String berthPreference) {
        Passenger passenger;
        if(!seatbirth.isEmpty()) {
            passenger=new Passenger(name, age,gender,berthPreference);
            conformedpassenger.add(passenger);
        }

    }
    public String BirthCondition(String name,int age, String preference, String gender, boolean hasChild, boolean israc) {
        if(age<5) {
            booking.add(name+","+age+","+gender);
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
    public void tickets() {
        for(int i=0;i<21;i++) lower.add(i);
        for(int i=0;i<21;i++) middle.add(i);
        for(int i=0;i<21;i++) lower.add(i);
        for(int i=0;i<9;i++) sidelower.add(i);
    }
    public void cancelTicket(){

    }

}
