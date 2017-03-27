package com.ambonare.TCEQForm.model;

public class ApplicationForReciprocity {

	private String licensedInAnotherStateOrCountry = "N";
	private String issuingStateOrCountry="";
	private String type="";
	private String issueDate="";
	private String expirationDate="";
	private String attachedCopyofLicensePath="";
	public String getLicensedInAnotherStateOrCountry() {
		return licensedInAnotherStateOrCountry;
	}
	public void setLicensedInAnotherStateOrCountry(String licensedInAnotherStateOrCountry) {
		this.licensedInAnotherStateOrCountry = licensedInAnotherStateOrCountry;
	}
	public String getIssuingStateOrCountry() {
		return issuingStateOrCountry;
	}
	public void setIssuingStateOrCountry(String issuingStateOrCountry) {
		this.issuingStateOrCountry = issuingStateOrCountry;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getAttachedCopyofLicensePath() {
		return attachedCopyofLicensePath;
	}
	public void setAttachedCopyofLicensePath(String attachedCopyofLicensePath) {
		this.attachedCopyofLicensePath = attachedCopyofLicensePath;
	}

}
