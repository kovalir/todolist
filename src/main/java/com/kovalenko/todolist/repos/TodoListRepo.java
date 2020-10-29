package com.kovalenko.todolist.repos;


import com.kovalenko.todolist.model.TodoListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepo extends JpaRepository<TodoListItem, Long> {
}
