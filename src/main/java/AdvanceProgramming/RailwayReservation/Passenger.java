package AdvanceProgramming.RailwayReservation;

public class Passenger {
    private String name;
    private int age;
    private String gender;
    private String berthPreference;

    public Passenger(String name, int age, String gender, String berthPreference) {

        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthPreference = berthPreference;
    }



    @Override
    public String toString() {
        return "Passenger [name=" + name + ", age=" + age + ", gender=" + gender + ", berthPreference="
                + berthPreference + "]";
    }

}
