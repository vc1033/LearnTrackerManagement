package com.airtribe.LearnTrack.ui;

import com.airtribe.LearnTrack.constants.EnrollmentStatus;
import com.airtribe.LearnTrack.constants.LearningTrackerOptions;
import com.airtribe.LearnTrack.entity.Course;
import com.airtribe.LearnTrack.entity.Student;
import com.airtribe.LearnTrack.exception.EntityNotFoundException;
import com.airtribe.LearnTrack.exception.InvalidInputException;
import com.airtribe.LearnTrack.service.CourseService;
import com.airtribe.LearnTrack.service.EnrollmentService;
import com.airtribe.LearnTrack.service.StudentService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService(studentService,courseService);

//        Student student1 = new Student("vaishnav","satheesh","satheesh@99","B1",true);
//        Student student2 = new Student("rohit","sharma","sharma@99","B1",true);
//         studentService.addStudent(student1);
//        studentService.addStudent(student2);
//        student2.setLastName("Rahul");
//        studentService.viewAllStudents();
//        Course course1 = new Course("Java" , "Java fundamentals",3,true);
//        Course course2 = new Course("Node" , "Node fundamentals" , 4 , true);
//        courseService.addNewCourse(course1);
//        courseService.addNewCourse(course2);
//        courseService.viewAllCourses();
//        enrollmentService.enrollStudent(1,1);
//        enrollmentService.viewEnrollments();
//        enrollmentService.updateStudentEnrollmentStatus(1, EnrollmentStatus.COMPLETED);
//        enrollmentService

        Scanner sc = new Scanner(System.in);
        int selection;

do{System.out.println("Learning Management Tracker : Please select any of the option");
    LearningTrackerOptions.options.stream().forEach(x -> System.out.println(x));
    selection = sc.nextInt();

    switch (selection)
    {
        case 1 :
            sc.nextLine();
            System.out.println("Enter Student First Name");
            String firstName = sc.nextLine();
            System.out.println("Enter Student Last Name");
            String lastName = sc.nextLine();
            System.out.println("Enter Student Email ID");
            String emailId = sc.nextLine();
            System.out.println("Enter Batch Name");
            String batchName = sc.nextLine();

            try{
                if (firstName.trim().isEmpty() || lastName.trim().isEmpty() || batchName.trim().isEmpty()) throw new InvalidInputException("Invalid Input");
                if (emailId.trim().isEmpty())
                {studentService.addStudent(new Student(firstName,lastName,batchName,true));
                }else studentService.addStudent(new Student(firstName,lastName,emailId,batchName,true));
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

            break;
        case 2 :
            try {
                System.out.println(studentService.viewAllStudents());
            }catch (EntityNotFoundException e)
            {
                System.out.println(e.getMessage());
            }
            break;
        case 3 :
            System.out.println("Enter Student ID");
            int studentIdToBeSearched = sc.nextInt();
            try{
                Student student = studentService.getStudentById(studentIdToBeSearched);
                System.out.println(student);
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            break;
        case 4 :
            System.out.println("Enter the student ID to be deactivated");
            int studentIdToBeDeactivated = sc.nextInt();
            try{
                studentService.deactivateStudent(studentIdToBeDeactivated);
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            break;
        case 5 :
            sc.nextLine();
            System.out.println("Enter Course Name");
            String courseName = sc.nextLine();
            System.out.println("Enter Course Description");
            String courseDescription = sc.nextLine();
            System.out.println("Enter Course Duration");
            int courseDuration = sc.nextInt();
            courseService.addNewCourse(new Course(courseName,courseDescription,courseDuration));
            break;
        case 6:
            try{
                courseService.viewAllCourses();
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            break;
        case 7 :
            sc.nextLine();
            System.out.println("Enter Course ID to be deactivated");
            int courseID = sc.nextInt();
            try {
                courseService.deactivateCourse(courseID);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
        case 8 :
            sc.nextLine();
            System.out.println("Enter Course ID to be activated");
            int courseIDToBeActivated = sc.nextInt();
            try {
                courseService.activateCourse(courseIDToBeActivated);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
        case 9 :
            sc.nextLine();
            System.out.println("Enter the Student ID to be enrolled");
            int studentIdToBeEnrolled = sc.nextInt();
            System.out.println("Enter the Course ID to be enrolled");
            int courseIdToBeEnrolled = sc.nextInt();
            try{
                enrollmentService.enrollStudent(studentIdToBeEnrolled,courseIdToBeEnrolled);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
        case 10 :
            sc.nextLine();
            System.out.println("Enter the Student ID");
            int enrolledStudentId = sc.nextInt();
            try{
                enrollmentService.getEnrollmentByStudentId(enrolledStudentId);
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            break;
        case 11 :
            sc.nextLine();
            System.out.println("Enter the enrollment ID");
            int enrollmentId = sc.nextInt();
            try{
                enrollmentService.updateStudentEnrollmentStatus();
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }


    }
    System.out.println();
}while(selection != 0);





    }
}
