var PASSWORD_ERROR_STRING = "Password is too short";
var PASSWORD_APPROVED_STRING = "";
var NAME_ERROR_STRING = "Invalid characters";
var NAME_APPROVED_STRING = "";
var SURNAME_ERROR_STRING = "Invalid characters";
var SURNAME_APPROVED_STRING = "";

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
	$('#password').blur(function(){
		validatePassword($('#password').val())
	});
	
	$('#firstName').blur(function(){
		validateName($('#firstName').val())
	})
	
	$('#lastName').blur(function(){
		validateSurname($('#lastName').val())
	})
});


function validatePassword(password){
	if(password.length < 8){
		$('#password_error').html(PASSWORD_ERROR_STRING);
	}else{
		$('#password_error').html(PASSWORD_APPROVED_STRING);
	}
}

function validateName(name){
	var regex = /[^A-Za-z\s]/g
	if(name == "" || name.match(regex)){
		$('#name_error').html(NAME_ERROR_STRING);
	}else{
		$('#name_error').html(NAME_APPROVED_STRING);
	}
}

function validateSurname(surname){
	var regex = /[^A-Za-z\s]/g
	if(surname == "" || surname.match(regex)){
		$('#surname_error').html(SURNAME_ERROR_STRING);
	}else{
		$('#surname_error').html(SURNAME_APPROVED_STRING);
	}
}

