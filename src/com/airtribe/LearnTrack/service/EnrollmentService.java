package com.airtribe.LearnTrack.service;

import com.airtribe.LearnTrack.constants.EnrollmentStatus;
import com.airtribe.LearnTrack.entity.Course;
import com.airtribe.LearnTrack.entity.Enrollment;
import com.airtribe.LearnTrack.entity.Student;
import com.airtribe.LearnTrack.exception.EntityNotFoundException;
import com.airtribe.LearnTrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {
    private List<Enrollment> enrollments = new ArrayList<>();
    StudentService studentService = new StudentService();
    CourseService courseService = new CourseService();

    public EnrollmentService(StudentService studentService , CourseService courseService){
        this.studentService = studentService;
        this.courseService = courseService;
    }
    public void enrollStudent(int studentId , int courseId){
        Student student = studentService.getStudentById(studentId);
        Course course = courseService.getCourseById(courseId);
        enrollments.add(new Enrollment(IdGenerator.updateEnrollmentId(),studentId,courseId));
    }

    public void viewEnrollments(){
        if(enrollments.isEmpty()) throw new EntityNotFoundException("No Enrollments are available");
        else{
            System.out.println("The available Enrollments are : ");
            enrollments.forEach(x -> System.out.println(x.getEnrollmentId() + " " + studentService.getStudentById(x.getStudentId()).getDisplayName() + " " + courseService.getCourseById(x.getCourseId()).getCourseName() + " " + x.getEnrollmentDate() + " " + x.getStatus()));
        }
    }

    public Enrollment getEnrollmentById(int id)
    {
        return enrollments.stream().filter(x -> x.getEnrollmentId() == id).findFirst().orElseThrow(()->new EntityNotFoundException("Enrollmetn ID doesn't exist"));
    }

    public void getEnrollmentByStudentId(int studentId){
        Enrollment enrollment = enrollments.stream().filter(x->x.getStudentId() == studentId).findFirst().orElseThrow(()->new EntityNotFoundException("Student hasn't enrolled into any course"));
        System.out.println(enrollment.getEnrollmentId() + " " + studentService.getStudentById(studentId) + " " + courseService.getCourseById(enrollment.getCourseId()) + enrollment.getStatus());
    }

    public void updateStudentEnrollmentStatus(int id , EnrollmentStatus status){
        Enrollment enrollment = getEnrollmentById(id);
        enrollment.setEnrollmentStatus(status);
    }
}
