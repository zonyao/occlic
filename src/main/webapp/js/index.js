var type="pdf|doc|docx|jpg|png|jpeg";
var upload_max_size = 10;
var currentTab = null;
var filetype_reminder_message="File is not "+type.replace(/\|/g,', ')+" type";

//var E_PAY = "https://www3tst.tceq.texas.gov/epay/";

function fileTypeCheck(filepath){
	var types = type.split('|');
	for(var i=0;i<types.length;i++){
		var pTypes = filepath.split('.');
		var pfilepath = pTypes[pTypes.length-1].toLowerCase();
		if(pfilepath==types[i]){
			return true;
		}
	}
	return false;
}

function  fileSizeCheck(obj){

	var size = obj.files[0].size;
	if(size > upload_max_size*1048576){
		return false;
	}
	return true
}

function removeFile(obj){
	$(obj).parent().parent().remove();
	var file_id = $(obj).prop("id");
	file_id =file_id.replace(/remove_/g,'');
	$("#"+file_id).remove();
	ser_number();
	$(".fileerrorTip").html("").hide();
}

function next(obj){
	var id = $(obj).parent().parent().attr("id");
	var id_next = parseInt(id.replace(/panel-part/,""))+1;
	var next_tab = "[href='#panel-part"+id_next+"']";
	var valid_bool = $("#tceqform").valid();
	if(valid_bool){
		//show next tab, and go.
		$(next_tab).prop('disabled',false);
		$(next_tab).removeAttr('class');
		$(next_tab).trigger("click");
		currentTab = next_tab;
	}

}


function checkValid(obj){

	var result = $("#tceqform").valid();
	if(result==false){
		$(obj).prop('disabled',true);    		  
		//alert("Please fill required fields.");
		dialog =  $("#dialog").dialog({
			modal:true,
			resizable:true,
			dialogClass: "no-close",
			buttons:[{
				text:"OK",
				"class":'dialog_button',
				click:function(){
					dialog.dialog("close");
					$("#myTab").find("[data-toggle='tab']").each(function(){
						if($(this).prop('class')!='disabled_tab'){
							$(this).prop("disabled",false);
						}
					});
				}
			}]

		});	

		return false;       
	}
	else if($(obj).prop("class")==""){
		$(obj).prop('disabled',false);
		result = true;
		currentTab = obj;
	}
	setTimeout(function(){$("#tceqform").valid();$("#affiadavitsignature").focus();},1000);
	return result;
}

function  feeChecker(obj){
	var result = false;
	if(!checkValid(obj)){
		return false;
	}
	$("#voucherNumber").prop('readonly',false);
	if(($("[name='typeOfLicenseApp.LPST']").is(":checked")&&($("[value='PE']").is(':checked')||$("[value='PG']").is(':checked')))|$("[name='militaryVeteran']").is(':checked')) {
		$("#fee").html("0.00");
		$("#goToEpayBtn").prop("disabled",true).prop("class","disable_button");
		$("#voucherNumber").prop('readonly',true).prop('class','input_gray').val("");
		result = true;
	}
	else{	
		$("#goToEpayBtn").prop("disabled",false).prop("class","my_button");
		//checked license tyep and suffix
		$("#licenceType").prop('disabled',false);
		$("#LT").find("[type='radio']").each(function(){
			if($(this).prop('checked')){
				var	class_Name =  $(this).attr("class");
				var classNameReals = class_Name.split(' ');
				var classNameReal = classNameReals[0];
				//console.log(classNameReal);
				$("#licenceType").find("[value='"+classNameReal+"']").prop('selected','selected');
				$("#licenceType").trigger('onchange');
			}
		});		   
		$("#voucherNumber").prop('readonly',false).removeAttr("class");
		$("#check_remind_message").html('');

	}
	if(!$("#licenceType").isDisabled){
		$("#licenceType").prop('disabled',true);
	}
	return result;
}

function  formatPhoneNumberStr(value) {
	if(value.length>14){
		return value.substring(0,14);
	}
	var pNmber = value.replace('(','').replace(')','').replace('-','').replace('/\w/g','').replace('(','').replace(')','').replace('-','').replace('/\w/g','');

	var length  = pNmber.length;
	var formtPhoneNumber = "";
	if(length>=7){
		formtPhoneNumber = '('+pNmber.substring(0,3)+')-'+pNmber.substring(3,6)+'-'+pNmber.substring(6,length);
		return formtPhoneNumber;
	}
	else if(length>=4){
		formtPhoneNumber = '('+pNmber.substring(0,3)+')-'+pNmber.substring(3,length);
		return formtPhoneNumber;
	}
	else if(length>=1){
		formtPhoneNumber ='('+pNmber;
		return formtPhoneNumber;
	}
}

function  phoneNumberFormat(obj) {
	var value = obj.value;
	var value1 = formatPhoneNumberStr(value);
	$(obj).val(value1);
	return value1;
}

function payment(){
	var E_PAY = "Epay";
	window.open(E_PAY);
}

function getAmount(value){	
	//ajax 
	$.ajax({
		type:'post',
		url:'prams?key='+value,
		date:{},
		chache:false,
		dataType:'json',
		success:function(data){
			$("#fee").html(data.toFixed(2));
		},
		error:function(){
			$("#fee").html("0.00");
		}
	});
}
function getParams(key){
	$.ajax({
		type:'post',
		url:'prams?key='+key,
		date:{},
		chache:false,
		dataType:'text',
		success:function(data){
			if(key=='Upload_Max_Size'){
				upload_max_size = data;
			}
			if(key=='Upload_File_Type'){
				type=data;
			}
			if(key=='Epay'){
				E_PAY=data;
			}
		},
		error:function(){
			return null;
		}
	});
}


var SSN = '';
$("#realSSN").hide();
function mask(obj){
	var insert_number =[3,5];
	var separator ="-";
	var mask = "*";
	var val = obj.value;
	var valLength = val.replace(/-/g,'').length;
	var SSNReal = val.replace(/-/g,'');
	var replace_string = obj.value.replace(/[^-]/g,mask);
	if(SSN.length < valLength)
	{
		SSN=SSN+SSNReal.substring(valLength-1);
		for(i=0;i<insert_number.length;i++){
			if(valLength==(insert_number[i]+1)){
				var tmp = separator + mask;
				replace_string = replace_string.substring(0,replace_string.length-1)+tmp;
			}
		}
	}
	else if(SSN.length > valLength){
		SSN = SSN.substring(0,valLength);
	}	
	$(obj).val(replace_string);	
}
function beforMask(obj){
	var showLast = 4;
	var length = 9;
	var patt1=new RegExp('[^\*-]*[^0-9\*-]$','g');
	if(patt1.test(obj.value)==true){
		$(obj).val(obj.value.substring(0,obj.value.length-1));
		return ;
	}
	else if(SSN.indexOf('*')!=-1||SSN.indexOf('-')!=-1){
		console.log(SSN);
		$(obj).val(obj.value.substring(0,obj.value.length-1));
		SSN = SSN.replace(/\*/g,'');
		return ;
	}

	mask(obj);

	if(obj.value.replace(/-/g,'').length>=(length - showLast)){
		var  show = SSN.substring((length - showLast),SSN.length);
		var  masks = obj.value.substring(0,(obj.value.length-show.length));

		$(obj).val(masks+show)
	}

	$("#realSSN").val(SSN)	

}
function onMouseOver(obj) {
	obj.style.background = "#2d4b62";
}

function onMouseOut(obj) {
	obj.style.background = "#526d82";
}

function checkVoucherNumber(obj){
	var fee  = feeChecker(obj);
	if(fee == true){
		next(obj);
		return ;
	}

	$("#check_remind_message").html("");
	$.ajax({
		type:'post',
		url:"vourcherCheck?vourcherNumber="+$("#voucherNumber").val()+"&amount="+$("#fee").html(),
		chache:false,
		data:{},
		success:function(date){
			$("#feePaidNext").attr("class","my_button").removeAttr("disabled");
			$("#check_remind_message").html(date).prop('class','reminder_text');
			if(date=='SUCCESS'){
				next(obj);
				return;
			}else{		
				$("[href='#panel-part7']").attr('class','disabled_tab');
				$("[href='#panel-part7']").prop('disabled',true);
			}
		},
		error:function(){
			$("#check_remind_message").html("Error, Please try again.").prop('class', 'reminder_text');
			return;
		}
	});

}


function ser_number(){
	var ser=1;
	$(".ser_number").each(function(){
		$(this).html(ser);
		ser++;
	});	
	if(ser==1){
		$("#selectFileInit").show();
	}else{
		$("#selectFileInit").hide();
	}
	$("#addNewAttchement").valid();
}



$().ready(
		function () {
			/*-----------------------------
			 * Init Params
			 *-----------------------------*/		
			getParams("Upload_Max_Size")
			getParams("Upload_File_Type");	
			getParams("Epay");
			/*----------------------------------
		       Phone number , Email address: Auto complete issue tmp solution	 
			 ----------------------------------*/
			$("#contact_info_section").find("input").change(function(){
				$("#tceqform").valid();
			});
			$("#withInUS_DIV").find("input").change(function(){
				$(this).valid();
			});
			$("#licenseattachfile").change(function(){
				$(this).valid();
			});
			$("#firstname").on("input",function(){
				//$(this).val($(this).val().replace(/\d|>|<|\?|\/|\\|\*|:|\||"|/g,""));
				//$(this).val($(this).val().replace(/[^a-zA-Z\d\u4e00-\u9fa5,.!?()，．；;？]/g,""));
				$(this).val($(this).val().replace(/[^a-zA-Z]/g,""));
				$(this).valid();
			});
			$("#middlename").on("input",function(){
				//$(this).val($(this).val().replace(/\d|>|<|\?|\/|\\|\*|:|\||"|/g,""));
				//$(this).val($(this).val().replace(/[^a-zA-Z\d\u4e00-\u9fa5,.!?()，．；;？]/g,""));
				$(this).val($(this).val().replace(/[^a-zA-Z]/g,""));
				$(this).valid();
			});
			$("#lastname").on("input",function(){
				//$(this).val($(this).val().replace(/\d|>|<|\?|\/|\\|\*|:|\||"|/g,""));
				//$(this).val($(this).val().replace(/[^a-zA-Z\d\u4e00-\u9fa5,.!?()，．；;？]/g,""));
				$(this).val($(this).val().replace(/[^a-zA-Z]/g,""));
				$(this).valid();
			});

			$("textarea").on("focus",function(){
				var textContent = $(this).val();
				var realContent = textContent.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
				if (realContent.length<=0){
					$(this).val("");
				}
			});

				/*------------------
                 * When using the autofill feature in chrome,fill section1-1-YES's four field with the correct data, should pass the validation.
                 -------------------*/
			$("[placeholder='MM/DD/YYYY']").change(function(){
				
				$(this).valid();
				
			});
			$("[placeholder='MM/YYYY']").change(function(){
				$(this).valid();
			});

			$("#dialog").hide();
			$("#socialSecurityNum").hide();
			$("[name='licenseTypeSelectCheck']").hide();
			$("[href='#panel-part2']").attr('class','disabled_tab');
			$("[href='#panel-part3']").attr('class','disabled_tab');
			$("[href='#panel-part4']").attr('class','disabled_tab');
			$("[href='#panel-part5']").attr('class','disabled_tab');
			$("[href='#panel-part6']").attr('class','disabled_tab');
			$("[href='#panel-part7']").attr('class','disabled_tab');

			$("[href='#panel-part2']").prop('disabled',true);
			$("[href='#panel-part3']").prop('disabled',true);
			$("[href='#panel-part4']").prop('disabled',true);
			$("[href='#panel-part5']").prop('disabled',true);
			$("[href='#panel-part6']").prop('disabled',true);
			$("[href='#panel-part7']").prop('disabled',true);


			$("#LT").find("[type='radio']").change(function(){
				//set other licence type radio disable
				var name = $(this).attr("name");
				var className = $(this).attr("class");
				if($(this).prop("name")!="typeOfLicenseApp.WaterType"){
					$("#LT").find("[type='radio']").filter("[name!='"+name+"']").filter("[class!='"+className+"']").prop("checked",false);
				}
				if($(this).prop("name")!="typeOfLicenseApp.WaterLevel"&&$(this).prop("name")!="typeOfLicenseApp.WaterType"){
					$("#divWaterHideOrShow").hide();
				}
				$("#licenceType").prop('disabled',false);
				$("#licenceType").find("[value='"+className+"']").prop('selected','selected');
				$("#licenceType").trigger('onchange');
				//make section 7 can not click
				$("[href='#panel-part7']").attr('class','disabled_tab');
				$("[href='#panel-part7']").prop('disabled',true);
                 
				//check lpst-suffix
				$(".lpst_suffix").trigger('change');
				//
				$("[name='typeOfLicenseApp.WaterLevel']").valid();
			});


			$(".lpst_suffix").change(function(){

				if($(".PPM").prop('checked') && $("[value='PG']").prop('checked')==false && $("[value='PE']").prop('checked')==false){          		
					$("[href='#panel-part7']").attr('class','disabled_tab');
					$("[href='#panel-part7']").prop('disabled',true);			
				}
				else if($(".PPM").prop('checked') && ($("[value='PG']").prop('checked')||$("[value='PE']").prop('checked'))){
					if($("[href='#panel-part6']").prop('disabled')==false){
						$("[href='#panel-part7']").removeAttr('class');
						$("[href='#panel-part7']").prop('disabled',false);
					}		
				}
			});

			$(".file").on("change","input[type='file']",function(){
				var filePath=$(this).val();
				if(filePath.length<=0)return true;
				filePath = filePath.toLowerCase();
				if(fileTypeCheck(filePath)){
					if (fileSizeCheck(this)) {
						$("#showErrorTip").html("").hide();
						var arr = filePath.split('\\');
						var fileName = arr[arr.length - 1];
						$("#showFileName1").html(fileName);
						$("#fileSelectBtn").html("Remove");
						return true;
					}else{
						$("#showFileName1").html("No file selected");
						var max_size_error="Each file must be less than "+upload_max_size+" M.";
						$("#showErrorTip").html(max_size_error).show();
						return false;
					}
				}else{
					$("#showFileName1").html("No file selected");
					$("#showErrorTip").html(filetype_reminder_message+", please choose another file.").show();
					$("#licenseattachfile").val("");
					return false 
				}
			});

			$(".file").on("click","input[type='file']",function(){
				if($("#fileSelectBtn").html()=='Remove'){
					$("#fileSelectBtn").html("Upload File");
					$(this).val('');
					$("#showFileName1").html("No file selected");
					return false;
				}
				return true;
			});

			$("#tceqform").submit(function(){
				if(submitable&&submited==false){
					//VALIDATE ALL FIELD.
				}
				else{
					return false;
				}
			});

			var first_error;
			$("#tceqform").validate({
				//debug:true,	
				onkeyup:function(error,element){
					$("#tceqform").valid();	

				},
				errorPlacement: function (error, element) { 
					if ($(element).attr("type") == "radio"|| $(element).attr("type") == "file"||$(element).attr("checkbox")) {
						$(element).closest("form").find("span[id='" + element.attr("name") + "']").html(error);
					}
					else {
						error.appendTo(element.parent());
					}
					$(error).css("color", "red").css("font-size", 14).css("font-weight","normal");
				},
				errorElement: "span",
				rules: {
					lastName: {
						required:true,
						minlength:1
					},
					firstName:{
						required:true,
						minlength:1
					},
					title:"required",
					typeOfLicenseApp: "required",
					licenseCopyFile:{
						isNeedUploadLicense:true
					},
					socialSecurityNumMask:{
						required:true,
						isSocialSecurityNum:true
					},
					mailingAddress1:{
						required:true,
					},
					birthday_show:{
						required:true,
						isValidDateFormat:true,
					},	
					'applicationForReciprocity.issueDate':{
						isValidDateFormat:true,
					},
					'applicationForReciprocity.expirationDate':{
						isValidDateFormat:true,
					},
					city: {
						required:true,
					},
					state: {
						required: true
					},
					zipCode: {
						required: true,
						minlength: 5,
						maxlength: 5
					},
					zipCodePlus:{
						minlength: 4,
						maxlength: 4
					},
					workEmail:{
						email:true ,
						atLeastOne:['workEmail','personalEmail']
					},
					personalEmail:{
						email:true,
						atLeastOne:['workEmail','personalEmail']
					},
					/*
					cellPhoneNumber:{
						isPhoneNumber:true,
						atLeastOne: ['cellPhoneNumber','homePhoneNumber','workPhoneNumber']
					},*/
					homePhoneNumber:{
						isPhoneNumber:true,
						atLeastOne: ['homePhoneNumber','workPhoneNumber']
					},
					workPhoneNumber:{
						isPhoneNumber:true,
						atLeastOne: ['homePhoneNumber','workPhoneNumber']
					},
					licensedInAnotherState: {
						required: true
					},
					'typeOfLicenseApp.WaterLevel':{
						licenseTypeSelect:true
					},
					'typeOfLicenseApp.WaterType':{
						required:true
					},
					'affiadavit.signature': {
						required: true
					},  
					'officeUseOnlyInfo.amount': {
						digits: true
					},                 
					'officeUseOnlyInfo.licenseNum': {
						number: true
					},
					'officeUseOnlyInfo.feePaid': {
						required: true
					},
					'occupationalLicenses.issuanceDate': {
						isValidDateFormat:true,
					},
					'occupationalLicenses.expirationDate':{
						isValidDateFormat:true,
					},
					'affiadavit.date':{
						isValidDateFormat:true,
					},
					'occupationalTrainingList[0].trainingDate':{
						isValidDateFormat2:true
					},
					'occupationalTrainingList[1].trainingDate':{
						isValidDateFormat2:true
					}
					,
					'occupationalTrainingList[2].trainingDate':{
						isValidDateFormat2:true
					}
					,
					'occupationalTrainingList[3].trainingDate':{
						isValidDateFormat2:true
					},
					'affiadavit.affidavit':{
						required:true
					},
					'educationBackground.educationYearOfGraduation':{
						isValidDateFormat3:true
					},
					uploadFileVerify:{
						uploadFileVerify:true
					}
				},
				messages: {
					lastName: {
						required:"This field is required."
					},
					firstName:{
						required:"This field is required."
					},
					/*
					cellPhoneNumber:{
						rangelength:'Please input a valid phone number',
						atLeastOne:'One of the cell/home/work phone number is required.'
					},*/
					homePhoneNumber:{
						rangelength:'Please input a valid phone number',
						atLeastOne:'One of these is required: day/work phone or evening/home phone.'
					},
					workPhoneNumber:{
						rangelength:'Please input a valid phone number.',
						atLeastOne:'One of these is required: day/work phone or evening/home phone.'
					},
					socialSecurityNumMask:{
						required:'SSN or taxid is required.',
					},
					workEmail:{
						atLeastOne:'One of the work/personal e-mail address is required.'
					},
					personalEmail:{
						atLeastOne:'One of the work/personal e-mail address is required.'
					},
					'typeOfLicenseApp.WaterType':{
						required:"Water Operators type is required."
					},
					title:{
						required:"Name Prefix is required."
					},
					zipCode:{
						required:"</br>This field is required.",
						minlength:"</br>Not a valid zip code.",
						maxlength:""
					},
					zipCodePlus:{
						minlength:"</br>Please enter at least 4 characters.",
						maxlength:""
					},
					birthday:{
						required:"This field is required."
					},
					'affiadavit.printName':{
						required:"Selection is required."
					},
					birthday_show:{
						required:"Date of birth is required."
					},
					'affiadavit.affidavit':{
						required:""
					},
				}
			});

			var submitable = false;
			var submited = false;
			$("#submitform").click(function(){
				if(submited){
					//alert("Processing... Please wait a moment");
					alert("Please do not submit the same form repeatedly, press F5 to refresh.");
					//location.reload(true);
					return;
				}
				if(!$("#tceqform").valid()){
					return;
				}
				submitable = true;
				$("#tceqform").submit();
				submitable = false;
				submited = true;
			});


			function  checkFileName(filePath){
				var count = 0;
				$(".mutifile").each(function(){
					var path =  $(this).val();           		
					if(filePath==path){           			
						count++;
					}               		
				});
				if(count>=2){
					return false;
				}
				return true;
			}

			var id = 1;
			var fileid='';
			var serNum=0;
			$("#addNewAttchement").click(function(){
				$("#selectFileInit").hide();
				fileid= "file"+id;
				$("#fileupload_showfiles").append("<input id='"+fileid+"'  name='"+fileid+"' type='file' class='mutifile'>");
				$(".mutifile").on("change",function(){
					var filePath = $(this).val();
					var fileTypeChecked = fileTypeCheck(filePath);
					var fileSizeChecked = fileSizeCheck(this);
					var fileNameChecked = checkFileName(filePath);
					var result = fileTypeChecked&&fileNameChecked&&fileSizeChecked;

					filePath = filePath.toLowerCase();
					if(result){
						$(".fileerrorTip").html("").hide();
						var arr=filePath.split('\\');
						var fileName=arr[arr.length-1];
						$("#fileupload_showfiles").append("<tr ><td class='ser_number'></td><td><strong  class='showFileName'>"+fileName+"</strong></td> <td><a id='remove_"+fileid+"' href='javascript:;'  class='file' >Remove</a></td></tr>");
						$("#remove_"+fileid).on('click',function(){
							removeFile(this);
						});
						ser_number();
					}
					else{
						$("#"+fileid).remove();
						if (!fileTypeChecked){
							filetype_reminder_message="File is not "+type.replace(/\|/g,', ')+" type";
							$("#fileerrorTipMsg").html(filetype_reminder_message+" or the file already existed, please choose another file.").show();
						} else {
							if (!fileSizeChecked){
								var max_size_error="Each file must be less than "+upload_max_size+" M.";
								$("#fileerrorTipMsg").html(max_size_error).show();
							}
						}
					}
				});
				$("#"+fileid).hide();    
				$("#"+fileid).trigger("click");
				id++;
			});


			$("#remove_files").click(function(){
				$("#fileupload_showfiles").empty();
			});

			$("#licensedInAnother_DIV").hide();
			$("#radioYes").click(function(){
				$("#licensedInAnother_DIV").show();
				$("#licenseattachfile").valid();

			});
			$("#radioNo").click(function(){
				$("#licensedInAnother_DIV").hide();
			});


			$("#divWaterHideOrShow").hide();
			$("#radioWaterA").click(function(){
				$("#divWaterHideOrShow").hide();
				$("[name='typeOfLicenseApp.WaterType']").prop('checked',false);
			});
			$("#radioWaterB").click(function(){
				$("#divWaterHideOrShow").show();
			});
			$("#radioWaterC").click(function(){
				$("#divWaterHideOrShow").show();
			});
			$("#radioWaterD").click(function(){
				$("#divWaterHideOrShow").hide();
				$("[name='typeOfLicenseApp.WaterType']").prop('checked',false);
			});

			$("#outsideOfUS_DIV").hide();
			$("#radioYes_outside").click(function(){
				$("#outsideOfUS_DIV").show();
				$("#withInUS_DIV").hide();
			});
			$("#radioNo_outside").click(function(){
				$("#outsideOfUS_DIV").hide();
				$("#withInUS_DIV").show();
			});

			$("#dialog_msg").html("The required fields in the current tab need to be completed.");

			/* issue: Add new line*/
			var line_num = 4;
			var copy_tr_id="#training_init_column";
			var copy_str="<tr>"+$(copy_tr_id).html()+"</tr>";
			var table_body="#training_table_body";
			$("#addNewLine").click(
					function(){
						if(line_num>11){
							return;
						}
						var str = copy_str.replace(/\[0\]/g,'['+line_num+']');
						$(table_body).append(str);
						/*
						var monthYearField = $(table_body).find("[placeholder='MM/YYYY']");
						monthYearField.rules('add',{isValidDateFormat2:true});
						$("[placeholder='MM/YYYY']").formatter({
							'pattern':'{{99}}/{{9999}}',
							'persistent':false
						});
						var inputname="occupationalTrainingList["+line_num+"].trainingDate";
						monthYearField.rules(inputname,{isValidDateFormat2:true});
						*/
						//$(table_body).find("[placeholder='MM/YYYY']").on("click",function(){
						$(table_body).find("[placeholder='MM/YYYY']").on("input",function(){
							$(this).rules('add',{isValidDateFormat2:true});
							$("[placeholder='MM/YYYY']").formatter({
								'pattern':'{{99}}/{{9999}}',
								'persistent':false
							});
							var inputname="occupationalTrainingList["+line_num+"].trainingDate";
							$(this).rules(inputname,{isValidDateFormat2:true});
						});

						var tdTextarea = table_body + " tr:last textarea";
						$(tdTextarea).on("focus",function(){
							var textContent = $(this).val();
							var realContent = textContent.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
							if (realContent.length<=0){
								$(this).val("");
							}
						});
						/*	$(this).datepicker({
						 changeMonth: true,
						 changeYear: true,
						 dateFormat: "mm/yy",
						 yearRange:'-100:+50',
						 onChangeMonthYear:function(year,month){
						 if(month<10){
						 month = "0"+month;
						 }
						 $(this).val(month+"/"+year);
						 }
						 }).focus();
						*/

						line_num = parseInt(line_num)+1;
					});

			/*$("[placeholder='MM/YYYY']").datepicker({
				changeMonth: true,
				changeYear: true,
				dateFormat: "mm/yy",
				yearRange:'-100:+50',
				onChangeMonthYear:function(year,month){
					if(month<10){
						month = "0"+month;
					}
					$(this).val(month+"/"+year);
				} 
			});*/


			$("[name='militaryVeteran']").click(function(){
				if($(".PPM").prop('checked') && ($("[value='PG']").prop('checked')||$("[value='PE']").prop('checked'))){return;}
				
				if($(this).is(':checked')){
					
						$("#fee").html("0.00");
						$("#voucherNumber").prop('readonly',true).prop('class','input_gray').val("");
						$("#goToEpayBtn").prop('class','disable_button').prop('disabled',true);
						$("[href='#panel-part7']").prop('disabled',false).removeAttr('class');
						$("#check_remind_message").html('');
				}
				else{
					$("[href='#panel-part6']").trigger("click");
					$("[href='#panel-part7']").attr('class','disabled_tab').prop('disabled',true);
					$("#goToEpayBtn").prop('class','my_button').prop('disabled',false);
				}
			});

			$("#voucherNumber").change(function(){
				$("[href='#panel-part7']").attr('class','disabled_tab').prop('disabled',true);
			});

			/*
			 *Resolve date of birth only year visible 
			 */
			var birthday_valid = false;
			$("#birthday_input").change(function(){
				if($(this).valid()&&birthday_valid==false){
					var value = $(this).val();
					var year = value.substring(6);
					var repalce_str = "**/**/"+year;
					$("#birthday_real").val(value);
					birthday_valid = true;
					$(this).rules("remove")
					$("#birthday_input").val(repalce_str);$("#birthday_input").blur();
				}
				else{
					if(birthday_valid){
						birthday_valid = false;
						var value = $(this).val();
						$(this).rules('add',{required:true,isValidDateFormat:true})
						var tmpStr =  $(this).val();
						if(tmpStr.indexOf("*")!=-1){
							//replece * with true day
							var day = $("#birthday_real").val();
							day = day.substring(3,5);
							tmpStr = tmpStr.substring(0,2)+"/"+day+"/"+tmpStr.substring(6);
							$(this).val(tmpStr);
						}
						if($(this).valid())
						{$(this).trigger('change');}
						else if(value.indexOf('*')!=-1){
							$(this).val("");
						}
					}
				}
			});
			$("#birthday_input").click(function(){
				var value = $(this).val();
				if(value!=""&&value.indexOf('*')!=-1){
					/*$(this).datepicker("setDate",new Date($("#birthday_real").val()));*/
					$(this).val($("#birthday_real").val());
				}
			});
			$("#birthday_input")/*.keyup(function(){
				$(this).trigger('change');
			})*/.blur(function(){
				var value = $(this).val();
				if(value.indexOf('*')==-1){
					 $(this).trigger('change');
				}
			});
			/*
			 * Clear browser catch data ,refresh page. 
			 */
			if($("[name='lastName']").val()!=""){
				window.location.reload(true);
			};

			/**
			 * Attachemnts description [other checkBox] focus.
			 */
			$("#attachementsDescription_other").click(function(){
				if($(this).is(":checked")){
					$("[name='attachementsDescriptionAnother']").focus().removeAttr('placeholder');
				}
				else{
					$("[name='attachementsDescriptionAnother']").val("").prop("placeholder","Other");
				}		
			});
			
			
			/*
			 * socialSecurityNumMask mask as ***-**-XXXX
			 */
			socialSecurityNum_valid = false;
			$("#socialSecurityNumId").change(function(){
				if($(this).valid()&&socialSecurityNum_valid==false){
					var value = $(this).val();
					var tmp_replace = "***-**"+value.substring(6);
					$("#realSSN").val(value);
					socialSecurityNum_valid = true;
					$(this).rules("remove");
					
						$("#socialSecurityNumId").val(tmp_replace);
						$("#socialSecurityNumId").blur();	
						
				}
				else if(socialSecurityNum_valid){
					socialSecurityNum_valid = false;
					$(this).rules('add',{required:true,isSocialSecurityNum:true});
					if($(this).valid()){
					   $(this).trigger('change');
					}
				}
			})
		   .click(function(){
			   var value = $(this).val();
				if(socialSecurityNum_valid&&value.indexOf('*')!=-1){
					$(this).val($("#realSSN").val());
				}
			})
			/*.keyup(function(){
				 $(this).trigger('change');
			})*/
			.blur(function(){
				var value = $(this).val();
				if(value.indexOf('*')==-1){
					 $(this).trigger('change');
				}
			});

			var socialSecurityNum_valid = false;
			$("[name='socialSecurityNumMask']")
			.formatter({
				'pattern':'{{999}}-{{99}}-{{9999}}',
				'persistent':false
			});
			
			$("[placeholder='MM/DD/YYYY']").formatter({
				'pattern':'{{99}}/{{99}}/{{9999}}',
				'persistent':false
			});
			
			$("[placeholder='MM/YYYY']").formatter({
				'pattern':'{{99}}/{{9999}}',
				'persistent':false
			});
			$("[placeholder='(XXX)XXX-XXXX']").formatter({
				'pattern':'({{999}}){{999}}-{{9999}}',
				'persistent':false
			})
			/*Verify the documents amount match the options checked at description of documents. */
			$("[name='attachementsDescription']").change(function(){$("#addNewAttchement").valid()});
			$("[name='attachementsDescription_other']").change(function(){$("#addNewAttchement").valid()});
			
			
			/** affiadavit.date  default  today**/
			var today = new Date();
			var day = today.getDate();
			if(day<10){
				day = '0'+day;
			}
			var month = today.getMonth()+1;
			if(month<10){
				month = '0'+month;
			}
			var year = today.getFullYear();
			
			var format_str = month+'/'+day+'/'+year;
			$("[name='affiadavit.date']").val(format_str);

			$("[name='affiadavit.affidavit']").change(function() {
				$("#reqAffidavit").removeClass("req2");
				if (this.checked){
					//$("#reqAffidavit").addClass("req");
				}else{
					$("#reqAffidavit").addClass("req2");
				}
			});

			$("#affiadavitradioinline span").addClass("hidden")

			$("#cellPhoneNumber").on("input",function(){
				var value1 = phoneNumberFormat(this);
				//var p = new RegExp("\[(][0-9]{3}\[)]\[-][0-9]{3}\[-][0-9]{4}$");
				//return  p.test(value1);
			});

		});