public class Tester {
    public static void main(String[] args) {
        LogisticsCompany company = new LogisticsCompany("Acme Logistics");

        // Add shipments
        company.addShipment("ABC123", "New York", "Los Angeles", 10.5, "Electronics");
        company.addShipment("DEF456", "Chicago", "San Diego", 5.2, "Books");
        company.addShipment("123456", "Batumi", "Tbilisi", 3, "Clothing");
        company.addShipment("6373", "Kutaisi", "Batumi", 6.8, "Toys");

        // Save state
        company.saveState();

        // Restore state
        company.restoreState();

        // List shipments
        System.out.println("Shipments after restoring state:");
        for (Shipment shipment : company.getShipments()) {
            System.out.println("Tracking Number: " + shipment.getTrackingNumber());
            System.out.println("Origin: " + shipment.getOrigin());
            System.out.println("Destination: " + shipment.getDestination());
            System.out.println("Weight: " + shipment.getWeight());
            System.out.println("Description: " + shipment.getDescription());
            System.out.println("-------------------");
        }
    }
}