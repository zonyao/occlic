package com.ambonare.TCEQForm.model;

import java.util.ArrayList;
import java.util.List;

public class Form {

	private  String firstName="";
	private String lastName="";
	private String middleName="";
	private String title="";//Mr. Mrs. Ms
	private String prefixOfName="";//Sr. Jr.
    private String voucherNumber ="";
	
	private String socialSecurityNum="";
	private String regulatedEntity="";
	private String customerRole="OCCUPATIONAL LICENSEE";
	private String typeOfCustomer="Individual";
	@SuppressWarnings("unused")
	private String mailingAddress="";
	private String mailingAddress1="";
	private String mailingAddress2="";
	private String workEmail="";
	private String personalEmail="";
	private String city="";
	private String state="";
	private String zipCode="";
	private String zipCodePlus="";
	private String insideUS = "";
/*	private String country="";
	private String maillingZone="";
	private String mailingCode="";
	private String postalFeatures="";*/
	private String currentMaillingAddress;
	private TypeOfLicencsApplication typeOfLicenseApp;
	private String homePhoneNumber="";
	private String workPhoneNumber="";
	private String cellPhoneNumber="" ;
	private String birthday ="";
	private String generalInfo="";
	private String attachementsDescription="";
	private String attachementsDescriptionAnother="";
	private String attachementsPath="";
	private String complianceHistory="";
	private String complianceExplain="";
	private String licensedInAnotherState="N";
	private String socialDOBNum="";
	private String USTAFiles="";
	private String USTBFiles="";
	private String militaryVeteran="NO";
	
	private List<OccupationalTraining>  occupationalTrainingList;
	private Affidavit affiadavit;
	private ApplicationForReciprocity applicationForReciprocity;
	private EducationBackground educationBackground;
	private OccupationalLicenses occupationalLicenses;
	private OfficeUseOnlyInfo officeUseOnlyInfo;
	
	
	public String getInsideUS() {
		return insideUS;
	}

	public void setInsideUS(String insideUS) {
		this.insideUS = insideUS;
	}

	/*public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMaillingZone() {
		return maillingZone;
	}

	public void setMaillingZone(String maillingZone) {
		this.maillingZone = maillingZone;
	}*/

	public String getMailingAddress1() {
		return mailingAddress1;
	}

	public void setMailingAddress1(String mailingAddress1) {
		this.mailingAddress1 = mailingAddress1;
	}

	public String getMailingAddress2() {
		return mailingAddress2;
	}

	public void setMailingAddress2(String mailingAddress2) {
		this.mailingAddress2 = mailingAddress2;
	}

	/*public String getMailingCode() {
		return mailingCode;
	}

	public void setMailingCode(String mailingCode) {
		this.mailingCode = mailingCode;
	}

	public String getPostalFeatures() {
		return postalFeatures;
	}

	public void setPostalFeatures(String postalFeatures) {
		this.postalFeatures = postalFeatures;
	}*/

	public String getZipCodePlus() {
		return zipCodePlus;
	}

	public void setZipCodePlus(String zipCodePlus) {
		this.zipCodePlus = zipCodePlus;
	}


	//Avoid the Null Point Exception
	public Form(){
		typeOfLicenseApp = new TypeOfLicencsApplication();
		occupationalTrainingList = new ArrayList<OccupationalTraining>();
		affiadavit = new Affidavit();
		applicationForReciprocity = new ApplicationForReciprocity();
		educationBackground = new EducationBackground();
		occupationalLicenses = new OccupationalLicenses();
		officeUseOnlyInfo = new OfficeUseOnlyInfo();
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrefixOfName() {
		return prefixOfName;
	}
	public void setPrefixOfName(String prefixOfName) {
		this.prefixOfName = prefixOfName;
	}
	public TypeOfLicencsApplication getTypeOfLicenseApp() {
		return typeOfLicenseApp;
	}
	public void setTypeOfLicenseApp(TypeOfLicencsApplication typeOfLicenseApp) {
		this.typeOfLicenseApp = typeOfLicenseApp;
	}
	public String getSocialSecurityNum() {
		return socialSecurityNum;
	}
	public void setSocialSecurityNum(String socialSecurityNum) {
		this.socialSecurityNum = socialSecurityNum;
	}
	public String getRegulatedEntity() {
		return regulatedEntity;
	}
	public void setRegulatedEntity(String regulatedEntity) {
		this.regulatedEntity = regulatedEntity;
	}
	public String getCustomerRole() {
		return customerRole;
	}
	public void setCustomerRole(String customerRole) {
		this.customerRole = customerRole;
	}
	public String getTypeOfCustomer() {
		return typeOfCustomer;
	}
	public void setTypeOfCustomer(String typeOfCustomer) {
		this.typeOfCustomer = typeOfCustomer;
	}
	public String getMailingAddress() {
		return mailingAddress1+" "+mailingAddress2;
	}
	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}
	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}
	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}
	public void setWorkPhoneNumber(String workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGeneralInfo() {
		return generalInfo;
	}
	public void setGeneralInfo(String generalInfo) {
		this.generalInfo = generalInfo;
	}
	public String getAttachementsDescription() {
		return attachementsDescription;
	}
	public void setAttachementsDescription(String attachementsDescription) {
		this.attachementsDescription = attachementsDescription;
	}
	public String getAttachementsPath() {
		return attachementsPath;
	}
	public void setAttachementsPath(String attachementsPath) {
		this.attachementsPath = attachementsPath;
	}
	public String getComplianceHistory() {
		return complianceHistory;
	}
	public void setComplianceHistory(String complianceHistory) {
		this.complianceHistory = complianceHistory;
	}
	public String getComplianceExplain() {
		return complianceExplain;
	}
	public void setComplianceExplain(String complianceExplain) {
		this.complianceExplain = complianceExplain;
	}
	public String getLicensedInAnotherState() {
		return licensedInAnotherState;
	}
	public void setLicensedInAnotherState(String licensedInAnotherState) {
		this.licensedInAnotherState = licensedInAnotherState;
	}
	public List<OccupationalTraining> getOccupationalTrainingList() {
		return occupationalTrainingList;
	}
	public void setOccupationalTrainingList(List<OccupationalTraining> occupationalTrainingList) {
		this.occupationalTrainingList = occupationalTrainingList;
	}
	public Affidavit getAffiadavit() {
		return affiadavit;
	}
	public void setAffiadavit(Affidavit affiadavit) {
		this.affiadavit = affiadavit;
	}
	public ApplicationForReciprocity getApplicationForReciprocity() {
		return applicationForReciprocity;
	}
	public void setApplicationForReciprocity(ApplicationForReciprocity applicationForReciprocity) {
		this.applicationForReciprocity = applicationForReciprocity;
	}
	public EducationBackground getEducationBackground() {
		return educationBackground;
	}
	public void setEducationBackground(EducationBackground educationBackground) {
		this.educationBackground = educationBackground;
	}
	public OccupationalLicenses getOccupationalLicenses() {
		return occupationalLicenses;
	}
	public void setOccupationalLicenses(OccupationalLicenses occupationalLicenses) {
		this.occupationalLicenses = occupationalLicenses;
	}
	public OfficeUseOnlyInfo getOfficeUseOnlyInfo() {
		return officeUseOnlyInfo;
	}
	public void setOfficeUseOnlyInfo(OfficeUseOnlyInfo officeUseOnlyInfo) {
		this.officeUseOnlyInfo = officeUseOnlyInfo;
	}


	public String getSocialDOBNum() {
		return socialDOBNum;
	}

	public void setSocialDOBNum(String socialDOBNum) {
		this.socialDOBNum = socialDOBNum;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getWorkEmail() {
		return workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public String getVoucherNumber() {
		return voucherNumber;
	}

	public void setVoucherNumber(String voucherNumber) {
		this.voucherNumber = voucherNumber;
	}

	public String getAttachementsDescriptionAnother() {
		return attachementsDescriptionAnother;
	}

	public void setAttachementsDescriptionAnother(String attachementsDescriptionAnother) {
		this.attachementsDescriptionAnother = attachementsDescriptionAnother;
	}

	public String getUSTAFiles() {
		return USTAFiles;
	}

	public void setUSTAFiles(String uSTAFiles) {
		USTAFiles = uSTAFiles;
	}

	public String getUSTBFiles() {
		return USTBFiles;
	}

	public void setUSTBFiles(String uSTBFiles) {
		USTBFiles = uSTBFiles;
	}

	public String getMilitaryVeteran() {
		return militaryVeteran;
	}

	public void setMilitaryVeteran(String militaryVeteran) {
		this.militaryVeteran = militaryVeteran;
	}

	public String getCurrentMaillingAddress() {
		return currentMaillingAddress;
	}

	public void setCurrentMaillingAddress(String currentMaillingAddress) {
		this.currentMaillingAddress = currentMaillingAddress;
	}		
}
