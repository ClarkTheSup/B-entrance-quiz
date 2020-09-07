package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentListSingletonFactory {
    private static List<Student> studentList = new ArrayList<Student>();
    private StudentListSingletonFactory() {}

    public static List<Student> getInstance() {
        return studentList;
    }

    static {
        studentList.add(new Student(1, "沈乐棋"));studentList.add(new Student(2, "徐慧慧"));
        studentList.add(new Student(3, "陈思聪"));studentList.add(new Student(4, "王江林"));
        studentList.add(new Student(5, "王登宇"));studentList.add(new Student(6, "杨思雨"));
        studentList.add(new Student(7, "江雨舟"));studentList.add(new Student(8, "廖燊"));
        studentList.add(new Student(9, "胡晓"));studentList.add(new Student(10, "但杰"));
        studentList.add(new Student(11, "盖迈达"));studentList.add(new Student(12, "肖美琦"));
        studentList.add(new Student(13, "黄云洁"));studentList.add(new Student(14, "齐瑾浩"));
        studentList.add(new Student(15, "刘亮亮"));studentList.add(new Student(16, "肖逸凡"));
        studentList.add(new Student(17, "王作文"));studentList.add(new Student(18, "郭瑞凌"));
        studentList.add(new Student(19, "李明豪"));studentList.add(new Student(20, "党泽"));
        studentList.add(new Student(21, "肖伊佐"));studentList.add(new Student(22, "贠晨曦"));
        studentList.add(new Student(23, "李康宁"));studentList.add(new Student(24, "马庆"));
        studentList.add(new Student(25, "商婕"));studentList.add(new Student(26, "余榕"));
        studentList.add(new Student(27, "谌哲"));studentList.add(new Student(28, "董翔锐"));
        studentList.add(new Student(29, "陈泰宇"));studentList.add(new Student(30, "赵允齐"));
        studentList.add(new Student(31, "张柯"));studentList.add(new Student(32, "廖文强"));
        studentList.add(new Student(33, "刘轲"));studentList.add(new Student(34, "廖浚斌"));
        studentList.add(new Student(35, "凌凤仪"));
    }


}
