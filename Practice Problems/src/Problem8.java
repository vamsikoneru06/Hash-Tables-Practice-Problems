public class Problem8 {
    enum Status { EMPTY, OCCUPIED, DELETED }

    class Spot {
        String licensePlate;
        Status status = Status.EMPTY;
    }

    private Spot[] spots = new Spot[500];

    public int parkVehicle(String licensePlate) {
        int hash = Math.abs(licensePlate.hashCode() % spots.length);
        for (int i = 0; i < spots.length; i++) {
            int index = (hash + i) % spots.length;
            if (spots[index] == null || spots[index].status != Status.OCCUPIED) {
                spots[index] = new Spot();
                spots[index].licensePlate = licensePlate;
                spots[index].status = Status.OCCUPIED;
                return index;
            }
        }
        return -1;
    }

    public void exitVehicle(String licensePlate) {
        int hash = Math.abs(licensePlate.hashCode() % spots.length);
        for (int i = 0; i < spots.length; i++) {
            int index = (hash + i) % spots.length;
            if (spots[index] != null && licensePlate.equals(spots[index].licensePlate)) {
                spots[index].status = Status.DELETED;
                return;
            }
        }
    }
}