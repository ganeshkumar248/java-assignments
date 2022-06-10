import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainClass {

	static List<Complaint> complaintsList = new ArrayList<>();

	public static void main(String[] args) {

		complaintsList = ComplaintsLoader.complaintsList();

		Scanner sc = new Scanner(System.in);

		System.out.println("Fetch Complaint Based on ID \n please enter ID");
		int id = sc.nextInt();
		Complaint complaint = fetchComplaintBasedOnID(id);
		
		System.out.println("Fetch Complaints Based on year \n please enter year");
		int year = sc.nextInt();
		List<Complaint> complaintsBasedOnYear = fetchAllComplaintsBasedOnYear(year);
		
		
		System.out.println("Fetch Complaints Based on bank name \n please enter bank name");
		String bankName = sc.next();
		List<Complaint> complaintsBasedOnbankName = fetchComplaintsBasedOnBankName(bankName);
		
		System.out.println("Fetch days between complaint received and closed dates \n please enter id");
		int id1 = sc.nextInt();
		long days = ticketClosingTime(id1);

	}

	public static Complaint fetchComplaintBasedOnID(int id) {
		return complaintsList.stream().filter(c -> c.getComplaintID() == id).findAny().orElse(null);
	}

	public static List<Complaint> fetchAllComplaintsBasedOnYear(int year) {

		return complaintsList.stream().filter(c -> c.getDateReceived().getYear() == year).collect(Collectors.toList());
	}

	public static List<Complaint> fetchComplaintsBasedOnBankName(String bankName) {

		return complaintsList.stream().filter(c -> c.getCompany().equals(bankName)).collect(Collectors.toList());
	}

	public static long ticketClosingTime(int id) {

		Complaint complaint = complaintsList.stream().filter(c -> c.getComplaintID() == id).findAny().orElse(null);
		LocalDate dateReceived = complaint.getDateReceived();
		LocalDate dateClosed = complaint.getDateClosed();

		return ChronoUnit.DAYS.between(dateReceived, dateClosed);

	}

}
