package com.example.todos;

import java.util.List;

public class TodoService {
  private final TodoRepository repo;

  public TodoService(TodoRepository repo) {
    this.repo = repo;
  }

  public List<Todo> list() { return repo.findAll(); }

  public Todo add(String title) { return repo.save(title); }

  public Todo completeOrThrow(long id) {
    return repo.complete(id).orElseThrow(() -> new IllegalArgumentException("Not found: " + id));
  }
}
