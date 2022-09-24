package model;

public class Furniture extends Thing{
	private String typeFurniture;
    private String color;
    private String material;

    public Furniture() {
    }

    public Furniture(String serialNumber, String name, double cost, int manufacturingYear, String typeFurniture,
            String color, String material) {
        super(serialNumber, name, cost, manufacturingYear);
        this.typeFurniture = typeFurniture;
        this.color = color;
        this.material = material;
    }
    
    public String getTypeFurniture() {
        return typeFurniture;
    }

    public void setTypeFurniture(String typeFurniture) {
        this.typeFurniture = typeFurniture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String getDescription() {
    	//Format information should be displayed on the console
    	String desc = String.format("%s%9s%2s%22s%3s%10s$%s%7s%4s%11s%2s%16s%3s%11s%2s",
        "|",super.getSerialNumber(),"|",super.getName(),"|",super.getCost(),"|",super.getManufacturingYear(),
                "|",this.color,"|",this.material,"|",this.typeFurniture,"|");
        String.format("%s%s\n%s%s\n%s%.2f$\n%s%d\n%s%s\n%s%s\n%s%s",
                        "Serial No:",super.getSerialNumber(),"Name:",super.getName(),
                                "Rent cost:",super.getCost(),"Manufacturing year:",super.getManufacturingYear(),
                                "Type furniture:",this.typeFurniture,"Color:",this.color,"Material:",this.material );
        return desc;
    }
}
