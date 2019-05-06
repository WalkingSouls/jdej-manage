package com.miquankj.api.dao;

import com.miquankj.api.dto.Productdto;
import com.miquankj.api.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

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

    int selectCountsByStoreId(@Param("storeId") Integer storeId, @Param("listType")Integer listType);

    List<Productdto> selectByStoreId(@Param("storeId") Integer storeId,@Param("listType")Integer listType,
                                     @Param("startRecord") Integer startRecord,@Param("pageSize") Integer pageSize);

    int changeProStatus(@Param("productId") int productId, @Param("operationType")int operationType);
}