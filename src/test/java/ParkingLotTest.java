import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParkingLotTest {
    @Test
    public void should_return_true_when_parking_given_1() throws Exception {
        Car car = new Car(1);

        List<ParkingLot> parkingLots = new ArrayList<>();

        ParkingLot firstParkingLot = new ParkingLot(1, 10);
        parkingLots.add(firstParkingLot);

        ParkingLot secondParkingLot = new ParkingLot(1, 10);
        parkingLots.add(secondParkingLot);

        ParkingBoy boy = new ParkingBoy(1, parkingLots);
        int carId = boy.park(car);

        assertThat(carId).isEqualTo(1);
        assertThat(firstParkingLot.hasCar(carId)).isTrue();
    }

    @Test
    public void should_return_true_when_parking_second_parkingLot() throws Exception {
        Car car = new Car(2);

        List<ParkingLot> parkingLots = new ArrayList<>();

        ParkingLot firstParkingLot = new ParkingLot(1, 0);
        parkingLots.add(firstParkingLot);

        ParkingLot secondParkingLot = new ParkingLot(1, 10);
        parkingLots.add(secondParkingLot);

        ParkingBoy boy = new ParkingBoy(1, parkingLots);
        int carId = boy.park(car);

        assertThat(carId).isEqualTo(2);
        assertThat(firstParkingLot.hasCar(carId)).isFalse();
        assertThat(secondParkingLot.hasCar(carId)).isTrue();
    }

    @Test
    public void should_return_false_when_out_of_first_parkingLot() throws Exception {
        Car car1 = new Car(1);
        Car car2 = new Car(2);

        List<ParkingLot> parkingLots = new ArrayList<>();

        ParkingLot firstParkingLot = new ParkingLot(1, 1);
        parkingLots.add(firstParkingLot);

        ParkingBoy boy = new ParkingBoy(1, parkingLots);
        int carId = boy.park(car1);

        int carId2 = boy.park(car2);

        assertThat(carId).isEqualTo(1);
        assertThat(carId2).isEqualTo(-1);
    }


}
