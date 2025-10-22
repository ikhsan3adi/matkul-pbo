package com.services;

public class Movie {

    private String title;
    private int availableSeats;
    private double ticketPrice;

    //   Constructor
    public Movie(String title, int availableSeats, double ticketPrice) {
        this.title = title;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
    }

    //  Getter dan Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    //   Tambahan untuk debugging/logging
    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", availableSeats=" + availableSeats +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
