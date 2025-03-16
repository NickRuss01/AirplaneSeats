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
}
