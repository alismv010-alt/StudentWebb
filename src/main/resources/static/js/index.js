function getStudents() {
    const xhttp = new XMLHttpRequest();

    function myfunction() {
        var responseText = this.responseText;
        var responseArr = JSON.parse(responseText);

        var tr = document.getElementById("tbl-students-body-tr").innerHTML;
        var trbody = "";
        for (var i = 0; i < responseArr.length; i++) {
            var student = responseArr[i];

            trbody += tr
                .replaceAll(":id", student.ID)
                .replace(":name", student.name)
                .replace(":surname", student.surname)
                .replace(":age", student.age)
                .replace(":email", student.email)
                .replace(":password", student.password)
                .replace(":university", student.university.name);
        }
        document.getElementById("tbl-students-body").innerHTML = trbody;
    }


    xhttp.onload = myfunction;
    xhttp.open("GET", "http://localhost:9090/education/students", true);
    xhttp.send();
}
var selectedId;

function select(id) {
    selectedId=id;
}

function deleteStudent(id) {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        if (xhttp.readyState==4 && xhttp.status== "200") {
            getStudents();
        }
    }
    xhttp.open("DELETE", "http://localhost:9090/education/students", true);
    xhtpp.send();
}
window.addEventListener('load', getStudents);