package itmd510.FP.models;


public class Opportunity extends Lead{

	Integer OppId;
	String OppDesc,OppPipelinePhase,OppStatus;
	Double OppEstRevenue;
	String OppEstCloseDate; 
	
	public Integer getOppId() {
		return this.OppId;
	}
	public void setOppId(Integer OppId) {
		this.OppId = OppId;
	}
	public Integer getLeadId() {
		return super.leadid;
	}
	public void setLeadId(Integer leadid) {
		super.leadid = leadid;
	}
	public String getOppDesc() {
		return this.OppDesc;
	}
	public void setOppDesc(String OppDesc) {
		this.OppDesc = OppDesc;
	}
	public String getOppPipelinePhase() {
		return this.OppPipelinePhase;
	}
	public void setOppPipelinePhase(String OppPipelinePhase) {
		this.OppPipelinePhase = OppPipelinePhase;
	}
	public String getOppStatus() {
		return this.OppStatus;
	}
	public void setOppStatus(String OppStatus) {
		this.OppStatus = OppStatus;
	}
	public String getLeadFirstName() {
		return super.firstname;
	}
	public void setLeadFirstName(String leadFirstName) {
		super.firstname = leadFirstName;
	}
	public Double getOppEstRevenue() {
		return this.OppEstRevenue;
	}
	public void setOppEstRevenue(Double OppEstRevenue) {
		this.OppEstRevenue = OppEstRevenue;
	}
	public String getOppEstCloseDate() {
		return this.OppEstCloseDate;
	}
	public void setOppEstCloseDate(String OppEstCloseDate) {
		this.OppEstCloseDate = OppEstCloseDate;
	}
	
	
}
