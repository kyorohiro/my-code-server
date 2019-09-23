package hello.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AppsMapper {
    @Select("SELECT id, name FROM apps")
    List<AppsEntity> findAll();
}
