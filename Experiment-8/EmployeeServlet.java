@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String empID = request.getParameter("empID");
        Connection con = // initialize JDBC connection;
        PreparedStatement ps;
        if(empID != null && !empID.isEmpty()){
            ps = con.prepareStatement("SELECT * FROM Employee WHERE EmpID = ?");
            ps.setString(1, empID);
        } else {
            ps = con.prepareStatement("SELECT * FROM Employee");
        }
        ResultSet rs = ps.executeQuery();
        PrintWriter out = response.getWriter();
        out.println("<table><tr><th>ID</th><th>Name</th><th>Salary</th></tr>");
        while(rs.next()) {
            out.println("<tr><td>"+rs.getInt("EmpID")+"</td><td>"+rs.getString("Name")+"</td><td>"+rs.getDouble("Salary")+"</td></tr>");
        }
        out.println("</table>");
    }
}
