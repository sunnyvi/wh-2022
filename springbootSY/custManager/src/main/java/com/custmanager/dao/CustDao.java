package com.custmanager.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.custmanager.entity.Cust;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Cust)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-20 12:04:18
 */
@Mapper
@Repository
public interface CustDao extends BaseMapper<Cust> {




}

