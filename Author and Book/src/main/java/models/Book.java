package models;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {

    private int id;
    private String Title;
    private String genre;

    public Book() {
    }

    public Book(String title, String genre) {
        Title = title;
        this.genre = genre;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    @Column(name ="title")
    public String getTitle() {
        return Title;
    }

    @Column(name="genre")
    public String getGenre() {
        return genre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
