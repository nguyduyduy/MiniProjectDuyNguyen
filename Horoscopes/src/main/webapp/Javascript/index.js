/*
  AJAX stands for Asynchronous JavaScript And XML
  It allows for performing javascript actions asynchronously.
  Generally used in conjunction with http requests, as we can wait
  for the response in the background while still doing other things.
  One of the biggest advantages of JS is the responsiveness it provides
  to our webpages. We can easily respond to events on our frontend and manipulate
  the DOM using basic JS functions.
  But the magic JS does not end there. We can use JS to make asynchronous
  requests to servers. We do this with AJAX.
  We want our application to continue to be responsive, while waiting
  for the server to respond. By sending the request and receiving the
  response asynchronously, we accomplish this.
  Note that AJAX has XML in it's name, but that primarily has its origin in
  and older era, where XML was used far more frequently as a data interchange
  format. Nowadays, we primarily use JSON. There are still some places that
  use XML, but JSON is a bit more popular.
*/

let loginButton = document.getElementById("login-button");
let signUpButton = document.getElementById("sign-up-button");

console.log(loginButton);

signUpButton.addEventListener("click", (event) => {
    event.preventDefault();
    window.location.replace("register.html");
});

loginButton.addEventListener('click', (event) => {
    event.preventDefault(); // this prevents the default behavior, bypassing the login credentials

    // Execute our AJAX call
    // 1. Create our XMLHTTPRequest object

    let xhttp = new XMLHttpRequest();

    // 2. Get the values from our form

    let username = document.getElementById("username-sign-in").value;

    let password = document.getElementById('password-sign-in').value;

    // Here we are creating a "loginInfo" object
    let loginInfo = {
        username:username,
        user_password:password
    }

    console.log(loginInfo);

    /*
        A readyState is a property which signifies that state that the request is currently in.
        There are several states:
        0: UNSENT - opening of the request has yet to be called
        1: OPENED - open() has been called
        2: HEADERS_RECEIVED: send() has been called[aka the request has been sent], and the headers of the response as well as the status are now available.
        3: LOADING: downloading the response. Therefore, the responseText (which is a xhr property) is holding partial data.
        4: DONE: the entire operation is now complete
        Why need readyStates?
        Ofter you can implement other transitions or animations to your webpages by triggering them at given readyStates.
        ex. loading screens
    */

        // When 'send' is clicked in Step 4, this function is triggered

        xhttp.onreadystatechange = function(){
            // 200 status is ok
            // indicates everything was processed correctly

            if(this.readyState == 4 && xhttp.status == 200){

                console.log(xhttp.responseText);

                let data = JSON.parse(xhttp.responseText);

                console.log(data);

                // Global Caching Function

                localStorage.setItem('currentUser', JSON.stringify(data));

                window.location.replace("welcome.html")

                // 204 status is a invalid login

            } else if(this.readyState == 4 && xhttp.status == 204){
                console.log(xhttp.responseText)
                alert("Failed to Login: Status Code -" + xhttp.status)
            }





        };

        // 3. 'Open' the request

        // by inserting 'user' or our 'resource', it indicates the mapping, and the what logic is in the POST method

        xhttp.open("POST", `http://localhost:8080/Horoscopes/user`);

        xhttp.setRequestHeader("Access-Control-Allow-Origin", "*");

        xhttp.setRequestHeader("Content-Type", "application/json");

        console.log(xhttp);

        // 4. 'Send' status

        xhttp.send(JSON.stringify(loginInfo));

        alert("Successfully logged in!");















})