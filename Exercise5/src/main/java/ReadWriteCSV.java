import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadWriteCSV {
    private static final String FILE_NAME = "src/main/resources/Vehicles.csv";

    public void writeToCsvFile(ArrayList<Vehicle> vehicles) {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_NAME));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("Brand", "Model", "Seats", "LicensePlate"));
        ) {
            for(int i=0;i<vehicles.size();i++) {
                csvPrinter.printRecord(vehicles.get(i).getBrand(),vehicles.get(i).getModel(),vehicles.get(i).getNoOfSeats(),vehicles.get(i).getLicensePlate());
            }
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

