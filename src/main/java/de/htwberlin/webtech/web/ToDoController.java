package de.htwberlin.webtech.web;

import de.htwberlin.webtech.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @GetMapping
    @RequestMapping("/getTodos")
    public Iterable<ToDo> getToDos() {
        return toDoService.getalltodos();
    }

    @PostMapping
    @RequestMapping("/ToDos")
    public ToDo createToDo(@RequestBody ToDo toDo) {
        return toDoService.save(toDo);
    }

    @DeleteMapping
    @RequestMapping("deleteTodos/{id}")
    public void deleteToDo(@PathVariable String id) {
        Long entryId = Long.parseLong(id);
        toDoService.delete(entryId);
    }

    @PostMapping
    @RequestMapping("toggleCompleted/{id}")
    public ToDo toggleCompleted(@RequestBody ToDo toDo, @PathVariable String id) {
        Long entryId = Long.parseLong(id);
        toDoService.delete(entryId);
        return toDoService.save(toDo);
    }
}