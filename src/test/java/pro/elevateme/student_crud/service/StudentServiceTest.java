package pro.elevateme.student_crud.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.elevateme.student_crud.model.Student;
import pro.elevateme.student_crud.repository.StudentRepository;

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
}