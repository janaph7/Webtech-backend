package de.htwberlin.webtech.repository;

import de.htwberlin.webtech.web.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long>{

}