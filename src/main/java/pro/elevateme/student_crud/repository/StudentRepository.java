package pro.elevateme.student_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.elevateme.student_crud.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
