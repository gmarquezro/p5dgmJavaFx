

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

@Component
public class UiController {
	
	private final HostServices hostServices;
	
	@FXML
	public Label label;
	
	@FXML
	public Button button;
	
	UiController(HostServices hostServices){
		this.hostServices = hostServices;
	}
	
	@FXML
	public void initialize() {
		this.button.setOnAction( actionEvent ->
		this.label.setText(this.hostServices.getDocumentBase()));
	}
}