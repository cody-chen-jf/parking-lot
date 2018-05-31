import java.util.Comparator;
import java.util.List;

public class SuperParkingBoy extends Parker{
    public SuperParkingBoy(int id, List<ParkingLot> parkingLots) {
        super(id, parkingLots);
    }

    @Override
    public int park(Car car) {
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.getRemainSpace() > 0)
                .max(Comparator.comparing( ParkingLot::getVacancyRate))
                .map(parkingLot1 -> parkingLot1.store(car))
                .orElse(-1);
    }
}
