let submitButton = document.getElementById("register-button")

submitButton.addEventListener("click", (event) => {

    event.preventDefault();

    let xhttp = new XMLHttpRequest();

    let firstname = document.getElementById("firstName-input").value;
    let lastname = document.getElementById("lastName-input").value;
    let email = document.getElementById("email-input").value;
    let username = document.getElementById("username-input").value;
    let password = document.getElementById("password-input").value;
    let zodiac = document.getElementById("zodiac-input").value;

    let registerInfo = {
        username:username,
        user_password:password,
        firstname:firstname,
        lastname:lastname,
        email:email,
        zodiac:zodiac,
    }

    console.log(registerInfo);

    xhttp.onreadystatechange = function(){

        if(this.readyState == 4 && xhttp.status == 200){

            console.log(xhttp.responseText);


            window.location.replace("index.html")
        } else if (this.readyState == 4 && xhttp.status == 204){
            console.log(xhttp.responseText);
                alert("Failed. Status Code: " + xhttp.status)
        }
    };

    xhttp.open("POST", `http://localhost:8080/Horoscopes/register`)

    xhttp.setRequestHeader("Access-Control-Allow-Origin", "*");

    xhttp.setRequestHeader("Content-Type", "application/json");

    console.log(xhttp);
    xhttp.send(JSON.stringify(registerInfo));
    
    alert("Account created succesfully");
    

})