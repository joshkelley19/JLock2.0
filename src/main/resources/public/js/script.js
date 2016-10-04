" use strict ";

//var welcomeHeader = document.getElementById("welcomeHeader");
var ans = document.getElementById("answers");

//window.onload = function (name){
//    welcomeHeader.innerHTML += "Hello!!! Welcome to JLock";
//};

var personalInfo = function(){
    var first = document.getElementById("first").value;
    var last = document.getElementById("last").value;
    var user = document.getElementById("user").value;
    var pass = document.getElementById("pass").value;
    
//    how to create JSON object
    var info = {
    "firstName":first,
    "lastName":last,
    "userName":user,
    "password":pass
    };
    
    ans.innerHTML = first+" "+last+" "+user+" "+pass;
    
    return false;
};