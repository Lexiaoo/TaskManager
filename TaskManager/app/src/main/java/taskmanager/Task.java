package taskmanager;

class Task {
  private int id;
  private String description;
  private boolean isDone;
  
  private static int nextId = 1;
  
  public Task(String description) {
      this.id = nextId++;
      this.description = description;


      this.isDone = false;
  }
  
  public int getId() {
      return id;
  }
  
  public String getDescription() {
      return description;
  }
  
  public boolean isDone() {
      return isDone;
  }
  
  public void setDone(boolean done) {
      isDone = done;
  }
  
  @Override
  public String toString() {
      String status = isDone ? "Terminée" : "En cours";
      return "Tâche #" + id + " : " + description + " (" + status + ")";
  }
}
