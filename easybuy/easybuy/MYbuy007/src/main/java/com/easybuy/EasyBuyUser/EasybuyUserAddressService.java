package com.easybuy.EasyBuyUser;

import com.easybuy.entity.EasybuyUserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EasybuyUserAddressService {

    @Autowired
    EasybuyUserAddressDao dao;


    public List<EasybuyUserAddress>getAllAddress(Long userid)
    {
        return dao.getAllByUserId(userid);
    }

    public void saveAdress(EasybuyUserAddress address)
    {
        dao.save(address);
    }

    public EasybuyUserAddress getOneAddressById(Long id)
    {
        return dao.getOne(id);
    }
}
