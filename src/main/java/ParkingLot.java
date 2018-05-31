import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int id;
    private final int size;
    private List<Car> cars = new ArrayList<>();

    public ParkingLot(int id, int size) {
        this.id = id;
        this.size = size;
    }

    public int store(Car car) {
        cars.add(car);
        return car.getId();
    }

    public boolean hasCar(int carId) {
        return cars.stream().anyMatch(car -> car.getId() == carId);
    }

    public boolean hasSpace() {
        return size - cars.size() > 0;
    }

    public int getRemainSpace() {
        return size - cars.size();
    }
}
