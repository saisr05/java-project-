import java.util.HashMap;
import java.util.Map;

public class Q5c {
    
        public static void main(String[] args) {
            Library library = new Library();
    
            Book book1 = new Book("Java Programming", "John Doe", "123456");
            Book book2 = new Book("Data Structures", "Jane Smith", "654321");
    
            Member member1 = new Member("Alice", "M001", "alice@example.com");
            Member member2 = new Member("Bob", "M002", "bob@example.com");
    
            library.addBook(book1);
            library.addBook(book2);
            library.addMember(member1);
            library.addMember(member2);
    
            library.borrowBook(book1, member1);
            System.out.println("Book 1 available: " + book1.isAvailable());
    
            library.returnBook(book1, member1);
            System.out.println("Book 1 available: " + book1.isAvailable());
        }
    }
    

//Book
 class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
}

//Members
 class Member {
    private String name;
    private String memberId;
    private String contactInfo;

    public Member(String name, String memberId, String contactInfo) {
        this.name = name;
        this.memberId = memberId;
        this.contactInfo = contactInfo;
    }

    public String getName() { return name; }
    public String getMemberId() { return memberId; }
    public String getContactInfo() { return contactInfo; }
}
//Browsing
 interface Borrowing {
    void borrowBook(Book book, Member member);
    void returnBook(Book book, Member member);
}

//Library
class Library implements Borrowing {
    private Map<String, Book> books = new HashMap<>();
    private Map<String, Member> members = new HashMap<>();
    private Map<String, String> borrowedBooks = new HashMap<>(); // Book ISBN -> Member ID

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    @Override
    public void borrowBook(Book book, Member member) {
        if (book.isAvailable() && members.containsKey(member.getMemberId())) {
            book.setAvailable(false);
            borrowedBooks.put(book.getIsbn(), member.getMemberId());
        }
    }

    @Override
    public void returnBook(Book book, Member member) {
        if (borrowedBooks.containsKey(book.getIsbn()) &&
            borrowedBooks.get(book.getIsbn()).equals(member.getMemberId())) {
            book.setAvailable(true);
            borrowedBooks.remove(book.getIsbn());
        }
    }
}