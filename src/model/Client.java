
package model;

/**
 *
 * @author hg_ofthecity
 */
public class Client {
    private String clientId;
    private String firstName;
    private String lastName;
    private String roomNo;
    private String entranceDate;
    private String exitDate;
    private String days;

    public Client() {
    }

    public Client(String clientId, String firstName, String lastName, String roomNo, String entranceDate, String exitDate, String days) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roomNo = roomNo;
        this.entranceDate = entranceDate;
        this.exitDate = exitDate;
        this.days = days;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(String entranceDate) {
        this.entranceDate = entranceDate;
    }

    public String getExitDate() {
        return exitDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
    
    
}

