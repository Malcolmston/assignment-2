/**
 * CMS270 Group Project
 * @version 1.0.0
 * @authors Jarod Fuentes, Ava Kopchak, Alex Rynott, Malcolm Stone
 * 
 * @purpose Animal subclass to specify Cat behaviors
 */
public class Cat extends Animal {
  private static final String SPECIES = "Cat";

  private String url;

  public Cat(String name, String gender, int age, boolean[] flags, String url) {
    super(name, gender, age, flags);
    this.url = url;
  }

  // getters
  @Override
  public String playing() {
    return super.getName() + " " + (this.getFlags()[10] ? "likes" : "does not like") + " to scratch up old boxes.";
  }

  @Override
  public String baths() {
    return super.getName() + " " + (this.getFlags()[1] ? "likes" : "HATES") + " taking baths.";
  }

  @Override
  public String eating() {
    return super.getName() + " " + (this.getFlags()[4] ? "loves eating more than anything in the world." : "does not like eating.");
  }

  @Override
  public String sleeping() {
    return super.getName() + " " + (this.getFlags()[8] ? "likes" : "does not like") + " to nap around the house all day.";
  }

  public String getSpecies() {
    return Cat.SPECIES;
  }

  @Override
  public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
