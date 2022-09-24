package model;

public abstract class Thing {
	private String serialNumber;
    private String name;
    private double cost;
    private int manufacturingYear;

    public Thing() {
    }

    public Thing(String serialNumber, String name, double cost, int manufacturingYear) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.cost = cost;
        this.manufacturingYear = manufacturingYear;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public abstract String getDescription();
}
