package pro.elevateme.student_crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.elevateme.student_crud.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    public final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
}
