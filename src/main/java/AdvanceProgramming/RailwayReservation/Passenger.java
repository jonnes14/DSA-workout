package AdvanceProgramming.RailwayReservation;

public class Passenger {
    private String name;
    private int age;
    private String gender;
    private String berthPreference;
    private  String ticketid;
      public Passenger(String name, int age, String gender, String berthPreference , String ticketid) {

        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthPreference = berthPreference;
        this.ticketid=ticketid;
    }

    public String getTicketid(){
          return ticketid;
    }
    public String getBerthPreference() {
        return berthPreference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBerthPreference(String berthPreference) {
        this.berthPreference = berthPreference;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", berthPreference='" + berthPreference + '\'' +
                ", ticketid=" + ticketid +
                '}';
    }
}
