package pro.elevateme.student_crud.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.elevateme.student_crud.exception.TeacherNotFoundException;
import pro.elevateme.student_crud.model.Teacher;
import pro.elevateme.student_crud.repository.TeacherRepository;

@Service
public class TeacherService {
  @Autowired private final TeacherRepository teacherRepository;

  public TeacherService(TeacherRepository teacherRepository) {
    this.teacherRepository = teacherRepository;
  }

  // CREATE
  public Teacher createTeacher(Teacher teacher) {
    return teacherRepository.save(teacher);
  }

  // READ ALL
  public List<Teacher> getAllTeachers() {
    return teacherRepository.findAll();
  }

  // READ ONE
  public Teacher getTeacherById(long id) {
    return teacherRepository
        .findById(id)
        .orElseThrow(() -> new TeacherNotFoundException("Teacher not found with id: " + id));
  }

  // UPDATE
  public Teacher updateTeacher(long id, Teacher updatedTeacher) {
    Teacher existingTeacher = getTeacherById(id);
    existingTeacher.setName(updatedTeacher.getName());
    existingTeacher.setEmail(updatedTeacher.getEmail());
    existingTeacher.setCourses(updatedTeacher.getCourses());
    existingTeacher.setAge(updatedTeacher.getAge());
    return teacherRepository.save(existingTeacher);
  }

  // DELETE
  public void deleteTeacher(long id) {
    Teacher existingTeacher = getTeacherById(id);
    teacherRepository.delete(existingTeacher);
  }
}
