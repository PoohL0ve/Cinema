package cinema;
import java.util.*;

public class Cinema {

    public static void main(String[] args) {

        //int total = 0;
        // Scanner object to obtain data
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the number of seats in each row:");
        int columns = scanner.nextInt();
        scanner.nextLine();

        // conditional statement to print seats
        if ((rows > 0 && rows <= 9) && (columns > 0 && columns <= 9)) {
            displaySeats(rows, columns);
        }
        System.out.println(); // for space
        System.out.println("Enter a row number:");
        int rowNum = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter a seat number in that row: ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine();

        if (rowNum <= rows && seatNumber <= columns) {
            ticketPrice(rows, columns, rowNum);
        }
        System.out.println(); // space
        printPurchasedSeat(rows, columns, rowNum, seatNumber);


    }
    // method to display seats
    public static void displaySeats(int row, int col) {
        // character 'S' to represent seats
        char chair = 'S';
        int[] numOfSeats = new int[col];
        int[][] seats  = new int[row][col];

        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= numOfSeats.length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int j = 1; j <= seats.length; j++) {
            System.out.print(j + " ");
            for (int l = 0; l < numOfSeats.length; l++) {
                System.out.print(chair + " ");
            }
            System.out.println();
        }
    }
    public static void ticketPrice(int lanes, int seats, int choose) {
        int total = 0;

        // conditional to obtain the correct output
        if (lanes * seats <= 60) {
            total += 10;
            System.out.println("Ticket price: $" + total);
        } else if (lanes * seats > 60) {
            int front = lanes / 2;
            int back = lanes - front;
            int frontSeats = front * seats;
            int backSeats = back * seats;
            if (choose * seats <= frontSeats) {
                total +=  10;
                System.out.println("Ticket price: $" + total);
            } else if (choose * seats > frontSeats) {
                total += 8;
                System.out.println("Ticket price: $" + total);
            }
        }
    }
    // method to display purchased seat
    public static void printPurchasedSeat(int row, int col, int lane, int seat){
        char chosen = 'S';
        int[][] cinemaSeats = new int[row][col];
        int[] chairs = new int[col];

        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= chairs.length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int j = 1; j <= cinemaSeats.length; j++) {
            System.out.print(j + " ");
            for (int l = 0; l < chairs.length; l++) {
                if (j == lane && l  == seat - 1) {
                    chosen = 'B';
                } else {
                    chosen = 'S';
                }
                System.out.print(chosen + " ");
            }
            System.out.println();
        }
    }
}