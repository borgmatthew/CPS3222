/**
 * 
 */


function validateForm() {
    var x = document.forms["registrationform"]["firstname"].value;
    if (x==null || x=="") {
        alert("First name must be filled out");
        return false;
    }
}