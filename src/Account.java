/**
* CMS270 Group Project
* Version 1
* Jarod Fuentes, Ava Kopchak, Alex Rynott, Malcolm Stone
*
* Account class
* Purpose: To create User objects that hold account and pet information.
*/

public class Account implements UserInfo {
    private String username;
    private Animal[] pets;
    private int numPets;

    Account(String username, int numPets, Animal[] pets) {
        this.username = username;
        this.numPets = numPets;
        this.pets = pets;
    }
    
    public Animal[] getPets() {
        return pets;
    }

    public void setPets(Animal[] pets) {
        this.pets = pets;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumPets() {
        return numPets;
    }

    public void setNumPets(int newNum) {
        this.numPets = newNum;
    }

    public Animal getPet(int index) {
        return pets[index];
    }

    @Override
    public void changeName(String newName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeName'");
    }

    @Override
    public void makeProfile() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeProfile'");
    }

}
