let userStorage = localStorage.getItem(`currentUser`);

let currentUser = JSON.parse(userStorage);

console.log(currentUser);

let moodButton = document.getElementById("btn_id");
let welcomeScreen = document.getElementById("welcome_screen");

welcomeScreen.innerText = `Welcome ${currentUser.username}, Check Your Horoscope Today!!`;

let button = document.getElementById("button");

button.addEventListener('click', async() => {

// var inputValue = document.getElementById("field").value
    try{

        const raw_response = await fetch(`http://sandipbgt.com/theastrologer/api/horoscope/${currentUser.zodiac}/today`);
        
        if(!raw_response.ok){
            throw new Error(raw_response.status);
        }

        const json_data = await raw_response.json();

        console.log(json_data);

        var input = document.getElementById("input")
        var horoscope = document.createElement("h2")

        horoscope.innerHTML = `Today's horror of scopes: ${json_data.horoscope}`;

        input.append(horoscope);

        var b = document.createElement('br');
        input.append(b);

        var mood = document.getElementById("mood");
        mood.innerText = `${json_data.meta.mood}`;

    

    } catch (error){

        console.log(error);
        alert("Error: " + error);
    }



})

moodButton.addEventListener('click', (event) => {

    event.preventDefault();

    let xhttp = new XMLHttpRequest();

    var mood2 = document.getElementById("mood");

    let mood3 = mood2.innerText;

    let username = currentUser.userid;

    let moodInfo = {
        username: username,
        mood: mood3,
        
    }

    console.log(moodInfo);

    xhttp.onreadystatechange = function(){

        if(this.readyState == 4 && xhttp.status === 200){
            console.log(xhttp.responseText);

            let data = JSON.parse(xhttp.responseText);
            console.log(data);

        } else if (this.readyState == 4 && xhttp.status == 204){
            console.log(xhttp.responseText)
            alert("Failed to Login: Status Code - " + xhttp.status)
        }
    };

    xhttp.open("POST", `http://localhost:8080/Horoscopes/mood`);

    xhttp.setRequestHeader("Access-Control-Allow-Origin", "*");

    xhttp.setRequestHeader("Content-Type", "application/json");

    console.log(xhttp);

    xhttp.send(JSON.stringify(moodInfo));

    alert("Mood updated");
})