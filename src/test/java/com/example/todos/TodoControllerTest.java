package com.example.todos;

import org.junit.jupiter.api.Test;

class TodoControllerTest {
  @Test void controllerWires() {
    var c = new TodoController();
    c.add(new TodoController.CreateTodo("demo"));
    assert !c.list().isEmpty();
  }
}
