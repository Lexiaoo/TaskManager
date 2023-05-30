package taskmanager;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
        System.out.println("Tâche ajoutée avec succès !");
    }

    public void markTaskAsDone(int taskId) {
        for (Task task : taskList) {
            if (task.getId() == taskId) {
                task.setDone(true);
                System.out.println("Tâche marquée comme terminée !");
                return;
            }
        }
        System.out.println("Aucune tâche correspondante trouvée.");
    }

    public void removeTask(int taskId) {
        for (Task task : taskList) {
            if (task.getId() == taskId) {
                taskList.remove(task);
                System.out.println("Tâche supprimée avec succès !");
                return;
            }
        }
        System.out.println("Aucune tâche correspondante trouvée.");
    }

    public void displayTasks() {
      if (taskList.isEmpty()) {
        System.out.println("Aucune tâche disponible.");
        return;
      }

      System.out.println("Liste des tâches :");
      for (Task task : taskList) {
        System.out.println(task);
      }
    }
    
    public int getTaskCount() {
      return taskList.size();
    }

    public boolean containsTask(int taskId) {
      for (Task task : taskList) {
        if (task.getId() == taskId) {
          return true;
        }
      }
      return false;
    }
}
