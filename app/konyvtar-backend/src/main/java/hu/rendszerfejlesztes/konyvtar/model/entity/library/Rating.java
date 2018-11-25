package hu.rendszerfejlesztes.konyvtar.model.entity.library;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.rendszerfejlesztes.konyvtar.model.entity.auth.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnore
    private Book book;

    @Lob
    private String textRating;

    private Integer stars;

    public Rating() {
    }

    public Rating(User user, Book book, String textRating, Integer stars) {
        this.user = user;
        this.book = book;
        this.textRating = textRating;
        this.stars = stars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getTextRating() {
        return textRating;
    }

    public void setTextRating(String textRating) {
        this.textRating = textRating;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }


}
