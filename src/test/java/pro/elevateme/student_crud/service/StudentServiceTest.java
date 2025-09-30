package pro.elevateme.student_crud.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.elevateme.student_crud.model.Student;
import pro.elevateme.student_crud.repository.StudentRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Use Mockito's extension for JUnit 5
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;    // Mock the repository

    @InjectMocks
    private StudentService studentService; // Inject the mock into the service

    @Test
    void testCreateStudent() {
        // Arrange: Create a mock student and tell Mockito what to return when save is called
        Student student = new Student("Alice", "alice@example.com", "Software Engineering", 24);
        when(studentRepository.save(any())).thenReturn(new Student("Alice", "alice@example.com", "Software Engineering", 24));

        // Act: Call the service method
        Student savedStudent = studentService.createStudent(student);

        // Assert: Check that the returned student is as expected
        assertEquals("Alice", savedStudent.getName());

        // Verify: Ensure that the repository's save method was called
        verify(studentRepository).save(student);
    }

    @Test
    void testGetStudentById() {
        // Arrange: Create a mock student and tell Mockito what to return when findById is called
        long studentId = 1L;
        Student student = new Student("Bob", "bob@example.com", "Mathematics", 22);
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student).map(s -> {
            s.setId(studentId);
            return s;
        }));

        // Act: Call the service method
        Student foundStudent = studentService.getStudentById(studentId);

        // Assert: Check that the returned student is as expected
        assertEquals(1, foundStudent.getId());
        assertEquals("Bob", foundStudent.getName());

        // Verify: Ensure that the repository's findById method was called
        verify(studentRepository).findById(studentId);
    }
}