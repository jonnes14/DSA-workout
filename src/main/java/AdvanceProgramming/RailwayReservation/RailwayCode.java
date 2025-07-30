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

        public void BookTicket(String name, int age,String gender,String berthPreference, boolean hasChild) {
            Passenger passenger;
            String ticketid= "T"+ticketcounter++;
            String assignedbirth=BirthCondition(age,berthPreference,gender,hasChild);
            if(age<5) {
                booking.add(name+","+age+","+gender);
                System.out.println( "age is less than 5 no seat allocated");
                return;
            }
            if(!lower.isEmpty()&& assignedbirth.equals("L")) {
                 int berthnumber =lower.remove(0);
                passenger=new Passenger(name, age,gender,berthPreference,ticketid);
                passenger.setBerthPreference("L"+berthnumber);
                conformedpassenger.add(passenger);
            }
            else if(!middle.isEmpty()&&assignedbirth.equals("M")) {
                int berthnumber =middle.remove(0);
                passenger=new Passenger(name, age,gender,berthPreference,ticketid);
                passenger.setBerthPreference("M"+berthnumber);
                conformedpassenger.add(passenger);
            }
           else  if(!upper.isEmpty()&& assignedbirth.equals("U")) {
                int berthnumber =upper.remove(0);
                passenger=new Passenger(name, age,gender,berthPreference,ticketid);
                passenger.setBerthPreference("U"+berthnumber);
                conformedpassenger.add(passenger);
            }
            else if(rac.size()<10){
                passenger =new Passenger(name,age,gender,berthPreference,ticketid);
                passenger.setBerthPreference("RAC");
                rac.offer(passenger);
                System.out.println("your ticket id"+passenger.getTicketid()+"moved to RAC");
            }
            else{
                passenger =new Passenger(name,age,gender,berthPreference,ticketid);
                passenger.setBerthPreference("WL");
                wait.offer(passenger);
                System.out.println("your ticket id"+passenger.getTicketid()+"moved to RAC");
            }

        }
        public String BirthCondition(int age, String preference, String gender, boolean hasChild) {

            if((age>60 || (gender.equalsIgnoreCase("female")&&hasChild)) ) {
                if(!lower.isEmpty()) {
                    return "L";
                }
            }
            if(preference.equalsIgnoreCase("L")&&!lower.isEmpty()) return "L";
            if(preference.equalsIgnoreCase("M")&&!middle.isEmpty()) return "M";
            if(preference.equalsIgnoreCase("U")&&!upper.isEmpty()) return "U";
                if(!sidelower.isEmpty()) {
                    sidelower.remove("SL");
                    return "SL";
                }

            return "NA";
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
    public void printBookingDetails(){
            if(conformedpassenger.isEmpty()){
                System.out.println("the passenger list is empty");
            }
            else{
                for(Passenger passenger: conformedpassenger){
                    System.out.println(passenger);
                }
            }
    }
    public void availabletickets(){
                int total=lower.size()+upper.size()+middle.size();
                System.out.println("Available tickets"+total);
                System.out.println("Available RAC"+(9-rac.size()));
                System.out.println("Available waiting"+(10-wait.size()));

    }

    }
