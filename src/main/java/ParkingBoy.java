import java.util.List;

public class ParkingBoy extends Parker {
    public ParkingBoy(int id, List<ParkingLot> parkingLots) {
        super(id, parkingLots);
    }

    @Override
    public int park(Car car) {
        return parkingLots.stream()
                .filter(ParkingLot::hasSpace)
                .findFirst()
                .map(parkingLot -> parkingLot.store(car))
                .orElse(-1);
    }
}
