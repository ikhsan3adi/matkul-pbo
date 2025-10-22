package com.services;

public interface MovieRepository {
  Movie findByTitle(String title);
    void updateSeats(String title, int newSeats);
}
