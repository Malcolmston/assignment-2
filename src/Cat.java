public class Cat extends Animal {
  private static final String SPECIES = "Cat";

  public Cat (String name, String gender, int age, boolean[] flags) {
    super(name, gender, age, flags);
  }

  // getters
  @Override
    public String playing() {
    	return super.getName() + "loves to scratch up old boxes.";
    }
    @Override
    public String baths() {
		  return super.getName() + "HATES taking baths.";
	}
  @Override
    public String eating() {
		  return super.getName() + "loves eating more than anything in the world.";
	}
  @Override
    public String sleeping() {
		  return super.getName() + "likes to nap around the house all day.";
	}
  public String getSpecies() {
    return Cat.SPECIES;
  }
  
}

