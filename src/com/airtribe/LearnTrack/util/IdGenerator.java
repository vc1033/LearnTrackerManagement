package com.airtribe.LearnTrack.util;

public class IdGenerator {
    private static int studentId;
    private static int courseId;
    private static int enrollmentId;

    public static int updateStudentId(){
        return ++studentId;
    }

    public static int updateCourseId(){
        return ++courseId;
    }

    public static int updateEnrollmentId(){
        return ++enrollmentId;
    }

}
