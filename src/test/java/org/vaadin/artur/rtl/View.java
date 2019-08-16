package org.vaadin.artur.rtl;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.router.Route;

@Route("")
public class View extends Div {

	public View() {
		RadioButtonGroup<Direction> directionSelect = new RadioButtonGroup<Direction>();
		directionSelect.setLabel("Text direction");
		directionSelect.setItems(Direction.values());
		directionSelect.setValue(Direction.LTR);
		directionSelect.addValueChangeListener(e -> {
			Direction.set(directionSelect.getValue());
		});
		directionSelect.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
		add(directionSelect);

		Grid<Person> grid = new Grid<Person>(Person.class);
		grid.setItems(PersonService.get().get(0, 50));
		add(grid);

		ComboBox<Person> combo = new ComboBox<Person>();
		combo.setItemLabelGenerator(p -> {
			return p.getFirstName() + " " + p.getLastName();
		});
		combo.setItems(PersonService.get().get(0, 50));
		add(combo);
	}
}
