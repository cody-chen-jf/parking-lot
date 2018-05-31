import java.util.List;

public abstract class Parker {
    protected int id;
    protected List<ParkingLot> parkingLots;

    public int getId() {
        return id;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public Parker(int id, List<ParkingLot> parkingLots) {
        this.id = id;
        this.parkingLots = parkingLots;
    }

    public abstract int park(Car car);

    public int take(int carId){
        return parkingLots.stream().filter(parkingLot -> parkingLot.hasCar(carId)).map(m -> m.remove(carId)).findFirst().orElse(-1);
    }
}
