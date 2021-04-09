// submitForm arrow function will fetch all data from form then this data will add into card dynamically 
const submitForm = () => {
    const sname = document.getElementById('name').value;
    const semail = document.getElementById('email').value;
    const swebsite = document.getElementById('website').value;
    const image = document.getElementById('imageLink').value;
    const gender = document.querySelector('input[type="radio"]:checked').value;
    var skills = document.getElementsByClassName('CheckboxForm');

    var str = ''
    for (i = 0; i < 3; i++) {
        if (skills[i].checked === true) {
            str += skills[i].value + ", ";
        }
    }
    str = str.slice(0, str.length - 2)

    // /create div tag using javascript
    const note = document.createElement('div');
    // add class inside div using javascript
    note.classList.add('card');

    // store our card data into htmlData variable
    const htmlData = `
    <h5 class="card-title" style="color: green;">&nbsp&nbspDescription &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Image</h5>
    <div class="card-body my-0">
        <img src="${image}" style="float: right;" class="card-img-right" alt="hello" width="80px">
        <p class="card-text my-0">${sname}</p>
        <p class="card-text my-0">${gender}</p>
        <p class="card-text my-0">${semail}</p>
        <a style="text-decoration: underline;" href="https://nagarro.com" target="_blank">${swebsite}</a>
        <p class="card-text my-0">${str}</p>
    </div>
    `
        // insertAdjacentHTML is use for inserting our htmlData after specified element
    note.insertAdjacentHTML('afterbegin', htmlData);
    document.getElementById('add-card').appendChild(note);
}

// clear our form data
$(document).ready(function() {
    $("#clear").click(function() {
        $("#enrollment-form")[0].reset();
    });
});



//https://images.unsplash.com/photo-1506794778202-cad84cf45f1d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NXx8bWVufGVufDB8fDB8&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60