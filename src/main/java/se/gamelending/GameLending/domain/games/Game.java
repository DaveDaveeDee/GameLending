package se.gamelending.GameLending.domain.games;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import se.gamelending.GameLending.domain.users.User;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "console")
    @NotEmpty
    private String console;

    @Column(name = "genres")
    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @NotNull
    private List<Genre> genres;

    @Column(name = "publishing year")
    @NotNull
    private int publishingYear;

    @Column(name = "publisher")
    @NotEmpty
    private String publisher;

    @JoinColumn(name = "owner")
    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @NotNull
    private User owner;

    @JoinColumn(name = "holder")
    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @NotNull
    private User holder;

    @Column(name = "lendingdate", columnDefinition = "DATETIME")
    private LocalDateTime lendingDate;

    public Game(
            @NotEmpty String name,
            @NotEmpty String console,
            @NotNull List<Genre> genres,
            @NotNull int publishingYear,
            @NotEmpty String publisher,
            @NotNull User owner,
            @NotNull User holder,
            LocalDateTime lendingDate) {
        this.name = name;
        this.console = console;
        this.genres = genres;
        this.publishingYear = publishingYear;
        this.publisher = publisher;
        this.owner = owner;
        this.holder = holder;
        this.setLendingDate(lendingDate);
    }

    public Game() {}

    // Getters and Setters

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(@NotEmpty String name) {
        this.name = name;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(@NotEmpty String console) {
        this.console = console;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(@NotNull List<Genre> genres) {
        this.genres = genres;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(@NotNull int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(@NotEmpty String publisher) {
        this.publisher = publisher;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(@NotEmpty User owner) {
        this.owner = owner;
    }

    public User getHolder() {
        return holder;
    }

    public void setHolder(@NotEmpty User holder) {
        this.holder = holder;
        if (this.holder.equals(this.owner)) {
            this.lendingDate = null;
        }
    }

    public LocalDateTime getLendingDate() {
        return lendingDate;
    }

    public void setLendingDate(LocalDateTime lendingDate) {
        if (!this.holder.equals(this.owner)) {
            this.lendingDate = lendingDate;
        } else {
            this.lendingDate = null;
        }
    }
}
