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
        seatMenu(AirplaneSeat);
    }

    public static void seatMenu(Seat[][] AirplaneSeat) {
        System.out.println("""
                Press 1 to view the map of the seats: o = Available, x = unavailable\
                
                Press 2 to get the information on a specific seat.\
                
                Press 3 to print available seats sorted by price, low to high.\
                
                Press 4 to purchase a seat.\
                
                Press 5 to see this menu again.\
                
                Press 0 to exit the program.""");
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

    public static void seatInfo(Seat[][] AirplaneSeat) {
        System.out.println("Please enter in the row you would like to sit in:");
        int row = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Please enter in the column you would like to sit in:");
        int column = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println(AirplaneSeat[row][column].toString());
        seatMenu(AirplaneSeat);

    }

    public static void seatBuy(Seat[][] AirplaneSeat) {
        System.out.println("Please enter the row you would like to sit in:");
        int row = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Please enter in the column you would like to sit in:");
        int column = keyboard.nextInt();
        keyboard.nextLine();
        if(!AirplaneSeat[row][column].getOccupied()) {
            System.out.println("You have purchased seat " + row + " " + column);
            AirplaneSeat[row][column].setOccupied(true);
        }
        else{
            System.out.println("This seat is already occupied. You may not purchase it.");
        }
        seatMenu(AirplaneSeat);
    }

    public static void sort(Seat[][] AirplaneSeat) {
        Seat[] sortingArray = new Seat[x * y];
        int counter = 0;
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                sortingArray[counter] = AirplaneSeat[i][j];
                ++counter;
            }
        }
        int n = sortingArray.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (sortingArray[j].getCost() > sortingArray[j + 1].getCost()) {
                    Seat temp = sortingArray[j];
                    sortingArray[j] = sortingArray[j + 1];
                    sortingArray[j + 1] = temp;
                }
            }
        }
        for (Seat seat : sortingArray) {
            System.out.println(seat.toString());
        }
        seatMenu(AirplaneSeat);
    }
}


