var selectedId=0;
var allstudents
function select(id) {
    selectedId=id;
}
function getStudents() {
    const xhttp = new XMLHttpRequest();

    function myfunction() {
        var responseText = this.responseText;
        var responseArr = JSON.parse(responseText);
        allstudents=responseArr
        var tr = document.getElementById("tbl-students-body-tr").innerHTML;
        var trbody = "";
        for (var i = 0; i < responseArr.length; i++) {
            var student = responseArr[i];
            console.log(student);
            trbody += tr
                .replaceAll(":id", student.ID)
                .replaceAll(":index", i)
                .replace(":name", student.Name)
                .replace(":surname", student.Surname)
                .replace(":age", student.Age)
                .replace(":email", student.Email)
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
        document.getElementById("update_university_id").innerHTML = optionsHtml;
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
function selectForUpdate(index) {
    var selectedstudent = allstudents[index];

    selectedId = selectedstudent.ID
    document.getElementById("update_name").value = selectedstudent.Name
    document.getElementById("update_surname").value = selectedstudent.Surname
    document.getElementById("update_age").value = selectedstudent.Age
    document.getElementById("update_email").value = selectedstudent.Email
    document.getElementById("update_university_id").value = selectedstudent.University.id
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
        Age: parseInt(document.getElementById("create_age").value),
        Email: document.getElementById("create_email").value,
        University: {
            id:document.getElementById("create_university_id").value
        }
    };
    xhttp.open("POST", "http://localhost:9090/education/students", true);
    xhttp.setRequestHeader("Content-Type", "application/json")
    xhttp.send(JSON.stringify(student));

}

function updateStudent() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        if (xhttp.status >= 200 && xhttp.status < 300) {
            getStudents();
        }
    }

    var student = {
        ID:selectedId,
        Name: document.getElementById("update_name").value,
        Surname: document.getElementById("update_surname").value,
        Age: document.getElementById("update_age").value,
        Email: document.getElementById("update_email").value,
        University: {
            id:document.getElementById("update_university_id").value
        }
    };
    xhttp.open("PUT", "http://localhost:9090/education/students", true);
    xhttp.setRequestHeader("Content-Type", "application/json")
    xhttp.send(JSON.stringify(student));

}
window.addEventListener('load', getStudents);
window.addEventListener('load', getUniverseties);