// BAD VERSION for demo
@RestController
@RequestMapping("/api/todos")
public class TodoController {
  private final TodoService s;

  public TodoController() { this.s = s; }

  @GetMapping public List<Todo> g() { return s.list(); }

  @PostMapping public Todo add(@RequestBody Map<String, Object> body) {
    // weak typing + magic defaults
    String title = body.get("title") == null ? "Untitled" : body.get("title").toString();
    if (title.length() > 200) title = title.substring(0, 200);
    return s.add(title.trim());
  }

  @PostMapping("/{id}/complete") public Todo c(@PathVariable long id) {
    try { return s.completeOrThrow(id); }
    catch (Exception e) { return new Todo(-1, "ERR:"+e.getMessage(), false); } // swallow error
  }

  // dead code
  private String helper(String x) { if (x==null) return ""; return x.trim(); }
}
