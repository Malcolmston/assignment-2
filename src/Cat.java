public class Cat extends Animal {
  private static final String species = "Cat";

  public Cat (String name, String gender, int age) {
    super(name, gender, age);
  }

  // getters
    public String playing() {
    	return super.getName() + "loves to scratch up old boxes.";
    }
    public String baths() {
		  return super.getName() + "HATES taking baths.";
	}
    public String eating() {
		  return super.getName() + "loves eating more than anything in the world.";
	}
    public String sleeping() {
		  return super.getName() + "likes to nap around the house all day.";
	}
  public String getSpecies() {
    return this.species;
  }
  
}

