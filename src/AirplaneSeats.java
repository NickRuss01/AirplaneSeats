import java.util.Scanner;
public class AirplaneSeats {
    static final int x = 5;
    static final int y = 4;
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        Seat[][] AirplaneSeat = new Seat[x][y];
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                AirplaneSeat[i][j] = new Seat(i, j);
            }
        }

    }

    public static void seatMenu(Seat[][] AirplaneSeat) {
        System.out.println("Press 1 to view the map of the seats: o = Available, x = unavailable" +
                "\nPress 2 to get the information on a specific seat." +
                "\nPress 3 to print available seats sorted by price, low to high." +
                "\nPress 4 to purchase a seat." +
                "\nPress 5 to see this menu again." +
                "\nPress 0 to exit the program.");
        String selection = keyboard.nextLine();
        switch(selection) {
            case "1":
                seatMap(AirplaneSeat);
                break;
            case "2":
                seatInfo(AirplaneSeat);
                break;
            case "3":
                sort(AirplaneSeat);
                break;
            case "4":
                seatBuy(AirplaneSeat);
                break;
            case "5":
                seatMenu(AirplaneSeat);
                break;
            case "0":
                System.exit(0);
                break;
            default:
        }
    }

    public static void seatMap(Seat[][] AirplaneSeat) {
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (AirplaneSeat[i][j].getOccupied()) {
                    System.out.print("x ");
                } else {
                    System.out.print("o ");
                }
            }
            System.out.println();
        }
        seatMenu(AirplaneSeat);
    }


}


