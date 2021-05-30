package com;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javafx.application.Application;


@SpringBootApplication
public class JavaFXApp{

	public static void main(String[] args) {
		Application.launch(P4Application.class, args);	
		}
}