package com.airtribe.LearnTrack.entity;

import com.airtribe.LearnTrack.util.IdGenerator;


public class Instructor extends Person{

    public Instructor(int id ,String firstName , String lastName , String email){
        super(id , firstName , lastName , email);
    }
    @Override
    public String getDisplayName() {
        return "Instructor is" + super.getFirstName() + super.getLastName();
    }

}
