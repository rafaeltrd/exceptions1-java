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

            Date now = new Date();

            if(checkIn.before(now) || checkOut.before(now)){
                System.out.println("Error in reservation: Reservation dates for updates must be future dates!");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Check-out must be after check-in date!");
            }else{
                reservation.UpdateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
        }
    }
}
