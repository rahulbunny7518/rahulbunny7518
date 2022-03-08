package TestAutomation.RestApiTestingProject;

public class PunchInOut {



	private int empNumber;
	private String date;
	private String time;
	private String timezoneOffset;
	private boolean forcePunchIn;
	
	PunchInOut()
	{
		
	}

	PunchInOut(int empNumber,String date,String time,String timezoneOffset){
		this.empNumber=empNumber;
		this.date=date;
		this.time=time;
		this.timezoneOffset=timezoneOffset;
		//this.forcePunchIn=forcePunchIn;
	}


	public int getEmpNumber() {
		return empNumber;
	}



	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public String getTimezoneOffset() {
		return timezoneOffset;
	}



	public void setTimezoneOffset(String timezoneOffset) {
		this.timezoneOffset = timezoneOffset;
	}



	public boolean isForcePunchIn() {
		return forcePunchIn;
	}



	public void setForcePunchIn(boolean forcePunchIn) {
		this.forcePunchIn = forcePunchIn;
	}

}
