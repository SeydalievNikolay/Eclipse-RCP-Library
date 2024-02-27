package com.example.libraryapp;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

/**
 * Класс LibraryWindow представляет собой компонент окна в приложении Eclipse RCP,
 * предназначенный для управления информацией о книгах и читателях.
 * Этот компонент предоставляет пользовательский интерфейс с кнопками для добавления,
 * просмотра, обновления и удаления записей о книгах и читателях.
 */
public class LibraryWindow extends ViewPart {

    /**
     * Создает пользовательский интерфейс для компонента окна.
     * @param parent родительский контейнер, в котором будет размещен пользовательский интерфейс.
     */
    @Override
    public void createPartControl(Composite parent) {
        parent.setLayout(new GridLayout(2, false));

        // Создание кнопок
        Button addBookButton = new Button(parent, SWT.PUSH);
        addBookButton.setText("Add Book");

        Button viewBooksButton = new Button(parent, SWT.PUSH);
        viewBooksButton.setText("View Books");

        Button updateBookButton = new Button(parent, SWT.PUSH);
        updateBookButton.setText("Update Book");

        Button deleteBookButton = new Button(parent, SWT.PUSH);
        deleteBookButton.setText("Delete Book");

        // Создание метки
        Label label = new Label(parent, SWT.NONE);
        label.setText("Library Management");

        // Добавление обработчиков событий
        addBookButton.addListener(SWT.Selection, e -> {
            // Логика добавления книги
            System.out.println("Add Book button clicked");
        });

        viewBooksButton.addListener(SWT.Selection, e -> {
            // Логика просмотра книг
            System.out.println("View Books button clicked");
        });

        updateBookButton.addListener(SWT.Selection, e -> {
            // Логика обновления книги
            System.out.println("Update Book button clicked");
        });

        deleteBookButton.addListener(SWT.Selection, e -> {
            // Логика удаления книги
            System.out.println("Delete Book button clicked");
        });
    }

    /**
     * Устанавливает фокус на компонент.
     * В данном случае метод не выполняет  никаких действий, так как не требуется специфическая
     *  логика для установки фокуса.
     */
    @Override
    public void setFocus() {
        // Метод для установки фокуса на компонент
        // Здесь можно добавить   логику, если это необходимо
    }
}