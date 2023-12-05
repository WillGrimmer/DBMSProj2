
import controller.RecordLabelService;
import model.dao.RecordLabelDAO;
import model.entity.RecordLabel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> items = new ArrayList<>();
        boolean notDone = true;
        RecordLabelService controller = new RecordLabelService();

        while (notDone) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a Record Label");
            System.out.println("2. List existing Record Labels");
            System.out.println("3. Delete a Record Label");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the Record Label");
                    String labelName = scanner.nextLine().trim();
                    System.out.println("Enter the name of the Owner of the Record Label");
                    String ownerName= scanner.nextLine().trim();
                    System.out.println("Enter the number of Artists the Record Label has");
                    int artists= scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the year the Record Label was founded : yyyy ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the month the Record Label was founded : mm ");
                    int month = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the day the Record Label was founded : dd ");
                    int day = scanner.nextInt();
                    scanner.nextLine();
                    controller.createNewRecordLabel(labelName,ownerName,artists,java.time.LocalDate.of(year,month,day));
                    break;
                case 2:
                    System.out.println("Items in the list:");
                    for (String item : items) {
                        System.out.println(item);
                    }
                    break;
                case 3:
                    System.out.println("Enter the item to delete:");
                    String itemToDelete = scanner.nextLine();
                    if (items.remove(itemToDelete)) {
                        System.out.println("Item deleted: " + itemToDelete);
                    } else {
                        System.out.println("Item not found: " + itemToDelete);
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

//    public static void preparedStatementExample(){
//        String ConUrl = "jdbc:mysql://localhost";
//        String Port = "3306";
//        String Database = "music_db";
//        String Username = "root";
//        String Password = "csforever";
//
//        try{
//            String url = ConUrl+":"+Port+"/"+Database+"?user="+Username
//                    +"&password="+Password;
//            Connection con = DriverManager.getConnection(url);
//            String sql = "INSERT INTO client(name_client,email) VALUES(?,?)";
//            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setString(1,"Prof. H. Rocha");
//            pst.setString(2,"hsrocha@loyola.edu");
//            int rows = pst.executeUpdate();
//
//            con.close();
//        } catch(Exception ex){
//            System.out.println(ex);
//        }
//    }

//    public static void queryExample(){
//        System.out.println("Hello world!");
//        String ConUrl = "jdbc:mysql://localhost";
//        String Port = "3306";
//        String Database = "music_db";
//        String Username = "root";
//        String Password = "csforever";
//
//        try{
//            String url = ConUrl+":"+Port+"/"+Database+"?user="+Username
//                    +"&password="+Password;
//            Connection con = DriverManager.getConnection(url);
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM Client ORDER BY name_client");
//            while(rs.next()){
//                String cname = rs.getString("name_client");
//                int cid = rs.getInt("id_client");
//                Date dob = rs.getDate("dob");
//                System.out.printf("%d %s %s \n",cid,cname, dob);
//            }
//            con.close();
//        } catch(Exception ex){
//            System.out.println(ex);
//        }
//    }

//    public static void insertExample(){
//        String ConUrl = "jdbc:mysql://localhost";
//        String Port = "3306";
//        String Database = "music_db";
//        String Username = "root";
//        String Password = "csforever";
//
//        try{
//            String url = ConUrl+":"+Port+"/"+Database+"?user="+Username
//                    +"&password="+Password;
//            Connection con = DriverManager.getConnection(url);
//            Statement st = con.createStatement();
//            int rows = st.executeUpdate("INSERT INTO artist(name_artist) VALUES ('Test')");
//
//            con.close();
//        } catch(Exception ex){
//            System.out.println(ex);
//        }
//
//    }
}