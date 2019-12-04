package com.trs.restfulcrud.service;

import com.trs.restfulcrud.dao.CriminalDao;
import com.trs.restfulcrud.pojo.Criminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.OverridesAttribute;
import java.util.List;

/**
 * Description: TODO
 * Project: seasonRESTfulCRUD
 *
 * @author : Julian
 * Create Time:2019/12/3 16:16
 */
@Service
public class CriminalService {

    final
    CriminalDao<Criminal> criminalDao;

    @Autowired
    public CriminalService(CriminalDao<Criminal> criminalDao) {
        this.criminalDao = criminalDao;
    }

    public Object save(Criminal criminal) {
        return criminalDao.save(criminal);
    }

    public Object update(Criminal criminal) {
        return criminalDao.update(criminal);
    }

    public Object findById(Long  id){
        return criminalDao.findById(id);
    }

    public Object delete(Criminal criminal){
        return criminalDao.delete(criminal);
    }

    public Object deleteById(Long  id){
        return criminalDao.deleteById(id    );
    }

    public List<Criminal> findAll(){
        return criminalDao.findAll();
    }

}
