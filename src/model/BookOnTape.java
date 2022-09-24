package model;

public class BookOnTape extends Thing{
	private String language;
    private String author;
    private int numberPages;
    private String typeBook;

    public BookOnTape() {
    }

    public BookOnTape(String serialNumber, String name, double cost, int manufacturingYear, String language,
            String author, int numberPages, String typeBook) {
        super(serialNumber, name, cost, manufacturingYear);
        this.language = language;
        this.author = author;
        this.numberPages = numberPages;
        this.typeBook = typeBook;
    }
    
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public String getTypeBook() {
        return typeBook;
    }

    public void setTypeBook(String typeBook) {
        this.typeBook = typeBook;
    }

    @Override
    public String getDescription() {
    	//Format information should be displayed on the console
    	String desc = String.format("%s%9s%2s%31s%3s%9s$%2s%7s%4s%11s%2s%16s%3s%10d%6s%11s%2s",
                "|",super.getSerialNumber(),"|",super.getName(),"|",super.getCost(),"|",super.getManufacturingYear(),
                "|",this.language,"|",this.author,"|",this.numberPages,"|",this.typeBook,"|");
        return desc;
    }
}
