package input;

public interface Datapoint {
    Datatype getDatatype();

    double getTime();

    double getValue();
}
