
public class Dog extends Animal {
	public static final String Species = "Dog";
	
	public Dog(String n, int age, String gender) {
		super.setName(n);
		super.setAge(age);
		super.setGender(gender);
		
	Dog n1 = new Dog(n, age, gender);
	
	}
	//Does not like the vet
    public String friendly() {
	return super.getName() + " is very loving and great with people";
    }
    public String running() {
    	return super.getName() + "loves to run around in the park on sunny days";
    }
    public String petting() {
    	return super.getName() + "loves belly rubs and likes to be pet by people";
    }
    public String playing() {
    	return super.getName() + "likes to play fetch with sticks from outside";
    }
	
}
