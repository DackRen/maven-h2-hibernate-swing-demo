package com.zsq.service;

import com.zsq.domain.Course;
import com.zsq.domain.Student;
import com.zsq.exception.EntityException;
import com.zsq.repository.CourseRepository;
import com.zsq.repository.StudentRepository;

public class CourseService {
    private CourseRepository courseRepository = new CourseRepository();
    private StudentRepository studentRepository = new StudentRepository();

    public void registerCourse(String courseId, String studentId) throws EntityException {
        Course course = courseRepository.findOne(courseId);
        Student student = studentRepository.findOne(studentId);

        student.setCourse(courseId);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }
}
