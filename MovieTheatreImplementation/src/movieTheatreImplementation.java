import java.util.Scanner;

public class movieTheatreImplementation {
    static boolean[][] seats = new boolean[5][5];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n1. Reserve Seat \n2. Cancel Seat \n3. View Seats \n0. Exit");
            System.out.println("Enter a number: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("You chose to reserve a seat.");
                    reserveSeat(scanner);
                    break;
                case 2:
                    System.out.println("You chose to cancel a seat.");
                    cancelSeat(scanner);
                    break;
                case 3:
                    System.out.println("Displaying seats...");
                    viewSeats();
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);

        scanner.close();
    }

    public static void reserveSeat(Scanner scanner) {
        System.out.println("Enter row (1–5): ");
        int row = scanner.nextInt() - 1;

        System.out.println("Enter seat number (1–5): ");
        int col = scanner.nextInt() - 1;

        if (row < 0 || row >= 5 || col < 0 || col >= 5) {
            System.out.println("Invalid seat position.");
            return;
        }

        if (seats[row][col]) {
            System.out.println("Seat is already taken.");
            suggestSeat();
        } else {
            seats[row][col] = true;
            System.out.println("Seat reserved at Row " + (row + 1) + ", Seat " + (col + 1));
        }
    }

    public static void suggestSeat() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (!seats[i][j]) {
                    System.out.println("Try Row " + (i + 1) + ", Seat " + (j + 1));
                    return;
                }
            }
        }
        System.out.println("No seats available.");
    }

    public static void cancelSeat(Scanner scanner) {
        System.out.println("Enter row to cancel (1–5): ");
        int row = scanner.nextInt() - 1;

        System.out.print("Enter seat number to cancel (1–5): ");
        int col = scanner.nextInt() - 1;

        if (row < 0 || row >= 5 || col < 0 || col >= 5) {
            System.out.println("Invalid seat position.");
            return;
        }

        if (seats[row][col]) {
            seats[row][col] = false;
            System.out.println("Reservation cancelled at Row " + (row + 1) + ", Seat " + (col + 1));
        } else {
            System.out.println("That seat wasn't reserved.");
        }
    }

    public static void viewSeats() {
        System.out.println("\nSeating Chart (5x5):\n");

        // Print column headers
        System.out.print("      ");
        for (int col = 1; col <= 5; col++) {
            System.out.printf("%-3d", col);
        }
        System.out.println();

        // Print rows with seat availability
        for (int row = 0; row < 5; row++) {
            System.out.printf("Row %-2d", (row + 1));
            for (int col = 0; col < 5; col++) {
                char displayChar = seats[row][col] ? 'X' : 'A';
                System.out.printf("%-3s", displayChar);
            }
            System.out.println();
        }
    }
}