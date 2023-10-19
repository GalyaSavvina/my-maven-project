import com.example.ListContainer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListContainerTest {
    /**
     * Тест метода add и size
     */
    @Test
    public void testAddAndSize() {
        ListContainer<String> container = new ListContainer<>();
        assertEquals(0, container.size());

        container.add("Item 1");
        assertEquals(1, container.size());

        container.add("Item 2");
        assertEquals(2, container.size());
    }

    /**
     * Тест метода get
     */
    @Test
    public void testGet() {
        ListContainer<String> container = new ListContainer<>();
        container.add("Item 1");
        container.add("Item 2");

        assertEquals("Item 1", container.get(0));
        assertEquals("Item 2", container.get(1));
        assertNull(container.get(2));
    }

    /**
     * Тест метода remove
     */
    @Test
    public void testRemove() {
        ListContainer<String> container = new ListContainer<>();
        container.add("Item 1");
        container.add("Item 2");
        container.add("Item 3");

        // Попробуйте удалить элемент по индексу 0
        container.remove(0);
        assertEquals(2, container.size()); // Размер контейнера должен уменьшиться на 1
        assertEquals("Item 2", container.get(0)); // Проверяем, что первый элемент теперь "Item 2"

        // Попробуйте удалить элемент по индексу 1
        container.remove(1);
        assertEquals(1, container.size()); // Размер контейнера должен уменьшиться ещё на 1
        assertNull(container.get(1)); // Проверяем, что второй элемент теперь null
    }

    /**
     * Тест метода add и remove для элементов со значением null
     */
    @Test
    public void testAddAndRemoveNull() {
        ListContainer<String> container = new ListContainer<>();
        container.add("Item 1");
        container.add(null);
        container.add("Item 2");

        assertEquals(3, container.size());

        container.remove(1);
        assertEquals(2, container.size());

        // После удаления элемента, его место займет следующий элемент
        assertEquals("Item 2", container.get(1));
    }
}
