import java.util.HashSet;
import java.util.Set;

public class ColeccionUsuario {
    /**
     *
     */
    private Set<Pokemon> userPokemons;

    /**
     * 
     */
    public ColeccionUsuario() {
        this.userPokemons = new HashSet<>();
    }

    /**
     * @param pokemon
     * @return
     */
    public boolean addPokemon(Pokemon pokemon) {
        return userPokemons.add(pokemon);
    }

    /**
     * @param pokemon
     * @return
     */
    public boolean hasPokemon(Pokemon pokemon) {
        return userPokemons.contains(pokemon);
    }

    /**
     * @return
     */
    public Set<Pokemon> getCollection() {
        return new HashSet<>(userPokemons);
    }
}
