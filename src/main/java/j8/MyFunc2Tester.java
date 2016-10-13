package j8;

/**
 * Created by Anand_Rajneesh on 7/5/2016.
 */
public class MyFunc2Tester {

    public static <T,P> int counter(T main, MyFunc2<T,P> func, P[] vals){
        int counter = 0;
        for(P p : vals){
            if(func.process(main,p)) counter++;
        }
        return counter;
    }

    public static void main(String[] args) {

        Book[] fantasyBooks = {new Book("got"), new Book("alice"), new Book("hardy"), new Book("olivertwist"), new Book("expectations")};

        Book[] programmingBooks = {new Book("java"), new Book("python"), new Book("scala"), new Book("prolog"), new Book("c")};

        BookHolder fantasyBookHolder = new BookHolder(fantasyBooks);

        Book[] solidProgrammingBooks = {new Book("java"), new Book("javascript")};

        BookHolder programmingBookHolder = new BookHolder(solidProgrammingBooks);

        int counter = counter(fantasyBookHolder, BookHolder::hasBook,fantasyBooks);

        System.out.println("Fantasy Book holder has "+ counter+ " fantasy books");

        counter = counter(fantasyBookHolder, BookHolder::hasBook,programmingBooks);

        System.out.println("Fantasy Book holder has "+ counter+ " programming books");

        counter = counter(programmingBookHolder, BookHolder::hasBook,fantasyBooks);

        System.out.println("Programming Book holder has "+ counter+ " fantasy books");

        counter = counter(programmingBookHolder, BookHolder::hasBook,programmingBooks);

        System.out.println("Programming Book holder has "+ counter+ " programming books");
    }
}
