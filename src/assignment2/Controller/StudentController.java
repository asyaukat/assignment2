package assignment2.Controller;

import java.sql.SQLException;
import assignment2.Model.DB;
import assignment2.View.StudentView;


public class StudentController {
	
	private StudentView view;
	private DB model;
	
	public StudentController(StudentView view, DB model) throws SQLException {
		this.view = view;
		this.model = model;
		
	}
		
	public void showMenu() throws SQLException{
		int option = 0;
		
		while(option != 99) { //Exit
			option = view.menu();
			
			if (option == 1) {
				
				view.readDataMultiple(model.readStudents());
			}
			else if (option == 2) {
				view.saveData();
				model.insertStudent(view.getStudent());
				
			}
			else if (option == 3) {
				
				try {
					view.readDataSingle(model.readStudentSingle(view.insertStudentID()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					view.noStudent();
				}
				
			}
		}
	
	}
		
}

