import java.time.LocalDate;

public class Complaint {

	private LocalDate dateReceived;
	private String product;
	private String subProduct;
	private String issue;
	private String subIssue;
	private String company;
	private String state;
	private String ZIPCode;
	private String submittedVia;
	private LocalDate dateClosed;
	private String comResToCus;
	private boolean timelyResponse;
	private boolean conDisputed;
	private int complaintID;
	 
	public Complaint() {
		
	}

	public Complaint(LocalDate dateReceived, String product, String subProduct, String issue, String subIssue,
			String company, String state, String zIPCode, String submittedVia, LocalDate dateClosed, String comResToCus,
			boolean timelyResponse, boolean conDisputed, int complaintID) {
		super();
		this.dateReceived = dateReceived;
		this.product = product;
		this.subProduct = subProduct;
		this.issue = issue;
		this.subIssue = subIssue;
		this.company = company;
		this.state = state;
		ZIPCode = zIPCode;
		this.submittedVia = submittedVia;
		this.dateClosed = dateClosed;
		this.comResToCus = comResToCus;
		this.timelyResponse = timelyResponse;
		this.conDisputed = conDisputed;
		this.complaintID = complaintID;
	}

	public LocalDate getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(LocalDate dateReceived) {
		this.dateReceived = dateReceived;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getSubProduct() {
		return subProduct;
	}

	public void setSubProduct(String subProduct) {
		this.subProduct = subProduct;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getSubIssue() {
		return subIssue;
	}

	public void setSubIssue(String subIssue) {
		this.subIssue = subIssue;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZIPCode() {
		return ZIPCode;
	}

	public void setZIPCode(String zIPCode) {
		ZIPCode = zIPCode;
	}

	public String getSubmittedVia() {
		return submittedVia;
	}

	public void setSubmittedVia(String submittedVia) {
		this.submittedVia = submittedVia;
	}

	public LocalDate getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(LocalDate dateClosed) {
		this.dateClosed = dateClosed;
	}

	public String getComResToCus() {
		return comResToCus;
	}

	public void setComResToCus(String comResToCus) {
		this.comResToCus = comResToCus;
	}

	public boolean getTimelyResponse() {
		return timelyResponse;
	}

	public void setTimelyResponse(boolean timelyResponse) {
		this.timelyResponse = timelyResponse;
	}

	public boolean getConDisputed() {
		return conDisputed;
	}

	public void setConDisputed(boolean conDisputed) {
		this.conDisputed = conDisputed;
	}

	public int getComplaintID() {
		return complaintID;
	}

	public void setComplaintID(int complaintID) {
		this.complaintID = complaintID;
	}

	@Override
	public String toString() {
		return "Complaint [dateReceived=" + dateReceived + ", product=" + product + ", subProduct=" + subProduct
				+ ", issue=" + issue + ", subIssue=" + subIssue + ", company=" + company + ", state=" + state
				+ ", ZIPCode=" + ZIPCode + ", submittedVia=" + submittedVia + ", dateClosed=" + dateClosed
				+ ", comResToCus=" + comResToCus + ", timelyResponse=" + timelyResponse + ", conDisputed=" + conDisputed
				+ ", complaintID=" + complaintID + "]";
	}

}
