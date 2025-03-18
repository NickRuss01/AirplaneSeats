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
                Enter 1 to view the map of the seats: o = Available, x = unavailable\
                
                Enter 2 to get the information on a specific seat.\
                
                Enter 3 to print available seats sorted by price, low to high.\
                
                Enter 4 to purchase a seat.\
                
                Enter 5 to see this menu again.\
                
                Enter 0 to exit the program.""");
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
        int row;
        do {
            System.out.println("Please enter in the row you would like to sit in:");
            while (!keyboard.hasNextInt()) {
                System.out.println("Invalid input - is not a valid integer. Please enter a row between 0 and 4.");
                keyboard.next();
            }
            row = keyboard.nextInt();
            if (row < 0 || row > x - 1) {
                System.out.println("Invalid input - is not a valid row.");
            }
        } while (row < 0 || row > x - 1);
        keyboard.nextLine();

        int column;
        do {
            System.out.println("Please enter in the column you would like to sit in:");
            while (!keyboard.hasNextInt()) {
                System.out.println("Invalid input - is not a valid integer. Please try again.");
                keyboard.next();
            }
            column = keyboard.nextInt();
            if (column < 0 || column > y - 1) {
                System.out.println("Invalid input - is not a valid column. Please enter a column between 0 and 3");
            }
        } while (column < 0 || column > y - 1);
        keyboard.nextLine();
        System.out.println(AirplaneSeat[row][column].toString());
        seatMenu(AirplaneSeat);
    }

    public static void seatBuy(Seat[][] AirplaneSeat) {
        int row;
        do {
            System.out.println("Please enter in the row you would like to sit in:");
            while (!keyboard.hasNextInt()) {
                System.out.println("Invalid input - is not a valid integer. Please enter a row between 0 and 4.");
                keyboard.next();
            }
            row = keyboard.nextInt();
            if (row < 0 || row > x - 1) {
                System.out.println("Invalid input - is not a valid row.");
            }
        } while (row < 0 || row > x - 1);
        keyboard.nextLine();

        int column;
        do {
            System.out.println("Please enter in the column you would like to sit in:");
            while (!keyboard.hasNextInt()) {
                System.out.println("Invalid input - is not a valid integer. Please try again.");
                keyboard.next();
            }
            column = keyboard.nextInt();
            if (column < 0 || column > y - 1) {
                System.out.println("Invalid input - is not a valid column. Please enter a column between 0 and 3");
            }
        } while (column < 0 || column > y - 1);
        keyboard.nextLine();
        if(!AirplaneSeat[row][column].getOccupied()) {
            System.out.println("You have purchased seat (Row: " + row + ", Column: " + column + ")");
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

    public static void inputValidation() {
        //checks if user is entering appropriate integer value between 0-4 for row, and 0-3 for column
    }

}


