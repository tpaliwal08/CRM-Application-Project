<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
    <link href="Application2.css" rel="stylesheet" type="text/css"/>
	<h1><center>CRM Application</center></h1>
	<h2>Add/Edit Leads</h2>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add/Edit Leads</title>
        <script>
          
     
        function validateForm()
		{
        	 var numbers=/^[0-9]+$/;
        	 function IsNumber(inputtxt)  
             {  
                var numbers = /^[-+]?[0-9]+$/;  
                if(inputtxt.value.match(numbers))  
                {  
             	   inputtxt.value.focus();  
                return false;  
                }  
                else  
                {  
             	   inputtxt.value.focus();  
                return true;  
                }  
             }        	
		    if (document.frmAddLead.LeadFirstName.value=="")
		    {
		      alert("First Name cannot be left blank");
		      document.frmAddLead.LeadFirstName.focus();
		      return false;
		    }
		    else if (document.frmAddLead.LeadLastName.value=="")
		    {
			      alert("Last Name cannot be left blank");
			      document.frmAddLead.LeadLastName.focus();
			      return false;
			    }
		    else if (document.frmAddLead.LeadJobTitle.value=="")
		    {
			      alert("Job Title cannot be left blank");
			      document.frmAddLead.LeadJobTitle.focus();
			      return false;
			    }
		    else if (document.frmAddLead.LeadCompanyName.value=="")
		    {
			      alert("Company Name cannot be left blank");
			      document.frmAddLead.LeadCompanyName.focus();
			      return false;
			    }
		    else if(document.frmAddLead.LeadEmailId.value=="")
		    {
			      alert("Email Id cannot be left blank");
			      document.frmAddLead.LeadEmailId.focus();
			      return false;
			    }
		   
		
		    
		    
		}
</script>
    </head>
    <body>
        <form method="POST" action='LeadServlet' name="frmAddLead" onSubmit="return validateForm()">
            <% String action = request.getParameter("action");
                System.out.println(action);
            %>
            
             <input type="hidden" name="LeadId"
                               value="<c:out value="${lead.leadid}"/>" /> <br />
             <% if (action.equalsIgnoreCase("edit")) {%>
            First Name* 	: <input type="text" name="LeadFirstName" 
                               value="<c:out value="${lead.firstname}" />" readonly="readonly" required="required"/> <br /> 
            <%} else {%> 
            First Name 		: <input type="text" name="LeadFirstName" required="required"
                               value="<c:out value="${lead.firstname}" />" /> <br />
            <%}%>
            <% if (action.equalsIgnoreCase("edit")) {%>
            Last Name* 		: <input type="text" name="LeadLastName" 
                               value="<c:out value="${lead.lastname}" />" readonly="readonly" required="required"/> <br /> 
            <%} else {%>
            Last Name 		: <input type="text" name="LeadLastName" required="required"
                               value="<c:out value="${lead.lastname}" />" /> <br />
            <%}%>
            Job Title 		: <input type="text" name="LeadJobTitle" required="required"
                               value="<c:out value="${lead.jobitle}" />" /> <br />
            
            Company Name : <input type="text" name="LeadCompanyName" required="required"
                               value="<c:out value="${lead.companyname}" />" /> <br />
            
            Email Id 		: <input type="text" name="LeadEmailId" required="required"
                               value="<c:out value="${lead.email}" />" /> <br />
            
            Phone No 		: <input type="text" name="LeadPhoneNo" required="required"
                               value="<c:out value="${lead.phone}" />" /> <br />
            
            Fax 			: <input type="text" name="LeadFax" required="required"
                               value="<c:out value="${lead.fax}" />" /> <br />
            
            Status 			: <SELECT name = "LeadStatus" id="LeadStatus" 
                    value="<c:out value ='${lead.status}'/>" >
							<OPTION value="" ></OPTION>
							<OPTION value="Active" >Active</OPTION> 
							<OPTION value="Inactive" >Inactive</OPTION>
							</SELECT>
					<br/>		
            
            Address 		: <input type="text" name="LeadAddress"
                               value="<c:out value="${lead.address}" />" /> <br />
            
            State 			: <input type="text" name="LeadState"
                               value="<c:out value="${lead.state}" />" /> <br />
            
            Country 		: <input type="text" name="LeadCountry"
                               value="<c:out value="${lead.country}" />" /> <br />
            
            Zip 			: <input type="text" name="LeadZip"
                               value="<c:out value="${lead.zip}" />" /> <br />
                               

            
                                    
                        
            <input style="background:#000033 font-color:white" type="submit" value="Submit" />
        </form>
    </body>
</html>