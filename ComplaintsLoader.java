import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ComplaintsLoader {
	
	public static List<Complaint> complaintsList() {
		
		List<Complaint> complaint = new ArrayList<>();
		
		String line = "";  
		String splitBy = ",";  
		try   
		{   
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\GaneshM3\\java8projectassignment.csv"));  
		while ((line = br.readLine()) != null)
		{  
		String[] employee = line.split(splitBy);
		
		
		Complaint newComplaint = new Complaint(parseDate(employee[0]), employee[1], employee[2], employee[3], employee[4], employee[5], employee[6],
				employee[7], employee[8], parseDate(employee[9]), employee[10],
				employee[11].equalsIgnoreCase("Yes")? true: false, employee[12].equalsIgnoreCase("yes")? true: false, Integer.parseInt(employee[13]));
		complaint.add(newComplaint);
		}  
		}   
		catch (IOException e)   
		{  
		e.printStackTrace();  
		}  
		
		return complaint;
	}
	
	 public static LocalDate parseDate(String date) {
	        final LocalDate[] parsedDate = new LocalDate[1];
	        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("MM-dd-yy");
	        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
	        DateTimeFormatter dateTimeFormatter4 = DateTimeFormatter.ofPattern("MM/dd/yy");

	        List<DateTimeFormatter> dateTimeFormatters = new ArrayList<>();

	        dateTimeFormatters.add(dateTimeFormatter);
	        dateTimeFormatters.add(dateTimeFormatter2);
	        dateTimeFormatters.add(dateTimeFormatter3);
	        dateTimeFormatters.add(dateTimeFormatter4);

	        dateTimeFormatters.forEach(dateTimeFormatterEach -> {

	            try {
	                parsedDate[0] = LocalDate.parse(date, dateTimeFormatterEach);
	            }
	            catch (Exception e) {}
	        } );

	        return parsedDate[0];
	    }
	
	
} 















