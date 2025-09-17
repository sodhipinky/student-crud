package pro.elevateme.student_crud.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Object>> handleValidationErrors(
      MethodArgumentNotValidException exception) {
    List<String> errors =
        exception.getBindingResult().getFieldErrors().stream()
            .map(error -> error.getField() + ": " + error.getDefaultMessage())
            .toList();

    Map<String, Object> response = new HashMap<>();
    response.put("timestamp", new Date());
    response.put("status", HttpStatus.BAD_REQUEST.value());
    response.put("errors", errors);

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({
    DataAccessResourceFailureException.class,
    CannotCreateTransactionException.class
  })
  public ResponseEntity<Map<String, Object>> handleCannotGetJdbcConnection(Exception ex) {
    Map<String, Object> response = new HashMap<>();
    response.put("timestamp", new Date());
    response.put("status", HttpStatus.SERVICE_UNAVAILABLE.value());
    response.put("error", "Database unavailable. Please try again later.");
    response.put("details", ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
  }

  @ExceptionHandler(StudentNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handleStudentNotFound(
      StudentNotFoundException exception) {
    Map<String, Object> response = new HashMap<>();
    response.put("timestamp", new Date());
    response.put("status", HttpStatus.NOT_FOUND.value());
    response.put("error", exception.getMessage());

    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(TeacherNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handleTeacherNotFound(
      TeacherNotFoundException exception) {
    Map<String, Object> response = new HashMap<>();
    response.put("timestamp", new Date());
    response.put("status", HttpStatus.NOT_FOUND.value());
    response.put("error", exception.getMessage());

    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }
}
