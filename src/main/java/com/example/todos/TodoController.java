package com.example.todos;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
  private final TodoService service;

  public TodoController() {
    this.service = new TodoService(new TodoRepository());
  }

  @GetMapping public List<Todo> list() { return service.list(); }

  @PostMapping public Todo add(@RequestBody CreateTodo body) { return service.add(body.title()); }

  @PostMapping("/{id}/complete") public Todo complete(@PathVariable long id) { return service.completeOrThrow(id); }

  public record CreateTodo(String title) {}
}
