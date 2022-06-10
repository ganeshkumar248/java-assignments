
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ComplaintsLoader {

	public List<Complaint> ComplaintsList() {
		List<Complaint> complaints = new ArrayList<>();

		try {
			ClassLoader classLoader = this.getClass().getClassLoader();
			File file = new File(classLoader.getResource("assignments.csv").getFile());
			FileReader filereader = new FileReader(file);
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
			List<String[]> allData = csvReader.readAll();
			
			for (String[] row : allData) {
				Complaint newComplaint = new Complaint(parseDate(row[0]), row[1], row[2], row[3], row[4],
				row[5], row[6], row[7], row[8], parseDate(row[9]), row[10],
				row[11].equalsIgnoreCase("Yes")? true: false, 
				row[12].equalsIgnoreCase("yes")? true: false, Integer.parseInt(row[13]));
		complaint.add(newComplaint);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return complaints;
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
