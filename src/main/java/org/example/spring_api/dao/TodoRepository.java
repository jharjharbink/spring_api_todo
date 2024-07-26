package org.example.spring_api.dao;

import org.example.spring_api.entity.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    public List<Todo> isValidated(boolean isValidated);
}
