package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Database {

	private static Map<String, Assignment> assignementDatabase = new HashMap<>();
	private static final String ASSIGNMENT_DATABASE = "assignment.dat";

	public Database() {
		loadDatabase();
	}

	public void insertAssignment(Assignment assignment) {
		assignementDatabase.put(assignment.getName(), assignment);

		try (FileOutputStream fos = new FileOutputStream(ASSIGNMENT_DATABASE);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(assignementDatabase);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public Assignment getAssignment(String name) {
		return assignementDatabase.get(name);
	}

	public boolean hasAssignment(String name) {
		return assignementDatabase.containsKey(name);
	}

	public Map<String, Assignment> getAllAssignments() {
		return assignementDatabase;
	}

	private void loadDatabase() {
		HashMap<Integer, String> map = null;
		try (FileInputStream fis = new FileInputStream(ASSIGNMENT_DATABASE);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			assignementDatabase = (Map<String, Assignment>) ois.readObject();
		} catch (FileNotFoundException fe) {
			System.out.println("no database file");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}
	}
}