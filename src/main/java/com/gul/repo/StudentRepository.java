package com.gul.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gul.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByEmailAndPassword(String email,String password);
	
	@Query(value = "select * from Student st where st.isDeleted='0'", nativeQuery = true)
	List<Student> listStudent();
}
