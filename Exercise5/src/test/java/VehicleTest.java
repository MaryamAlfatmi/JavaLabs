import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {

    @Test
    public void addVehicle() {
        Vehicle v1 = Vehicle.addVehicle("Hyundai","i10",5,"MH 18 AD 0779");
        assertEquals(v1.getBrand(),"Hyundai");
        assertEquals(v1.getModel(),"i10");
        assertEquals(v1.getLicensePlate(),"MH 18 AD 0779");
        assertEquals(v1.isRented(),false);

    }
}