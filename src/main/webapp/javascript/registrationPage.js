var PASSWORD_ERROR_STRING = "Password is too short";
var PASSWORD_APPROVED_STRING = "";
var NAME_ERROR_STRING = "Invalid characters";
var NAME_APPROVED_STRING = "";
var SURNAME_ERROR_STRING = "Invalid characters";
var SURNAME_APPROVED_STRING = "";
var DOB_ERROR_STRING=	"Under age";
var DOB_EMPTY_STRING="Please enter date of birth";
var DOB_APPROVED_STRING="";
var CC_ERROR_STRING=	"Invalid card";
var CC_APPROVED_STRING="";
var EXP_ERROR_STRING=	"Invalid Expirary date";
var EXP_APPROVED_STRING="";
var CVV_ERROR_STRING=	"Invalid CVV number";
var CVV_APPROVED_STRING="";

$(document).ready(function(){
	$('#cvv').blur(function(){
		validateCvv($('#cvv').val());
	});
	
	$('#expiry_date').blur(function(){
		validateExp($('#expiry_date').val());
	});
	
	$('#creditcard').blur(function(){
		ValidateCard($('#creditcard').val());
	
	});
	
	
	$('#dob').blur(function(){
		validateDob($('#dob').val());
	});
	
	$('#password').blur(function(){
		validatePassword($('#password').val());
	});
	
	$('#firstName').blur(function(){
		validateName($('#firstName').val());
	})
	
	$('#lastName').blur(function(){
		validateSurname($('#lastName').val());
	})
	
	$('#registrationForm').submit(function(event){
		var validName = validateName($('#firstName').val());
		var validSurname = validateSurname($('#lastName').val());
		var validPassword = validatePassword($('#password').val());
		var validDob= validateDob($('#dob').val());
		var validCvv= validateCvv($('#cvv').val());
		var validexp=validateExp($('#expiry_date').val());
		var validCard= ValidateCard($('#creditcard').val());
		var result = validName && validSurname && validPassword && validDob && validCvv && validexp && validCard;
		if(!result){
			event.preventDefault();
		}
		 /*var $form = $( this ),
		    term = $form.find( "input[name='firstName']" ).val();
		 var posting = $.post( "betting.jsp", { s: term } );*/
		
	})
});


function validateCvv(cvv){
	var result= false;
	var regx=/[^0-9\s]/g;
	if(cvv.length<3||cvv.match(regx) || cvv.length>3){
		$('#cvv_error').html(CVV_ERROR_STRING);
		$('#cvv').removeClass("good");
		$('#cvv').addClass("error");
	}
	else{
		$('#cvv_error').html(CVV_APPROVED_STRING);
		$('#cvv').removeClass("error");
		$('#cvv').addClass("good");
		result= true;
	}
	return result;
}

function validateExp(exp){
	var current_date=new Date();
	var db= new Date(exp);
	var result = false;
	if(db>current_date){
		$('#expiry_error').html(EXP_APPROVED_STRING);
		$('#expiry_date').removeClass("error");
		$('#expiry_date').addClass("good");
		result= true;
	}
	else{
		$('#expiry_error').html(EXP_ERROR_STRING);
		$('#expiry_date').removeClass("good");
		$('#expiry_date').addClass("error");
		result = false;
	}
	return result;
}

function ValidateCard(cardno){
	var result=false;
	if(isAmericanExpress(cardno) || isMasterCard(cardno) || isVisa(cardno)){
		$('#creditcard_error').html(CC_APPROVED_STRING);
		$('#creditcard').removeClass("error");
		$('#creditcard').addClass("good");
		result= true;
	}
	else{
		$('#creditcard_error').html(CC_ERROR_STRING);
		$('#creditcard').removeClass("good");
		$('#creditcard').addClass("error");
	}
	return result;
	
}


function isAmericanExpress(cardno){
	if((cardno[0]=="3" && cardno[1]=="4")|| (cardno[0]=="3"&&cardno[1]=="7")){
		if(cardno.length==15){
			return Luhn(cardno);
		}
	}
	else{
		return false;
	}
	
	
	//$('#test').html(test);
}
function isMasterCard(cardno){
	if((cardno[0]=="5" && cardno[1]=="1") || (cardno[0]=="5"&&cardno[1]=="2") || (cardno[0]=="5"&&cardno[1]=="3") || (cardno[0]=="5"&&cardno[1]=="4") || (cardno[0]=="5"&&cardno[1]=="5")){
		if(cardno.length==16){
			return Luhn(cardno);
		}
	}
	else{
		return false;
	}
}
function isVisa(cardno){
	if(cardno[0]=="4"){
		if((cardno.length==16)||(cardno.length=13)){
			return Luhn(cardno);
		}
	}
	else{
		return false;
	}
}

function Luhn(cardno){
	var odds=[];
	var test="";
	var test1="";
	var evens=[];
	var inverted="";
	for(k=(cardno.length)-1;k>-1;k--){
		inverted+=cardno[k];
	}
	for( i=0;i<inverted.length;i++){
    	if(i%2==0){
    		 odds[odds.length]=parseInt(inverted[i],10);
    		test+=odds[odds.length-1].toString();
    	}else{
    		evens[evens.length]=parseInt(inverted[i],10);
    		test1+=evens[evens.length-1].toString();
    		}
    	}
	var s1=0;
	for(j=0;j<odds.length;j++){
		s1=s1+odds[j];
	}
	
	var s2=0;
	
	for(q=0;q<evens.length;q++){
		
		var temp=evens[q]*2;
		if(temp<10){
			s2=s2+temp;
		}else{
			var stringtemp=temp.toString();
			var n1=parseInt(stringtemp[0]);
			var n2=parseInt(stringtemp[1]);
			var tempsum=n1+n2;
			s2=s2+tempsum;
		}
	}
	var result=s1+s2;
	var out=result.toString();
	//var d;
	if(out[1]=="0"){
		return true;
	}
	else{
		return false;
	}
	
/*	$('#cvv_error').html(test);
	$('#expiry_error').html(test1);*/
}

function validateDob(dob){
	var result = false;
	var current_date=new Date();
	var db= new Date(dob);
	if(db=="Invalid Date"){
		$('#dob_error').html(DOB_EMPTY_STRING);
		$('#dob').removeClass("good");
		$('#dob').addClass("error");
		return false;
	}
	
	var test_age=current_date.getFullYear() - db.getFullYear();
	//$('#dob_error').html(test_age);
	if(test_age<18){
		$('#dob_error').html(DOB_ERROR_STRING);
		$('#dob').removeClass("good");
		$('#dob').addClass("error");
	}
	else{
		$('#dob_error').html(DOB_APPROVED_STRING);
		$('#dob').removeClass("error");
		$('#dob').addClass("good");
		result= true;
	}
	
	return result;
}

function validatePassword(password){
	var result = false;
	if(password.length < 8){
		$('#password_error').html(PASSWORD_ERROR_STRING);
		$('#password').removeClass("good");
		$('#password').addClass("error");
	}else{
		$('#password_error').html(PASSWORD_APPROVED_STRING);
		$('#password').removeClass("error");
		$('#password').addClass("good");
		result = true;
	}
	return result;
}

function validateName(name){
	var regex = /[^A-Za-z\s]/g;
	var result = false;
	if(name == "" || name.match(regex)){
		$('#name_error').html(NAME_ERROR_STRING);
		$('#firstName').removeClass("good");
		$('#firstName').addClass("error");
	}else{
		$('#name_error').html(NAME_APPROVED_STRING);
		$('#firstName').removeClass("error");
		$('#firstName').addClass("good");
		result = true;
	}
	return result;
}

function validateSurname(surname){
	var regex = /[^A-Za-z\s]/g;
	var result = false;
	if(surname == "" || surname.match(regex)){
		$('#surname_error').html(SURNAME_ERROR_STRING);
		$('#lastName').removeClass("good");
		$('#lastName').addClass("error");
	}else{
		$('#surname_error').html(SURNAME_APPROVED_STRING);
		$('#lastName').removeClass("error");
		$('#lastName').addClass("good");
		result = true;
	}
	return result;
}

