package com.airtribe.LearnTrack.service;

import com.airtribe.LearnTrack.entity.Student;
import com.airtribe.LearnTrack.exception.EntityNotFoundException;
import com.airtribe.LearnTrack.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (student.getDisplayName().trim().isEmpty() || student.getBatch().trim().isEmpty())
            throw new InvalidInputException("Invalid Input");
        try {
            students.add(student);

        } catch (Exception e) {
            throw new InvalidInputException("Invalid Input");
        }
    }

    public void viewAllStudents() {
        if (students.isEmpty()) throw new EntityNotFoundException("No Students are added");
        else {
            System.out.println("Students are as follows :- ");
            System.out.println("ID Name Batch Status");
            students.forEach(x -> System.out.println(x.getId() + " " + x.getDisplayName() + " " + x.getBatch() + " " + x.getStatus()));
        }
    }

    public Student getStudentById(int id) {
        return students.stream().filter(x -> x.getId() == id).findFirst().orElseThrow(() -> new EntityNotFoundException("Student with  ID " + id + " doesn't exist"));
    }

    public void deactivateStudent(int id) {

        Student student = getStudentById(id);
        student.setActive(false);
    }
}
