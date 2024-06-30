package de.htwberlin.webtech;

import de.htwberlin.webtech.service.ToDoService;
import de.htwberlin.webtech.web.ToDo;
import de.htwberlin.webtech.web.ToDoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@WebMvcTest(ToDoController.class)
public class ControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoService toDoService;

    @Test
    public void testGetToDos() throws Exception {
        ToDo toDo1 = new ToDo("Title 1", "Description 1", false);
        toDo1.setId(1L);
        ToDo toDo2 = new ToDo("Title 2", "Description 2", true);
        toDo2.setId(2L);

        when(toDoService.getalltodos()).thenReturn(Arrays.asList(toDo1, toDo2));

        mockMvc.perform(get("/getToDos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Title 1"))
                .andExpect(jsonPath("$[1].title").value("Title 2"));
    }
}
