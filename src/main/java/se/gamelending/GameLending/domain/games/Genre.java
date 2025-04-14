package se.gamelending.GameLending.domain.games;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @Column(name = "genres")
    @NotBlank
    private String genre;

    public Genre() {}

    public Genre(@NotBlank String genre) {
        this.genre = genre;
    }

    // Getters and Setters

    public String getGenre() {
        return genre;
    }

    public void setGenre(@NotBlank String genre) {
        this.genre = genre;
    }
}
