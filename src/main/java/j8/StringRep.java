package j8;

/**
 * Created by Anand_Rajneesh on 4/17/2017.
 */
public interface StringRep extends JsonStringRep{

    default String jsonRep(){
        return "this is one morething i can do";
    }
}
