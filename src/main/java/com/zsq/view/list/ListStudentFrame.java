package com.zsq.view.list;

import com.zsq.domain.Student;
import com.zsq.repository.StudentRepository;

import java.util.Collection;


/**
 * This class lists all the students of the system.
 */
public final class ListStudentFrame extends AbstractListFrame {

    public ListStudentFrame() {
        super();
        setTitle("Lists all the students");
    }

    protected String[] getColumnNames() {
        return new String[]{"ID", "Name"};
    }

    protected String[][] getData(){
        final String[][] data;

        final Collection<Student> studentsDO;

        studentsDO = new StudentRepository().findAll();
        data = new String[studentsDO.size()][2];

        int i = 0;
        for (Student Student : studentsDO) {
            data[i][0] = Student.getId();
            data[i][1] = Student.getName();
            i++;
        }
        return data;
    }
}
