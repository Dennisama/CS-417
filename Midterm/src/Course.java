import java.util.ArrayList;

public class Course {
    private String name;
    private int sectionnumber;
    private ArrayList<Student> students;

    public Course(int sectionnumber, String name) {
        this.sectionnumber = sectionnumber;
        this.name = name;
        students = new ArrayList<Student>();
    }

    public void add(Student student) {
        boolean isfound = false;
        for(Student st : students) {
            if (st.getId() == student.getId()) {
                isfound = true;
            }
        }

        if (isfound) {
            students.add(student);
        }
    }

    public void drop(Student student) {
        students.remove(student);
    }

    public ArrayList<Student> getRoster() {
        return students;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append(name).append(" ")
                .append(sectionnumber).append("\n");
        for (Student st : students) {
            ret.append(st.toString()).append("\n");
        }

        return ret.toString();
    }
}
