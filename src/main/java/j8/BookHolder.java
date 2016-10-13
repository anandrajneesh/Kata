package j8;

/**
 * Created by Anand_Rajneesh on 7/5/2016.
 */
public class BookHolder {

    private Book[] books;

    public BookHolder(Book[] books) {
        this.books = books;
    }


    public boolean hasBook(Book book){
        for(Book b : books){
            if(b.equals(book)){
                return true;
            }
        }
        return false;
    }
}
