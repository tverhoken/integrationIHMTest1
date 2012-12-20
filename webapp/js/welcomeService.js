var requete;

/**
 * Cette methode recupere la valeur de l'element <b>toCheck</b>, l'envoi au
 * service et appel la fonction qui va mettre a jour l'IHM au niveau de
 * l'element <b>divToFill</b> une fois la reponse du service recue.
 * 
 * @param divToFill
 *            l'element de type <i>div</i> qui va recevoir la reponse de
 *            l'appel au service.
 * @param toCheck
 *            l'element de type <i>input</i> que l'on va inspecter.
 */
function callWelcomeService(divToFill, toCheck) {
	var name = document.getElementById(toCheck).value;
	var url = "http://localhost:8080/WelcomeService/welcomeService?name="
			+ name;
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

/**
 * Methode qui va mettre a jour la partie IHM une fois la reponse du service
 * recue.
 * 
 * @param divToFill
 */
function updateIHM(divToFill) {
	document.getElementById(divToFill).innerHTML = requete.responseText;
}