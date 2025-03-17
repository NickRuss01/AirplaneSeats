import java.util.Random;
public class Seat {
    private int row;
    private int seat;
    private boolean aisle;
    private boolean window;
    private boolean occupied;
    private int cost;
    private static int revenue = 0;

    public Seat() {
        row = 0;
        seat = 0;
        aisle = false;
        window = false;
        occupied = false;
        cost = 0;
    }

    public Seat(int rowPassed, int seatPassed) {
        Random rng = new Random();
        row = rowPassed;
        seat = seatPassed;
        aisle = seatPassed == 1 || seatPassed == 2;

        window = seatPassed == 0 || seatPassed == 3;

        occupied = false;
        cost = rng.nextInt(301) + 200;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public boolean getAisle() {
        return aisle;
    }

    public boolean getWindow() {
        return window;
    }

    public boolean getOccupied() {
        return occupied;
    }

    public int getCost() {
        return cost;
    }

    public static int getRevenue() {
        return revenue;
    }



    public void setRow(int rowPassed) {
        row = rowPassed;
    }

    public void setSeat(int seatPassed) {
        seat = seatPassed;
    }

    public void setAisle(boolean aislePassed) {
        aisle = aislePassed;
    }

    public void setWindow(boolean windowPassed) {
        window = windowPassed;
    }

    public void setOccupied(boolean occupiedPassed) {
        if (occupiedPassed && !occupied) {
            occupied = occupiedPassed;
            revenue = revenue + cost;
        }
        else if (!occupiedPassed && occupied) {
            occupied = occupiedPassed;
            revenue = revenue - cost;
        }
    }

    public void setCost(int costPassed) {
        cost = costPassed;
    }

    public String toString() {
        return
                "Row: " + row + "\n" +
                        "Seat: " + seat + "\n" +
                        "Aisle: " + aisle + "\n" +
                        "Window: " + window + "\n" +
                        "Occupied: " + occupied + "\n" +
                        "Cost: " + cost + "\n";

    }

}
