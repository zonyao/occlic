package com.ambonare.TCEQForm.service;

import java.util.HashMap;
import java.util.Map;

public class GlobalConstant {
	private static Map<String,String> licenseCodes = null;
	
	private static void init()
	{
		licenseCodes = new HashMap<String,String>();
		licenseCodes.put("BAT", "BACKFLOW PREVENTION ASSEMBLY TESTER LICENSE (BPAT)");
		licenseCodes.put("CSI", "CUSTOMER SERVICE INSPECTOR LICENSE (CSI)");
		licenseCodes.put("IRR", "IRRIGATOR/TECHNICIAN/INSPECTOR LICENSE");
		licenseCodes.put("CAS", "LPST CORRECTIVE ACTION SPECIALIST");
		licenseCodes.put("PPM", "LPST PROJECT MANAGER LICENSE");
		licenseCodes.put("STT", "MUNICIPAL SOLID WASTE (MSW)");			
		licenseCodes.put("OIR", "OSSF INSTALLER/DESIGNATED REPRESENTATIVE/SITE EVALUATOR LICENSE/APPRENTICE");
		licenseCodes.put("AMP", "OSSF MAINTENANCE PROVIDER/TECHNICIAN LICENSE");
		licenseCodes.put("SLC", "UST CONTRACTORS LICENSE");
		licenseCodes.put("SLI", "UST INSTALLER/ON-SITE SUPERVISOR LICENSE");
		licenseCodes.put("WQC", "WASTEWATER OPERATOR LICENSE");
		licenseCodes.put("WSC", "WATER OPERATOR LICENSE");
		licenseCodes.put("ROC", "WATER TREATMENT SPECIALIST LICENSE");
		licenseCodes.put("Upload_Max_Size", "MB");
		licenseCodes.put("logMaxSize", "KB");
		licenseCodes.put("email_list", "Separated by a space.(administrator)");
	}
	
	public static Map<String,String> getLicenseCodes(){
		if(licenseCodes==null){
			init();
		}
		return licenseCodes;
	}
	
}
