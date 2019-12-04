package com.trs.restfulcrud.dao;

import com.trs.restfulcrud.dao.base.BaseDao;
import com.trs.restfulcrud.dao.base.BaseDao0;
import com.trs.restfulcrud.pojo.Criminal;
import org.springframework.stereotype.Repository;

/**
 * Description:
 * Project: seasonRESTfulCRUD
 *
 * @author : Julian
 * Create Time:2019/12/3 10:05
 */
@Repository
public class CriminalDao extends BaseDao {


    public CriminalDao() {
    }

    /**
     * Description 清理缓存
     *
     * @param criminal 传入的pojo类
     * @return void
     * @author julian cao
     */


    @Override
    public void clearCache(Criminal criminal) {

    }
}
