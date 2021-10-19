public class Request {
    int fromFloor;
    int toFloor;
    String direction;

    public Request(int fromFloor, int toFloor) {
        this.fromFloor = fromFloor;
        this.toFloor = toFloor;
        this.direction = fromFloor < toFloor ? "UP" : "DOWN";
    }

    public int getFromFloor() {
        return fromFloor;
    }

    public int getToFloor() {
        return toFloor;
    }

    public String getDirection() {
        return direction;
    }
}
