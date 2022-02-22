public class Vehicle {
    private String id;
    private String brand;
    private String model;
    private int noOfSeats;
    private String licensePlate;
    private boolean isRented;


    public Vehicle(String brand, String model, int noOfSeats, String licensePlate) {
        this.brand = brand;
        this.model = model;
        this.noOfSeats = noOfSeats;
        this.licensePlate = licensePlate;
        this.isRented = false;
    }

    public Vehicle(){

    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public static Vehicle addVehicle(String brand, String model, int seats, String licensePlate){
        return new Vehicle(brand,model,seats,licensePlate);
    }

}
