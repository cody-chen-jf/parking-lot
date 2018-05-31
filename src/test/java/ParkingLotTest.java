import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParkingLotTest {
    @Test
    public void should_return_true_when_parking_in_the_first_parking_lot() throws Exception {
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
    public void should_park_in_second_parkingLot_when_first_parkingLot_is_full() throws Exception {
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

    @Test
    public void should_parking_in_parking_lot_with_more_space() throws Exception {
        Car car = new Car(1);

        List<ParkingLot> parkingLots = new ArrayList<>();

        ParkingLot firstParkingLot = new ParkingLot(1, 5);
        parkingLots.add(firstParkingLot);

        ParkingLot secondParkingLot = new ParkingLot(1, 10);
        parkingLots.add(secondParkingLot);

        SmartParkingBoy boy = new SmartParkingBoy(1, parkingLots);
        int carId = boy.park(car);

        assertThat(firstParkingLot.hasCar(carId)).isFalse();
        assertThat(secondParkingLot.hasCar(carId)).isTrue();
    }

    @Test
    public void should_take_from_first_parking_lot_when_taken_car() throws Exception {
        Car car = new Car(1);

        List<ParkingLot> parkingLots = new ArrayList<>();

        ParkingLot firstParkingLot = new ParkingLot(1, 5);
        parkingLots.add(firstParkingLot);

        ParkingLot secondParkingLot = new ParkingLot(1, 15);
        parkingLots.add(secondParkingLot);

        SmartParkingBoy boy = new SmartParkingBoy(1, parkingLots);
        int carId = boy.park(car);

        assertThat(firstParkingLot.hasCar(carId)).isFalse();
        assertThat(secondParkingLot.hasCar(carId)).isTrue();

        int takenCarId = boy.take(carId);

        assertThat(firstParkingLot.hasCar(takenCarId)).isFalse();
        assertThat(secondParkingLot.hasCar(takenCarId)).isFalse();
    }

    @Test
    public void should_parking_in_high_vacancy_rate_parking_lot() throws Exception {
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(3);

        List<ParkingLot> parkingLots = new ArrayList<>();

        ParkingLot firstParkingLot = new ParkingLot(1, 2);
        firstParkingLot.store(car1);
        parkingLots.add(firstParkingLot);

        ParkingLot secondParkingLot = new ParkingLot(1, 3);
        secondParkingLot.store(car2);
        parkingLots.add(secondParkingLot);

        SuperParkingBoy boy = new SuperParkingBoy(1, parkingLots);
        int carId = boy.park(car3);

        assertThat(firstParkingLot.hasCar(carId)).isFalse();
        assertThat(secondParkingLot.hasCar(carId)).isTrue();
    }

}
