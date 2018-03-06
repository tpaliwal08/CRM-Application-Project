package itmd510.FP.models;

public class Accounts extends Opportunity{

	Integer AccId,AccPhone,AccFax;
	String AccName ,AccNo,AccEmail,AccAddress;

		
	public Integer getAccId() {
		return AccId;
	}
	public void setAccId(Integer accId) {
		this.AccId = accId;
	}
	public Integer getAccPhone() {
		return this.AccPhone;
	}
	public void setAccPhone(Integer accPhone) {
		this.AccPhone = accPhone;
	}
	public Integer getAccFax() {
		return this.AccFax;
	}
	public void setAccFax(Integer accFax) {
		this.AccFax = accFax;
	}
	public String getAccName() {
		return this.AccName;
	}
	public void setAccName(String accName) {
		this.AccName = accName;
	}
	public String getAccNo() {
		return this.AccNo;
	}
	public void setAccNo(String accNo) {
		this.AccNo = accNo;
	}
	public String getAccEmail() {
		return this.AccEmail;
	}
	public void setAccEmail(String accEmail) {
		this.AccEmail = accEmail;
	}
	public String getAccAddress() {
		return this.AccAddress;
	}
	public void setAccAddress(String accAddress) {
		this.AccAddress = accAddress;
	}
	
	public Integer getOppId() {
		return super.OppId;
	}
	public void setOppId(Integer OppId) {
		super.OppId = OppId;
	}
}
