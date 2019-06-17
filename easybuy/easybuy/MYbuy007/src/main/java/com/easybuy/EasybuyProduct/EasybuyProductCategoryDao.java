package com.easybuy.EasybuyProduct;

import com.easybuy.entity.EasybuyProductCategory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EasybuyProductCategoryDao extends JpaRepository<EasybuyProductCategory,Long> {

    @Query("from EasybuyProductCategory e")
    List<EasybuyProductCategory>finflist();


    //根据parentid 查询子分类

    @Query("from EasybuyProductCategory e where e.parentId=?1")
    List<EasybuyProductCategory>listbyparentid(Long partent);


    //查询分类数量
    @Query("select  count(e.id)  from EasybuyProductCategory e ")
    Integer getEasybuyProductCategoryNum();

    //分页查询分类
    @Query("from EasybuyProductCategory e")
    List<EasybuyProductCategory>findAllBy(Pageable pageable);

    //根据id和type删除
    @Modifying
    @Query("delete from EasybuyProductCategory e where e.type=?1 and e.id=?2")
    public void deleteByIdAndType(Long type, Long id);

    //添加分类
    @Modifying
    @Override
    <S extends EasybuyProductCategory> S save(S s);

    //根据id获得分类
    @Override
    EasybuyProductCategory getOne(Long aLong);

    //修改分类
    @Modifying
    @Query("UPDATE EasybuyProductCategory e set  e.name=?1,e.parentId=?2,e.type=?3,e.iconClass=?4 where e.id =?5")
    public void UpdateProductCategoryById(String name, Long parentId, Long type, String iconClass, Long id);
}
