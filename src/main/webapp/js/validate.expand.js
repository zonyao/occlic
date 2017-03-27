//params : elements's id 
jQuery.validator.addMethod("atLeastOne", function(value,element,params) {  
   var length = params.length;
   for(var i=0;i<length;i++){
	   if($("#"+params[i]).val()!=''){
		   return true;
	   }
   }
   return false;
}, "At least one filed is required.");

jQuery.validator.addMethod("isPhoneNumber",function(value,element,params){
	if(value==''){
		return true;
	}

	var value1 = phoneNumberFormat(element);
	/*
	var p0 = new RegExp("^[0-9]*$");
	if (p0.test(value)){
	}else{

	}
	*/
    var p = new RegExp("\[(][0-9]{3}\[)]\[-][0-9]{3}\[-][0-9]{4}$");
    return  p.test(value1);
},"Not a valid phone number.");

jQuery.validator.addMethod("isNeedUploadLicense",function(value,element,params){
	if($(element).val()!="")
   {	    
	   return true
   }
   else {
	   var flag = true;
	   $("#licensedInAnother_DIV").find("[type='text']").each(function(){
		  if($(this).val()==""){
			  flag = false;
		  } 
	   });
	   return flag;
   }
},"&nbsp; &nbsp; You must enter the following four fields: Type and/or Class, Issuing State or Country, Issue Date, Expiration Date, or upload copy of license.");

jQuery.validator.addMethod("licenseTypeSelect",function(value,element,params){
   var flag = false;
	$("#LT").find("[type='radio']").each(function(){
	   if($(this).prop('checked')==true){
		   flag = true;
	   }
   });
   return flag;
},"&nbsp; &nbsp;Please select one type of license.");

jQuery.validator.addMethod("isValidDateFormat",function(value,element,params){
	//DD-MM-YYYY
	var flag = false;
	if(value==''){
		return true;
	}
	var p = new RegExp("^[0-9]{2}/[0-9]{2}/[0-9]{4}$");
	if(p.test(value)){
	    var month = parseInt(value.substring(0,2));
		var day = parseInt(value.substring(3,5));
		var year = parseInt(value.substring(6));
		//var current_year = new Date().getFullYear();
		//var currnt_month = new Date().getMonth();
		//var current_day = new Date().getDay();
		//var abs_year = Math.abs(current_year-year);
		var maxYear = 2060;
		var minYear = 1920;

		var intYear = year;
		var intMonth = month;
		var intDay = day;
		if(isNaN(intYear)||isNaN(intMonth)||isNaN(intDay)) return false;
		if(intMonth>12||intMonth<1) return false;
		if ( intDay<1||intDay>31)return false;
		if((intMonth==4||intMonth==6||intMonth==9||intMonth==11)&&(intDay>30)) return false;
		if(intMonth==2){
			if(intDay>29) return false;
			if((((intYear%100==0)&&(intYear%400!=0))||(intYear%4!=0))&&(intDay>28))return false;
		}

		if(month >=1&&month<=12&&day>=1&&day<=31&&year<=maxYear&&year>=minYear){
			var current_date = new Date();
			var date = new Date(value);
			if(params[0]=="pastTime"){
				flag = current_date>=date;
				return flag;
			}
			else if(params[0]=="futureTime"){
				flag = current_date<=date;
				return flag;
			}
			flag = true;
		}
	}
	return flag;
},"Please enter a valid date.");

jQuery.validator.addMethod("isValidDateFormat2",function(value,element,params){
	//MM/YYYY
	if(value==''){
		return true;
	}
	var maxYear = 2060;
	var minYear = 1920;
	var year = value.substring(3);
	var abs_year = Math.abs(new Date().getFullYear() - value.substring(3));
	var p = new RegExp("^[0-9]{2}/[0-9]{4}$");
	if(p.test(value)){
		var month = parseInt(value.substring(0,2));
		if(month<=12&&month>=1&&year<=maxYear&&year>=minYear){
			return true;
		}
	}
	return false;
},"Please enter a valid date.");

jQuery.validator.addMethod("isValidDateFormat3",function(value,element,params){
	//MM/YYYY
	if(value==''){
		return true;
	}
	var maxYear = 2060;
	var minYear = 1920;
	var year = value;
	if(year>=minYear&&year<=maxYear){
		return true;
	}
	return false;
},"Please enter a valid date.");

jQuery.validator.addMethod("isSocialSecurityNum",function(value,element,params){
	if(value==''){
		return true;
	}
	var p = new RegExp("^[0-9]{3}-[0-9]{2}-[0-9]{4}$");
	return p.test(value);
},"Not a valid social security number.");

jQuery.validator.addMethod("uploadFileVerify",function(value,element,params){
	var number = 0;
	
    $("[name='attachementsDescription']").each(function(){
    	if($(this).prop("checked")){
    		number++;
    	}
    });
    if($("[name='attachementsDescription_other']").prop("checked")){number++}
    if(number==0){return true;}
    var docs_number = 0;
    $(".ser_number").each(function(){
    	docs_number++;
    });
    return docs_number>=1;
},"Please upload the documents you checked.");


