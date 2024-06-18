package de.htwberlin.webtech.service;

import de.htwberlin.webtech.repository.ToDoRepository;
import de.htwberlin.webtech.web.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
    @Autowired
    ToDoRepository toDoRepository;

    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public ToDo get(Long id) {
        return toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo not found"));
    }
}