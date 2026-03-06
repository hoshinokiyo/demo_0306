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
            new TodoItem(1L, "Spring Bootの学習", false),
            new TodoItem(2L, "ToDo一覧画面を作成", true),
            new TodoItem(3L, "登録機能を実装", false)
        );

        model.addAttribute("todos", todos);
        return "todo/list";
    }

    public record TodoItem(Long id, String title, boolean completed) {
    }
}
