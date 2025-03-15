import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Pokedex {
    private Map<String, Pokemon> pokemonMap;

    public Pokedex(String mapType) {
        MapFactory factory = new MapFactory();
        this.pokemonMap = factory.createMap(mapType);
    }

    public void cargarDatos(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Salta la primera línea (encabezado)
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0].trim();
                int pokedexNum = Integer.parseInt(data[1].trim());
                String type1 = data[2].trim();
                String type2 = data[3].trim().isEmpty() ? null : data[3].trim();
                String classification = data[4].trim();
                double height = Double.parseDouble(data[5].trim());
                double weight = Double.parseDouble(data[6].trim());
                List<String> abilities = Arrays.asList(data[7].trim().split(";"));
                int generation = Integer.parseInt(data[8].trim());
                boolean isLegendary;
                if (data[9].trim() == "No") {
                    isLegendary = false;
                }
                else {
                    isLegendary = true;
                }

                Pokemon pokemon = new Pokemon(name, pokedexNum, type1, type2, classification, height, weight, abilities, generation, isLegendary);
                pokemonMap.put(name, pokemon);
            }
        }
    }

    public Pokemon getPokemon(String name) {
        return pokemonMap.get(name);
    }

    public Collection<Pokemon> getAllPokemons() {
        return pokemonMap.values();
    }
}