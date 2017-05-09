package ua.beloff.worker;

import org.springframework.beans.factory.annotation.Autowired;
import ua.beloff.data.Student;
import ua.beloff.data.dao.StudentDao;


public class StudentsWorker {
    @Autowired
    StudentDao studentDao;

    public Student addStudent(Student Student){
        Student = studentDao.addStudent(Student);
        System.out.println(Student);
        return Student;
    }

    public Student getStudent(int id){
        return studentDao.getStudent(id);
    }

    public void saveStudent(Student student) {
        studentDao.saveStudent(student);
    }
}