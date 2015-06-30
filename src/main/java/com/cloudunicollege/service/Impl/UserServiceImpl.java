package com.cloudunicollege.service.Impl;

import com.cloudunicollege.dao.BaseDao;
import com.cloudunicollege.entities.po.User;
import com.cloudunicollege.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by u6031313 on 6/24/2015.
 * Content:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private BaseDao<User> baseDao;

    @Override
    public void saveUser(User user) {
        baseDao.save(user);
    }

    @Override
    public void updateUser(User user) {
        baseDao.update(user);
    }

    @Override
    public User findUserById(int id) {
        return baseDao.get(User.class,id);
    }

    @Override
    public void deleteUser(User user) {
        baseDao.delete(user);
    }

    @Override
    public List<User> findAllList() {
        return baseDao.find("from User u");
    }

    @Override
    public User findUserByNameAndPassword(User user) {
        List<User> users =  baseDao.find("from User u where u.username=? and u.password=?", new Object[]{user.getUsername(), user.getPassword()});
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public User loadUserById(int id) {
        return baseDao.load(User.class,id);
    }
}
