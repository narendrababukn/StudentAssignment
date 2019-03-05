package com.chandu.dao.impl;

import com.chandu.dao.StudentDao;

import com.chandu.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void insertStudent(Student std) {
    String sql= "INSERT INTO student"+" (stdId, stdName) VALUES(?,?)";
    jdbcTemplate.update(sql, new Object[]{std.getStdId(), std.getStdName()});
    }

    @Override
    public void insertStudents(List<Student> students) {
    String sql="INSERT INTO student"+" (stdId, stdName) VALUES(?,?)";
    jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
        @Override
        public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
            Student student= students.get(i);
            preparedStatement.setString(1, student.getStdId());
            preparedStatement.setString(2, student.getStdName());
        }

        @Override
        public int getBatchSize() {
            return students.size();
        }
    });
    }

    @Override
    public List<Student> getAllStudents() {

        String sql = "SELECT * FROM student";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        List<Student> result = new ArrayList<Student>();
        for (Map<String, Object> row : rows) {
            Student std = new Student();
            std.setStdId((String) row.get("stdId"));
            std.setStdName((String) row.get("stdName"));
            result.add(std);
        }

        return result;
    }




    @Override
    public Student getStudentById(String stdId) {
        String sql = "SELECT * FROM student WHERE stdId=?";
        return (Student) jdbcTemplate.queryForObject(sql, new Object[]{stdId}, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rwNumber) throws SQLException {
                Student std = new Student();
                std.setStdId(rs.getString("stdId"));
                std.setStdName(rs.getString("stdName"));
                return std;
            }
        });


    }
}
