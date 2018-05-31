import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy {
    private final int id;
    private final List<ParkingLot> parkingLots;

    public SmartParkingBoy(int id, List<ParkingLot> parkingLots) {

        this.id = id;
        this.parkingLots = parkingLots;
    }

    public int park(Car car) {
        return parkingLots.stream()
                .max(Comparator.comparing( ParkingLot::getRemainSpace))
                .map(parkingLot1 -> parkingLot1.store(car))
                .orElse(-1);
    }
}
