package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> selectStudents() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId="com.bjpowernode.dao.StudentDao.selectStudents";
        List<Student> students=sqlSession.selectList(sqlId);
        sqlSession.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId="com.bjpowernode.dao.StudentDao.insertStudent";
        int nums = sqlSession.insert(sqlId,student);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        return nums;
    }
}
