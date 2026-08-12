var selectedId=0;
function select(id) {
    selectedId=id;
}
function getStudents() {
    const xhttp = new XMLHttpRequest();

    function myfunction() {
        var responseText = this.responseText;
        var responseArr = JSON.parse(responseText);

        var tr = document.getElementById("tbl-students-body-tr").innerHTML;
        var trbody = "";
        for (var i = 0; i < responseArr.length; i++) {
            var student = responseArr[i];
            console.log(student);
            trbody += tr
                .replaceAll(":id", student.ID)
                .replace(":name", student.Name)
                .replace(":surname", student.Surname)
                .replace(":age", student.Age)
                .replace(":email", student.Email)
                .replace(":password", student.Password)
                .replace(":university", student.University.name);
        }
        document.getElementById("tbl-students-body").innerHTML = trbody;
    }

    xhttp.onload = myfunction;
    xhttp.open("GET", "http://localhost:9090/education/students?"+
        "name="+val("name")+"&"+
        "surname="+val("surname")+"&"+
        "age="+val("age")+"&"+
        "email="+val("email")+"&"+
        "password="+val("password")+"&"+
        "university_id="+val("university_id"), true);
    xhttp.send();
}

function val (elementId) {
    var value = document.getElementById(elementId).value;
    return value!==null && value!=='undefined'?value:'';
}


function getUniverseties() {
    const xhttp = new XMLHttpRequest();

    function myfunction() {
        var responseArr = JSON.parse(this.responseText);

        var optionsHtml = '<option value "" selected></option>'
        for (var i = 0; i < responseArr.length; i++) {
            var universtiy = responseArr[i];
            optionsHtml += '<option value = "'
                + universtiy.id +
                '">'
                + universtiy.name +
                '</option>';
        }
        document.getElementById("university_id").innerHTML = optionsHtml;
        document.getElementById("create_university_id").innerHTML = optionsHtml;

    }
    xhttp.onload = myfunction;
    xhttp.open("GET", "http://localhost:9090/education/universities", true);
    xhttp.send();

}
function deleteStudent(id) {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        if (xhttp.status >= 200 && xhttp.status < 300) {
            getStudents();
        }
    }
    xhttp.open("DELETE", "http://localhost:9090/education/students?id=" + id, true);
    xhttp.send();
}
function insertStudent() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        if (xhttp.status >= 200 && xhttp.status < 300) {
            getStudents();
        }
    }

    var student = {
        Name: document.getElementById("create_name").value,
        Surname: document.getElementById("create_surname").value,
        Age: document.getElementById("create_age").value,
        Email: document.getElementById("create_email").value,
        Password: document.getElementById("create_password").value,
        University: {
            id:document.getElementById("create_university_id").value
        }
    };
    xhttp.open("POST", "http://localhost:9090/education/students", true);
    xhttp.setRequestHeader("Content-Type", "application/json")
    xhttp.send(JSON.stringify(student));

}
window.addEventListener('load', getStudents);
window.addEventListener('load', getUniverseties);