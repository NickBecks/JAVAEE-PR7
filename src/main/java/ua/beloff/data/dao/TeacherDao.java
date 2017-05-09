package ua.beloff.data.dao;

import ua.beloff.data.Teacher;

public interface TeacherDao {
    Teacher addTeacher(Teacher teacher);
    Teacher getTeacher(int id);
    void saveTeacher(Teacher teacher);
}
