import java.util.*;

public class MapFactory {
    /**
     * 
     */
    public MapFactory() {}

    /**
     * @param type
     * @return
     */
    public Map<String, Pokemon> createMap(String type) {
        switch (type.toLowerCase()) {
            case "hashmap":
                return new HashMap<>();
            case "treemap":
                return new TreeMap<>();
            case "linkedhashmap":
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Tipo de Map no válido");
        }
    }
}
