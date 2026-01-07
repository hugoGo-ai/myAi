package hugo.ai.mapper;

import hugo.ai.entity.DataTest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DataTestMapper {

    DataTest findById(@Param("id") String id);

    List<DataTest> findAll();

    int insert(DataTest dataTest);

    int update(DataTest dataTest);

    int deleteById(@Param("id") String id);
}
