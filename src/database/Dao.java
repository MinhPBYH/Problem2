package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Video;
import model.BookOnTape;
import model.Furniture;

public class Dao {
	private static Connection conn;
	
	
	
	public Dao() {
		try {
			//Register the JDBC driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			//Establish a database connection
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=RRSDatabase;"
					+ "encrypt=true;trustServerCertificate=true;"
					+ "user=sa;password=123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addVideo(Video video) {
		String sql = "INSERT INTO Video(Serial,Title,Cost,Manu_Year,Language,Duration,Type)"
				+ "Values(?,?,?,?,?,?,?)";
		
		try {
			//perform parameter queries.Its value will be set by calling the PreparedStatement setter methods.
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,video.getSerialNumber());
			ps.setString(2,video.getName());
			ps.setDouble(3, video.getCost());
			ps.setInt(4, video.getManufacturingYear());
			ps.setString(5, video.getLanguage());
			ps.setInt(6, video.getDuration());
			ps.setString(7, video.getTypeVideo());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addBook(BookOnTape book) {
		String sql = "INSERT INTO Book(Serial,Title,Cost,Manu_Year,Language,Author,Num_Pages,Type)"
				+ "Values(?,?,?,?,?,?,?,?)";
		
		try {
			//perform parameter queries.Its value will be set by calling the PreparedStatement setter methods.
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,book.getSerialNumber());
			ps.setString(2,book.getName());
			ps.setDouble(3, book.getCost());
			ps.setInt(4, book.getManufacturingYear());
			ps.setString(5, book.getLanguage());
			ps.setString(6, book.getAuthor());
			ps.setInt(7, book.getNumberPages());
			ps.setString(8, book.getTypeBook());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addFurniture(Furniture fur) {
		String sql = "INSERT INTO Furniture(Serial,Name,Cost,Manu_Year,Color,Material,Type)"
				+ "Values(?,?,?,?,?,?,?)";
		
		try {
			//perform parameter queries.Its value will be set by calling the PreparedStatement setter methods.
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,fur.getSerialNumber());
			ps.setString(2,fur.getName());
			ps.setDouble(3, fur.getCost());
			ps.setInt(4, fur.getManufacturingYear());
			ps.setString(5, fur.getColor());
			ps.setString(6, fur.getMaterial());
			ps.setString(7, fur.getTypeFurniture());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList getVideoList() {
		ArrayList<Video> videos = new ArrayList<>();
		String sql = "SELECT * FROM Video";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//maintains a pointer to a row of table
			ResultSet rs = ps.executeQuery();
			
			//loop moves the pointer to the next row from the current position.
			while (rs.next()) {
				Video video = new Video();
				
				//get the values ​​of the table and set the values ​​to the video using the setter methods
				video.setSerialNumber(rs.getString("Serial"));
				video.setName(rs.getString("Title"));
				video.setCost(rs.getDouble("Cost"));
				video.setManufacturingYear(rs.getInt("Manu_Year"));
				video.setLanguage(rs.getString("Language"));
				video.setDuration(rs.getInt("Duration"));
				video.setTypeVideo(rs.getString("Type"));

				videos.add(video);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return videos;
	}
	
	public ArrayList getBookList() {
		ArrayList<BookOnTape> books = new ArrayList<>();
		String sql = "SELECT * FROM Book";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//maintains a pointer to a row of table
			ResultSet rs = ps.executeQuery();
			
			//loop moves the pointer to the next row from the current position.
			while (rs.next()) {
				BookOnTape book = new BookOnTape();
				
				//get the values ​​of the table and set the values ​​to book using the setter methods
				book.setSerialNumber(rs.getString("Serial"));
				book.setName(rs.getString("Title"));
				book.setCost(rs.getDouble("Cost"));
				book.setManufacturingYear(rs.getInt("Manu_Year"));
				book.setLanguage(rs.getString("Language"));
				book.setAuthor(rs.getString("Author"));
				book.setNumberPages(rs.getInt("Num_Pages"));
				book.setTypeBook("Type");

				books.add(book);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return books;
	}
	
	public ArrayList getFurnitureList() {
		ArrayList<Furniture> furnitures = new ArrayList<>();
		String sql = "SELECT * FROM Furniture";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//maintains a pointer to a row of table
			ResultSet rs = ps.executeQuery();
			
			//loop moves the pointer to the next row from the current position.
			while (rs.next()) {
				Furniture fur = new Furniture();
				
				//get the values ​​of the table and set the values ​​to fur using the setter methods
				fur.setSerialNumber(rs.getString("Serial"));
				fur.setName(rs.getString("Name"));
				fur.setCost(rs.getDouble("Cost"));
				fur.setManufacturingYear(rs.getInt("Manu_Year"));
				fur.setColor(rs.getString("Color"));
				fur.setMaterial(rs.getString("Material"));
				fur.setTypeFurniture(rs.getString("Type"));

				furnitures.add(fur);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return furnitures;
	}

}
