package pro.elevateme.student_crud.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.elevateme.student_crud.repository.StudentRepository;

@ExtendWith(MockitoExtension.class) // Use Mockito's extension for JUnit 5
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;    // Mock the repository

    @InjectMocks
    private StudentService studentService; // Inject the mock into the service

    @Test
    void createStudent() {
    }
}