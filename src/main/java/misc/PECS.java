package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anand_Rajneesh on 10/24/2016.
 * Producer Extends Consuming Super
 */
public class PECS {

    static{
        System.out.println("i");
    }
    public static void main(String[] args) {
        List<? super Integer> intList = new ArrayList<Number>();

        //can only take objects out of it
        for(Object i : intList){

        }
        //can only add integer and its sub classes
        intList.add(2);
        //cannot add subclasses of actual object declaration<> i.e subclasses of number
        //intList.add(2.0);

        Dog d1 = new Dog();
        Cat c1 = new Cat();
        Cow co1 = new Cow();
        Dog d2 = new Dog();
        Cat c2 = new Cat();
        Cow co2 = new Cow();


        List<Animal> animals = new ArrayList<>();
        animals.add(d1);
        animals.add(c1);
        animals.add(co1);

       /* for(Dog d : animals){

        }*/

        for(Animal a : animals){
            System.out.println(a);
        }

        List<? super Animal> animals2 = new ArrayList<>();
        animals2.add(d1);
        animals2.add(c1);
        animals2.add(co1);

        /*for(Animal a : animals2){
            System.out.println(a);
        }*/

        for(Object o :animals2){

        }


        List<? extends Animal> animals3 = new ArrayList<Cow>();

        /*animals3.add(c1);
        animals3.add(co1);
        */

        for(Animal c : animals3){

        }

    }

    public static class Animal{
        protected String type;
        @Override
        public String toString() {
            return type;
        }
    }

    public static class Dog extends Animal{
        {
            type = "dog";
        }

    }

    public static class Cat extends Animal{
        {
            type = "cat";
        }
    }

    public static class Cow extends Animal{
        {
            type = "cow";
        }
    }
}
