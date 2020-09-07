package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudentList() {
        return StudentListSingletonFactory.getInstance();
    }

    public List<Team> getTeamList() {
        return TeamListSingletonFactory.getInstance();
    }

    public List<Team> groupStudents() {
        List<Student> studentList = this.getStudentList();
        List<Student> newStudentList = new ArrayList<Student>();
        ObjectMapper objectMapper = new ObjectMapper();
        studentList.stream().forEach((student)->{
            try {
                Student newStudent = objectMapper.readValue(
                        objectMapper.writeValueAsString(student), Student.class);
                newStudentList.add(newStudent);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

        List<Team> teamList = this.getTeamList();
        for(Team team: teamList) {
            team.getStudentList().clear();
        }
        Collections.shuffle(newStudentList);
        for(int i = 0; i < newStudentList.size(); i++) {
            teamList.get(i%6).getStudentList().add(newStudentList.get(i));
        }
        return teamList;
    }

    public void addStudent(String name) {
        List<Student> studentList = this.getStudentList();
        studentList.add(new Student(studentList.size()+1, name));
    }

    public void changeTeamName(int index, String newName) {
        List<Team> teamList = this.getTeamList();
        teamList.forEach((team -> {
            if (team.getName().equals(newName)) {
                throw new RuntimeException();
            }
        }));
        teamList.get(index).setName(newName);
    }
}
