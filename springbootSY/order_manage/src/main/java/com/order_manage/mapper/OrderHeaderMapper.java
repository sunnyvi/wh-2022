package com.order_manage.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.order_manage.entity.OrderHeader;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author weiqi
* @description 针对表【order_header】的数据库操作Mapper
* @createDate 2022-04-26 17:03:06
* @Entity com.order_manage.entity.OrderHeader
*/

@Mapper
public interface OrderHeaderMapper extends BaseMapper<OrderHeader> {

    // 查询所有
    List<OrderHeader> selectById(@Param("id") Integer id);


}




