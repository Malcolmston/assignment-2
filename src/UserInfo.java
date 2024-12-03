
import javax.swing.JPanel;

/**
 * CMS270 Group Project
 * @version 1.0.0
 * @authors Jarod Fuentes, Ava Kopchak, Alex Rynott, Malcolm Stone
 * 
 * @purpose To share methods between Account and Animal class
 */
public interface UserInfo {
    public void changeName(String newName);

    public JPanel makeProfile();

}
