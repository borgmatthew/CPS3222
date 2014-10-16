var PASSWORD_ERROR_STRING = "Password is too short";
var PASSWORD_APPROVED_STRING = "";
var NAME_ERROR_STRING = "Invalid characters";
var NAME_APPROVED_STRING = "";
var SURNAME_ERROR_STRING = "Invalid characters";
var SURNAME_APPROVED_STRING = "";
var DOB_ERROR_STRING=	"Under age";
var DOB_APPROVED_STRING="";
var CC_ERROR_STRING=	"Invalid card";
var CC_APPROVED_STRING="";
var EXP_ERROR_STRING=	"Invalid Expirary date";
var EXP_APPROVED_STRING="";

/*
function validateForm() {
	//Validating First name
    var x = document.forms["registrationform"]["firstname"].value;
    if (x==null || x=="") {
        alert("First name must be filled out");
        return false;
    }
    //int i=0;
    for( i=0;i<x.length;i++){funct
    	if(!isNaN(x[i])){
    		 alert("First name must be letters");
    	        return false;
    	}
    }
    //Validating password
    
    
}*/
$(document).ready(function(){
	$('#Exp').blur(function(){
		ValidExp($('#Exp').val());
	});
	
	$('#creditcard').blur(function(){
		isValidCard($('#creditcard').val());
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
		var result = validName && validSurname && validPassword && validDob;
		event.preventDefault();
	})
});

function ValidExp(exp){
	var current_date=new Date();
	var db= new Date(exp);
	if(db>current_date){
		$('#exp_error').html(EXP_APPROVED_STRING);
		$('#Exp').removeClass("error");
		$('#Exp').addClass("good");
		result= true;
	}
	else{
		$('#exp_error').html(EXP_ERROR_STRING);
		$('#Exp').removeClass("good");
		$('#Exp').addClass("error");
	}
}

function isValidCard(cardno){
	var result=false;
	if(isMasterCard(cardno)||isVisa(cardno)){
			
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
	var inverted;
	for(k=(cardno.length);k>-1;k--){
		inverted+=cardno[k];
	}
	for( i=3;i<inverted.length;i++){
    	if(i%2==0){
    		 evens[evens.length]=parseInt(inverted[i],10);
    		 test+=evens[evens.length-1].toString();
    	}else{
    		odds[odds.length]=parseInt(inverted[i],10);
    		test1+=odds[odds.length-1].toString();
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
	
	//$('#test').html(d);
	//$('#test1').html(test1);
}

function validateDob(dob){
	var result = false;
	var current_date=new Date();
	var db= new Date(dob);
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

