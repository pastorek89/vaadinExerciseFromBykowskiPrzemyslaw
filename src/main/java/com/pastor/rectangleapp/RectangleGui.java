package com.pastor.rectangleapp;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class RectangleGui extends VerticalLayout {
	
	@Autowired
	private RectangleRepository repository;
	
	private TextField textFieldHeight;
	private TextField textFieldWidth;
	private Button button;
	
	public RectangleGui() {
		dataInit();
		button.addClickListener(clickEvent -> addRectangle());
	}
	
	public void dataInit() {
		textFieldHeight = new TextField("Give me a height");
		textFieldWidth = new TextField("Give me a width");
		button = new Button("Add!");
		
		add(textFieldHeight);
		add(textFieldWidth);
		add(button);
	}
	
	public void addRectangle() {
		Rectangle rectangle = new Rectangle (
				Integer.parseInt(textFieldHeight.getValue()),
				Integer.parseInt(textFieldWidth.getValue()));
		repository.save(rectangle);
	}
	

}
