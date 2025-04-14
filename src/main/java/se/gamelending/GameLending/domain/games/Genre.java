package se.gamelending.GameLending.domain.games;

import jakarta.persistence.*;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @Column(name = "genres")
    private String genre;

    public Genre() {}

    public Genre(String genre) {
        this.genre = genre;
    }

    // Getters and Setters

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
