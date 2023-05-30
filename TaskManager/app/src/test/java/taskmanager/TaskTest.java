package taskmanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    public void testTaskInitialization() {
        Task task = new Task("Faire les courses");

        assertFalse(task.isDone());
        assertEquals("Faire les courses", task.getDescription());
    }

    @Test
    public void testTaskMarkAsDone() {
        Task task = new Task("Faire les courses");

        assertFalse(task.isDone());

        task.setDone(true);

        assertTrue(task.isDone());
    }
}
