import java.util.List;

public abstract class Parker {
    protected final int id;
    protected final List<ParkingLot> parkingLots;

    public Parker(int id, List<ParkingLot> parkingLots) {
        this.id = id;
        this.parkingLots = parkingLots;
    }

    public abstract int park(Car car);

    public int take(int carId){
        return parkingLots.stream().filter(parkingLot -> parkingLot.hasCar(carId)).findFirst().get().remove(carId);
    }
}
