/**
 * 
 */

/*
 * AJAX - Asynchronous JavaScript and XML Asynchronous - the browser doesn't
 * need to reload the entire page when only a small bit of data on the page has
 * changed
 * 
 * AJAX is not a programming language
 * 
 * AJAX is a technique for accessing web servers from a web page.
 * 
 * AJAX is a combination of: - a browser built-in XMLHttpRequest object
 * (requests data from a web server) - JavaScript - HTML DOM (to display or use
 * the data)
 * 
 * XML - a data format JSON - the preferred data format for transferring data
 * between server and the web browser
 * 
 * AJAX is a misleading name because AJAX applications might use XML to
 * transport data, but again, JSON is the bomb.com (plain text)
 * 
 * How does AJAX work? 1) An event occurs in a web page (the page is loaded, a
 * button is clicked) 2) An XMLHttpRequest object is created by JavaScript 3)
 * The XMLHttpRequest object sends a request to a web server 4) The server
 * processes the request 5) The server sends a response back to the web page 6)
 * The response is read by JavaScript 7) Proper action (like page update) is
 * performed by JavaScript
 * 
 */
window.onload = function() {
    getRequests();
}
/*
 * Used to request the data for the table on the admin home page.
 */
function getRequests() {
	// this object allows us to make requests
	// and get data back
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
				/*
				 * The ready state property holds the status of the
				 * XMLHttpRequest
				 * 
				 * 0 - request not initialized 1 - server connection established
				 * 2 - request received 3 - processing request 4 - request is
				 * finished and response is ready
				 * 
				 * We want state of 4 and a status of 200 200 - OK
				 */
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let list = JSON.parse(xhttp.responseText);
			// JSON parse turns it into an object
            setValues(list);
        }
    }
	// create a connection (method, url, boolean asynch or not)
    xhttp.open("GET", "/0429ProjectOne/html/LoadExpenses.do", true);
    xhttp.send();
}
/*
 * Used to set the values in the table (populate the table)
 */
function setValues(list) {
    
    let table = document.getElementById("reimbtable");
    table.innerHTML = `<tr>
                       <th>User Id</th>
                       <th>First Name</th>
                       <th>Last Name</th>
                       <th>Type</th>
                       <th>Amount</th>
                       <th>Date submitted</th>
                       <th>Date resolved</th>
                       <th>Status</th>
                       <th>Description</th>
                       <th>Ticket Id</th>
                       <th></th>
                       </tr>`
    
    for (r in list) {
        let trNewRow = document.createElement("tr");
        let tdUser = document.createElement("td");
        let tdFirstName = document.createElement("td");
        let tdLastName = document.createElement("td");
        let tdType = document.createElement("td");
        let tdAmount = document.createElement("td");
        let tdSubmitDate = document.createElement("td");
        let tdResolveDate = document.createElement("td");
        let tdStatus = document.createElement("td");
        let tdDescription = document.createElement("td");
        let tdTicketId = document.createElement("td");
        let tdButtons = document.createElement("td");
        
        // Author Name
        tdUser.innerHTML = list[r].employeeId;
        tdFirstName.innerHTML = list[r].firstname;
        tdLastName.innerHTML = list[r].lastname;
        // Type
        switch (list[r].type) {
        case "LODGING":
        	tdType.innerHTML = "Lodging";
            break;
        case "TRAVEL":
        	tdType.innerHTML = "Travel";
            break;
        case "FOOD":
        	tdType.innerHTML = "Food";
            break;
        case "OTHER":
        	tdType.innerHTML = "Other";
            break;
        }
        // Amount
        tdAmount.innerHTML = "$" + list[r].amount;
        // Submit Date
        tdSubmitDate.innerHTML = list[r].submitted;
        // Resolve Date
        tdResolveDate.innerHTML = list[r].resolved;
        // Status
        switch (list[r].status) {
        case "APPROVED":
        	tdStatus.innerHTML = "Approved";
            break;
        case "DENIED":
        	tdStatus.innerHTML = "Denied";
            break;
        case "PENDING":
        	tdStatus.innerHTML = "Pending";
            break;
        }
        // Description
        tdDescription.innerHTML = list[r].description;
        // Ticket Number
        tdTicketId.innerHTML = list[r].ticketId;
        
        // Buttons
        if (list[r].status == "PENDING") {
            btnApprove = document.createElement("button");
            btnApprove.setAttribute("name", "btnApprove");
            btnApprove.setAttribute("value", list[r].ticketId);
            btnApprove.style.width = "100px";
            btnApprove.style.background = "green";
            btnApprove.style.color = "white";
            btnApprove.style.fontSize = "16px";
            btnApprove.innerText = "APPROVE";
            btnApprove.addEventListener('click', approveExpense);

            btnDeny = document.createElement("button");
            btnDeny.setAttribute("name", "btnDeny");
            btnDeny.setAttribute("value", list[r].ticketId);
            btnDeny.style.width = "100px";
            btnDeny.style.background = "red";
            btnDeny.style.color = "white";
            btnDeny.style.fontSize = "16px";
            btnDeny.innerText = "DENY";
            btnDeny.addEventListener('click', denyExpense);
            
            tdButtons.appendChild(btnApprove);
            tdButtons.appendChild(btnDeny);
        }
        
        trNewRow.appendChild(tdUser);
        trNewRow.appendChild(tdFirstName);
        trNewRow.appendChild(tdLastName);
        trNewRow.appendChild(tdType);
        trNewRow.appendChild(tdAmount);
        trNewRow.appendChild(tdSubmitDate);
        trNewRow.appendChild(tdResolveDate);
        trNewRow.appendChild(tdStatus);
        trNewRow.appendChild(tdDescription);
        trNewRow.appendChild(tdTicketId);
        trNewRow.appendChild(tdButtons);
       
        table.appendChild(trNewRow);
    }
}

function approveExpense(e) {
    let target = e.target;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            getRequests();
        }
    }
    xhttp.open("POST", "/0429ProjectOne/html/ApproveExpense.do", true);
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhttp.send("value=" + e.target.value);
}

function denyExpense(e) {
    let target = e.target;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            getRequests();
        }
    }
	xhttp.open("POST", "/0429ProjectOne/html/DenyExpense.do", true);
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhttp.send("value=" + e.target.value);
}