package input;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Datapoint {
    @JsonProperty("name")
    private final Datatype datatype;
    @JsonProperty("value")
    private final double value;
    @JsonProperty("timestamp")
    private final double time;


    public Datapoint(Datatype datatype, double data, double time) {
        this.datatype = datatype;
        this.value = data;
        this.time = time;
    }

    public Datapoint(String rawData, double time, Datatype datatype) {
        this(datatype, parseValue(rawData), time);
    }

    public static double parseValue(String string) {
        String value = string.substring(string.indexOf(':') + 1);
        if (value.equals("true")) return 1;
        else if (value.equals("false")) return 0;
        else if (value.charAt(0) == '"') {
            if (value.equals("\"reverse\"")) return -1;
            else if (value.equals("\"neutral\"")) return 0;
            else if (value.equals("\"first\"")) return 1;
            else if (value.equals("\"second\"")) return 2;
            else if (value.equals("\"third\"")) return 3;
            else if (value.equals("\"fourth\"")) return 4;
            else if (value.equals("\"fifth\"")) return 5;
            else if (value.equals("\"sixth\"")) return 6;
            else return 0;
        }
        return Double.valueOf(value);
    }

    public Datatype getDatatype() {
        return datatype;
    }

    public double getValue() {
        return value;
    }

    public double getTime() {
        return time;
    }

    public String toJson(ObjectMapper mapper) throws JsonProcessingException {
        return mapper.writeValueAsString(this) + '\n';
    }

}
