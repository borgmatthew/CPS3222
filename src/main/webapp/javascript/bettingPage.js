/**
 * 
 */
var AMMOUNT_ERROR_STRING=	"Invalid Ammount";
var AMMOUNT_APPROVED_STRING="";

$(document).ready(function(){
	$('#ammount').blur(function(){
		validateAmmount($('#ammount').val());
	});
})

function validateAmmount(amm){
	var result= false;
	var regx=/[^0-9\s]/g;
	if(amm.match(regx)){
		$('#ammount_error').html(AMMOUNT_ERROR_STRING);
		$('#ammount').removeClass("good");
		$('#ammount').addClass("error");
	}
	else{
		$('#ammount_error').html(AMMOUNT_APPROVED_STRING);
		$('#ammount').removeClass("error");
		$('#ammount').addClass("good");
		result= true;
	}
	return result;
}