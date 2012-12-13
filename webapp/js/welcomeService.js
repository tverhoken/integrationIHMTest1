var requete;

function callWelcomeService(divToFill, toCheck) {
	var name = document.getElementById(toCheck).value;
	var url = "http://localhost:8080/WelcomeService/welcomeService?name=" + name;
	if (window.XMLHttpRequest) {
		requete = new XMLHttpRequest();
		requete.open("GET", url, true);
		requete.onload = function() {
			updateIHM(divToFill);
		};
		requete.send();
	} else if (window.ActiveXObject) {
		requete = new XDomainRequest();
		requete.open("GET", url, true);
		requete.onload = updateIHM(divToFill);
		requete.send();
	} else {
		alert("Browser doesn't support Ajax Call.");
	}
}

function updateIHM(divToFill) {
	document.getElementById(divToFill).innerHTML = requete.responseText;
}