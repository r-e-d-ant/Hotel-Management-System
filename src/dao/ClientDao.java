
package dao;
import java.sql.*;
import model.Client;
import view.Login;

/**
 *
 * @author hg_ofthecity
 */
public class ClientDao {
    
    public ClientDao() {}

    private Connection conn = Login.conn;
    
    // register client
    public Integer registerClient(Client clientObj) {
        try {
            // Register driver
            // --
            // Prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("INSERT INTO client (client_id, first_name, last_name, client_room_no, entrance_date, exit_date) VALUES(?,?,?,?,?,?)");
            pst.setString(1, clientObj.getClientId());
            pst.setString(2, clientObj.getFirstName());
            pst.setString(3, clientObj.getLastName());
            pst.setString(4, clientObj.getRoomNo());
            pst.setString(5, clientObj.getEntranceDate());
            pst.setString(6, clientObj.getExitDate());
            // execute query
            int rowsAffected = pst.executeUpdate();
            return rowsAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    // view clients
    public ResultSet displayClients() {
        try {
            // Register driver
            // --
            // Prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("SELECT client_id, first_name, last_name, client_room_no, entrance_date, exit_date, fee, (exit_date - entrance_date) as Days FROM client\n" +
"JOIN room ON room.room_no = client.client_room_no ORDER BY entrance_date ASC");
            // execute query
            ResultSet result = pst.executeQuery();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    // search client
    public ResultSet searchClient(String searchKey) {
        try {
            // Register driver
            // --
            // Prepared statement
            PreparedStatement pst =
                    conn.prepareStatement(
            "SELECT client_id, first_name, last_name, client_room_no, entrance_date, exit_date, fee, (exit_date - entrance_date) as Days FROM client JOIN room ON room.room_no = client.client_room_no WHERE client_id LIKE '%"+searchKey+"%' OR first_name LIKE '%"+searchKey+"%' OR last_name LIKE '%"+searchKey+"%' OR client_room_no LIKE '%"+searchKey+"%' ORDER BY entrance_date ASC");
            // execute query
            ResultSet result = pst.executeQuery();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    // update client
    public Integer updateClient(Client clientObj) {
        try {
            // Register driver
            // --
            // Prepared statement
            PreparedStatement pst =
                    conn.prepareStatement(
            "UPDATE client SET first_name=?, last_name=?, client_room_no=?, entrance_date=?, exit_date=? WHERE client_id=?");
            pst.setString(1, clientObj.getFirstName());
            pst.setString(2, clientObj.getLastName());
            pst.setString(3, clientObj.getRoomNo());
            pst.setString(4, clientObj.getEntranceDate());
            pst.setString(5, clientObj.getExitDate());
            pst.setString(6, clientObj.getClientId());
            // execute query
            int rowsAffected = pst.executeUpdate();
            return rowsAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    // delete client
    public Integer deleteClient(Client clientObj) {
        try {
            // Register driver
            // --
            // Prepared statement
            PreparedStatement pst =
                    conn.prepareStatement("DELETE FROM client WHERE client_id=?");
            pst.setString(1, clientObj.getClientId());
            // execute query
            int rowsAffected = pst.executeUpdate();
            return rowsAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
