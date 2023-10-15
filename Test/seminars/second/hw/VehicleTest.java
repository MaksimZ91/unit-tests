package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Car car;
    Motorcycle moto;

    @BeforeEach
    void setUp(){
         car = new Car("Dodge", "Ram", 2010);
         moto = new Motorcycle("Honda", "СBR650R", 2020);
    }

    @Test
    public void testCarIsInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    @Test
    public void testCarWheel(){
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    public void testMotorcycleWheel(){
        assertThat(moto.getNumWheels()).isEqualTo(2);
    }

    @Test
    public void testCarSpeed(){
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    public void tesMotorcycleSpeed(){
        moto.testDrive();
        assertThat(moto.getSpeed()).isEqualTo(75);
    }

    @Test
    public void testCarParking(){
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    public void testMotorcycleParking(){
        moto.testDrive();
        moto.park();
        assertThat(moto.getSpeed()).isEqualTo(0);
    }

}