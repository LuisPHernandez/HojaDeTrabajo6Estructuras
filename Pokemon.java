import java.util.List;

public class Pokemon {
    /**
     *
     */
    private String name;
    /**
     *
     */
    private int pokedexNum;
    /**
     *
     */
    private String type1;
    /**
     *
     */
    private String type2;
    /**
     *
     */
    private String classfication;
    /**
     *
     */
    private double height;
    /**
     *
     */
    private double weight;
    /**
     *
     */
    private List<String> abilities;
    /**
     *
     */
    private int generation;
    /**
     *
     */
    private boolean isLegendary;

    /**
     * @param name
     * @param pokedexNum
     * @param type1
     * @param type2
     * @param classfication
     * @param height
     * @param weight
     * @param abilities
     * @param generation
     * @param isLegendary
     */
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

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public int getPokedexNum() {
        return pokedexNum;
    }

    /**
     * @param pokedexNum
     */
    public void setPokedexNum(int pokedexNum) {
        this.pokedexNum = pokedexNum;
    }

    /**
     * @return
     */
    public String getType1() {
        return type1;
    }

    /**
     * @param type1
     */
    public void setType1(String type1) {
        this.type1 = type1;
    }

    /**
     * @return
     */
    public String getType2() {
        return type2;
    }

    /**
     * @param type2
     */
    public void setType2(String type2) {
        this.type2 = type2;
    }

    /**
     * @return
     */
    public String getClassfication() {
        return classfication;
    }

    /**
     * @param classfication
     */
    public void setClassfication(String classfication) {
        this.classfication = classfication;
    }

    /**
     * @return
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return
     */
    public List<String> getAbilities() {
        return abilities;
    }

    /**
     * @param abilities
     */
    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    /**
     * @return
     */
    public int getGeneration() {
        return generation;
    }

    /**
     * @param generation
     */
    public void setGeneration(int generation) {
        this.generation = generation;
    }

    /**
     * @return
     */
    public boolean isLegendary() {
        return isLegendary;
    }

    /**
     * @param legendary
     */
    public void setLegendary(boolean legendary) {
        isLegendary = legendary;
    }

    public String toString() {
        return String.format("Name: %s, PokedexNum: %d, Type1: %s, Type2: %s, Classification: %s, Height: %.2f, Weight: %.2f, Abilities: %s, Generation: %d, Legendary: %b", 
                name, pokedexNum, type1, type2, classfication, height, weight, abilities, generation, isLegendary);
    }
}
