
package dao;
import java.sql.*;
import model.Room;
import view.Login;

/**
 *
 * @author hg_ofthecity
 */
public class RoomDao {
    // global variables
    private Connection conn = Login.conn;
    
    public RoomDao() {}
    
    // register room
    public Integer registerRoom(Room roomObj) {
        try {
            // Register driver
            // --
            // Prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("INSERT INTO room (room_no, fee, status) VALUES(?,?,?)");
            pst.setString(1, roomObj.getRoomNo());
            pst.setString(2, roomObj.getFee());
            pst.setString(3, roomObj.getRoomStatus());
            // execute query
            int rowsAffected = pst.executeUpdate();
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
            // Prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("SELECT room_no, fee, status FROM room ORDER BY room_no ASC");
            // execute query
            ResultSet result = pst.executeQuery();
            return result;
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
            // Prepared statement
            PreparedStatement pst =
                    conn.prepareStatement(
            "SELECT room_no, fee, status FROM room WHERE room_no LIKE '%"+searchKey+"%' ORDER BY room_no ASC");
            // execute query
            ResultSet result = pst.executeQuery();
            return result;
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
            // prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("UPDATE room SET fee=?, status=? WHERE room_no=?");
            pst.setString(1, roomObj.getFee());
            pst.setString(2, roomObj.getRoomStatus());
            pst.setString(3, roomObj.getRoomNo());
            // execute query
            int rowsAffected = pst.executeUpdate();
            return rowsAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public Integer updateRoomStatus(Room roomObj) {
        try {
            // Register driver
            // -
            // prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("UPDATE room SET status=? WHERE room_no=?");
            
            pst.setString(1, roomObj.getRoomStatus());
            pst.setString(2, roomObj.getRoomNo());
            // execute query
            int rowsAffected = pst.executeUpdate();
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
            // prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("DELETE FROM room WHERE room_no=?");
            pst.setString(1, roomObj.getRoomNo());
            // execute query
            int rowsAffected = pst.executeUpdate();
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
            // Prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("SELECT room_no, fee, status FROM room");
            // execute query
            ResultSet result = pst.executeQuery();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
