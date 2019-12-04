package com.trs.restfulcrud.dao.base;

import com.season.orm.dao.ISeasonDao;
import com.trs.restfulcrud.pojo.Criminal;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Description: TODO
 * Project: seasonRESTfulCRUD
 *
 * @author : Julian
 * Create Time:2019/12/4 13:32
 */
public abstract class BaseDao {

    @Autowired
    protected ISeasonDao seasonDao;

    public abstract void clearCache(Criminal criminal);

    public Criminal save(Criminal criminal) {
        if (null == criminal) {
            return null;
        }
        return seasonDao.save(criminal);
    }

    public Integer update(Criminal t) {
        if (null == t) {
            return 0;
        }
        int count = seasonDao.update(t);
        clearCache(t);
        return count;
    }

    public Criminal findById(Long id) {
        if (null == id) {
            return null;
        }
        return seasonDao.findById(Criminal.class, id);
    }

    public List<Criminal> findAll() {
        return seasonDao.find(Criminal.class, "select * from criminal  ", null);
    }

    public Integer delete(Criminal t) {
        if (null == t) {
            return 0;
        }
        if (null == findById(t.getId())) {
            return 0;
        }
        return seasonDao.delete(t);

    }

    public Integer deleteById(Long id) {
        if (null == id) {
            return 0;
        }
        return seasonDao.deleteById(Criminal.class, id);


    }

}
