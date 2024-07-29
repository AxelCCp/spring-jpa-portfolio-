package jpa.hql.relations.restful_hibernate.model.dto;

import java.util.HashSet;
import java.util.Set;

import jpa.hql.relations.restful_hibernate.model.entity.Course;

public class StudentCoursesDto {

    private String studentName;
    private Set<Course>courses;

    public StudentCoursesDto() {
        this.courses = new HashSet<>();
    }

    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public Set<Course> getCourses() {
        return courses;
    }
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    

}
