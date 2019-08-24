//package com.rotech.employees.repositories;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import com.rotech.employees.models.Manager;
//
//@Repository
//public interface ManagerRepo extends CrudRepository<Manager, Long> {
//	@Query("SELECT m.last_name, m.first_name, e.first_name, e.last_name FROM Manager m JOIN m.employees e GROUP BY(m.id)")
//	List<String[]> findAllMtoENames();
//	@Query("SELECT m.first_name, e.last_name, m.first_name, m.last_name FROM Manager m JOIN m.employees e GROUP BY(e.id)")
//	List<String[]> findAllEtoMNames();
//	
//}
