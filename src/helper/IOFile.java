package helper;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class IOFile {
	//write information of videos to file "Video.dat"
	public static void writeVideo(ArrayList<Video> videos){
        try (PrintWriter pw = new PrintWriter(new File("Video.dat"))) {
            for (Video video : videos) {
                pw.println(video.getSerialNumber());
                pw.println(video.getName());
                pw.println(video.getCost());
                pw.println(video.getManufacturingYear());
                pw.println(video.getLanguage());
                pw.println(video.getDuration());
                pw.println(video.getTypeVideo());
            }
        } catch (Exception e) {
            System.out.println("got an exception!");
        }
    }

	//write information of books to file "Book.dat"
    public static void writeBook(ArrayList<BookOnTape> books){
        try (PrintWriter pw = new PrintWriter(new File("Book.dat"))) {
            for (BookOnTape book : books) {
                pw.println(book.getSerialNumber());
                pw.println(book.getName());
                pw.println(book.getCost());
                pw.println(book.getManufacturingYear());
                pw.println(book.getLanguage());
                pw.println(book.getAuthor());
                pw.println(book.getNumberPages());
                pw.println(book.getTypeBook());
            }
        } catch (Exception e) {
            System.out.println("got an exception!");
        }
    }

  //write information of furnitures to file "Furniture.dat"
    public static void writeFurniture(ArrayList<Furniture> furnitures){
        try (PrintWriter pw = new PrintWriter(new File("Furniture.dat"))) {
            for (Furniture furniture : furnitures) {
                pw.println(furniture.getSerialNumber());
                pw.println(furniture.getName());
                pw.println(furniture.getCost());
                pw.println(furniture.getManufacturingYear());
                pw.println(furniture.getColor());
                pw.println(furniture.getMaterial());
                pw.println(furniture.getTypeFurniture());
            }
        } catch (Exception e) {
            System.out.println("got an exception!");
        }
    }

    //read file"Video.dat" and return ArrayList videos. 
    public static ArrayList readVideo(){
        ArrayList<Video> videos = new ArrayList<>();
        File file = new File("Video.dat");
        //If the file does not exist, return null
        if(!file.exists())
            return null;

        try (Scanner sc = new Scanner(file)) {
            while(sc.hasNext()){
                Video video = new Video();

                video.setSerialNumber(sc.nextLine());
                video.setName(sc.nextLine());
                video.setCost(Double.parseDouble(sc.nextLine()));
                video.setManufacturingYear(Integer.parseInt(sc.nextLine()));
                video.setLanguage(sc.nextLine());
                video.setDuration(Integer.parseInt(sc.nextLine()));
                video.setTypeVideo(sc.nextLine());

                videos.add(video);
            }
        } catch (Exception e) {
            System.out.println("got an exception!");
        }

        return videos;
    }
    
    public static ArrayList readBook(){
        ArrayList<BookOnTape> books = new ArrayList<>();
        File file = new File("Book.dat");
        if(!file.exists())
            return null;

        try (Scanner sc = new Scanner(file)) {
            while(sc.hasNext()){
                BookOnTape book = new BookOnTape();

                book.setSerialNumber(sc.nextLine());
                book.setName(sc.nextLine());
                book.setCost(Double.parseDouble(sc.nextLine()));
                book.setManufacturingYear(Integer.parseInt(sc.nextLine()));
                book.setLanguage(sc.nextLine());
                book.setAuthor(sc.nextLine());
                book.setNumberPages(Integer.parseInt(sc.nextLine()));
                book.setTypeBook(sc.nextLine());

                books.add(book);
            }
        } catch (Exception e) {
            System.out.println("got an exception!");
        }

        return books;
    } 

    public static ArrayList readFurniture(){
        ArrayList<Furniture> furnitures = new ArrayList<>();
        File file = new File("Furniture.dat");
        if(!file.exists())
            return null;

        try (Scanner sc = new Scanner(file)) {
            while(sc.hasNext()){
                Furniture furniture = new Furniture();

                furniture.setSerialNumber(sc.nextLine());
                furniture.setName(sc.nextLine());
                furniture.setCost(Double.parseDouble(sc.nextLine()));
                furniture.setManufacturingYear(Integer.parseInt(sc.nextLine()));
                furniture.setColor(sc.nextLine());
                furniture.setMaterial(sc.nextLine());
                furniture.setTypeFurniture(sc.nextLine());

                furnitures.add(furniture);
            }
        } catch (Exception e) {
            System.out.println("got an exception!");
        }

        return furnitures;
    }
}
