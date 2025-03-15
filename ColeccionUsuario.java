import java.util.HashSet;
import java.util.Set;

public class ColeccionUsuario {
    private Set<Pokemon> userPokemons;

    public ColeccionUsuario() {
        this.userPokemons = new HashSet<>();
    }

    public boolean addPokemon(Pokemon pokemon) {
        return userPokemons.add(pokemon);
    }

    public boolean hasPokemon(Pokemon pokemon) {
        return userPokemons.contains(pokemon);
    }

    public Set<Pokemon> getCollection() {
        return new HashSet<>(userPokemons);
    }
}
