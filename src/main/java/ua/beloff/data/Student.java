package ua.beloff.data;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by TrueLecter on 03.03.2017.
 */
@Entity
@Table(name="Students")
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int studentId;
    private String pib;
    private int course;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "jnd_students_lectures",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "lecture_id"))
    private List<Lecture> lectures;

    public Student(String pib, int course){
        this.pib = pib;
        this.course = course;
    }

    public Student(){}

    public List<Lecture> getLectures() {
        if (lectures == null){
            lectures = new ArrayList<Lecture>();
        }
        return lectures;
    }

    public void addLecture(Lecture lecture){
        getLectures().add(lecture);
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public int getStudentId(){
        return studentId;
    }

    public void setStudentId(int studentId){
        this.studentId = studentId;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", pib='" + pib + '\'' +
                ", course=" + course +
                '}';
    }
}