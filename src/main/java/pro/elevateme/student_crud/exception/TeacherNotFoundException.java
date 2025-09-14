package pro.elevateme.student_crud.exception;

public class TeacherNotFoundException extends RuntimeException {
  public TeacherNotFoundException(String message) {
    super(message);
  }
}

