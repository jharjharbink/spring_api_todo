package org.example.spring_api.controleur;


import org.example.spring_api.entity.Todo;
import org.example.spring_api.service.todoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final todoService todoService;

    public TodoController(todoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo newTodo = todoService.create(todo);
        return ResponseEntity.ok(newTodo);
    }

    @PostMapping("/update")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo) {
        Todo newTodo = todoService.update(todo);
        return ResponseEntity.ok(newTodo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.ok("todo supprimé");
    }

    @GetMapping("/validated")
    public ResponseEntity<List<Todo>> validateTodo(@RequestParam boolean isValidated) {
        List<Todo> todos = todoService.validated(isValidated);
        return ResponseEntity.ok(todos);
    }

}
