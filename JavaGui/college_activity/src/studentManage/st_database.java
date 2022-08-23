package studentManage;
import GUI.User;
import java.sql.*;


public class st_database {
    static User user;
    static Connection con;
    private static void crateC() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentManagement", "root", "sarao341983");
    }
    public static User fetchdata(int roll_no) throws Exception{
        crateC();
        String q= "select * from students where sroll_no=?;";
        PreparedStatement preparedStatement = con.prepareStatement(q);
        preparedStatement.setInt(1, roll_no);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            user = new User();
            user.name = resultSet.getString("sname");
            user.roll_no = resultSet.getInt("sroll_no");
            user.phone = resultSet.getString("sphone");
            user.address = resultSet.getString("scity");
            user.course= resultSet.getString("scourse");
        }
        preparedStatement.close();
        con.close();
        return user;
    }
    public static boolean InsertStudent(String name,int roll_no,String phone,String city,String course){
        boolean check=false;
        
        try{
            crateC();
            String q="insert into students(sroll_no,sname,sphone,scourse,scity) values(?,?,?,?,?);";
            PreparedStatement pstmt =con.prepareStatement(q);
            pstmt.setInt(1, roll_no);
            pstmt.setString(2, name);
            pstmt.setString(3, phone);
            pstmt.setString(4, course); 
            pstmt.setString(5, city);
            pstmt.executeUpdate();
            check=true;
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();

        }
        
        return check;    
    }
    public static boolean deleteStudent(int roll_no){
        boolean check=false;
        try{
            crateC();
            String q="delete from students where sroll_no=?;";
            PreparedStatement pstmt =con.prepareStatement(q);
            pstmt.setInt(1, roll_no);
            pstmt.executeUpdate();
            check=true;
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return check;    
    }

    public static void closeCon()throws Exception{
        con.close();
    }
    public static User getAuthenticatedUser(String phone, int password) {  
        
        try{
            crateC();
            String q = "SELECT * FROM students WHERE sphone=? AND sroll_no=?";
            PreparedStatement preparedStatement = con.prepareStatement(q);
            preparedStatement.setString(1, phone);
            preparedStatement.setInt(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.name = resultSet.getString("sname");
                user.roll_no = resultSet.getInt("sroll_no");
                user.phone = resultSet.getString("sphone");
                user.address = resultSet.getString("scity");
                user.course= resultSet.getString("scourse");
            }
            preparedStatement.close();
            con.close();
  
        }catch(Exception e){
            System.out.println("Database connexion failed!");
            e.printStackTrace();
        }
        return user;
    }
    public static boolean getAuthenticatedAdmin(String username, String password) {
        boolean check=false;
        try{
            crateC();
            String q = "SELECT * FROM adminLogin WHERE username=? AND username=?";
            PreparedStatement preparedStatement = con.prepareStatement(q);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
               check=true;    
            }
            preparedStatement.close(); 
            con.close();
        }catch(Exception e){
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
        System.out.println(check);
        return check;
    }

}
    




 




    
