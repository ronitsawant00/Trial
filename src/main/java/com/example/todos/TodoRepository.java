package com.example.todos;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class TodoRepository {
  private final Map<Long, Todo> store = new ConcurrentHashMap<>();
  private final AtomicLong seq = new AtomicLong();

  public List<Todo> findAll() { return new ArrayList<>(store.values()); }

  public Optional<Todo> findById(long id) { return Optional.ofNullable(store.get(id)); }

  public Todo save(String title) {
    long id = seq.incrementAndGet();
    Todo t = new Todo(id, title, false);
    store.put(id, t);
    return t;
  }

  public Optional<Todo> complete(long id) {
    return Optional.ofNullable(store.computeIfPresent(id, (k, v) -> new Todo(k, v.title(), true)));
  }
}
