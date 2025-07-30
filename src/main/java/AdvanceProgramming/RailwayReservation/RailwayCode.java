package AdvanceProgramming.RailwayReservation;

import java.util.*;

public class RailwayCode {
    private final List<String> booking=new ArrayList<String>();
    private final List<Passenger> conformedpassenger=new ArrayList<>();
    private final Queue<Passenger> rac=new LinkedList<>();
    private final Queue<Passenger> wait=new LinkedList<>();
    private final List<Integer> lower=new ArrayList<>();
    private final List<Integer> upper=new ArrayList<>();
    private final List<Integer> middle=new ArrayList<>();
    private final List<Integer> sidelower=new ArrayList<>();

    private int ticketcounter=0;

    public void BookTicket(String name, int age,String gender,String berthPreference) {
        Passenger passenger;
        String ticketid= "T"+ticketcounter++;
        String assignedbirth=BirthCondition(name,age,berthPreference,gender,hasChild,true);
        if(age<5) {
            booking.add(name+","+age+","+gender);
            System.out.println( "age is less than 5 no seat allocated");
            return;
        }
        if(!lower.isEmpty()) {
             int berthnumber =lower.remove(0);
            passenger=new Passenger(name, age,gender,berthPreference,ticketid);
            passenger.setBerthPreference("L"+berthnumber);
            conformedpassenger.add(passenger);
        }
        else if(!middle.isEmpty()) {
            int berthnumber =middle.remove(0);
            passenger=new Passenger(name, age,gender,berthPreference,ticketid);
            passenger.setBerthPreference("M"+berthnumber);
            conformedpassenger.add(passenger);
        }
       else  if(!upper.isEmpty()) {
            int berthnumber =upper.remove(0);
            passenger=new Passenger(name, age,gender,berthPreference,ticketid);
            passenger.setBerthPreference("U"+berthnumber);
            conformedpassenger.add(passenger);
        }
        else if(rac.isEmpty()){
            passenger =new Passenger(name,age,gender,berthPreference,ticketid);
            rac.offer(passenger);
            System.out.println("your ticket id"+passenger.getTicketid()+"moved to RAC");
        }
        else{
            passenger =new Passenger(name,age,gender,berthPreference,ticketid);
            wait.offer(passenger);
            System.out.println("your ticket id"+passenger.getTicketid()+"moved to RAC");
        }

    }
    public String BirthCondition(String name,int age, String preference, String gender, boolean hasChild, boolean israc) {

        if((age>60 || (gender.equalsIgnoreCase("female")&&hasChild)) ) {
            if(!lower.isEmpty()) {
                return "L";
            }
        }
        if(!upper.isEmpty() || !lower.isEmpty() || !middle.isEmpty()) {
            return preference;
        }
        if(israc) {
            if(!sidelower.isEmpty()) {
                sidelower.remove("SL");
            }
        }
        return "No";
    }
    public void tickets() {
        for(int i=0;i<21;i++) lower.add(i);
        for(int i=0;i<21;i++) middle.add(i);
        for(int i=0;i<21;i++) upper.add(i);
        for(int i=0;i<9;i++) sidelower.add(i);
    }
    public void cancelTicket(String inputid){
        Passenger tocancel=null;
       for(Passenger p:conformedpassenger){
           if(p.getTicketid().equals(inputid)) {
               tocancel = p;
               break;
           }
       }
       conformedpassenger.remove(tocancel);
       String berth=tocancel.getBerthPreference();

        System.out.println("ticketid"+inputid+"is cancelled");
        if(!rac.isEmpty()){
            Passenger racpassenger=rac.poll();
            racpassenger.setBerthPreference(berth);
            conformedpassenger.add(racpassenger);
            System.out.println("Rac passenger"+racpassenger.getName()+" moved to"+berth);
        }
        if(!wait.isEmpty()){
            Passenger waitpassenger=wait.poll();
            rac.offer(waitpassenger);
            waitpassenger.setBerthPreference("RAC");
            System.out.println("Wait passenger"+waitpassenger.getName()+" moved to rac list");
        }
        System.out.println("ticket cancelled successfully");
    }


}
