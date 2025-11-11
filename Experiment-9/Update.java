Student s = session.get(Student.class, id);
s.setEmail("newmail@example.com");
session.update(s);
