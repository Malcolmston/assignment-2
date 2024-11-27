public class Matchmaking<T1, T2> {
    private T1 t1;
    private T2 t2;

    // Parameterized constructor
    public Matchmaking(T1 t1, T2 t2) {

        this.t1 = t1;
        this.t2 = t2;
    }

    // Getters
    public T1 getFirst() {
        return t1;
    }

    public T2 getSecond() {
        return t2;
    }

    // Setters
    public void setFirst(T1 t1) {
        this.t1 = t1;
    }

    public void setSecond(T2 t2) {
        this.t2 = t2;
    }

    private static int getScore (boolean[] flag) {
        int i = 0;

        for (boolean b : flag) {
            i += b? 1 : 0;
        }

        return i;
    }

    @Override
    public String toString() {
        return "Matchmaking{" +
                "t1=" + t1 +
                ", t2=" + t2 +
                '}';
    }

    public static void main(String[] args) {
        // Assuming Cat and Dog classes exist
        Cat cat = new Cat("Fluffy", "female", 2, new boolean[]{true, true, true, true, true, true,true, true});
        Dog dog = new Dog("Rex", "male", 3, new boolean[]{false, true, true, true, true, true,true, true});

        Matchmaking<Cat, Dog> m = new Matchmaking<>(cat, dog);

        System.out.println(m);
    }
}
