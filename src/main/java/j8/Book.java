package j8;

/**
 * Created by Anand_Rajneesh on 7/5/2016.
 */
public class Book {

    private String name;

    public Book(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return name.equalsIgnoreCase(((Book)obj).name);
    }
}
