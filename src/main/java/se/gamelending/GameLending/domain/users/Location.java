package se.gamelending.GameLending.domain.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @Column(name = "city")
    @NotEmpty
    private String city;

    @Column(name = "country")
    @NotEmpty
    private String country;

    public Location() {}

    public Location(@NotEmpty String city, @NotEmpty String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(@NotEmpty String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(@NotEmpty String country) {
        this.country = country;
    }
}
