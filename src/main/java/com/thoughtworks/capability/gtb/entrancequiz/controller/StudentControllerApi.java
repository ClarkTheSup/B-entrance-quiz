package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Team;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentListSingletonFactory;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import com.thoughtworks.capability.gtb.entrancequiz.service.TeamListSingletonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentControllerApi {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudentList() {
        return StudentListSingletonFactory.getInstance();
    }

    @PostMapping("/student/{name}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@PathVariable String name) {
        studentService.addStudent(name);
    }

    @GetMapping("/student/teams")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public List<Team> getTeamList() throws Exception{
        return TeamListSingletonFactory.getInstance();
    }

    @PostMapping("/student/teams")
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public List<Team> createTeamList() throws Exception{
        List<Team> teamList = studentService.groupStudents();
        return teamList;
    }

    @PostMapping("/student/teams/{index}/{name}")
    @CrossOrigin
    public ResponseEntity changeTeamName(@PathVariable int index, @PathVariable String name) {
        try {
            studentService.changeTeamName(index, name);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception exception) {
            return ResponseEntity.status(409).build();
        }
    }
}
