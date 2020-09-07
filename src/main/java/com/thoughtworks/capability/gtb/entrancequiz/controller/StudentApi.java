package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Team;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentListSingletonFactory;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentApi {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudentList() {
        return StudentListSingletonFactory.getInstance();
    }

    @GetMapping("/student/teams")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public List<Team> getTeamList() {
        List<Team> teamList = studentService.groupStudents();
        return teamList;
    }
}
