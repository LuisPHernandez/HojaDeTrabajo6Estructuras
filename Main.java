import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el número de la implementación de Map a utilizar:");
        System.out.println("1) HashMap");
        System.out.println("2) TreeMap");
        System.out.println("3) LinkedHashMap");
        
        String mapType;
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

        Pokedex pokedex = new Pokedex(mapType);
        ColeccionUsuario coleccion = new ColeccionUsuario();

        try {
            pokedex.cargarDatos("pokemon_data_pokeapi.csv");
        } catch (IOException e) {
            System.err.println("Error al cargar los datos: " + e.getMessage());
            return;
        }

        boolean seguir = true;

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
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del Pokémon a agregar: ");
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
                    String searchName = scanner.nextLine();
                    Pokemon pokeDatos = pokedex.getPokemon(searchName);
                    if (pokeDatos != null) {
                        System.out.println(pokeDatos.toString());
                    } else {
                        System.out.println("Pokémon no encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Colección del usuario ordenada por tipo:");
                    coleccion.getCollection().stream()
                        .sorted((p1, p2) -> p1.getType1().compareTo(p2.getType1()))
                        .forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Todos los Pokémon ordenados por tipo:");
                    pokedex.getAllPokemons().stream()
                        .sorted((p1, p2) -> p1.getType1().compareTo(p2.getType1()))
                        .forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Ingrese la habilidad a buscar: ");
                    String ability = scanner.nextLine();
                    pokedex.getAllPokemons().stream()
                        .filter(pokemon -> pokemon.getAbilities().contains(ability))
                        .forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
