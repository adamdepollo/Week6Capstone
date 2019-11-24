//This code displays warnings if the user enters an incorrect password or attempts to login using a username that does not appear in the database

if (document.getElementById('passAlert').innerHTML !== "") {
	document.getElementById('passAlert').removeAttribute("style");
}

if (document.getElementById('emailAlert').innerHTML !== "") {
	document.getElementById('emailAlert').removeAttribute("style");
}