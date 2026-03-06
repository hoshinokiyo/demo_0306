package com.example.demo.service;

import java.util.List;

import com.example.demo.mapper.TodoMapper;
import com.example.demo.model.Todo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final TodoMapper todoMapper;

    public TodoService(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    public void create(Todo todo) {
        todoMapper.insert(todo);
    }

    public List<Todo> findAll() {
        return todoMapper.findAll();
    }

    public Todo findById(Long id) {
        return todoMapper.findById(id);
    }

    public boolean update(Todo todo) {
        return todoMapper.update(todo) > 0;
    }

    public boolean toggleCompleted(Long id) {
        Todo todo = todoMapper.findById(id);
        if (todo == null) {
            return false;
        }
        todo.setCompleted(!Boolean.TRUE.equals(todo.getCompleted()));
        return todoMapper.update(todo) > 0;
    }

    public boolean deleteById(Long id) {
        return todoMapper.deleteById(id) > 0;
    }
}
