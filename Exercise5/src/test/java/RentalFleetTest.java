import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RentalFleetTest {
    Vehicle v1 = Vehicle.addVehicle("Hyundai","i10",5,"MH 18 AD 0779");
    Vehicle v2 = Vehicle.addVehicle("Hyundai","i10",5,"MH 18 AD 1234");
    List<Vehicle> vehicleList = new ArrayList<Vehicle>();
    RentalFleet fleet = new RentalFleet();

    @Test
    public void availableVehicles() {
    }

    @Test
    public void addNewVehicle() {
    }

    @Test
    public void rentVehicle() {
    }

    @Test
    public void returnVehicle() {
        String licensePlate = "MH 18 AD 0779";
        fleet.returnVehicle(licensePlate);


    }

    @Test
    public void cancelVehicle() {
        vehicleList.add(v1);
        vehicleList.add(v2);
        vehicleList.remove(v1);
        int size = vehicleList.size();
        assertEquals(size,1);
    }
}