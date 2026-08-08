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
    xhttp.open("GET", "http://localhost:9090/education/students", true);
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
window.addEventListener('load', getStudents);