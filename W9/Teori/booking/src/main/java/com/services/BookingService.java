package com.services;

public class BookingService {
 private final MovieRepository movieRepo;
    private final PaymentGateway paymentGateway;

    public BookingService(MovieRepository movieRepo, PaymentGateway paymentGateway) {
        this.movieRepo = movieRepo;
        this.paymentGateway = paymentGateway;
    }

    public String bookTicket(String userId, String movieTitle, int seatsRequested) {
        Movie movie = movieRepo.findByTitle(movieTitle);

        if (movie == null)
            throw new IllegalArgumentException("Movie not found");

        if (movie.getAvailableSeats() < seatsRequested)
            throw new IllegalStateException("Not enough seats available");

        double total = movie.getTicketPrice() * seatsRequested;

        boolean paid = paymentGateway.processPayment(userId, total);
        if (!paid)
            return "Payment failed";

        movieRepo.updateSeats(movieTitle, movie.getAvailableSeats() - seatsRequested);

        return "Booking successful";
    }
}
