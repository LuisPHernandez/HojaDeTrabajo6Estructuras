import java.util.List;

public class Pokemon {
    private String name;
    private int pokedexNum;
    private String type1;
    private String type2;
    private String classfication;
    private double height;
    private double weight;
    private List<String> abilities;
    private int generation;
    private boolean isLegendary;

    public Pokemon(String name, int pokedexNum, String type1, String type2, String classfication, double height, double weight, List<String> abilities, int generation, boolean isLegendary) {
        this.name = name;
        this.pokedexNum = pokedexNum;
        this.type1 = type1;
        this.type2 = type2;
        this.classfication = classfication;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.generation = generation;
        this.isLegendary = isLegendary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPokedexNum() {
        return pokedexNum;
    }

    public void setPokedexNum(int pokedexNum) {
        this.pokedexNum = pokedexNum;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getClassfication() {
        return classfication;
    }

    public void setClassfication(String classfication) {
        this.classfication = classfication;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public boolean isLegendary() {
        return isLegendary;
    }

    public void setLegendary(boolean legendary) {
        isLegendary = legendary;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, PokedexNum: %d, Type1: %s, Type2: %s, Classification: %s, Height: %.2f, Weight: %.2f, Abilities: %s, Generation: %d, Legendary: %b", 
                name, pokedexNum, type1, type2, classfication, height, weight, abilities, generation, isLegendary);
    }
}
