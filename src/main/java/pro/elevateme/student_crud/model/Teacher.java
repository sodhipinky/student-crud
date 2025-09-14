package pro.elevateme.student_crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public Long getId() {
    return id;
  }

  @NotBlank(message = "Name is manditory")
  private String name;

  @Email(message = "email should be valid")
  @NotBlank(message = "Email is manditory")
  private String email;

  @Size(min = 1, message = "Atleast one course must be selected")
  private List<String> courses;

  @NotNull(message = "Age is manditory")
  @Min(value = 25, message = "Age should not be less the 25")
  private Integer age;

  public Teacher() {}

  public Teacher(String name, String email, List<String> courses, Integer age) {
    this.name = name;
    this.email = email;
    this.courses = courses;
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

  public List<String> getCourses() {
    return courses;
  }

  public void setCourses(List<String> courses) {
    this.courses = courses;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
