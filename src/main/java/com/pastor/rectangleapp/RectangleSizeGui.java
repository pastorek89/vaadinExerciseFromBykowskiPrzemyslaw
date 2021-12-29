package com.pastor.rectangleapp;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class RectangleSizeGui extends VerticalLayout {
			
	@Autowired
	private RectangleRepository repository;
	private TextArea textAreaRectangle;
	private TextField textFieldSize;
	private Button buttonBigger;
	private Button buttonSmaller;
	
	public RectangleSizeGui() {		
		textAreaRectangle = new TextArea("Result");
		textFieldSize = new TextField("Give me a size");
		buttonBigger = new Button("Show bigger rectangles");
		buttonSmaller = new Button("Show smaller rectangles");
		
		buttonSmaller.addClickListener(clickEvent -> textAreaRectangle.setValue(
				repository.getSmallRectangles(Integer.parseInt(textFieldSize.getValue())).toString()));
		buttonBigger.addClickListener(clickEvent -> textAreaRectangle.setValue(
				repository.getBigRectangles(Integer.parseInt(textFieldSize.getValue())).toString()));
		
		add(textFieldSize);
		add(buttonBigger);
		add(buttonSmaller);
		add(textAreaRectangle);		
	}
}
