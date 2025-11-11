@WebServlet("/AttendanceServlet")
public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sid = request.getParameter("studentId");
        String date = request.getParameter("date");
        String status = request.getParameter("status");
        Connection con = // init JDBC connection;
        PreparedStatement ps = con.prepareStatement("INSERT INTO Attendance (StudentID, Date, Status) VALUES (?, ?, ?)");
        ps.setString(1, sid);
        ps.setString(2, date);
        ps.setString(3, status);
        ps.executeUpdate();
        response.sendRedirect("success.jsp"); // Or show confirmation
    }
}
