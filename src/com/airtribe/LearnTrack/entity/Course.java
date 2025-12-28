package com.airtribe.LearnTrack.entity;

import com.airtribe.LearnTrack.util.IdGenerator;

public class Course {

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDurationinWeeks(int durationinWeeks) {
        this.durationinWeeks = durationinWeeks;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCourseStatus(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return  courseId +
                " " + courseName  +
                " " + description +
                " " + durationinWeeks +
                " " + active;
    }

    private int courseId;
    private String courseName;
    private String description;
    private int durationinWeeks;
    private boolean active;

    public Course( String courseName, String description, int durationinWeeks) {
        this.courseId = IdGenerator.updateCourseId();
        this.courseName = courseName;
        this.description = description;
        this.durationinWeeks = durationinWeeks;
        this.active = true;
    }
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDescription() {
        return description;
    }

    public int getCourseDuration(){
        return  durationinWeeks;
    }

    public boolean getCourseStatus(){
        return active;
    }
    public boolean isActive() {
        return active;
    }

    public void deactivateCourse() {
        this.active = false;
    }
}
