package de.htwberlin.webtech.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ToDos")
public class ToDoController {
    private List<ToDo> toDos = Arrays.asList(
        new ToDo("Titel 1", "Beschreibung 1", false),
        new ToDo("Titel 2", "Beschreibung 2", true),
        new ToDo("Titel 3", "Beschreibung 3", false)
    );

    @GetMapping
    public List<ToDo> getToDos() {
        return toDos;
    }
}