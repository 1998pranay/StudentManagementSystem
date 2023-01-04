package database1;

import java.sql.SQLException;

public class StarterApp {
	public static void main(String[] args) {
		try {
			UIInterface1.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}