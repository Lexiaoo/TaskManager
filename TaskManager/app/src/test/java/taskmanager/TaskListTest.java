package taskmanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {
    private TaskList taskList;

    @BeforeEach
    public void setUp() {
        taskList = new TaskList();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("Faire les courses");
        taskList.addTask(task);

        assertEquals(1, taskList.getTaskCount());
    }

    @Test
    public void testMarkTaskAsDone() {
        Task task1 = new Task("Faire les courses");
        Task task2 = new Task("Nettoyer la maison");

        taskList.addTask(task1);
        taskList.addTask(task2);

        taskList.markTaskAsDone(task1.getId());

        assertTrue(task1.isDone());
        assertFalse(task2.isDone());
    }

    @Test
    public void testRemoveTask() {
        Task task1 = new Task("Faire les courses");
        Task task2 = new Task("Nettoyer la maison");

        taskList.addTask(task1);
        taskList.addTask(task2);

        taskList.removeTask(task1.getId());

        assertEquals(1, taskList.getTaskCount());
        assertFalse(taskList.containsTask(task1.getId()));
    }

    @Test
    public void testDisplayTasks() {
        Task task1 = new Task("Faire les courses");
        Task task2 = new Task("Nettoyer la maison");

        taskList.addTask(task1);
        taskList.addTask(task2);

        taskList.displayTasks();
        // Vérifiez la sortie console si nécessaire
    }
}
