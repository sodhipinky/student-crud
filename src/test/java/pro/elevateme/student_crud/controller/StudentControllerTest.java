package pro.elevateme.student_crud.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired  // Inject MockMvc to simulate HTTP requests
    private MockMvc mockMvc;

    @Test
    void getAllStudents() throws Exception {
        mockMvc.perform(get("/api/students"))           // Perform a GET request to the /api/students endpoint
                .andExpect(status().isOk())                         // Expect HTTP 200 OK status
                .andExpect(jsonPath("$").isArray());    // Expect the response to be a JSON array
    }
}