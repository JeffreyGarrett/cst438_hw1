package cst438.hw1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class MovieRating {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(min=3, max=50)
    private String title;

    @NotNull
    private short rating;

    @NotNull
    @Size(min=3, max=50)
    private String name;

    private LocalDateTime postingDate;


    public MovieRating() {
        this.title = null;
        this.rating = 0;
        this.name = null;
        this.postingDate = null;
    }

    public MovieRating(long id, String title, short rating, String name, LocalDateTime postingDate){
        this.title = title;
        this.rating = rating;
        this.name = name;
        this.postingDate = postingDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getRating() {
        return rating;
    }

    public void setRating(short rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDateTime postingDate) {
        this.postingDate = postingDate;
    }
}
