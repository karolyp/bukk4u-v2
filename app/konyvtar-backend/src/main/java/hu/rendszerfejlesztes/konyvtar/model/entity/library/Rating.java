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
import java.util.Date;

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

    private Date date;

    @Lob
    private String textRating;

    private Integer stars;

    public Rating() {
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

    public DTO toDTO() {
        DTO dto = new DTO();
        dto.setId(id);
        dto.setStars(stars);
        dto.setUsername(user.toDto().getUsername());
        dto.setTextRating(textRating);
        dto.setDate(date);
        return dto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static class DTO {
        private Long id;
        private String username;
        private String textRating;
        private Integer stars;
        private Date date;
        private Long bookId;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
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

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "DTO{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", textRating='" + textRating + '\'' +
                    ", stars=" + stars +
                    ", date=" + date +
                    '}';
        }

        public Long getBookId() {
            return bookId;
        }

        public void setBookId(Long bookId) {
            this.bookId = bookId;
        }
    }


}
