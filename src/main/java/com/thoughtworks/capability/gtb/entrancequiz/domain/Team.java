package com.thoughtworks.capability.gtb.entrancequiz.domain;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Student> studentList = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
