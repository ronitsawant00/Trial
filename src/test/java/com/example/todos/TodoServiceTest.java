package com.example.todos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TodoServiceTest {
  @Test void addAndList() {
    var svc = new TodoService(new TodoRepository());
    var t = svc.add("hello");
    assertEquals("hello", t.title());
    assertEquals(1, svc.list().size());
  }

  @Test void completeOrThrow() {
    var svc = new TodoService(new TodoRepository());
    var t = svc.add("x");
    var c = svc.completeOrThrow(t.id());
    assertTrue(c.completed());
  }
}
