package org.vaadin.artur.rtl;

import com.vaadin.flow.component.UI;

public enum Direction {
	LTR, RTL;

	public static void set(Direction direction) {
		set(UI.getCurrent(), direction);
	}

	private static void set(UI ui, Direction direction) {
		ui.getElement().executeJs("document.querySelector('html').dir=$0", direction.toString());
	}
}
