package taskmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
  private List<Task> taskList;

  public TaskManager() {
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

  public static void main(String[] args) {
    TaskManager taskManager = new TaskManager();
    Scanner scanner = new Scanner(System.in);

    boolean running = true;
    while (running) {
      System.out.println("===== Gestionnaire de tâches =====");
      System.out.println("1. Ajouter une tâche");
      System.out.println("2. Marquer une tâche comme terminée");
      System.out.println("3. Supprimer une tâche");
      System.out.println("4. Afficher la liste des tâches");
      System.out.println("5. Quitter");
      System.out.print("Choisissez une action : ");

      int choice = scanner.nextInt();
      scanner.nextLine(); // Clear the newline character

      switch (choice) {
        case 1:
          System.out.print("Entrez la description de la tâche : ");
          String description = scanner.nextLine();
          Task task = new Task(description);
          taskManager.addTask(task);
          break;
        case 2:
          System.out.print("Entrez l'ID de la tâche à marquer comme terminée : ");
          int taskId = scanner.nextInt();
          taskManager.markTaskAsDone(taskId);
          break;
        case 3:
          System.out.print("Entrez l'ID de la tâche à supprimer : ");
          taskId = scanner.nextInt();
          taskManager.removeTask(taskId);
          break;
        case 4:
          taskManager.displayTasks();
          break;
        case 5:
          running = false;
          break;
        default:
          System.out.println("Action invalide.");
      }

      System.out.println();
    }

    System.out.println("Merci d'avoir utilisé le gestionnaire de tâches !");
    scanner.close();
  }
}