
//This method is used for change password
function validpassword()
{
if(document.chngpwd.newpassword.value!= document.chngpwd.confirmpassword.value)
{
alert("New Password and Confirm Password Field do not match  !!");
document.chngpwd.confirmpassword.focus();
return false;
}
xhr = new XMLHttpRequest();
var url = "http://localhost:9090/LibraryManagementSystem/myApp/password/forgotPassword";
xhr.open("POST", url);
xhr.setRequestHeader("Content-type", "application/json");
xhr.onreadystatechange = function () { 
if (this.readyState == 4 && this.status == 200) {
var json = JSON.parse(this.responseText);
alert("Hello student -> " + json.password + " " + json.Status);

myStorage = window.localStorage;

localStorage.setItem('userId', json.userId);
}
}
var data = JSON.stringify({"Email":document.chngpwd.email.value, "password":document.chngpwd.newpassword.value,
	"mNumber":document.chngpwd.mobile.value});
xhr.send(data); 


return true;
}
//This function is user for update user profile
function update(){
	
  	 xhr = new XMLHttpRequest();
	 var url = "http://localhost:9090/LibraryManagementSystem/myApp/signup/userUpdate";
	 xhr.open("POST", url);
	 xhr.setRequestHeader("Content-type", "application/json");
	 xhr.onreadystatechange = function () { 
	 if (this.readyState == 4 && this.status == 200) {
	 var json = JSON.parse(this.responseText);
	
	 alert("Hello student -> " + json.update + " " + json.Status);

	 myStorage = window.localStorage;

	 localStorage.setItem('userId', json.Status);
	 }
	 }
	 var data = JSON.stringify({"Email":document.signup.email.value,"mNumber":document.signup.mobileno.value,"userName":document.signup.fullname.value});
	 xhr.send(data);   

 }
 

//This is used for Signup user
       function valid()
            {
          if(document.signup.password.value!= document.signup.confirmpassword.value)
       {
        alert("Password and Confirm Password Field do not match  !!");
            document.signup.confirmpassword.focus();
          return false;
         }
              xhr = new XMLHttpRequest();
           var url = "http://localhost:9090/LibraryManagementSystem/myApp/signup/userSignup";
              xhr.open("POST", url);
         xhr.setRequestHeader("Content-type", "application/json");
           xhr.onreadystatechange = function () { 
            if (this.readyState == 4 && this.status == 200) {
           var json = JSON.parse(this.responseText);
             alert("Hello student -> " + json.Signup + " " + json.Status);

            myStorage = window.localStorage;

             localStorage.setItem('userId', json.Status);
             }
                 }
               var data = JSON.stringify({"Email":document.signup.email.value, "password":document.signup.password.value,
	                "mNumber":document.signup.mobileno.value,"userName":document.signup.fullanme.value});
                 xhr.send(data); 

                 return true;
                  }


//This function is  used for userlogin
	function login(){
	                   //   var userName = document.forms["myForm"]["username"].value;
                 	  //   var password = document.forms["myForm"]["password"].value;
		             //      alert("Hello student -> " + userName + " " + password);
		  xhr = new XMLHttpRequest();
     	var url = "http://localhost:9090/LibraryManagementSystem/myApp/login/userlogin";
		xhr.open("POST", url, true);
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.onreadystatechange =  function () { 
		    if ( this.readyState == 4 && this.status == 200) {
		    	var json = JSON.parse(this.responseText);
		    
		   alert("Hello student -> " + json.userId + " " + json.Status);
		    	
		    	myStorage = window.localStorage;
		    	
		    	localStorage.setItem('userId', json.userId);
		    	
		    	window.location.href = "dashboard.html";
		    
		    		 }
		    else{
		    	alert("Login failed");
		    	//window.location.href = "index.html";
		    }
		   
		}
		var data = JSON.stringify({"userName":document.forms["myForm"]["username"].value, "password":document.forms["myForm"]["password"].value});
		xhr.send(data); 
		
	}
	
	function getUserData(){
		myStorage = window.localStorage;
		var userId = localStorage.getItem('userId');
		//alert("This is user with id " + userId);
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var result = this.responseText;
				var obj = JSON.parse(result);
				document.getElementById("demo").innerHTML = obj['name'] + "  " + obj['rollNo'];
			}
		};
		xhttp.open("GET", "http://localhost:9090/FirstProject/myApp/user/getInfo/" + userId, true);
		xhttp.send();
	}
	
	