import java.util.ArrayList;
import java.util.Date;

public class RentalFleet {
    private String customerName;
    private Date startDate;
    private int noOfDays;
    private ArrayList<Vehicle> vehicles;

    public RentalFleet(String customerName, Date startDate, int noOfDays) {
        this.customerName = customerName;
        this.startDate = startDate;
        this.noOfDays = noOfDays;
    }

    public RentalFleet() {
        this.vehicles = new ArrayList<Vehicle>();
    }

    public void availableVehicles() {
        System.out.println("Available vehicles");
        for(int i=0;i< vehicles.size();i++){
            if(!vehicles.get(i).isRented()) {
                System.out.println(i + 1 + "." + this.vehicles.get(i).getBrand() +
                        "->" + this.vehicles.get(i).getModel() +
                        "->" + this.vehicles.get(i).getLicensePlate());
            }
        }

    }


    public boolean addNewVehicle(Vehicle vehicle) {

            if(findVehicle(vehicle.getLicensePlate()) >=0) {
                System.out.println("Vehicle is already on file");
                return false;
            }

            vehicles.add(vehicle);
            return true;

    }
    private int findVehicle(String number) {
        for(int i=0; i<this.vehicles.size(); i++) {
            Vehicle vehicle = this.vehicles.get(i);
            if(vehicle.getLicensePlate().equals(number)) {
                return i;
            }
        }
        return -1;
    }

    public void rentVehicle(String name, String date, int days, String number) {
        for(Vehicle v:vehicles){
            if(v.getLicensePlate().equals(number)){
                v.setRented(true);
            }
        }
    }

    public void returnVehicle(String number) {
        for(Vehicle v:vehicles){
            if(v.getLicensePlate().equals(number)){
                v.setRented(false);
            }
        }
    }

    public void cancelVehicle(String number) {
      int index = findVehicle(number);
      vehicles.remove(index);

    }


    public void writeToCsvFile() {
        ReadWriteCSV write = new ReadWriteCSV();
        write.writeToCsvFile(vehicles);
    }
}
