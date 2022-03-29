package assignment2.View;

import java.util.ArrayList;
import java.util.Scanner;

import assignment2.Model.Student;

public class StudentView {
	private Scanner sc;
	private Student stud;
	
	public StudentView() {
		sc = new Scanner(System.in);
	}
	
	public int menu() {
		System.out.println("\n1. Read data from database");
		System.out.println("2. Add data to database");
		System.out.println("3. Exit");
		return sc.nextInt();

	}
	public void readData(ArrayList<Student> studs) {
		System.out.println("ID\tName\tMath\tScience");
		for(Student s: studs) {
			System.out.print(s.getID() + "\t");
			System.out.print(s.getName()+ "\t");
			System.out.print(s.getMathmark()+ "\t");
			System.out.println(s.getSciencemark()+ "\t");
		}
	}
	
	
	public void saveData() {
		stud = new Student();
		System.out.println("Input ID (only integers)");
		stud.setID(sc.nextInt());
		System.out.println("Input Name ");
		stud.setName(sc.next()); 
		System.out.println("Input Math Mark (only Integers)");
		stud.setMathmark(sc.nextInt());
		System.out.println("Input Science Mark (only Integers)");
		stud.setSciencemark(sc.nextInt());
	}
	
	public Student getStudent() {
		return stud;
	}
	
}
