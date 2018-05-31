import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParkingManagerTest {
    @Test
    public void should() throws Exception {
        Car car = new Car(1);

        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot firstParkingLot = new ParkingLot(1, 10);
        parkingLots.add(firstParkingLot);

        ParkingLot secondParkingLot = new ParkingLot(1, 10);
        parkingLots.add(secondParkingLot);

        ParkingBoy p1 = new ParkingBoy(1, parkingLots);
        SmartParkingBoy p2 = new SmartParkingBoy(2, parkingLots);
        SuperParkingBoy p3 = new SuperParkingBoy(3, parkingLots);

        List<Parker> parkerList = new ArrayList<>();
        parkerList.add(p1);
        parkerList.add(p2);
        parkerList.add(p3);

        ParkingManager manager = new ParkingManager(100, parkingLots, parkerList);
        int carId = manager.parkBoy(car, p1.getId());

        assertThat(carId).isEqualTo(1);
    }
}
