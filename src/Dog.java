
public class Dog extends Animal {
	public static final String SPECIES = "Dog";
	
  public Dog (String name, String gender, int age, boolean[] flags) {
    super(name, gender, age, flags);
    }

    public String getSpecies () {
        return Dog.SPECIES;
    }

	//Does not like the vet
    @Override
    public String friendly() {
	return super.getName() + " is very loving and great with people";
    }

    @Override
    public String running() {
    	return super.getName() + "loves to run around in the park on sunny days";
    }

    @Override
    public String petting() {
    	return super.getName() + "loves belly rubs and likes to be pet by people";
    }

    @Override
    public String playing() {
    	return super.getName() + "likes to play fetch with sticks from outside";
    }
	
}
