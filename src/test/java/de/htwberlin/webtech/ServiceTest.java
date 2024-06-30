package de.htwberlin.webtech;

import de.htwberlin.webtech.repository.ToDoRepository;
import de.htwberlin.webtech.service.ToDoService;
import de.htwberlin.webtech.web.ToDo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private ToDoService toDoService;

    @MockBean
    private ToDoRepository toDoRepository;

    @Test
    public void testGetAllToDos() {
        ToDo toDo1 = new ToDo("Title 1", "Description 1", false);
        toDo1.setId(1L);
        ToDo toDo2 = new ToDo("Title 2", "Description 2", true);
        toDo2.setId(2L);

        when(toDoRepository.findAll()).thenReturn(Arrays.asList(toDo1, toDo2));

        Iterable<ToDo> toDos = toDoService.getalltodos();
        List<ToDo> toDoList = (List<ToDo>) toDos;

        assertEquals(2, toDoList.size());
        assertEquals("Title 1", toDoList.get(0).getTitle());
        assertEquals("Title 2", toDoList.get(1).getTitle());
    }

    @Test
    public void testSaveToDo() {
        ToDo toDo = new ToDo("Title", "Description", false);

        when(toDoRepository.save(toDo)).thenReturn(toDo);

        ToDo savedToDo = toDoService.save(toDo);

        assertEquals("Title", savedToDo.getTitle());
        assertEquals("Description", savedToDo.getDescription());
        assertEquals(false, savedToDo.isCompleted());
    }

    @Test
    public void testGetToDo() {
        ToDo toDo = new ToDo("Title", "Description", false);
        toDo.setId(1L);

        when(toDoRepository.findById(1L)).thenReturn(java.util.Optional.of(toDo));

        ToDo retrievedToDo = toDoService.get(1L);

        assertEquals("Title", retrievedToDo.getTitle());
        assertEquals("Description", retrievedToDo.getDescription());
        assertEquals(false, retrievedToDo.isCompleted());
    }

    @Test
    public void testDeleteToDo() {
        toDoService.delete(1L);

        Mockito.verify(toDoRepository, Mockito.times(1)).deleteById(1L);
    }
}
