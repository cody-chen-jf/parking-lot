import java.util.List;

public class ParkingManager extends Parker {
    private List<Parker> parkerList;

    public ParkingManager(int id, List<ParkingLot> parkingLots, List<Parker> parkerList) {
        super(id, parkingLots);
        this.parkerList = parkerList;
    }

    @Override
    public int park(Car car) {
        return parkingLots.stream()
                .filter(ParkingLot::hasSpace)
                .findFirst()
                .map(parkingLot -> parkingLot.store(car))
                .orElse(-1);
    }

    public int parkBoy(Car car, int id) {
        if(id != this.getId()){
            return parkerList.stream().filter(parker -> parker.getId() == id).map(parker -> parker.park(car)).findFirst().orElse(-1);
        }else {
            return this.park(car);
        }
    }
}
