package com.ambonare.TCEQForm.model;

public class EducationBackground {

	private String educationYearOfGraduation="";
	private String highestLevelOfEducation="";
	private String numberOfSemesterhours="";
	private String collegeName="";
	private String major="";

	public String getEducationYearOfGraduation() {
		return educationYearOfGraduation;
	}

	public void setEducationYearOfGraduation(String educationYearOfGraduation) {
		this.educationYearOfGraduation = educationYearOfGraduation;
	}

	public String getHighestLevelOfEducation() {
		return highestLevelOfEducation;
	}

	public void setHighestLevelOfEducation(String highestLevelOfEducation) {
		this.highestLevelOfEducation = highestLevelOfEducation;
	}

	public String getNumberOfSemesterhours() {
		return numberOfSemesterhours;
	}

	public void setNumberOfSemesterhours(String numberOfSemesterhours) {
		this.numberOfSemesterhours = numberOfSemesterhours;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return educationYearOfGraduation+"\t"+highestLevelOfEducation+"\t"+numberOfSemesterhours+"\t"+collegeName+"\t"+major;
	}


}
