package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class StudentService {
    public List<Student> getStudentList() {
        return StudentListSingletonFactory.getInstance();
    }

    public List<Team> groupStudents() {
        List<Student> studentList = this.getStudentList();

        List<Team> teamList = new ArrayList<Team>(6);
        for (int i=0; i<6; i++) {
            teamList.add(new Team());
        }

        Random random = new Random();
        for(int i = 0; i < studentList.size(); i++) {
            int randomPos = random.nextInt(studentList.size());
            Student temp = studentList.get(i);
            studentList.set(i, studentList.get(randomPos));
            studentList.set(randomPos, temp);

            teamList.get(i%6).getStudentList().add(temp);
        }
        return teamList;
    }
}
