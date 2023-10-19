package com.example;

/**
 * Класс `ListContainer` представляет собой контейнер для хранения элементов.
 *
 * @param <T> Тип элементов, которые могут быть добавлены в контейнер.
 */
public class ListContainer<T> {
    /**
     * Внутренний класс `Node` представляет элемент контейнера.
     *
     * @param <T> Тип данных, хранимых в узле.
     */
    private static class Node<T> {
        T data;
        Node<T> next;

        /**
         * Создает новый узел с указанными данными.
         *
         * @param data Данные, которые будут храниться в узле.
         */
        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    /**
     * Голова контейнера-первый элемент
     */
    private Node<T> head;

    /**
     * Количество элементов в контейнере
     */
    private int size;

    /**
     * Создает новый контейнер.
     */
    public ListContainer() {
        head = null;
        size = 0;
    }

    /**
     * Добавляет элемент в контейнер.
     *
     * @param item Элемент, который необходимо добавить.
     */
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Извлекает элемент по индексу.
     *
     * @param index Индекс элемента для извлечения.
     * @return Элемент, находящийся по указанному индексу, или `null`, если индекс некорректен.
     */
    public T get(int index) {
        if (index < 0 || index >= size || head == null) {
            return null;
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }
        return current.data;
    }

    /**
     * Удаляет элемент по индексу.
     *
     * @param index Индекс элемента для удаления.
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            return; // Проверка на корректность индекса
        }

        if (index == 0) {
            // Удаление первого элемента
            head = head.next;
        } else {
            // Удаление элемента по индексу
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    /**
     * Возвращает количество элементов в контейнере.
     *
     * @return Количество элементов в контейнере
     */
    public int size() {

        return size;
    }
}





