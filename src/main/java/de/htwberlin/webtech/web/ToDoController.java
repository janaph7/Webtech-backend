package de.htwberlin.webtech.web;

import de.htwberlin.webtech.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin (origins ={"http://localhost:5173/", "https://webtech-frontend-ve54.onrender.com", "https://webtech-backend-6ifr.onrender.com/todos"})
@RestController
@RequestMapping("/ToDos")
public class ToDoController {
   @Autowired
    ToDoService toDoService;

    @GetMapping
    public Iterable<ToDo> getToDos() {
        return toDoService.getalltodos();
    }

    @PostMapping
    public ToDo createToDo(@RequestBody ToDo toDo) {
        return toDoService.save(toDo);
    }

}
