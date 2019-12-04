package com.trs.restfulcrud.dao.base;

import com.season.common.ClassKit;
import com.season.orm.dao.ISeasonDao;
import com.season.orm.dao.Table;
import com.season.orm.dao.dialect.AbstractDialect;
import com.trs.restfulcrud.pojo.Criminal;
import com.trs.restfulcrud.pojo.base.BasePojo;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Description: TODO
 * Project: seasonRESTfulCRUD
 *
 * @author : Julian
 * Create Time:2019/12/3 10:08
 */
public abstract class BaseDao<T> {

    @Autowired
    protected ISeasonDao seasonDao;

    private final Class<T> entityClass;
    private final String currTableName;
    private final Table table;


    public BaseDao() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
        table = AbstractDialect.getTable(entityClass);
        currTableName = table.getTableName();
    }

    /**
     * Description 清理缓存
     *
     * @param t 传入的pojo类
     * @return void
     * @author julian cao
     */
    protected abstract void clearCache(T t);

    public T save(T t) {
        if (null == t) {
            return null;
        }
        return seasonDao.save(t);
    }

    public Integer update(T t) {
        if (null == t) {
            return 0;
        }
        int count = seasonDao.update(t);
        clearCache(t);
        return count;
    }

    public Criminal findById( Long id) {
        if (null == id) {
            return null;
        }
        return seasonDao.findById(Criminal.class, id);
    }

    public List<Criminal> findAll(){
        return seasonDao.find(Criminal.class, "select * from criminal  ", null);
    }

    public Integer delete(T t) {
        if (null == t) {
            return 0;
        }
        Criminal criminal = (Criminal) t;
        if (null == findById( criminal.getId())) {
            return 0;
        }
        return seasonDao.delete(t);

    }

    public Integer deleteById(Long id) {
        if (null == id) {
            return 0;
        }
        T t = ClassKit.newInstance(entityClass);
        if (t instanceof BasePojo) {
            return seasonDao.deleteById(Criminal.class, id);
        }
        return 0;

    }


}
