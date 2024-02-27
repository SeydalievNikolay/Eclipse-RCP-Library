package libraryforcft;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

/**
 * Класс BookAddView представляет собой пользовательский интерфейс для добавления новой книги в библиотеку.
 * Он предоставляет форму для ввода информации о книге, такие как название, автор и год публикации.
 */
public class BookAddView extends ViewPart {
	private Text titleText;
    private Text authorsText;
    private Text yearPublishedText;
    private Button saveButton;

    /**
     * Создает и настраивает пользовательский интерфейс для добавления новой книги.
     * Этот метод создает текстовые поля для ввода названия книги, авторов и года публикации,
     * а также кнопку для сохранения информации о книге.
     *  
     * @param parent Композит, который будет содержать элементы пользовательского интерфейса.
     */
	@Override
	public void createPartControl(Composite parent) {
		 parent.setLayout(new GridLayout(2, false));

	        Label titleLabel = new Label(parent, SWT.NONE);
	        titleLabel.setText("Title:");
	        titleText = new Text(parent, SWT.BORDER);
	        titleText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	        Label authorsLabel = new Label(parent, SWT.NONE);
	        authorsLabel.setText("Authors:");
	        authorsText = new Text(parent, SWT.BORDER);
	        authorsText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	        Label yearPublishedLabel = new Label(parent, SWT.NONE);
	        yearPublishedLabel.setText("Year Published:");
	        yearPublishedText = new Text(parent, SWT.BORDER);
	        yearPublishedText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	        saveButton = new Button(parent, SWT.PUSH);
	        saveButton.setText("Save");
	        saveButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	        saveButton.addListener(SWT.Selection, e -> saveBook());
		
	}

	/**
	 * Сохраняет информацию о книге в базу данных.
	 * Этот метод извлекает текст из текстовых полей интерфейса, создает объект книги
	 * и вызывает метод добавления книги через сервис книг.
	 */
    private void saveBook() {
        String title = titleText.getText();
        String authors = authorsText.getText();
        int yearPublished = Integer.parseInt(yearPublishedText.getText());

        BookService bookService = new BookService();
        bookService.addBook(title, authors, yearPublished);
    }

    /**
     * Устанавливает фокус на текстовое поле для ввода названия книги.
     * Этот метод вызывается, когда пользователь переходит к этому представлению,
     * чтобы обеспечить удобство ввода данных.
     */
	@Override
	public void setFocus() {
		titleText.setFocus();
		
	}

}
