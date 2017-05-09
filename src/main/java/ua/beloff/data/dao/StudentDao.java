package ua.beloff.data.dao;

import ua.beloff.data.Student;

public interface StudentDao {
    Student addStudent(Student student);
    Student getStudent(int id);
    void saveStudent(Student student);
}
