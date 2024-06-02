package com.example.firebase_crud;

import java.util.Map;

public class User {
    private String id;
    private String name;
    private Map<String, Integer> subjectMarks; // Assuming subject marks are stored as key-value pairs (subject ->
                                               // marks)

    // Constructors, getters, setters
    public User() {
    }

    public User(String id, String name, Map<String, Integer> subjectMarks) {
        this.id = id;
        this.name = name;
        this.subjectMarks = subjectMarks;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getSubjectMarks() {
        return subjectMarks;
    }

    public void setSubjectMarks(Map<String, Integer> subjectMarks) {
        this.subjectMarks = subjectMarks;
    }
}