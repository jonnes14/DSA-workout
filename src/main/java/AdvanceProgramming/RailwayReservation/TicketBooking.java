package AdvanceProgramming.RailwayReservation;

import java.util.Scanner;

public class TicketBooking {
    public static void main(String[] args) {
        RailwayCode r=new RailwayCode();
        r.tickets();
        Scanner s =new Scanner(System.in);
        while(true) {
            System.out.println("Railway Reservation");
            System.out.println("Enter 1 for Book");
            System.out.println("Enter 2 for Cancel");
            System.out.println("Enter 3 for Print booked tickets");
            System.out.println("Enter 4 for Print available tickets (details with summary)");
            System.out.println("Enter 5 for Exit");
            System.out.println("Enter your choice");
            int choice=s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter name");
                    String name=s.nextLine();
                    System.out.println("Enter age");
                    int age=s.nextInt();
                    System.out.println("Enter Gender");
                    String gender=s.nextLine();
                    System.out.println("Enter Berth preference (L/U/M)");
                    String berthpreference=s.nextLine();
                    r.BookTicket(name,age,gender,berthpreference,true);
                    break;
                case 2:
                    System.out.println("Enter ticket id to cancel");
                    String ticketid=s.nextLine();
                    r.cancelTicket(ticketid);
                    break;
                case 3:
                    System.out.println("Booking details");
                    r.printBookingDetails();
                    break;
                case 4:
                    System.out.println("Available tickets");
                    r.availabletickets();
                    break;
                case 5:
                    System.out.println("exiting..");
                    System.exit(0);
                default:
                    System.out.println("invalid choice");
            }
        }

    }
}
