import java.util.Random;
import java.util.Scanner;

public class CabBooking {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
    
        while (true) {
            System.out.println("\n===== CAB BOOKING SYSTEM =====");
            System.out.println("1. Book Ride");
            System.out.println("2. Exit");

            int menuChoice = readInt("Enter your choice: ");

            if (menuChoice == 1) {
                bookRide();
            } else if (menuChoice == 2) {
                System.out.println("Thank you for using Cab Booking System. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }

        scanner.close();
    }

    private static void bookRide() {
        String cabType;
        int ratePerKm;

        System.out.println("\n===== SELECT CAB TYPE =====");
        System.out.println("1. Auto  - Rs.12/km");
        System.out.println("2. Sedan - Rs.18/km");
        System.out.println("3. SUV   - Rs.25/km");

        int cabChoice = readInt("Choose cab type: ");

        if (cabChoice == 1) {
            cabType = "Auto";
            ratePerKm = 12;
        } else if (cabChoice == 2) {
            cabType = "Sedan";
            ratePerKm = 18;
        } else if (cabChoice == 3) {
            cabType = "SUV";
            ratePerKm = 25;
        } else {
            System.out.println("Invalid cab choice. Booking cancelled; returning to main menu.");
            return;
        }

        String source;
        String destination;
        int distanceKm;

        System.out.println("\n===== SELECT ROUTE =====");
        System.out.println("1. Pune Station to Shivajinagar (5 km)");
        System.out.println("2. Swargate to Kothrud (8 km)");
        System.out.println("3. Hinjawadi to Wakad (10 km)");

        int routeChoice = readInt("Choose route: ");

        if (routeChoice == 1) {
            source = "Pune Station";
            destination = "Shivajinagar";
            distanceKm = 5;
        } else if (routeChoice == 2) {
            source = "Swargate";
            destination = "Kothrud";
            distanceKm = 8;
        } else if (routeChoice == 3) {
            source = "Hinjawadi";
            destination = "Wakad";
            distanceKm = 10;
        } else {
            System.out.println("Invalid route choice. Booking cancelled; returning to main menu.");
            return;
        }

        int totalFare = ratePerKm * distanceKm;

        System.out.println("\n===== RIDE DETAILS =====");
        System.out.println("Cab type    : " + cabType);
        System.out.println("Source      : " + source);
        System.out.println("Destination : " + destination);
        System.out.println("Distance    : " + distanceKm + " km");
        System.out.println("Rate        : Rs." + ratePerKm + "/km");
        System.out.println("Total fare  : Rs." + totalFare);

        while (true) {
            System.out.println("\n===== CONFIRM BOOKING =====");
            System.out.println("1. Confirm & Share OTP");
            System.out.println("2. Cancel Ride");

            int confirmation = readInt("Enter your choice: ");

            if (confirmation == 1) {
                int otp = 1000 + random.nextInt(9000);

                System.out.println("\nBooking confirmed!");
                System.out.println("Your 4-digit OTP is: " + otp);
                System.out.println("OTP has been shared with the user.");
                System.out.println("IMPORTANT: Once the OTP is shared, cancellation is not allowed.");
                System.out.println("Have a safe ride!");
                return;
            } else if (confirmation == 2) {
                System.out.println("Ride cancelled successfully. No OTP has been shared.");
                return;
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
               
            }
        }
    }

    
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }

            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); 
        }
    }
}
