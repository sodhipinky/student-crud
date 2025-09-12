package pro.elevateme.student_crud.controller;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.elevateme.student_crud.model.Student;
import pro.elevateme.student_crud.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

  @Autowired private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  // CREATE
  @PostMapping("/create")
  public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
    Student newStudent = studentService.createStudent(student);
    return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
  }

  // READ ALL
  @GetMapping
  public ResponseEntity<List<Student>> getAllStudents() {
    return ResponseEntity.ok(studentService.getAllStudents());
  }

  // READ BY ID
  @GetMapping("/{id}")
  public ResponseEntity<Student> getStudentById(@PathVariable long id) {
    Student student = studentService.getStudentById(id);
    return ResponseEntity.ok(student);
  }

  // UPDATE
  @PutMapping("update/{id}")
  public ResponseEntity<Student> updateStudent(
      @PathVariable long id, @Valid @RequestBody Student updatedStudent) {
    Student student = studentService.updateStudent(id, updatedStudent);
    return ResponseEntity.ok(student);
  }

  // DELETE
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Map<String, String>> deleteStudent(@PathVariable long id) {
    studentService.deleteStudent(id);

    Map<String, String> response = new HashMap<>();
    response.put("message", "Student with ID " + id + " has been deleted.");

    return ResponseEntity.ok(response);
  }
}
