package libraryforcft;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * Класс Perspective представляет собой перспективу в пользовательском интерфейсе приложения библиотеки.
 * Он определяет, как будет выглядеть и функционировать пользовательский интерфейс, включая расположение и видимость компонентов.
 */
public class Perspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
        layout.setEditorAreaVisible(false);
        layout.setFixed(true);

        IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT,  0.25f, editorArea);
        topLeft.addView("libraryforcft.BookAddView");
	}
}
