package com.ambonare.TCEQForm.model;

public class TypeOfLicencsApplication {
    String waterLevel;
    String waterType ;
    String wasteWater ;
    String BPAT ;
    String CSI ;
    String landscapeIrrigation;
    String WTS ;
    String MSW ;
    String OSSF ;
    String UST ;
    public String getWasteWater() {
		return wasteWater;
	}
	public void setWasteWater(String wasteWater) {
		this.wasteWater = wasteWater;
	}
	String LPST ;
	public String getWaterLevel() {
		return waterLevel;
	}
	public void setWaterLevel(String waterLevel) {
		this.waterLevel = waterLevel;
	}
	public String getWaterType() {
		return waterType;
	}
	public void setWaterType(String waterType) {
		this.waterType = waterType;
	}
	
	public String getBPAT() {
		return BPAT;
	}
	public void setBPAT(String bPAT) {
		BPAT = bPAT;
	}
	@Override
	public String toString() {
		return "TypeOfLicencsApplication [waterLevel=" + waterLevel + ", waterType=" + waterType + ", wasteWater="
				+ wasteWater + ", BPAT=" + BPAT + ", CSI=" + CSI + ", landscapeIrrigation=" + landscapeIrrigation
				+ ", WTS=" + WTS + ", MSW=" + MSW + ", OSSF=" + OSSF + ", UST=" + UST + ", LPST=" + LPST + "]";
	}
	public String getCSI() {
		return CSI;
	}
	public void setCSI(String cSI) {
		CSI = cSI;
	}
	public String getLandscapeIrrigation() {
		return landscapeIrrigation;
	}
	public void setLandscapeIrrigation(String landscapeIrrigation) {
		this.landscapeIrrigation = landscapeIrrigation;
	}
	public String getWTS() {
		return WTS;
	}
	public void setWTS(String wTS) {
		WTS = wTS;
	}
	public String getMSW() {
		return MSW;
	}
	public void setMSW(String mSW) {
		MSW = mSW;
	}
	public String getOSSF() {
		return OSSF;
	}
	public void setOSSF(String oSSF) {
		OSSF = oSSF;
	}
	public String getUST() {
		return UST;
	}
	public void setUST(String uST) {
		UST = uST;
	}
	public String getLPST() {
		return LPST;
	}
	public void setLPST(String lPST) {
		LPST = lPST;
	}
   }
