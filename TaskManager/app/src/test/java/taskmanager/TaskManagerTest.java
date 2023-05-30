package taskmanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {
    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("Faire les courses");
        taskManager.addTask(task);

        assertEquals(1, taskManager.getTaskCount());
    }

    @Test
    public void testMarkTaskAsDone() {
        Task task1 = new Task("Faire les courses");
        Task task2 = new Task("Nettoyer la maison");

        taskManager.addTask(task1);
        taskManager.addTask(task2);

        taskManager.markTaskAsDone(task1.getId());

        assertTrue(task1.isDone());
        assertFalse(task2.isDone());
    }

    @Test
    public void testRemoveTask() {
        Task task1 = new Task("Faire les courses");
        Task task2 = new Task("Nettoyer la maison");

        taskManager.addTask(task1);
        taskManager.addTask(task2);

        taskManager.removeTask(task1.getId());

        assertEquals(1, taskManager.getTaskCount());
        assertFalse(taskManager.containsTask(task1.getId()));
    }
}
