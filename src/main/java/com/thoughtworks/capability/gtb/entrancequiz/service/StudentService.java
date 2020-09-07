package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class StudentService {
    public List<Student> getStudentList() {
        return StudentListSingletonFactory.getInstance();
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

        List<Team> teamList = new ArrayList<Team>(6);
        for (int i=0; i<6; i++) {
            teamList.add(new Team());
        }

        Collections.shuffle(newStudentList);
        for(int i = 0; i < newStudentList.size(); i++) {
            teamList.get(i%6).getStudentList().add(newStudentList.get(i));
        }
        return teamList;
    }
}
