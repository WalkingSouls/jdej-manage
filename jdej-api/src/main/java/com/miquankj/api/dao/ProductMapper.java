package com.miquankj.api.dao;

import com.miquankj.api.dto.ProductConditiondto;
import com.miquankj.api.dto.Productdto;
import com.miquankj.api.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);

    int selectCountsByStoreId(Map<String, Object> map);

    List<Productdto> selectByStoreId(Map<String, Object> map);

    int changeProStatus(@Param("productId") int productId, @Param("operationType")int operationType);

    Integer selectCountsByCondition(Map<String, Object> map);

    List<Productdto> selectByCondition(Map<String, Object> map);
}