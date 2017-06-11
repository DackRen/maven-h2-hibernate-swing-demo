package com.zsq.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course implements java.io.Serializable{
    @Id
    private String id;
    private String name;
    @OneToMany
    @JoinColumn(name="course_id")
    private List<Student> students;

    public Course() {}

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course(String id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
