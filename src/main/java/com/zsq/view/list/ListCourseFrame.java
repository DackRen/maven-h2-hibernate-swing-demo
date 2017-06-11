package com.zsq.view.list;

import com.zsq.domain.Course;
import com.zsq.domain.Student;
import com.zsq.repository.CourseRepository;

import java.util.Collection;


/**
 * This class lists all the courses of the system.
 */
public final class ListCourseFrame extends AbstractListFrame {
    public ListCourseFrame() {
        super();
        setTitle("Lists all the courses");
    }

    protected String[] getColumnNames() {
        return new String[]{"ID", "Name", "Students"};
    }

    protected String[][] getData(){
        final String[][] data;

        final Collection<Course> CoursesDO;

        CoursesDO = new CourseRepository().findAll();
        data = new String[CoursesDO.size()][3];

        int i = 0;
        for (Course course : CoursesDO) {
            data[i][0] = course.getId();
            data[i][1] = course.getName();
            StringBuilder studentLists = new StringBuilder();
            for (Student student : course.getStudents()) {
                studentLists.append(student.getName()).append(", ");
            }
            data[i][2] = studentLists.toString();
            i++;
        }
        return data;
    }
}
