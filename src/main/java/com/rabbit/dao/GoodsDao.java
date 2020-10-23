package com.rabbit.dao;

import com.rabbit.domain.Goods;
import org.apache.ibatis.annotations.Param;

public interface GoodsDao {
    Goods findAmountById(Integer id);
    int updateGoodsById(@Param("gid") Integer gid, @Param("reduceAmount") Integer reduceAmount);
}
