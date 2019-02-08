package com.tcs.hack.dto;


public class BookingDTO {
    private String bookingSlot;
    private String bookingDate;
    private int resourceId;

    public String getBookingSlot() {
        return bookingSlot;
    }
    public void setBookingSlot(String bookingSlot) {
        this.bookingSlot = bookingSlot;
    }
    public String getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
    public int getResourceId() {
        return resourceId;
    }
    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
    public BookingDTO(){

    }

    public BookingDTO (String bookingSlot ,String bookingDate ,int resourceId){
        this.bookingSlot = bookingSlot;
        this.bookingDate = bookingDate;
        this.resourceId = resourceId;

    }
}
