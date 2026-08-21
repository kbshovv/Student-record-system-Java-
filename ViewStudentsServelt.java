    import java.io.IOException;
    import java.sql.Connection;
    import java.sql.ResultSet;
    import java.sql.Statement;
    import java.util.ArrayList;
    import javax.servlet.RequestDispatcher;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;

    @WebServlet("/ViewStudentsServlet")
    public class ViewStudentsServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
            
            ArrayList<Student> students = new ArrayList<>();
            
            try {
                Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM students");
                
                while(rs.next()) {
                    students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("course")
                    ));
                }
                conn.close();
                
                request.setAttribute("studentList", students);
                RequestDispatcher rd = request.getRequestDispatcher("viewStudents.jsp");
                rd.forward(request, response);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
