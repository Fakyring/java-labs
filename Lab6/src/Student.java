import java.util.Comparator;

public class Student {
    protected int id, mark;
    protected String surname, name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getMark() {
        return mark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(int id, int mark, String surname, String name) {
        this.id = id;
        this.mark = mark;
        this.surname = surname;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id = " + id +
                ", mark = " + mark +
                ", surname = '" + surname + '\'' +
                ", name = '" + name + '\'' +
                '}';
    }
}
