package application;

import java.io.Serializable;
import java.time.LocalDateTime;

//must add notification
public class Assignment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int number;
	private String name;
	private String details;
	// LocalDateTime of(int year,int month,int day,int hour,int minute)
	private LocalDateTime startDate;
	private LocalDateTime dueDate;
	private boolean canvasCheck;

	public Assignment(int number, String name, String details, LocalDateTime startDate, LocalDateTime dueDate,
			boolean canvasCheck) {
		this.number = number;
		this.name = name;
		this.details = details;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.canvasCheck = canvasCheck;
	}

	@Override
	public String toString() {
		return "Assignment [number=" + number + ", name=" + name + ", details=" + details + ", startDate=" + startDate
				+ ", dueDate=" + dueDate + ", canvasCheck=" + canvasCheck + "]";
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDateTime getStartDate() {
		return this.startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public boolean getCanvasCheck() {
		return canvasCheck;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setCanvasCheck(boolean canvasCheck) {
		this.canvasCheck = canvasCheck;
	}
}