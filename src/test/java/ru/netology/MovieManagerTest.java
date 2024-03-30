package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    public void FindAllTest() {
        MovieManager manager = new MovieManager();

        String[] actual = manager.findAll();
        String[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllOneTest() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");

        String[] actual = manager.findAll();
        String[] expected = {"Бладшот"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllTest() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");
        String[] actual = manager.findAll();
        String[] expected = {"Бладшот", "Вперед", "Отель Белград", "Джентельмены", "Человек-невидимка", "Тролли. Мировой тур", "Номер один"};

        Assertions.assertArrayEquals(expected, actual);
    }

    // в обратном порядке
    @Test
    public void shouldFindLastBeginingTest() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель Белград");
        String[] actual = manager.findLast();
        String[] expected = {"Отель Белград", "Вперед", "Бладшот"};

        Assertions.assertArrayEquals(expected, actual);
    }

    // Больше лимита
    @Test
    public void shouldFindLastMoreMaxLimit() { // больше чем лимит без уточнения лимита
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");

        String[] actual = manager.findLast();
        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель Белград"};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindLastMoreMaxLimitSet() { // больше чем заданный лимит с уточнением (3)
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");

        String[] actual = manager.findLast();
        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек-невидимка"};

        Assertions.assertArrayEquals(expected, actual);
    }

    // Равно лимиту
    @Test
    public void shouldFindAllTestEqualsLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");

        String[] actual = manager.findAll();
        String[] expected = {"Бладшот", "Вперед", "Отель Белград", "Джентельмены", "Человек-невидимка"};

        Assertions.assertArrayEquals(expected, actual);
    }

    // Меньше чем лимит
    @Test
    public void shouldFindLastMoreMinLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");

        String[] actual = manager.findAll();
        String[] expected = {"Бладшот", "Вперед"};

        Assertions.assertArrayEquals(expected, actual);
    }
}