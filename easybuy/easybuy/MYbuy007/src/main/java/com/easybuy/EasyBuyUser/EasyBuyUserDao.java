package com.easybuy.EasyBuyUser;

import com.easybuy.entity.EasybuyUser;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EasyBuyUserDao extends JpaRepository<EasybuyUser,Integer> {

    @Query("from EasybuyUser u where u.loginName=?1 and u.password=?2")
    public EasybuyUser login(String loginname, String password);

    //利用自带方法 增加用户
    @Modifying
    @Override
    <S extends EasybuyUser> S save(S s);

    //获取查询用户总数
    @Query("select count (u.id) from  EasybuyUser  u ")
    Integer getUserNum();

    //获取用户信息
    @Query("from EasybuyUser e ")
    List<EasybuyUser> getAllUser(Pageable pageable);

    //根据用户id查询用户信息
    @Query("from EasybuyUser  e where  e.id=?1")
    EasybuyUser lookuser(Long id);

    //根据用户id删除用户
    @Modifying
    @Query("delete from EasybuyUser e where e.id=?1")
    void removeById(Long id);

    //修改用户信息
    @Modifying
    @Query("update EasybuyUser e set  e.loginName =?1,e.userName=?2, e.password=?3,e.identityCode=?4 ,e.email=?5, e.mobile=?6, e.type=?7 where e.id=?8")
    public void UpdateUser(String loginName, String userName, String password, String identityCode, String email, String mobile, Long type, Long id);

    //根据loginName查询用户是否存在
    @Query("from EasybuyUser e where  e.loginName=?1")
    EasybuyUser findByLoginName(String loginName);

}
