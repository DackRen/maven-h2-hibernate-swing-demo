package com.zsq.domain;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student implements java.io.Serializable{
    @Id
    private String id;
    private String name;

    private String course_id;

    public Student(){
    }

    public Student(String id ,String name) {
        this.id = id;
        this.name = name;
    }


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

    public String getCourse() {
        return course_id;
    }

    public void setCourse(String course) {
        this.course_id = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name +
                '}';
    }
}
