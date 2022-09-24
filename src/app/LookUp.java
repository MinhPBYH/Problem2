package app;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.BookOnTape;
import model.Video;
import model.Furniture;
import helper.IOFile;
import database.Dao;

public class LookUp { 
    static Scanner sc = new Scanner(System.in);
    static Pattern patternVideoSerial = Pattern.compile("^[V][D][O]{1}[0-9]{4}$");// format VDOxxxx
    static Pattern patternBookSerial = Pattern.compile("^[B][O][T]{1}[0-9]{4}$");// format BOTxxxx
    static Pattern patternFurnitureSerial = Pattern.compile("^[F][U][R]{1}[0-9]{4}$");// format FURxxxx
    static Matcher matcher;
    static String tempSerial;
    
    //function for the user to input data for Video
    public static void enterDataVideo(Video video){
        // the loop checks the format of serial number  
    	do {
            System.out.print("Serial number(request format is \"VDOxxxx\"):");
            
            tempSerial = sc.nextLine();
            matcher = patternVideoSerial.matcher(tempSerial);
        } while (!matcher.find());
        
        video.setSerialNumber(tempSerial);
        System.out.print("Video title:");
        video.setName(sc.nextLine());
        System.out.print("Rent cost:");
        video.setCost(sc.nextDouble());
        System.out.print("Manufacturing year:");
        video.setManufacturingYear(sc.nextInt());sc.nextLine();
        System.out.print("Language:");
        video.setLanguage(sc.nextLine());
        System.out.print("Video duration:");
        video.setDuration(sc.nextInt());sc.nextLine();
        System.out.print("Type of video:");
        video.setTypeVideo(sc.nextLine());
    }

  //function for the user to input data for Book
    public static void enterDataBook(BookOnTape book){
    	// the loop checks the format of serial number  
    	do {
            System.out.print("Serial number(request format is \"BOTxxxx\"):");
            
            tempSerial = sc.nextLine();
            matcher = patternBookSerial.matcher(tempSerial);
        } while (!matcher.find());
        
        book.setSerialNumber(tempSerial);
        System.out.print("Book title:");
        book.setName(sc.nextLine());
        System.out.print("Rent cost:");
        book.setCost(sc.nextDouble());
        System.out.print("Manufacturing year:");
        book.setManufacturingYear(sc.nextInt());sc.nextLine();
        System.out.print("Language:");
        book.setLanguage(sc.nextLine());
        System.out.print("Author:");
        book.setAuthor(sc.nextLine());
        System.out.print("Number of pages:");
        book.setNumberPages(sc.nextInt());sc.nextLine();
        System.out.print("Type of book:");
        book.setTypeBook(sc.nextLine());
    }

    //function for the user to input data for Furniture
    public static void enterDataFurniture(Furniture furniture){
    	// the loop checks the format of serial number
    	do {
            System.out.print("Serial number(request format is \"FURxxxx\"):");
            
            tempSerial = sc.nextLine();
            matcher = patternFurnitureSerial.matcher(tempSerial);
        } while (!matcher.find());
        
        furniture.setSerialNumber(tempSerial);
        System.out.print("Furniture name:");
        furniture.setName(sc.nextLine());
        System.out.print("Rent cost:");
        furniture.setCost(sc.nextDouble());
        System.out.print("Manufacturing year:");
        furniture.setManufacturingYear(sc.nextInt());sc.nextLine();
        System.out.print("Color:");
        furniture.setColor(sc.nextLine());
        System.out.print("Material:");
        furniture.setMaterial(sc.nextLine());
        System.out.print("Type of furniture:");
        furniture.setTypeFurniture(sc.nextLine());
    }

    //show Fields of table Videos on the console
    static void showFieldsVideoTable(){
        System.out.println("+----------+-----------------------------------------+-----------+------------------+------------+----------+------------+");
        System.out.println(String.format("%s%s%2s%23s%19s%10s%2s%s%s%11s%2s%9s%2s%8s%5s", 
            "|","Serial No","|","Title","|","Rent cost","|","Manufacturing year","|",
                    "Language","|","Duration","|","Type","|"));
        System.out.println("+----------+-----------------------------------------+-----------+------------------+------------+----------+------------+");
    }

    //show Fields of table Books on the console
    static void showFieldsBookTable(){
        System.out.println("+----------+---------------------------------+-----------+----------+------------+------------------+---------------+------------+");
        System.out.println(String.format("%s%s%2s%19s%15s%10s%2s%s%s%10s%3s%12s%7s%s%s%8s%5s", 
            "|","Serial No","|","Title","|","Rent cost","|","Manu. year","|",
                    "Language","|","Author","|","Number of pages","|","Type","|"));
        System.out.println("+----------+---------------------------------+-----------+----------+------------+------------------+---------------+------------+");
    }

    //show Fields of table Furnitures on the console
    static void showFieldsFurnitureTable(){
        System.out.println("+----------+------------------------+-----------+----------+------------+------------------+------------+");
        System.out.println(String.format("%s%s%2s%15s%10s%10s%2s%s%s%9s%4s%12s%7s%8s%5s", 
            "|","Serial No","|","Name","|","Rent cost","|","Manu. year","|",
                    "Color","|","Material","|","Type","|"));
        System.out.println("+----------+------------------------+-----------+----------+------------+------------------+------------+");
    }

    //find video by serial number in Video List
    static Video findVideoBySerial(ArrayList<Video> videos,String serialNumber){
        for (Video video : videos) {
            if(video.getSerialNumber().equals(serialNumber)){
                return video;
            }
        }

        return null;
    }

  //find book by serial number in Book List
    static BookOnTape findBookBySerial(ArrayList<BookOnTape> books,String serialNumber){
        for (BookOnTape book : books) {
            if(book.getSerialNumber().equals(serialNumber)){
                return book;
            }
        }
        
        return null;
    }

    //find furniture by serial number in furniture List
    static Furniture findFurnitureBySerial(ArrayList<Furniture> furnitures,String serialNumber){
        for (Furniture fur : furnitures) {
            if(fur.getSerialNumber().equals(serialNumber)){
                return fur;
            }
        }
        
        return null;
    }

    public static void main(String[] args){
        int choice;
        int numberVideos = 0;
        int numberBooks = 0;
        int numberFurnitures = 0;
        boolean flagLoop = true;
        Dao dao = new Dao();
        ArrayList<Video> videos = new ArrayList<>();
        
        //check file "Video.dat" already exists, if it exists, read the data from "Videos.dat"
        //and save to videos
        /*if(IOFile.readVideo() != null)
            videos = IOFile.readVideo();*/
        
        //read data from database, if there is data, save it to videos
        if(dao.getVideoList() != null)
            videos = dao.getVideoList();

        ArrayList<BookOnTape> books = new ArrayList<>();
       
        //check file "Book.dat" already exists, if it exists, read the data from "Books.dat"
        //and save to books
        /*if(IOFile.readBook() != null)
            books = IOFile.readBook();*/
        
      //read data from database, if there is data, save it to books
        if(dao.getBookList() != null)
            books = dao.getBookList();

        ArrayList<Furniture> furnitures = new ArrayList<>();
        
        //check file "Furniture.dat" already exists, if it exists, read the data from "Furniture.dat"
        //and save to furnitures
        /*if(IOFile.readFurniture() != null)
            furnitures = IOFile.readFurniture();*/
        
        //read data from database, if there is data, save it to furnitures
        if(dao.getFurnitureList() != null)
            furnitures = dao.getFurnitureList();

        //loop shows a menu of options to the user
        do {
        	System.out.println("-------------------------------------------");
        	System.out.println("Please select an option below:");
            System.out.println("-------------------------------------------");
            System.out.println("1.Enter data for Videos.");
            System.out.println("2.Enter data for Books on tape.");
            System.out.println("3.Enter data for Furnitures.");
            System.out.println("4.Show information of Videos.");
            System.out.println("5.Show information of Books.");
            System.out.println("6.Show information of Furnitures.");
            System.out.println("7.Show information based on serial number.");
            System.out.println("Press other key to exit.");
            System.out.println("-------------------------------------------");
            System.out.print("Press the key corresponding to your selection:");
            
            try {
                choice = sc.nextInt(); sc.nextLine();
            } catch (Exception e) {
            	choice = Integer.MIN_VALUE;
            }
        
            switch(choice){
                case 1:// enter data for videos
                    System.out.println("-------------------------------------------");
                    System.out.print("Enter the number of videos:");

                    numberVideos = sc.nextInt();sc.nextLine();

                    for (int i = 0; i < numberVideos; i++) {
                        Video additionalVideo = new Video();
                        enterDataVideo(additionalVideo);
                        dao.addVideo(additionalVideo);
                        videos.add(additionalVideo);
                    }

                    IOFile.writeVideo(videos);
                    System.out.println("-------------------------------------------");
                    break;
                case 2: // enter data for books
                    System.out.println("-------------------------------------------");
                    System.out.print("Enter the number of Books on tape:");

                    numberBooks = sc.nextInt();sc.nextLine();

                    for (int i = 0; i < numberBooks; i++) {
                        BookOnTape additionalBook = new BookOnTape();
                        enterDataBook(additionalBook);
                        dao.addBook(additionalBook);
                        books.add(additionalBook);
                    }

                    IOFile.writeBook(books);
                    System.out.println("-------------------------------------------");
                    break;
                case 3: // enter data for furniture
                    System.out.println("-------------------------------------------");
                    System.out.print("Enter the number of Furnitures:");

                    numberFurnitures = sc.nextInt();sc.nextLine();

                    for (int i = 0; i < numberFurnitures; i++) {
                        Furniture additionalFurniture = new Furniture();
                        enterDataFurniture(additionalFurniture);
                        dao.addFurniture(additionalFurniture);
                        furnitures.add(additionalFurniture);
                    }
                    
                    IOFile.writeFurniture(furnitures);
                    System.out.println("-------------------------------------------");
                    break;
                case 4:// display information of videos in a table on console
                    System.out.println("-------------------------------------------");
                    System.out.println("\tThe information of Videos:");
                    showFieldsVideoTable();
                    
                    for (Video video : videos) {
                        System.out.println(video.getDescription());
                        System.out.println("+----------+-----------------------------------------+-----------+------------------+------------+----------+------------+");
                    }

                    break;
                case 5:// display information of books on tape in a table on console
                    System.out.println("-------------------------------------------");
                    System.out.println("\tThe information of Books:");
                    showFieldsBookTable();
                    
                    for (BookOnTape book : books) {
                        System.out.println(book.getDescription());
                        System.out.println("+----------+---------------------------------+-----------+----------+------------+------------------+---------------+------------+");
                    }

                    break;
                case 6://display information of furnitures in a table on console
                    System.out.println("-------------------------------------------");
                    System.out.println("\tThe information of Furnitures:");
                    showFieldsFurnitureTable();

                    for (Furniture furniture : furnitures) {
                        System.out.println(furniture.getDescription());
                        System.out.println("+----------+------------------------+-----------+----------+------------+------------------+------------+");
                    }

                    break;
                case 7://Show information based on serial number      
                    System.out.println("-------------------------------------------");    
                    System.out.print("Enter serial number of item that you want to show information:");
                    tempSerial = sc.nextLine();
                    System.out.println("-------------------------------------------"); 
                    
                    if(tempSerial.length() != 7){
                        System.out.println("Invalid serial number format");
                        break;
                    }
    
                    //check entered serial number by the format of three things (Video, Book On Tape, Furniture)
                    if(tempSerial.substring(0, 3).equals("VDO")){
                        Video video = findVideoBySerial(videos, tempSerial);
                        if(video != null){
                            showFieldsVideoTable();
                            System.out.println(video.getDescription());
                            System.out.println("+----------+-----------------------------------------+-----------+------------------+------------+----------+------------+");
                        }else{
                            System.out.println("serial number does not exist");
                        }
                    }else if(tempSerial.substring(0, 3).equals("BOT")){
                        BookOnTape book = findBookBySerial(books, tempSerial);
                        if(book != null){
                            showFieldsBookTable();
                            System.out.println(book.getDescription());
                            System.out.println("+----------+---------------------------------+-----------+----------+------------+------------------+---------------+------------+");
                        }else{
                            System.out.println("serial number does not exist");
                        }
                    }else if(tempSerial.substring(0, 3).equals("FUR")){
                        Furniture fur = findFurnitureBySerial(furnitures, tempSerial);
                        if( fur != null){
                            showFieldsFurnitureTable();
                            System.out.println(fur.getDescription());
                            System.out.println("+----------+------------------------+-----------+----------+------------+------------------+------------+");
                        }else{
                            System.out.println("serial number does not exist");
                        }
                    }else  System.out.println("Invalid serial number format");
                    break;
                default:
                    System.out.println("-------------------------------------------");    
                    System.out.println("Thank you!!!");
                    flagLoop = false;
                    break;
            }
        } while (flagLoop == true);

    }
}
