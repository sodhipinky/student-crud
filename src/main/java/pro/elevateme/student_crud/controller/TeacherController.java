package pro.elevateme.student_crud.controller;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.elevateme.student_crud.model.Teacher;
import pro.elevateme.student_crud.service.TeacherService;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
  @Autowired private final TeacherService teacherService;

  public TeacherController(TeacherService teacherService) {
    this.teacherService = teacherService;
  }

  @PostMapping("/create")
  public ResponseEntity<Teacher> createTeacher(@Valid @RequestBody Teacher teacher) {
    Teacher newTeacher = teacherService.createTeacher(teacher);
    return ResponseEntity.status(HttpStatus.CREATED).body(newTeacher);
  }

  @GetMapping
  public ResponseEntity<List<Teacher>> getAllTeachers() {
    return ResponseEntity.ok(teacherService.getAllTeachers());
  }

  @GetMapping("{id}")
  public ResponseEntity<Teacher> getTeacherById(@PathVariable long id) {
    return ResponseEntity.ok(teacherService.getTeacherById(id));
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<Teacher> updateTeacher(
      @PathVariable long id, @Valid @RequestBody Teacher updatedTeacher) {
    Teacher teacher = teacherService.updateTeacher(id, updatedTeacher);
    return ResponseEntity.ok(teacher);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Map<String, String>> deleteTeacher(@PathVariable long id) {
    teacherService.deleteTeacher(id);
    Map<String, String> response = new HashMap<>();
    response.put("message", "delete teacher with id: " + id + " successfully");
    return ResponseEntity.ok(response);
  }
}
