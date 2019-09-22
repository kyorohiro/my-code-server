package hello.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersMapper {
    @Select("SELECT id, name FROM users")
    UsersEntity findAll();
}