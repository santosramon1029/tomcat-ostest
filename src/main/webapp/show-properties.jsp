<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.InputStream"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		
	
		<%! Properties props = new Properties(); %>
		
		<% 
			InputStream in = null;
			InputStreamReader isr = null;
			try{
				in = application.getResourceAsStream("WEB-INF/props.txt");
				isr = new InputStreamReader(in, StandardCharsets.UTF_8);
				
				props.load(isr);
				Set<Object> propsSet = props.keySet();
			
		%>	
		
		<table border="1px" width="100%" bordercolor="red">
			<tr>
				<td colspan="2"><%@include file="header.html" %></td>
			</tr>
			<tr style="font-weight: 900;">
				<td  >Nome</td>
				<td >Valor</td>
			</tr>
			<% for(Object k : propsSet) { %>
				<tr>
					<td style="color: purple;"><%=k %></td>
					<td style="color: purple;"><%= props.get((String) k) %></td>
				</tr>
			<%}
			}finally{
				if(in != null){
					in.close();
				}
				if(isr != null){
					isr.close();
				}
			}
			%>
			
			<%! public void jspInit(){
				System.out.println("testando o init");
			}
			%>
		</table>
	</body>

</html>




