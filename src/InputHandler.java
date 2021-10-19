import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Handles incoming request and adds them to queue
 */
public class InputHandler extends Thread{
    private final ElevatorSystem elevators;

    public InputHandler(ElevatorSystem elevators){
        this.elevators = elevators;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            try {
                System.out.println("Enter current floor: ");
                int currFloor = scanner.nextInt();

                System.out.println("Enter destination floor: ");
                int destFloor = scanner.nextInt();

                if (currFloor < 0 || currFloor > 55 || destFloor < 0 || destFloor > 55){
                    throw new IllegalArgumentException();
                }

                elevators.addRequest(new Request(currFloor, destFloor));
            } catch (InputMismatchException | IllegalArgumentException e){
                System.err.println("Input must be an integer between 0 and 55");

                scanner.nextLine(); // to clear buffer of input stream, otherwise endless loop of thrown exceptions
            }
        }
    }
}
