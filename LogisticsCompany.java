import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class LogisticsCompany {
    private String name;
    private List<Shipment> shipments;

    public LogisticsCompany(String name) {
        this.name = name;
        this.shipments = new ArrayList<>();
    }

    public void addShipment(String trackingNumber, String origin, String destination, double weight, String description) {
        Shipment shipment = new Shipment(trackingNumber, origin, destination, weight, description);
        shipments.add(shipment);
    }

    public void removeShipment(Shipment shipment) {
        shipments.remove(shipment);
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    public void saveState() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("state.csv"))) {
            for (Shipment shipment : shipments) {
                writer.write(shipment.getTrackingNumber() + "," +
                        shipment.getOrigin() + "," +
                        shipment.getDestination() + "," +
                        shipment.getWeight() + "," +
                        shipment.getDescription() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void restoreState() {
        try (BufferedReader reader = new BufferedReader(new FileReader("state.csv"))) {
            String line;
            shipments.clear(); // Clear the existing shipments list
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String trackingNumber = parts[0];
                    String origin = parts[1];
                    String destination = parts[2];
                    double weight = Double.parseDouble(parts[3]);
                    String description = parts[4];
                    addShipment(trackingNumber, origin, destination, weight, description);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}