import java.util.List;

public class ParkingBoy {
    private final int id;
    private final List<ParkingLot> parkingLots;

    public ParkingBoy(int id, List<ParkingLot> parkingLots) {
        this.id = id;
        this.parkingLots = parkingLots;
    }

    public int park(Car car) {
        for (ParkingLot parkingLot: parkingLots){
            if(parkingLot.hasSpace()){
                return parkingLot.store(car);
            }
        }
        return -1;
    }
}
