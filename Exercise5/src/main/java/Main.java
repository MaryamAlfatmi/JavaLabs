import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static RentalFleet fleet = new RentalFleet();
    static ReadWriteCSV read = new ReadWriteCSV();
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
                    "\n6. Export the rented vehicles data to a CSV file"+
                    "\n7. Exit");
            System.out.println("Please choose an option");
            choice = sc.nextInt();
            switch(choice){
                case 0:
                    printMenu();
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
                    fleet.returnVehicle(sc.nextLine());

                    break;
                case 4 :
                    sc.nextLine();
                    fleet.availableVehicles();
                    break;
                case 5 :
                    sc.nextLine();
                    System.out.println("Enter the license number for the cancellation of car from the fleet");
                    fleet.cancelVehicle(sc.nextLine());
                    break;
                case 6:
                    sc.nextLine();
                    fleet.writeToCsvFile();
                    System.out.println("Data written to CSV file");
                    printMenu();
                    sc.nextLine();

                case 7:
                    sc.nextLine();
                    choice = -1;
                default:
                    sc.nextLine();
                    System.out.println("Invalid option. Please choose correct option.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Choose an option" +
                "\n1. Add Vehicle to the Car Rental fleet" +
                "\n2. Rent the vehicle. "+
                "\n3. Return the vehicle "+
                "\n4. View all the vehicles available for rental"+
                "\n5. Cancel a vehicle from the fleet" +
                "\n6. Export the rented vehicles data to a CSV file"+
                "\n7. Exit");
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
        fleet.availableVehicles();
        String number = sc.nextLine();
        fleet.rentVehicle(name,date,days,number);
        System.out.println("The vehicle has been booked for you for "+days+" days.");
    }
    
}
