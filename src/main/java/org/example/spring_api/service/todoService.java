package org.example.spring_api.service;

import org.example.spring_api.dao.TodoRepository;
import org.example.spring_api.entity.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class todoService {
    private final TodoRepository todoRepository;

    public todoService(TodoRepository userRepository) {
        this.todoRepository = userRepository;
    }
    public Todo create(Todo todo){
        todo.setDate(new Date());
        return todoRepository.save(todo);
    }

    public Todo getById(long id){
        return todoRepository.findById(id).orElse(null);
    }

    public List<Todo> getAll(){
        return (List<Todo>) todoRepository.findAll();
    }

    public Todo update(Todo todo){
        todo.setDate(new Date());
        return todoRepository.save(todo);
    }

    public void delete(long id){
        Todo todo = getById(id);
        todoRepository.delete(todo);
    }

    public List<Todo> validated(boolean isValidated){
        return todoRepository.isValidated(isValidated);
    }

}

