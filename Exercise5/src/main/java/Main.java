import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static RentalFleet fleet = new RentalFleet();
    public static void main(String[] args){

        int choice =0;
        while(choice != -1){
            System.out.println("-------------------------------------------------");
            System.out.println("Choose an option" +
                    "\n1. Add Vehicle to the Car Rental fleet" +
                    "\n2. Rent the vehicle. "+
                    "\n3. Return the vehicle "+
                    "\n4. View all the vehicles available for rental"+
                    "\n5. Cancel a vehicle from the fleet" +
                    "\n6. Exit");
            System.out.println("Please choose an option");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    sc.nextLine();
                    addVehicle();
                    break;
                case 2:
                    sc.nextLine();
                    rentVehicle();
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter the license number of a vehicle");
                    //String number = sc.nextLine();
                    returnVehicle(sc.nextLine());
                    break;
                case 4 :
                    sc.nextLine();
                    availableVehicles();
                    break;
                case 5 :
                    sc.nextLine();
                    System.out.println("Enter the license number for the cancellation of car from the fleet");
                    cancelVehicle(sc.nextLine());
                    break;
                case 6:
                    sc.nextLine();
                    choice = -1;
                default:
                    sc.nextLine();
                    System.out.println("Invalid option. Please choose correct option.");


            }

        }


    }

    private static void cancelVehicle(String number) {
        fleet.cancelVehicle(number);
    }

    private static void availableVehicles() {
        fleet.availableVehicles();
    }

    private static void returnVehicle(String number) {
        fleet.returnVehicle(number);
    }

    private static void addVehicle() {
        System.out.println("Please enter the Vehicle details");
        System.out.println("Enter the brand");
        String brand = sc.nextLine();
        System.out.println("Enter the model");
        String model = sc.nextLine();
        System.out.println("Enter the number of seats");
        int seats = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the license plate number");
        String number = sc.nextLine();
        Vehicle vehicle = Vehicle.addVehicle(brand,model,seats,number);
        if(fleet.addNewVehicle(vehicle)) {
            System.out.println("New Vehicle added");
        } else {
            System.out.println("Cannot add");
        }


    }

    private static void rentVehicle() {
        System.out.println("Customer name");
        String name = sc.nextLine();
        System.out.println("Start Date");
        String date = sc.nextLine();
        System.out.println("Renting for how many days");
        int days = sc.nextInt();
        sc.nextLine();
        System.out.println("Choose a vehicle from a list of available vehicles. Enter the license plate number");
        availableVehicles();
        String number = sc.nextLine();
        fleet.rentVehicle(name,date,days,number);
        System.out.println("The vehicle has been booked for you for "+days+" days.");



    }
    
}
