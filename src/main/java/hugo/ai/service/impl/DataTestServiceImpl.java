package hugo.ai.service.impl;

import hugo.ai.entity.DataTest;
import hugo.ai.mapper.DataTestMapper;
import hugo.ai.service.DataTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataTestServiceImpl implements DataTestService {

    @Autowired
    private DataTestMapper dataTestMapper;

    @Override
    public DataTest findById(String id) {
        return dataTestMapper.findById(id);
    }

    @Override
    public List<DataTest> findAll() {
        return dataTestMapper.findAll();
    }

    @Override
    public int save(DataTest dataTest) {
        return dataTestMapper.insert(dataTest);
    }

    @Override
    public int update(DataTest dataTest) {
        return dataTestMapper.update(dataTest);
    }

    @Override
    public int deleteById(String id) {
        return dataTestMapper.deleteById(id);
    }
}
