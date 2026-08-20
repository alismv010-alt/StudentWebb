const urlParams = new URLSearchParams(window.location.search);
const studentId = urlParams.get('id');

window.onload = function () {
    getStudentDetails(studentId);
};

function getStudentDetails(id) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:9090/education/students/"+id, true);

    xhttp.onload = function () {
        if (xhttp.status === 200) {
            var student = JSON.parse(xhttp.responseText);

            document.getElementById("detail_id").innerText = student.ID ;
            document.getElementById("detail_name").innerText = student.Name ;
            document.getElementById("detail_surname").innerText = student.Surname ;
            document.getElementById("detail_email").innerText = student.Email ;
            document.getElementById("detail_age").innerText = student.Age ;
            document.getElementById("detail_university").innerText = student.University.name;
            document.getElementById("detail_faculty").innerText = student.Faculty;
            document.getElementById("detail_major").innerText = student.Major ;
            document.getElementById("detail_gpa").innerText = student.GPA;
            document.getElementById("detail_timeframe").innerText = student.Timeframe ;
            if (student.Scholarship && typeof student.Scholarship === 'object') {
                const scholarshipName = student.Scholarship.name
                const scholarshipAmount = student.Scholarship.amount;

                document.getElementById("detail_scholarship").innerText =
                    scholarshipName + " / " + scholarshipAmount + " AZN";
            }
        } else {
            document.getElementById("detail_scholarship").innerText =
                "There is no person for this student.";
        }
    };

    xhttp.send();
}