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
            br.readLine();
            while ((line = br.readLine()) != null) {
                List<String> data = parseCSVLine(line);
            
                String name = data.get(0).trim();
                int pokedexNum = Integer.parseInt(data.get(1).trim());
                String type1 = data.get(2).trim();
                String type2 = data.get(3).trim().isEmpty() ? null : data.get(3).trim();
                String classification = data.get(4).trim();
                double height = Double.parseDouble(data.get(5).trim());
                double weight = Double.parseDouble(data.get(6).trim());
                
                // Parse abilities with semicolon separator
                List<String> abilities = Arrays.asList(data.get(7).trim().split(","));
                int generation = Integer.parseInt(data.get(8).trim());
                boolean isLegendary = "Yes".equalsIgnoreCase(data.get(9).trim());

                Pokemon pokemon = new Pokemon(name, pokedexNum, type1, type2, classification, height, weight, abilities, generation, isLegendary);
                pokemonMap.put(name, pokemon);
            }
        }
    }

    /*
    * Método de análisis CSV personalizado.
    * Este método resuelve el problema de lectura de campos entre comillas que contienen comas,
    * particularmente en el campo de habilidades donde pueden existir múltiples habilidades
    * separadas por comas dentro de comillas.
    * 
    * Implementado con la ayuda de Claude AI.
    */
    private List<String> parseCSVLine(String line) {
        List<String> result = new ArrayList<>();
        StringBuilder currentField = new StringBuilder();
        boolean inQuotes = false;
        
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            
            if (c == '"') {
                inQuotes = !inQuotes; // Toggle quote state
            } else if (c == ',' && !inQuotes) {
                // End of field
                result.add(currentField.toString());
                currentField = new StringBuilder();
            } else {
                currentField.append(c);
            }
        }
    
    // Add the last field
    result.add(currentField.toString());
    return result;
}

    public Pokemon getPokemon(String name) {
        return pokemonMap.get(name);
    }

    public Collection<Pokemon> getAllPokemons() {
        return pokemonMap.values();
    }
}