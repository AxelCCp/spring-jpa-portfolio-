package jpa.hql.relations.restful_hibernate.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpa.hql.relations.restful_hibernate.model.dao.CourseDao;
import jpa.hql.relations.restful_hibernate.model.dao.StudentDao;
import jpa.hql.relations.restful_hibernate.model.dto.StudentCoursesDto;
import jpa.hql.relations.restful_hibernate.model.entity.Course;
import jpa.hql.relations.restful_hibernate.model.entity.Student;

@RestController
@RequestMapping("/student")
public class StudentRest {

    @GetMapping("/list")
    public ResponseEntity<?> getList() {
        return ResponseEntity.ok().body(this.studentDao.findAll());
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody List<StudentCoursesDto> studentCourses) {

        List<Student> studentList = new ArrayList<>();
        for(StudentCoursesDto st_dto : studentCourses){
            Student st = new Student();
            st.setName(st_dto.getStudentName());
            for(Course c : st_dto.getCourses()){
                st.addCourse(c);
            }
            studentList.add(st);
        }
        return ResponseEntity.ok().body(this.studentDao.saveAll(studentList));
    }


    @DeleteMapping("del-course/{idStudent}/{idCourse}")
    public ResponseEntity<?> deleteCourseFromStudent(@PathVariable Long idStudent, @PathVariable Long idCourse) {
        Optional<Student> opSt = this.studentDao.findById(idStudent);
        if(opSt.isPresent()){
            Optional<Course> opCourse = this.courseDao.findById(idCourse);
            if(opCourse.isPresent()){
                Student studentDB = opSt.get();
                studentDB.getCourses().remove(opCourse.get());
                return ResponseEntity.ok().body(Optional.of(this.studentDao.save(studentDB)));
            }
        }
        return ResponseEntity.badRequest().body("No se encontró registro de worker");
    }

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CourseDao courseDao;
}
