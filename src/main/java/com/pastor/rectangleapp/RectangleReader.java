package com.pastor.rectangleapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class RectangleReader {
	
	@Autowired
	private RectangleRepository repository;

	@Value("${confA1}")
	private int a1;
	@Value("${confB1}")
	private int b1;
	
	@Value("${confA2}")
	private int a2;
	@Value("${confB2}")
	private int b2;
	
	@Value("${confA3}")
	private int a3;
	@Value("${confB3}")
	private int b3;
	
	@Value("${confA4}")
	private int a4;
	@Value("${confB4}")
	private int b4;
	
	@EventListener(ApplicationReadyEvent.class)
	public void addRectangles() {
		Rectangle rectangle1 = new Rectangle(a1,b1);
		Rectangle rectangle2 = new Rectangle(a2,b2);
		Rectangle rectangle3 = new Rectangle(a3,b3);
		Rectangle rectangle4 = new Rectangle(a4,b4);
				
		repository.save(rectangle1);
		repository.save(rectangle2);
		repository.save(rectangle3);
		repository.save(rectangle4);		
	}
	
}
