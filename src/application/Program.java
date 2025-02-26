package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        Integer roomNumber = sc.nextInt();
        System.out.print("Check-in date (DD/MM/YYYY): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (DD/MM/YYYY): ");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out must be after check-in date!");
        }else{
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("\nEnter data to update the reservation: ");
            System.out.print("Updated check-in date: ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Updated check-out date: ");
            checkOut = sdf.parse(sc.next());

            String error = reservation.UpdateDates(checkIn,checkOut);
            if(error != null){
                System.out.println("Error in reservation: " + error);
            }else {
                System.out.println("Reservation: " + reservation);
            }
        }

        sc.close();
    }
}
