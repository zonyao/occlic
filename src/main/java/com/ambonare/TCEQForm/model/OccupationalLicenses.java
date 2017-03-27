package com.ambonare.TCEQForm.model;

public class OccupationalLicenses {

	private String type="";
	private String issuingAgency="";
	private String issuanceDate="";
	private String expirationDate="";
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIssuingAgency() {
		return issuingAgency;
	}
	public void setIssuingAgency(String issuingAgency) {
		this.issuingAgency = issuingAgency;
	}
	public String getIssuanceDate() {
		return issuanceDate;
	}
	public void setIssuanceDate(String issuanceDate) {
		this.issuanceDate = issuanceDate;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	@Override
	public String toString() {
		return type + "\t " + issuingAgency + "\t " + issuanceDate + "\t " + expirationDate;
	}

}
