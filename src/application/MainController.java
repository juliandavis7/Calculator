package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
	
	@FXML
	private Label res;
	private long num1 = 0;
	private String op = "";
	private boolean start = true;
	private Model model = new Model();
	
	@FXML
	public void processNums(ActionEvent event) {
		if (start) {
			res.setText("");
			start = false;
		}
		String val = ((Button)event.getSource()).getText();
		res.setText(res.getText() + val);
	}
	
	@FXML
	public void processOps(ActionEvent event) {
		String val = ((Button)event.getSource()).getText();
		if (!val.equals("=")) {
			if (!op.isEmpty()) {
				return;
			}
			op = val;
			num1 = Long.parseLong(res.getText());
			res.setText("");
		} else {
			if (op.isEmpty()) {
				return;
			}
			long num2 = Long.parseLong(res.getText());
			
			double output = model.calculate(num1, num2, op);
			res.setText(String.valueOf(output));
			op = "";
			start = true;
		}
		
	}
	
}
