import java.sql.*;
import java.util.*;
public class StudentDAO {
    Connection con;
    public StudentDAO(Connection con){ this.con = con; }
    public void addStudent(Student s){ /* JDBC Insert logic with PreparedStatement */ }
    public List<Student> getAllStudents(){ /* SELECT * FROM Student and return list */ }
    public void updateStudent(Student s){ /* JDBC Update logic */ }
    public void deleteStudent(int studentID){ /* JDBC Delete logic */ }
}
