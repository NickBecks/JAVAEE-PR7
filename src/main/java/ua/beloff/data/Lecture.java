package ua.beloff.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Lectures")
@NamedQueries({
        @NamedQuery(name = Lecture.FIND_ALL, query="select c from Lecture c"),
        @NamedQuery(name = Lecture.FIND_BY_NAME, query="select c from Lecture c where c.name = :name"),
        @NamedQuery(name = Lecture.FIND_BY_ID, query="select c from Lecture c where c.id = :id")
})
public class Lecture implements Serializable{
    public static final String FIND_ALL = "Lectures.findAll";
    public static final String FIND_BY_NAME = "Lectures.findByName";
    public static final String FIND_BY_ID = "Lectures.findById";

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    private String name;
    private double credits;
    @ManyToMany(mappedBy = "lectures")
    private List<Student> students;

    @ManyToOne
    private Teacher teacher;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public List<Student> getStudents() {
        if (students == null){
            students = new ArrayList<Student>();
        }
        return students;
    }

    public void addStudent(Student student){
        List<Student> students = getStudents();
        students.add(student);
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", teacher=\'" + teacher.getFirstname() + ' ' + teacher.getLastname() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lecture lecture = (Lecture) o;

        if (id != lecture.id) return false;
        if (Double.compare(lecture.credits, credits) != 0) return false;
        if (name != null ? !name.equals(lecture.name) : lecture.name != null) return false;
        if (students != null ? !students.equals(lecture.students) : lecture.students != null) return false;
        return teacher != null ? teacher.equals(lecture.teacher) : lecture.teacher == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(credits);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (students != null ? students.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        return result;
    }
}