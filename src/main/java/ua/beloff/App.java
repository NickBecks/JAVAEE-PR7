package ua.beloff;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.beloff.data.Lecture;
import ua.beloff.data.Student;
import ua.beloff.data.Teacher;
import ua.beloff.worker.LecturesWorker;
import ua.beloff.worker.StudentsWorker;
import ua.beloff.worker.TeachersWorker;
import java.util.Date;


public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        LecturesWorker lecturesWorker = (LecturesWorker) context.getBean("lecturesWorker");
        StudentsWorker studentsWorker = (StudentsWorker) context.getBean("studentsWorker");
        TeachersWorker teachersWorker = (TeachersWorker) context.getBean("teachersWorker");

        Student me = new Student("Nick Belov", 3);

        Teacher teacher = new Teacher();
        teacher.setFirstname("Natalya");
        teacher.setLastname("Gulaeva");
        teacher.setCellphone("+380675097865");
        teacher.setBirthDate(new Date());

        studentsWorker.addStudent(me);

        Lecture OBDZ = new Lecture();
        OBDZ.setCredits(4);
        OBDZ.setName("OBDZ");
        OBDZ.setTeacher(teacher);
        OBDZ.addStudent(me);
        me.addLecture(OBDZ);
        teachersWorker.addTeacher(teacher);
        lecturesWorker.addLecture(OBDZ);
        studentsWorker.saveStudent(me);

        Lecture ch = lecturesWorker.getLecture(1);
        System.out.println(ch);
        ch = lecturesWorker.getLecture(1);
        System.out.println(ch);
    

    }
}
