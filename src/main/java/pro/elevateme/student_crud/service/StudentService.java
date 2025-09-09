package pro.elevateme.student_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.elevateme.student_crud.exception.StudentNotFoundException;
import pro.elevateme.student_crud.model.Student;
import pro.elevateme.student_crud.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //CREATE
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    //READ ALL
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //READ BY ID
    public Student getStudentById(long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    //UPDATE
    public Student updateStudent(long id, Student updatedStudent) {
        Student existingStudent = getStudentById(id);
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setCourse(updatedStudent.getCourse());
        return studentRepository.save(existingStudent);
    }

    //DELETE
    public void deleteStudent(long id) {
        Student existingStudent = getStudentById(id);
        studentRepository.delete(existingStudent);
    }
}
