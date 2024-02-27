package libraryforcft;

/**
 * Класс Book представляет модель данных книги в библиотеке.
 * Он содержит информацию о книге, такую как идентификатор, название, автор и год публикации.
 */
public class Book {
	private int id;
    private String title;
    private String authors;
    private int yearPublished;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
}
