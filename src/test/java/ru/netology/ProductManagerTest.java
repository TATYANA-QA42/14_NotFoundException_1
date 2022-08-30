package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.*;

import java.security.acl.NotOwnerException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(11, "Евгений Онегин", 450, "Пушкин");
    Book book2 = new Book(14, "Война и мир", 450, "Толстой");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
    }

    @Test
    public void testsMatchesT() {
        boolean expected = true;
        boolean actual = manager.matches(book2, "Война и мир");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesF() {
        boolean expected = false;
        boolean actual = manager.matches(book2, "rthkgj");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearchBy() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Война и мир");
        assertArrayEquals(expected, actual);

    }

    @Test
    public void testFindAll() {
        Product[] expected = {book1, book2};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveById() {
        Product[] expected = {book1};
        Product[] actual = repo.removeById(14);
        assertArrayEquals(expected, actual);
    }

    //    @Test
//    public void testFindById() {
//       // Product product = new Product(14, "Война и мир", 450);
//        Product[] expected = new Product[14, "Война и мир", 450];
//        Product[] actual = repo.findById(14);
//        Assertions.assertArrayEquals(expected, actual);
//
//    }
    @Test
    public void removeById() {
        Product[] expected = new Product[]{book2};
        Product[] actual = repo.removeById2(11);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdNotFoundException() {
        assertThrows(NotFoundException.class, () -> repo.removeById2(9));
    }
}

