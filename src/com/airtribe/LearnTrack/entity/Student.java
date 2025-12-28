package com.airtribe.LearnTrack.entity;

import com.airtribe.LearnTrack.exception.InvalidInputException;
import com.airtribe.LearnTrack.util.IdGenerator;

public class Student extends Person{

    private String batch;
    private boolean active;

    public Student( String firstName ,String lastName , String email , String batch, boolean active) {
        super(IdGenerator.updateStudentId() ,firstName,lastName,email);
        this.batch = batch;
        this.active = active;
    }

    public Student(String firstName , String lastName , String batch , boolean active){
        super(IdGenerator.updateStudentId(), firstName, lastName);
            if (batch.trim().isEmpty()) throw new InvalidInputException("Batch cannot be empty");
            this.batch = batch;
            this.active = active;

    }


    public String getBatch() {
        return batch;
    }

    public boolean getStatus(){
        return active;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setFirstName(String firstName){

    }
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String getDisplayName() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public String toString() {
        return super.getId() + " " + getDisplayName() + " " + batch + " " + active;
    }

}
