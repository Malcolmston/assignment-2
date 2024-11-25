public class Cat extends Animal {
  private static final String species = "Cat";

  public Cat (String name, String gender, int age) {
    super(name, gender, age);
  }

  // getters
  public String getSpecies() {
    return this.species;
  }
  
}
