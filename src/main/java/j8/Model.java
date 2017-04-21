package j8;

/**
 * Created by Anand_Rajneesh on 4/17/2017.
 */
public abstract class Model implements JsonStringRep{

    public String toString(){
        return jsonRep();
    }
}
