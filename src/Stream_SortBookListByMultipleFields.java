import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Problem statement : Given a list og book where each book has book name, author name, cost
 * Print the list of books sorted by three fields - name, author and cost
 *
 * @author Unmesh Chougule
 */
public class Stream_SortBookListByMultipleFields {

    public static void main(String[] args) {
        Book b1 = new Book("ABC", "BCD", 10.0);
        Book b2 = new Book("BXY", "ABC", 9.0);
        Book b3 = new Book("BCD", "BCD", 100.0);
        Book b4 = new Book("ABC", "BCD", 1.0);
        Book b5 = new Book("XYZ", "ABD", 20.0);
        Book b6 = new Book("XZY", "ABC", 50.0);

        List<Book> bList = new ArrayList<>();
        bList.add(b1);
        bList.add(b2);
        bList.add(b3);
        bList.add(b4);
        bList.add(b5);
        bList.add(b6);

        Comparator<Book> nameComp = (bookName1, bookName2) -> bookName1.name.compareToIgnoreCase(bookName2.name);
        Comparator<Book> authorComp = (bookAuthor1, bookAuthor2) -> bookAuthor1.author.compareToIgnoreCase(bookAuthor2.author);
        Comparator<Book> priceComp = Comparator.comparingDouble(bookCost -> bookCost.cost);

        //using stream to first compare by name then by author and then by cost
        bList.stream()
                .sorted(nameComp
                        .thenComparing(authorComp)
                        .thenComparing(priceComp))
                .forEach(System.out::println);
    }
}

class Book {
    String name;
    String author;
    Double cost;

    public Book(String name, String author, Double cost) {
        this.name = name;
        this.author = author;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", cost=" + cost +
                '}';
    }
}