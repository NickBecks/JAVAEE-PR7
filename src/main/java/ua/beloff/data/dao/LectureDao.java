package ua.beloff.data.dao;

import java.util.List;

import ua.beloff.data.Lecture;

public interface LectureDao {
    Lecture addLecture(Lecture lecture);
    Lecture getLecture(int id);
    List<Lecture> getLecture(String name);
    void saveLecture(Lecture lecture);
    List<Lecture> listAll();
}
