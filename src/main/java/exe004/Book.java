package exe004;

public class Book {
    
    private Integer bookId;
    
    private String bookName;
    
    public Book() {
        super();       
    }    
    
    public Book(Integer bookId, String bookName) {
        super();
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookName=" + bookName + "]";
    } 
    
}
