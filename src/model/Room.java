/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hg_ofthecity
 */
public class Room {
    // private variables
    private String roomNo;
    private String roomStatus;
    private String fee;
    
    // constructors
    
    public Room() {}

    public Room(String roomNo, String roomStatus, String fee) {
        this.roomNo = roomNo;
        this.roomStatus = roomStatus;
        this.fee = fee;
    }
    
    // getters and setters
    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
