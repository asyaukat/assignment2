package assignment2.main;

import java.sql.SQLException;

import assignment2.Controller.StudentController;
import assignment2.Model.DB;
import assignment2.View.StudentView;

public class StudentMain {
	public static void main(String[] args) throws SQLException {
		StudentController controller;
		StudentView view;
		DB model;

		view = new StudentView();
		model = new DB();
		controller = new StudentController(view, model);

		controller.showMenu();
	}
}
