import db.DBAuthor;
import db.DBBook;
import models.Author;
import models.Book;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Author author1 = new Author("JK", "Rowling");
        DBAuthor.save(author1);
        Author author2 = new Author("Kirsten", "Cashore");
        DBAuthor.save(author2);
        Author author3 = new Author("Ava", "Marie");
        DBAuthor.save(author3);

        Book book1 = new Book("Harry Potter", "Fantasy");
        DBBook.save(book1);
        Book book2 = new Book("Graceling", "Fantasy");
        DBBook.save(book2);
        Book book3 = new Book("Bitterblue", "Fantasy");
        DBBook.save(book3);

        List<Author> allAuthors =  DBAuthor.getAll();
        List<Book> allBooks =  DBBook.getAll();

        Author kirsten = DBAuthor.find(author2.getId());
        Book graceling = DBBook.find(book2.getId());

        DBAuthor.deleteAll();
        List<Author> allAuthorsAfterDelete = DBAuthor.getAll();
        DBBook.deleteAll();
        List<Book> allBooksAfterDelete = DBBook.getAll();
    }
}
