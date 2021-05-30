package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.controllers.MenuController;
import com.repositories.ProyectoRepository;
import com.services.ProyectoService;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;


public class P4Application extends Application{
	
	private ConfigurableApplicationContext applicationContext;
	public static Parent rootNode;
	public static Stage stage;
	
	@Override
	public void init() throws Exception {
		

	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ApplicationContextInitializer<GenericApplicationContext> initializer =
				ac ->{
						ac.registerBean(Application.class, () -> P4Application.this);
						ac.registerBean(Parameters.class, this::getParameters);
						ac.registerBean(HostServices.class,  this::getHostServices);

						
					};
		
		this.applicationContext = new SpringApplicationBuilder()
				.sources(JavaFXApp.class)
				.initializers(initializer)
				.run(getParameters().getRaw().toArray(new String[0]));

		FXMLLoader loader = new FXMLLoader(JavaFXApp.class.getResource("/ui.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		Scene scene = new Scene(loader.load(), 800,800,false,SceneAntialiasing.BALANCED);
		
		primaryStage.setTitle("ONG Entreculturas");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception {
		this.applicationContext.close();
		Platform.exit();
	}
}

class StageReadyEvent extends ApplicationEvent{
	
	public Stage getStage() {
		return Stage.class.cast(getSource());
	}
	
	public StageReadyEvent(Stage source) {
		super(source);
	}
}