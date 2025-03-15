import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;

public class ColeccionTest {
    /**
     * 
     */
    @Test
    public void testAdd_Has() {
        List<String> abilities = new ArrayList<>(Arrays.asList("Overgrow", "Chlorophyll"));
        // Crea a Bulbasaur como Pokemon de prueba
        Pokemon testPokemon = new Pokemon("Bulbasaur", 1, "Grass", "Poison", "Seed Pokémon", 0.7, 6.9, abilities, 1, false);

        ColeccionUsuario coleccion = new ColeccionUsuario(); // Crea la coleccion

        coleccion.addPokemon(testPokemon); // Agrega a Bulbasaur a la coleccion
        assertTrue(coleccion.hasPokemon(testPokemon)); // Revisa si la coleccion tiene a Bulbasaur
    }

    /**
     * 
     */
    @Test
    public void testGetCollection() {
        List<String> abilities = new ArrayList<>(Arrays.asList("Overgrow", "Chlorophyll"));
        // Crea a Bulbasaur como Pokemon de prueba
        Pokemon testPokemon1 = new Pokemon("Bulbasaur", 1, "Grass", "Poison", "Seed Pokémon", 0.7, 6.9, abilities, 1, false);

        abilities = new ArrayList<>(Arrays.asList("Blaze, Solar-power"));
        // Crea a Charizard como Pokemon de prueba
        Pokemon testPokemon2 = new Pokemon("Charizard", 6, "Fire", "Flying", "Flame Pokémon", 1.7, 90.5, abilities, 1, false);

        ColeccionUsuario coleccion = new ColeccionUsuario(); // Crea la coleccion
        coleccion.addPokemon(testPokemon1); // Agrega a Bulbasaur a la coleccion
        coleccion.addPokemon(testPokemon2); // Agrega a Charizard a la coleccion

        Set<Pokemon> result = coleccion.getCollection();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(testPokemon1)); // Revisa si Bulbasaur está en la coleccion
        assertTrue(result.contains(testPokemon2)); // Revisa si Charizard está en la coleccion
    }

}
