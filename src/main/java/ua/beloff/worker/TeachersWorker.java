package ua.beloff.worker;

import org.springframework.beans.factory.annotation.Autowired;
import ua.beloff.data.Teacher;
import ua.beloff.data.dao.TeacherDao;

public class TeachersWorker {
    @Autowired
    TeacherDao lecturesDao;

    public Teacher addTeacher(Teacher lecture){
        lecture = lecturesDao.addTeacher(lecture);
        System.out.println(lecture);
        return lecture;
    }

    public Teacher getTeacher(int id){
        return lecturesDao.getTeacher(id);
    }

}
