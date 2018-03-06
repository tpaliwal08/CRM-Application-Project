package itmd510.FP.models;


public class Order extends Accounts{
	
	Integer OrdId;
	Double OrdAmount,OrdQuantity;
	String OrdDesc, OrdDate, OrdType;
	
	public Integer getAccId() {
		return super.AccId;
	}
	public void setAccId(Integer AccId) {
		super.AccId = AccId;
	}
	
	public Integer getOrdId() {
		return this.OrdId;
	}
	public void setOrdId(Integer ordId) {
		this.OrdId = ordId;
	}
	public Double getOrdAmount() {
		return this.OrdAmount;
	}
	public void setOrdAmount(Double ordAmount) {
		this.OrdAmount = ordAmount;
	}
	public Double getOrdQuantity() {
		return this.OrdQuantity;
	}
	public void setOrdQuantity(Double ordQuantity) {
		this.OrdQuantity = ordQuantity;
	}
	public String getOrdDesc() {
		return this.OrdDesc;
	}
	public void setOrdDesc(String ordDesc) {
		this.OrdDesc = ordDesc;
	}
	public String getOrdDate() {
		return this.OrdDate;
	}
	public void setOrdDate(String ordDate) {
		this.OrdDate = ordDate;
	}
	public String getOrdType() {
		return this.OrdType;
	}
	public void setOrdType(String ordType) {
		this.OrdType = ordType;
	}
	
	
}
