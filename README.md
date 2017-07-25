# Money Transfer RESTful API
Author: Sarvar Nishonboyev

Information:

Used tools, libraries & frameworks: 
- Tomcat 8.0
- Java, JSP 
- Jersey 2.x
- maven
- jUnit and rest-assured (testing)

Installing: 
- Please, find `revolute.war` file in the target folder
- copy it into tomcat workplace directory
- Home page: http://localhost:8080/revolut/

Home page has links to to HTML pages which are used for creating a new account and making transfer between accounts.  

src/main/java/test folder contains 2 test files: 
- AccountServiceTest
- TransferServiceTest

These files are run from the Eclipse as a jUnit Test

## API Manual
<table>
    	<thead>
    	<tr>
    		<th>Recourse</th>
    		<th>URI</th>
    		<th>Method</th>
    	</tr>
        <tr>
            <th colspan=3>Accounts</th>
        </tr>
    	<tr>
    		<td>List of all accounts</td>
    		<td> http://localhost:8080/revolut/webapi/accounts </td>
    		<td>GET</td>
    	</tr>
    	<tr>
    		<td>Find particular account</td>
    		<td> http://localhost:8080/revolut/webapi/accounts/{accountID} </td>
    		<td>GET</td>
    	</tr>
    	<tr>
    		<td>Adding new account</td>
    		<td> http://localhost:8080/revolut/webapi/accounts </td>
    		<td>POST</td>
    	</tr>
    	<tr>
    		<td>Updating an account</td>
    		<td> http://localhost:8080/revolut/webapi/accounts/{accountID} </td>
    		<td>PUT</td>
    	</tr>
    	<tr>
    		<td>Deleting an account</td>
    		<td> http://localhost:8080/revolut/webapi/accounts/{accountID} </td>
    		<td>DELETE</td>
    	</tr>
    	<tr>
    		<th colspan=3>Transfers</th>
    	</tr>
    	<tr>
    		<td>List of transfer history</td>
    		<td> http://localhost:8080/revolut/webapi/transfers </td>
    		<td>GET</td>
    	</tr>
    	<tr>
    		<td>Account transfer history</td>
    		<td> http://localhost:8080/revolut/webapi/transfers/{accountID} </td>
    		<td>GET</td>
    	</tr>
    	<tr>
    		<td>Make a new transfer</td>
    		<td> http://localhost:8080/revolut/webapi/transfers/make </td>
    		<td>POST</td>
    	</tr>
    	</thead>
    </table>
  
