import java.sql.*;
import java.util.Scanner;

public class ProductCRUD {
    static String url = "jdbc:mysql://localhost:3306/yourdb";
    static String user = "root";
    static String password = "password";

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            while(true) {
                System.out.println("Menu: 1.Add 2.View All 3.Update 4.Delete 5.Exit");
                int choice = sc.nextInt();
                switch(choice) {
                    case 1: // Create
                        con.setAutoCommit(false);
                        PreparedStatement ps1 = con.prepareStatement(
                            "INSERT INTO Product(ProductID, ProductName, Price, Quantity) VALUES (?, ?, ?, ?)");
                        // get input and set params
                        // ps1.setInt(...), ps1.setString(...), ps1.setDouble(...), ps1.setInt(...)
                        ps1.executeUpdate();
                        con.commit();
                        break;
                    case 2: // Read
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
                        while(rs.next()) {
                            System.out.println(rs.getInt("ProductID") + " " +
                                               rs.getString("ProductName") + " " +
                                               rs.getDouble("Price") + " " + rs.getInt("Quantity"));
                        }
                        break;
                    case 3: // Update
                        con.setAutoCommit(false);
                        PreparedStatement ps2 = con.prepareStatement(
                            "UPDATE Product SET Price=?, Quantity=? WHERE ProductID=?");
                        // get ProductID, new Price, new Quantity; set params
                        ps2.executeUpdate();
                        con.commit();
                        break;
                    case 4: // Delete
                        con.setAutoCommit(false);
                        PreparedStatement ps3 = con.prepareStatement(
                            "DELETE FROM Product WHERE ProductID=?");
                        // get ProductID, set param
                        ps3.executeUpdate();
                        con.commit();
                        break;
                    case 5: return; // Exit
                }
            }
        }
    }
}
