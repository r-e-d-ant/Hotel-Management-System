
package dao;
import java.sql.*;
import model.Room;

/**
 *
 * @author hg_ofthecity
 */
public class RoomDao {
    // global variables
    private String db_url = "jdbc:mysql://localhost:3306/Hotel_management_system_db";
    private String db_username = "root";
    private String db_password = "mugishathi";
    
    public RoomDao() {}
    
    // register room
    public Integer registerRoom(Room roomObj) {
        try {
            // Register driver
            // --
            // Create connection
            Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
            // Prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("INSERT INTO room VALUES(?,?,?)");
            pst.setString(1, roomObj.getRoomNo());
            pst.setString(2, roomObj.getRoomType());
            pst.setString(3, roomObj.getFee());
            // execute query
            int rowsAffected = pst.executeUpdate();
            // Close connection
            conn.close();
            return rowsAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    // view rooms
    public ResultSet displayRooms(Room roomObj) {
        try {
            // Register driver
            // --
            // Create connection
            Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
            // Prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("SELECT room_no, room_type, fee FROM room");
            // execute query
            ResultSet result = pst.executeQuery();
            return result;
//            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    // search room
    public ResultSet searchRoom(Room roomObj, String searchKey) {
        try {
            // Register driver
            // --
            // Create connection
            Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
            // Prepared statement
            PreparedStatement pst =
                    conn.prepareStatement(
            "SELECT room_no, room_type, fee FROM room WHERE room_no LIKE '%"+searchKey+"%' OR room_type LIKE '%"+searchKey+"%' OR fee LIKE '%"+searchKey+"%' ORDER BY fee ASC");
            // execute query
            ResultSet result = pst.executeQuery();
            return result;
//            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    // update room
    public Integer updateRoom(Room roomObj) {
        try {
            // Register driver
            // -
            // Create connection
            Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
            // prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("UPDATE room SET room_type=?, fee=? WHERE room_no=?");
            pst.setString(1, roomObj.getRoomType());
            pst.setString(2, roomObj.getFee());
            pst.setString(3, roomObj.getRoomNo());
            // execute query
            int rowsAffected = pst.executeUpdate();
            // close connection
            conn.close();
            return rowsAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    // delete room
    public Integer deleteRoom(Room roomObj) {
        try {
            // Register driver
            // -
            // Create connection
            Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
            // prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("DELETE FROM room WHERE room_no=?");
            pst.setString(1, roomObj.getRoomNo());
            // execute query
            int rowsAffected = pst.executeUpdate();
            // close connection
            conn.close();
            return rowsAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    // get room types
    public ResultSet getAllRooms(Room roomObj) {
        try {
            // Register driver
            // --
            // Create connection
            Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
            // Prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("SELECT room_no, room_type FROM room");
            // execute query
            ResultSet result = pst.executeQuery();
            return result;
//            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
