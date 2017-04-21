package coursera.algoGraphs.week1;

import java.util.Optional;

/**
 * Created by Anand_Rajneesh on 2/14/2017.
 */
abstract class AbstractGraphProperty<T> implements  Property<T>{

    protected Optional<T> property;
    protected Graph graph;

    public AbstractGraphProperty(Graph graph) {
        this.graph = graph;
        property = Optional.empty();
    }

    protected abstract T compute();

    public final T get() {
        if(!property.isPresent()){
            property = Optional.of(this.compute());
        }
        return property.orElseGet(this::compute);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
