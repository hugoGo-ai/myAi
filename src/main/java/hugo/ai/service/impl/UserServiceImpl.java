package hugo.ai.service.impl;

import hugo.ai.entity.User;
import hugo.ai.mapper.UserMapper;
import hugo.ai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public int save(User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        return userMapper.update(user);
    }

    @Override
    public int deleteById(Long id) {
        return userMapper.deleteById(id);
    }
}
