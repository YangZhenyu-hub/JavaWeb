package com.yzy.fruit.dao.impl;

import com.yzy.fruit.dao.FruitDAO;
import com.yzy.fruit.pojo.Fruit;
import com.yzy.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @ClassName FruitDAOImpl
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-19 20:14
 * @Version
 **/
public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    @Override
    public int getFruitCount(String keyword) {
        return ((Long) executeComplexQuery("select count(*)from t_fruit where fname like ? or remark like ?","%"+keyword+"%","%"+keyword+"%")[0]).intValue();
    }

    @Override
    public List<Fruit> getFruitList() {
        return executeQuery("select * from t_fruit");
    }

    @Override
    public List<Fruit> getFruitList(String keyword,int pageNumber) {
        return executeQuery("select * from t_fruit where fname like ? or remark like ? limit ?,5","%"+keyword+"%","%"+keyword+"%",(pageNumber-1)*5);
    }

    @Override
    public Fruit getFruitByFid(Integer fid) {
        return super.load("select * from t_fruit where fid=?",fid);
    }

    @Override
    public boolean updateFruite(Fruit fruit) {
        String sql="update t_fruit set fname=?,price=?,fcount=?,remark=? where fid=?";
        int update = super.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark(), fruit.getFid());
        return update == 1;
    }

    @Override
    public boolean delFruit(Integer fid) {
        int updateCount = super.executeUpdate("delete from t_fruit where fid=?", fid);
        return updateCount==1;
    }

    @Override
    public boolean addFruit(Fruit fruit) {
        String sql=("insert into t_fruit values(0,?,?,?,?)");
        int insertCount = super.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark());
        return insertCount!=0;


    }

}
