package com.kovalenko.todolist.control;

import com.kovalenko.todolist.model.TodoListItem;
import com.kovalenko.todolist.repos.TodoListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class TodoListControl {

    @Autowired
    private TodoListRepo todoListRepo;

    @GetMapping
    public String get(Map<String, Object> model) {
        return findAll(model);
    }

    @PostMapping("add")
    public String add(@RequestParam String task, Map<String, Object> model) {
        if (!StringUtils.isEmpty(task)) {
            TodoListItem item = new TodoListItem(task);
            todoListRepo.save(item);
        }
        return findAll(model);
    }

    @PostMapping("delete")
    public String delete(@RequestParam Long id, Map<String, Object> model) {
        todoListRepo.deleteById(id);
        return findAll(model);
    }

    private String findAll(Map<String, Object> model) {
        Iterable<TodoListItem> listItems = todoListRepo.findAll();
        model.put("items", listItems);
        return "main";
    }
}
