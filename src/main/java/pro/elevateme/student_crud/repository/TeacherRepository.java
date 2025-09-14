package pro.elevateme.student_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.elevateme.student_crud.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {}

