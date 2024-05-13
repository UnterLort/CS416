/**
 * 
 * @author Kyle Stewart
 * @version 1
 */

public class Book {

    private String title;
    private Author[] authors;

    private double price;

    /**
     * 
     * 
     * @param title   book's title.
     * @param authors array of the author(s) who wrote this book.
     * @param price   price of the book.
     */
    public Book(String title, Author[] authors, double price) {
        this.title = title;
        this.authors = authors;
        this.price = price;
    }

    /**
     * 
     * 
     * @return title of the book.
     */
    public String getTitle() {
        return this.Title;
    }

    /**
     * 
     * 
     * @return price of the book.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * 
     * 
     * @return an array containing all the authors of the book.
     */
    public Author[] getAuthors() {
        return this.authors;
    }

    /**
     * 
     * 
     * @param price is a new price for the book.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 
     * 
     * @param title is a new title for the book.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * 
     * @return a string representation of the object in a format.
     */
    public String toString() {
        String ret = "";

        for (Author a : this.authors) {
            ret += a.toString() + ", ";
        }

        ret = ret.substring(0, ret.length() - 2);

        return String.format("Book[title=%s, authors={%s}, price=%f",
                this.title, ret, this.price);
    }

    /**
     * 
     * 
     * @return A copy of the Book object.
     */
    public String getAuthorNames() {
        String ret = "";

        for (Author a : this.authors) {
            ret += a.getName() + ", ";
        }

        return ret.substring(0, ret.length() - 2);
    }

    /**
     * 
     * 
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        Author a1 = new Author("John Doe", "jodoe@doewriter.com");
        Author a2 = new Author("Jane Doe", "jadoe@doewriter.com");

        Author[] a = new Authors[]{a1, a2};

        Book b = new Book("JAVA! - coffee is good", a, 15.99);

        assert b.getAuthorNames().equals("John Doe, Jane Doe");
        assert b.toString().equals("Book[title=JAVA! - coffee is good, authors={}, price=15.99");
    }
}