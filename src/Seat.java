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
    }
}
