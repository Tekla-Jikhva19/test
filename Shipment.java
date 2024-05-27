class Shipment {
    private String trackingNumber;
    private String origin;
    private String destination;
    private double weight;
    private String description;

    public Shipment(String trackingNumber, String origin, String destination, double weight, String description) {
        this.trackingNumber = trackingNumber;
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
        this.description = description;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }
}