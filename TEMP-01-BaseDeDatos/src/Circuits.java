public class Circuits {
    private int circuitId;
    private String circuitRef;
    private String name;
    private String location;
    private String country;
    
    public Circuits(int circuitId, String circuitRef, String name, String location, String country) {
        this.circuitId = circuitId;
        this.circuitRef = circuitRef;
        this.name = name;
        this.location = location;
        this.country = country;
    }

    public int getCircuitId() {
        return circuitId;
    }

    public void setCircuitId(int circuitId) {
        this.circuitId = circuitId;
    }

    public String getCircuitRef() {
        return circuitRef;
    }

    public void setCircuitRef(String circuitRef) {
        this.circuitRef = circuitRef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
