import java.io.IOException;
import java.util.Scanner;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el número de la implementación de Map a utilizar:");
        System.out.println("1) HashMap");
        System.out.println("2) TreeMap");
        System.out.println("3) LinkedHashMap");
        
        String mapType = "hashmap";
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                mapType = "hashmap";
                break;
            case 2:
                mapType = "treemap";
                break;
            case 3:
                mapType = "linkedhashmap";
                break;
            default:
                System.out.println("Opción inválida, se usará HashMap por defecto.");
        }

        // Se crea la pokedex con la implementation seleccionada
        Pokedex pokedex = new Pokedex(mapType);
        ColeccionUsuario coleccion = new ColeccionUsuario();

        // Se intentan cargar los datos del CSV
        try {
            pokedex.cargarDatos("pokemon_data_pokeapi.csv");
        } catch (IOException e) {
            System.err.println("Error al cargar los datos: " + e.getMessage());
            scanner.close();
            return;
        }

        boolean seguir = true;

        // Loop principal
        while (seguir) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1) Agregar un Pokémon a la colección");
            System.out.println("2) Mostrar datos de un Pokémon");
            System.out.println("3) Mostrar colección del usuario ordenada por tipo");
            System.out.println("4) Mostrar todos los Pokémon ordenados por tipo");
            System.out.println("5) Buscar Pokémon por habilidad");
            System.out.println("6) Salir");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            // Switch para ejecutar código según elección del usuario
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del Pokémon a agregar (primera letra en mayúscula): ");
                    String name = scanner.nextLine();
                    Pokemon pokeAgregar = pokedex.getPokemon(name);
                    if (pokeAgregar != null) {
                        if (coleccion.addPokemon(pokeAgregar)) {
                            System.out.println("Pokémon agregado con éxito.");
                        } else {
                            System.out.println("El Pokémon ya está en la colección.");
                        }
                    } else {
                        System.out.println("El Pokémon no existe en los datos.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    String nombre = scanner.nextLine();
                    Pokemon pokeDatos = pokedex.getPokemon(nombre);
                    if (pokeDatos != null) {
                        System.out.println(pokeDatos.toString());
                    } else {
                        System.out.println("Pokémon no encontrado.");
                    }
                    break;
                case 3:
                    /*
                    * Este bloque de código ordena y muestra la colección de Pokémon del usuario por tipo primario.
                    * 
                    * Utiliza la API Stream de Java para obtener un stream de la colección de Pokémom,
                    * ordenar los Pokemón comparando sus tipos primarios alfabéticamente,
                    * imprimir el nombre y tipo primario de cada Pokémon ordenado en la consola
                    * 
                    * Implementado con la ayuda de Claude AI.
                    */
                    System.out.println("Colección del usuario ordenada por tipo:");
                    coleccion.getCollection().stream()
                        .sorted((p1, p2) -> p1.getType1().compareTo(p2.getType1()))
                        .forEach(pokemon -> System.out.println(pokemon.getName() + " - Tipo: " + pokemon.getType1()));
                        break;
                case 4:
                    /*
                    * Este bloque de código ordena y muestra todos los Pokémon de la Pokedex por tipo primario.
                    * 
                    * Utiliza la API Stream de Java para obtener un stream de la colección de Pokémom,
                    * ordenar los Pokemono comparando sus tipos primarios alfabéticamente,
                    * imprimir el nombre y tipo primario de cada Pokémon ordenado en la consola
                    * 
                    * Implementado con la ayuda de Claude AI.
                    */
                    System.out.println("Todos los Pokémon ordenados por tipo:");
                    pokedex.getAllPokemons().stream()
                        .sorted((p1, p2) -> p1.getType1().compareTo(p2.getType1()))
                        .forEach(pokemon -> System.out.println(pokemon.getName() + " - Tipo: " + pokemon.getType1()));
                    break;
                case 5:
                    /*
                    * Este bloque de código busca y muestra todos los Pokémon que poseen una habilidad específica.
                    * 
                    * El proceso es el siguiente:
                    * 1. Solicita al usuario que ingrese la habilidad que desea buscar
                    * 2. Obtiene un stream de todos los Pokémon en la Pokedex
                    * 3. Filtra aquellos Pokémon cuya lista de habilidades contiene la habilidad buscada
                    * 4. Imprime en consola el nonmbre de cada Pokémon que cumple con el criterio de búsqueda
                    * 
                    * Implementado con la ayuda de Claude AI.
                    */
                    System.out.print("Ingrese la habilidad a buscar: ");
                    String ability = scanner.nextLine();
                    pokedex.getAllPokemons().stream()
                        .filter(pokemon -> pokemon.getAbilities().contains(ability))
                        .forEach(pokemon -> System.out.println(pokemon.getName()));
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}
