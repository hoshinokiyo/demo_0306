package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @GetMapping
    public String list(Model model) {
        List<TodoItem> todos = List.of(
            new TodoItem(1L, "Learn Spring Boot", false),
            new TodoItem(2L, "Create Todo list page", true),
            new TodoItem(3L, "Implement registration", false)
        );

        model.addAttribute("todos", todos);
        return "todo/list";
    }

    @GetMapping("/new")
    public String newForm() {
        return "todo/new";
    }

    @GetMapping("/confirm")
    public String confirm() {
        return "todo/confirm";
    }

    public record TodoItem(Long id, String title, boolean completed) {
    }
}
