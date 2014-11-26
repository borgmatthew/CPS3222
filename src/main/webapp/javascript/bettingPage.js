var AMMOUNT_ERROR_STRING="Invalid Ammount";
var AMMOUNT_APPROVED_STRING="";

$(document).ready(function(){
	$('#ammount').blur(function(){
		validateAmmount($('#ammount').val());
	});
	
	$('#betting_form').submit(function(event){
		event.preventDefault();
		var amount = $('#ammount').val();
		var risk = $("input[name=betrisk]:checked").val();
		if(validateAmmount(amount)){
			$.post("successfullBetting.jsp", {amm: amount, betrisk: risk}, function(data){
				var parse = JSON.parse(data);
				$('#Bett_error').html(parse.message);
				if(parse.success == "true"){
					$('#past_bets > ul').append("<li>" + risk + ", " + amount + "</li>");
				}
				$('#ammount').val("");
			});
		}
	});
});

function validateAmmount(amm){
	var result= false;
	var regx=/[^0-9\.]/g;
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