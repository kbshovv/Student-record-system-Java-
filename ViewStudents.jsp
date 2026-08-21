    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="Student" %>
    <!DOCTYPE html>
    <html>
    <head><title>View Students</title></head>
    <body>
        <h2>Student List</h2>
        <table border="1">
            <tr>
                <th>ID</th><th>Name</th><th>Email</th><th>Course</th>
            </tr>
            <% 
                ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("studentList");
                if(students != null) {
                    for(Student s : students) {
            %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getEmail() %></td>
                <td><%= s.getCourse() %></td>
            </tr>
            <%      }
                }
            %>
        </table>
        <br>
        <a href="index.jsp">Back to Home</a>
    </body>
    </html>
