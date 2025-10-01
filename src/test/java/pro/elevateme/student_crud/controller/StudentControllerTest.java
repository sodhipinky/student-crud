package pro.elevateme.student_crud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import pro.elevateme.student_crud.model.Student;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired  // Inject MockMvc to simulate HTTP requests
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;  // For converting objects to/from JSON

    @Test
    void getAllStudents() throws Exception {
        mockMvc.perform(get("/api/students"))           // Perform a GET request to the /api/students endpoint
                .andExpect(status().isOk())                         // Expect HTTP 200 OK status
                .andExpect(jsonPath("$").isArray());    // Expect the response to be a JSON array
    }

    @Test
    void createStudent() throws Exception {
        // Prepare a new student object
        Student newStudent = new Student();
        newStudent.setName("John Doe");
        newStudent.setEmail("john@example.com");
        newStudent.setCourse("Computer Science");
        newStudent.setAge(20);

        // convert the student object to JSON
        String studentJson = objectMapper.writeValueAsString(newStudent);

        // Perform a POST request to create the student
        mockMvc.perform(post("/api/students/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value(newStudent.getName()))
                .andExpect(jsonPath("$.email").value(newStudent.getEmail()))
                .andExpect(jsonPath("$.course").value(newStudent.getCourse()))
                .andExpect(jsonPath("$.age").value(newStudent.getAge()));
    }
}