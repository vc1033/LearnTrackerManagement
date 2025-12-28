package com.airtribe.LearnTrack.util;

public class IdGenerator {
    private static int studentId;
    private static int courseId;
    private static int enrollmentId;

    public static int getNextStudentId(){
        return ++studentId;
    }

    public static int getNextCourseId(){
        return ++courseId;
    }

    public static int getNextEnrollmentId(){
        return ++enrollmentId;
    }


}
