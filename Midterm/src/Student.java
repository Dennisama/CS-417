public class Student {
    private String name;
    private int id;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return name + " (" + id + ")";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
