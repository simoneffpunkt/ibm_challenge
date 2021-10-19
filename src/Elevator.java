import java.util.concurrent.BlockingQueue;

public class Elevator extends Thread{
    private static int amount = 0;
    private int id;
    private int currFloor = 0;
    private final BlockingQueue<Request> requests;

    public Elevator(BlockingQueue<Request> requests){
        this.requests = requests;
        this.id = amount++;
    }


    @Override
    public void run(){
        while(true){
            try {
                System.out.println("Elevator " + id + " ready!");
                Request request = requests.take();

                // Go to passenger
                String direction = this.currFloor < request.getFromFloor() ? "UP" : "DOWN";
                moveElevator(this.currFloor, request.getFromFloor(), direction);

                Thread.sleep(3000);

                // Lift passenger
                direction = request.getDirection();
                moveElevator(this.currFloor, request.getToFloor(), direction);




            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Simulates elevator movement
     */
    private void moveElevator(int fromFloor, int toFloor, String direction) throws InterruptedException{
        int amountFloors = Math.abs(fromFloor - toFloor);

        for (int i = 0; i < amountFloors; i++) {
            Thread.sleep(500);
            if (direction.equals("UP")) {
                currFloor++;
            } else {
                currFloor--;
            }

            System.out.println("Elevator " + this.id + " on floor " + this.currFloor);
        }
    }
}
