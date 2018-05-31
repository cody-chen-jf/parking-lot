import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends Parker {

    public SmartParkingBoy(int id, List<ParkingLot> parkingLots) {
        super(id, parkingLots);
    }

    @Override
    public int park(Car car) {
        return parkingLots.stream()
                .max(Comparator.comparing( ParkingLot::getRemainSpace))
                .map(parkingLot1 -> parkingLot1.store(car))
                .orElse(-1);
    }
}
