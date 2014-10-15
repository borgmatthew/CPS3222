var PASSWORD_ERROR_STRING = "Password is too short";
var PASSWORD_APPROVED_STRING = "";
var NAME_ERROR_STRING = "Invalid characters";
var NAME_APPROVED_STRING = "";
var SURNAME_ERROR_STRING = "Invalid characters";
var SURNAME_APPROVED_STRING = "";
var DOB_ERROR_STRING=	"Under age";
var DOB_APPROVED_STRING="";

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

function isAmericanExpress(cardno){
	
}
function isMasterCard(cardno){
	
}
function isVisa(cardno){
	
}
function Luhn(cardno){
	
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

