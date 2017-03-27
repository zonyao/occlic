package com.ambonare.TCEQForm.model;

public class OccupationalTraining {

  
  private String trainingInstitution="";
  private String courseTitle="";
  private String location="";
  private String   trainingDate="";
  private String creditHours="";

public String getTrainingInstitution() {
	return trainingInstitution;
}
public void setTrainingInstitution(String trainingInstitution) {
	this.trainingInstitution = trainingInstitution;
}
public String getCourseTitle() {
	return courseTitle;
}
public void setCourseTitle(String courseTitle) {
	this.courseTitle = courseTitle;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getTrainingDate() {
	return trainingDate;
}
public void setTrainingDate(String trainingDate) {
	this.trainingDate = trainingDate;
}
public String getCreditHours() {
	return creditHours;
}
public void setCreditHours(String creditHours) {
	this.creditHours = creditHours;
}


@Override
public String toString() {
	return "[ "+trainingInstitution+"\t"+courseTitle+"\t"+location+"\t"+ trainingDate+"\t"+creditHours+ " ]";
}
  
  
  
}
