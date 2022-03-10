package uiAutromation.pages;

//Converting hours into minutes

public class HoursToMinutes {
	public static int convertHoursToMinutes(String in) {
		String a1[]=in.split(" ");
		String hours=a1[0].substring(0,a1[0].length()-1);
		String min=a1[1].substring(0,a1[1].length()-1);
		int h=Integer.parseInt(hours);
		int m=Integer.parseInt(min);
		return (m+(h*60));
	}
}

