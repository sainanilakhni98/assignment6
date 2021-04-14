 //funtion for email validation
 function emailValidation(semail) {
     var atSymbol = semail.indexOf("@");
     var dot = semail.lastIndexOf(".");
     var flag = true;
     if (atSymbol < 1) flag = false;
     else if (dot <= atSymbol + 2) flag = false;
     else if (dot === semail.length - 1) flag = false;
     return flag;
 }


 //funtion for add enrolled student dynamically 
 function addEnrolledStudent(sname, image, semail, website, gender, studentSkills) {
     // create div tag using javascript
     const note = document.createElement('div');
     // add class inside div using javascript
     note.classList.add('card');

     // store our card data into htmlData variable
     const htmlData = `
   <h5 class="card-title" style="background-color: lightgreen; color:white;">&nbsp&nbspDescription &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Image &emsp;&emsp;</h5>
   <div class="card-body my-0">
       <img src="${image}" style="float: right;" class="card-img-right" alt="hello" width="80px">
       <p class="card-text my-0">${sname}</p>
       <p class="card-text my-0">${gender}</p>
       <p class="card-text my-0">${semail}</p>
       <a style="text-decoration: underline;" href="${website}" target="_blank">${website}</a>
       <p class="card-text my-0">${studentSkills}</p>
   </div>
   `
         // insertAdjacentHTML is use for inserting our htmlData after specified element
     note.insertAdjacentHTML('afterbegin', htmlData);
     document.getElementById('add-card').appendChild(note);
 }

 //  function for skills validation
 function skillsValidation(skills) {
     var studentSkills = ''
     check = false;
     for (i = 0; i < skills.length; i++) {
         if (skills[i].checked === true) {
             studentSkills += skills[i].value + ", ";
             check = true;
         }
     }
     studentSkills = studentSkills.slice(0, studentSkills.length - 2)

     return [check, studentSkills];
 }

 // Main Function(submitForm arrow function) will fetch all data from form then this data will add into card dynamically
 const submitForm = () => {
     var name = document.getElementById('name').value.trim();;
     var email = document.getElementById('email');
     var website = document.getElementById('website').value.trim();
     var image = document.getElementById('imageLink').value.trim();
     var gender = document.querySelector('input[type="radio"]:checked').value;
     var skills = document.getElementsByClassName('CheckboxForm');

     var semail = email.value.trim();

     //------------------------------Form validation start here----------------------------------//


     //email validation
     var validation = emailValidation(semail); //function calling for email validation
     if (validation === false) {
         alert("Email is not valid")
         email.focus();
         return false;
     }

     //skill(checkbox) validation
     var [check, studentSkills] = skillsValidation(skills); //function calling for skills validation
     if (check === false) {
         alert("Skills is required");
         return false;
     }

     //----------------------------------Form validation ends here----------------------------------//

     //  funtion for add enrolled student dynamically 
     addEnrolledStudent(name, image, semail, website, gender, studentSkills);
 }


 // clear our form data
 $(document).ready(function() {
     $("#clear").click(function() {
         $("#enrollment-form")[0].reset();
     });
 });


 //It is image link. We use this link in our form for getting image from url.
 //https://images.unsplash.com/photo-1506794778202-cad84cf45f1d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NXx8bWVufGVufDB8fDB8&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60