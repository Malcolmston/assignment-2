public class Monster extends Animal{
	private static final String SPICIES = "Monster";
	
	public Monster (String name, String gender, int age, boolean[] flags) {
		super(name,gender,age,flags);
	}
	
	public String getSpecies() {
		return Monster.SPICIES;
	}
	
	@Override
	public String adventurous() {
		return super.getName() + " loves exploring abandoned places.";
	}
	@Override
	public String running() {
		return super.getName() + " loves chasing after people";
	}
	@Override
	public String playing() {
		return super.getName() + " loves to play games like Hide-in-Seek.";
	}
	
	
}
