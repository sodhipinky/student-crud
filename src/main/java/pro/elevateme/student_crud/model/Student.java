package pro.elevateme.student_crud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "students")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotBlank(message = "Name is mandatory")
  @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
  private String name;

  @Email(message = "Email should be valid")
  @NotBlank(message = "Email is mandatory")
  private String email;

  @NotBlank(message = "Course is mandatory")
  private String course;

  @NotNull(message = "Age is mandatory")
  @Min(value = 15, message = "Age should not be less than 15")
  private Integer age;

  public Student() {}

  public Student(String name, String email, String course, Integer age) {
    this.name = name;
    this.email = email;
    this.course = course;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCourse() {
    return course;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  public long getId() {
    return id;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }

    public void setId(long id) {
        this.id = id;
    }
}
