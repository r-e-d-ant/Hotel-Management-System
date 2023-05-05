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
    private String roomType;
    private String fee;
    
    public Room() {}

    public Room(String roomNo, String roomType, String fee) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.fee = fee;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
