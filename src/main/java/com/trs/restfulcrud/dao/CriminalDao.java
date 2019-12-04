package com.trs.restfulcrud.dao;

import com.season.orm.dao.ISeasonDao;
import com.trs.restfulcrud.dao.base.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Description: TODO
 * Project: seasonRESTfulCRUD
 *
 * @author : Julian
 * Create Time:2019/12/3 10:05
 */
@Repository
public class CriminalDao<Criminal> extends BaseDao {

    @Autowired
    private ISeasonDao seasonDao;

    /**
     * Description 清理缓存
     *
     * @param o 传入的pojo类
     * @return void
     * @author julian cao
     */
    @Override
    protected void clearCache(Object o) {

    }
}
