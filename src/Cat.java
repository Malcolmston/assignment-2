public class Cat extends Animal {
  private static final String SPECIES = "Cat";

  public Cat (String name, String gender, int age, boolean[] flags) {
    super(name, gender, age, flags);
  }

  // getters
  @Override
    public String playing() {
    	return super.getName() + " " + (this.getFlags()[10] ? "likes" : "dose not like") + " to scratch up old boxes.";
    }
    @Override
    public String baths() {
		  return super.getName() + " " + (this.getFlags()[1] ? "likes" : "HATES") +  " taking baths.";
	}
  @Override
    public String eating() {
		  return super.getName() + (this.getFlags()[4] ? "loves eating more than anything in the world." : "dose not like eating");
	}
  @Override
    public String sleeping() {
		  return super.getName() + (this.getFlags()[8] ? "likes" : "dose not like") +" to nap around the house all day.";
	}
  public String getSpecies() {
    return Cat.SPECIES;
  }
  
}

