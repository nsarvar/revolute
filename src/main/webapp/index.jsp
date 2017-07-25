<html>
<body>
    <h2>Money transfer Application!</h2>
    <p>Author: Sarvar Nishonboyev</p>
    <p><a href="webapi/myresource">Initializing data</a> | 
    <a href="webapi/accounts">Accounts</a> |
    <a href="webapi/transfers">Transfer History</a></p>
    
    <p><a href="account.jsp">Create an account</a> |
    <a href="transfer.jsp">Make a transfer</a></p>
    
    <hr>

    <h3>API Manual</h3>
    <style>
    	body{color: #333; font-size: 80%; font-family: tahoma}
    	table{
    		border: 1px solid #ddd;
    		border-collapse: collapse;
    	}
    	tr,td, th{
    		border: 1px solid #ddd;
    		padding: 5px 8px;
    	}
    	td{
    		font-family:monospace;
    	}
    </style>
    <table>
    	<thead>
    	<tr>
    		<th>Recourse</th>
    		<th>URI</th>
    		<th>Method</th>
    	</tr>
    	<tr>
    		<td>List of all accounts</td>
    		<td>http://localhost:8080/revolut/webapi/accounts</td>
    		<td>GET</td>
    	</tr>
    	<tr>
    		<td>Find particular account</td>
    		<td>http://localhost:8080/revolut/webapi/accounts/{accountID}</td>
    		<td>GET</td>
    	</tr>
    	<tr>
    		<td>Adding new account</td>
    		<td>http://localhost:8080/revolut/webapi/accounts</td>
    		<td>POST</td>
    	</tr>
    	<tr>
    		<td>Updating an account</td>
    		<td>http://localhost:8080/revolut/webapi/accounts/{accountID}</td>
    		<td>PUT</td>
    	</tr>
    	<tr>
    		<td>Deleting an account</td>
    		<td>http://localhost:8080/revolut/webapi/accounts/{accountID}</td>
    		<td>DELETE</td>
    	</tr>
    	<tr>
    		<th colspan=3>Transfers</th>
    	</tr>
    	<tr>
    		<td>List of transfer history</td>
    		<td>http://localhost:8080/revolut/webapi/transfers</td>
    		<td>GET</td>
    	</tr>
    	<tr>
    		<td>Account transfer history</td>
    		<td>http://localhost:8080/revolut/webapi/transfers/{accountID}</td>
    		<td>GET</td>
    	</tr>
    	<tr>
    		<td>Make a new transfer</td>
    		<td>http://localhost:8080/revolut/webapi/transfers/make</td>
    		<td>POST</td>
    	</tr>
    	</thead>
    </table>
  
</body>
</html>
