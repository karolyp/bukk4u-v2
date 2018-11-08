package hu.rendszerfejlesztes.konyvtar.model.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Date date;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Category> categories;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Author> authors;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Keyword> keywords;

    @Enumerated(EnumType.STRING)
    private Language language;

}
