package de.htwberlin.webtech.web;

import de.htwberlin.webtech.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin (origins ={"http://localhost:5173/d", "https://webtech-frontend-ve54.onrender.com", "https://webtech-backend-6ifr.onrender.com/ToDos"})
@RestController
@RequestMapping("/ToDos")
public class ToDoController {
   @Autowired
    ToDoService toDoService;

    @GetMapping
    public Iterable<ToDo> getToDos() {
        return toDoService.getalltodos();
    }
}
