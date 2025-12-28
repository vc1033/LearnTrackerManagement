package com.airtribe.LearnTrack.service;

import com.airtribe.LearnTrack.entity.Course;
import com.airtribe.LearnTrack.exception.EntityNotFoundException;
import com.airtribe.LearnTrack.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private List<Course> courses = new ArrayList<>();

    public void addNewCourse(Course course){
        courses.add(course);
    }

    public void viewAllCourses(){
        if(courses.isEmpty()) throw new EntityNotFoundException("No Courses are available");
        else{
            System.out.println("The available courses are : ");
            courses.forEach(x -> System.out.println(x.getCourseId() + " " + x.getCourseName() + " " + x.getCourseDescription() + " " + x.getCourseDuration() + " " + x.getCourseStatus()));
        }
    }

    public Course getCourseById(int id){
        return courses.stream().filter(x -> x.getCourseId() == id).findFirst().orElseThrow(()->new EntityNotFoundException("Invalid course ID" + id));
    }

    public void deactivateCourse(int id){
        Course course = courses.stream().filter(x->x.getCourseId() == id).findFirst().orElseThrow(()->new EntityNotFoundException("The Course for the given course" + id + "doesn't exist"));
        if(course.getCourseStatus() == false) throw new InvalidInputException("Course is already in inactive state");
        course.setCourseStatus(false);
    }

    public void activateCourse(int id){
        Course course = courses.stream().filter(x->x.getCourseId() == id).findFirst().orElseThrow(()->new EntityNotFoundException("The Course for the given course" + id + "doesn't exist"));
        if(course.getCourseStatus() == true) throw new InvalidInputException("Course is already in active state");
        course.setCourseStatus(false);
    }
}
