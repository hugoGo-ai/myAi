package hugo.ai.service;

import hugo.ai.entity.DataTest;

import java.util.List;

public interface DataTestService {

    DataTest findById(String id);

    List<DataTest> findAll();

    int save(DataTest dataTest);

    int update(DataTest dataTest);

    int deleteById(String id);
}
