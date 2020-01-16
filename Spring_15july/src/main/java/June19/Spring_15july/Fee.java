package June19.Spring_15july;

public class Fee {

	private Double totalFee;
	private Double paidFee;
	private Double pendingFee;
	
	public Fee(Double totalFee, Double paidFee, Double pendingFee) {
		super();
		this.totalFee = totalFee;
		this.paidFee = paidFee;
		this.pendingFee = pendingFee;
	}

	public Double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}

	public Double getPaidFee() {
		return paidFee;
	}

	public void setPaidFee(Double paidFee) {
		this.paidFee = paidFee;
	}

	public Double getPendingFee() {
		return pendingFee;
	}

	public void setPendingFee(Double pendingFee) {
		this.pendingFee = pendingFee;
	}
	
	
}
