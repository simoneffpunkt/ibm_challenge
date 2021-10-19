import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ElevatorSystem extends Thread{
    private final BlockingQueue<Request> requests;
    private final ArrayList<Elevator> elevators;


    public ElevatorSystem(int numberOfElevators) {
        this.requests = new ArrayBlockingQueue<Request>(100);
        this.elevators = new ArrayList<Elevator>();
        for (int i = 0; i < numberOfElevators; i++) {
            Elevator elevator = new Elevator(requests);
            elevators.add(elevator);
        }
    }

    public void run(){
        for (Elevator elevator : elevators){
            elevator.start();
        }
    }

    public void addRequest(Request request){
        requests.add(request);
    }

    // Ich hoffe, der Testing-Part war in etwa so einfach gehalten gemeint, da ich keinen sinnvollen Einsatz von diversen Testing Frameworks sehen würde.
    public void testElevatorSystem(){
        addRequest(new Request(0,55));
        addRequest(new Request(0,35));
        addRequest(new Request(35,0));
        addRequest(new Request(20,40));
        addRequest(new Request(7,45));
        addRequest(new Request(10,35));
        addRequest(new Request(0,50));
        addRequest(new Request(4,45));
        addRequest(new Request(45,4));
        addRequest(new Request(30,2));
        addRequest(new Request(4,45));
        addRequest(new Request(4,45));

        try {
            Thread.sleep(30000);
            System.out.println("-------------- NO REQUEST FOR 30 SECONDS --------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        addRequest(new Request(0,55));
        addRequest(new Request(0,55));
    }





}
