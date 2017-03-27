package com.ambonare.TCEQForm.model;

public class OfficeUseOnlyInfo {
	private String feePaid="null";
	private String applicationReceivedDate="null";
	private String evaluationDate="null";
	private String amount="null";
	private String re_evaluationCompleted="null";
	private String date="null";
	private String approvStatus="null";
	private String scoreAndDate1st="null";
	private String scoreAndDate2nd="null";
	private String scoreAndDate3rd="null";
	private String scoreAndDate4th="null";
	private String licenseTypeIssued="null";
	private String issueDate="null";
	private String expirationDate="null";
	private String licenseNum="null";
	private String commentsOrNotes="null";
	public String getFeePaid() {
		return feePaid;
	}
	public void setFeePaid(String feePaid) {
		this.feePaid = feePaid;
	}
	public String getApplicationReceivedDate() {
		return applicationReceivedDate;
	}
	public void setApplicationReceivedDate(String applicationReceivedDate) {
		this.applicationReceivedDate = applicationReceivedDate;
	}
	public String getEvaluationDate() {
		return evaluationDate;
	}
	public void setEvaluationDate(String evaluationDate) {
		this.evaluationDate = evaluationDate;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getRe_evaluationCompleted() {
		return re_evaluationCompleted;
	}
	public void setRe_evaluationCompleted(String re_evaluationCompleted) {
		this.re_evaluationCompleted = re_evaluationCompleted;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getApprovStatus() {
		return approvStatus;
	}
	public void setApprovStatus(String approvStatus) {
		this.approvStatus = approvStatus;
	}
	public String getScoreAndDate1st() {
		return scoreAndDate1st;
	}
	public void setScoreAndDate1st(String scoreAndDate1st) {
		this.scoreAndDate1st = scoreAndDate1st;
	}
	public String getScoreAndDate2nd() {
		return scoreAndDate2nd;
	}
	public void setScoreAndDate2nd(String scoreAndDate2nd) {
		this.scoreAndDate2nd = scoreAndDate2nd;
	}
	public String getScoreAndDate3rd() {
		return scoreAndDate3rd;
	}
	public void setScoreAndDate3rd(String scoreAndDate3rd) {
		this.scoreAndDate3rd = scoreAndDate3rd;
	}
	public String getScoreAndDate4th() {
		return scoreAndDate4th;
	}
	public void setScoreAndDate4th(String scoreAndDate4th) {
		this.scoreAndDate4th = scoreAndDate4th;
	}
	public String getLicenseTypeIssued() {
		return licenseTypeIssued;
	}
	public void setLicenseTypeIssued(String licenseTypeIssued) {
		this.licenseTypeIssued = licenseTypeIssued;
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
	public String getLicenseNum() {
		return licenseNum;
	}
	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}
	public String getCommentsOrNotes() {
		return commentsOrNotes;
	}
	public void setCommentsOrNotes(String commentsOrNotes) {
		this.commentsOrNotes = commentsOrNotes;
	}
	@Override
	public String toString() {
		return feePaid + "\t " + applicationReceivedDate + "\t " + evaluationDate + "\t " + amount + "\t "
				+ re_evaluationCompleted + "\t " + date + "\t " + approvStatus + "\t " + scoreAndDate1st + "\t "
				+ scoreAndDate2nd + "\t " + scoreAndDate3rd + "\t " + scoreAndDate4th + "\t " + licenseTypeIssued + "\t "
				+ issueDate + "\t " + expirationDate + "\t " + licenseNum + "\t " + commentsOrNotes;
	}
	
}
