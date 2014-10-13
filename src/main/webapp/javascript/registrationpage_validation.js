/**
 * 
 */


function validateForm() {
	//Validating First name
    var x = document.forms["registrationform"]["firstname"].value;
    if (x==null || x=="") {
        alert("First name must be filled out");
        return false;
    }
    //int i=0;
    for( i=0;i<x.length;i++){
    	if(!isNaN(x[i])){
    		 alert("First name must be letters");
    	        return false;
    	}
    }
    //Validating password
    
    
}
function validatePassword(){
	var p=document.forms["registrationform"]["password"].value;
	//var x=
    if(p.length<8){
    	
    	 document.getElementById('error').innerHTML =
             "password not long enouph";
    	
    }
}