import java.util.InputMismatchException;
import java.util.Scanner;

public class ExecuteSystem {

    public static void main(String[] args) {
        ElevatorSystem elevators = new ElevatorSystem(7);
        elevators.start();

        InputHandler io = new InputHandler(elevators);
        io.start();

        //elevators.testElevatorSystem();
    }
}
