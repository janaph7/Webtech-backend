package de.htwberlin.webtech.web;

import de.htwberlin.webtech.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController()
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @CrossOrigin
    @GetMapping("/getToDos")
    public Iterable<ToDo> getToDos() {
        return toDoService.getalltodos();
    }

    @CrossOrigin
    @PostMapping("/ToDos")
    public ToDo createToDo(@RequestBody ToDo toDo) {
        return toDoService.save(toDo);
    }

    @CrossOrigin
    @DeleteMapping("deleteToDos/{id}")
    public void deleteToDo(@PathVariable String id) {
        Long entryId = Long.parseLong(id);
        toDoService.delete(entryId);
    }

    @CrossOrigin
    @PostMapping("toggleCompleted/{id}")
    public ToDo toggleCompleted(@RequestBody ToDo toDo, @PathVariable String id) {
        Long entryId = Long.parseLong(id);
        toDoService.delete(entryId);
        return toDoService.save(toDo);
    }

}