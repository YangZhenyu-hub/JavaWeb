package com.yzy.fruit.dao;

import com.yzy.fruit.pojo.Fruit;

import java.util.List;

/**
 * @ClassName FruitDAO
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-19 19:51
 * @Version
 **/
public interface FruitDAO {
    //查询总记录条数
    int getFruitCount(String keyword);

    //获取所有的库存列表信息
    List<Fruit> getFruitList();

    //获取指定页面上的库存列表信息，每页显示5条
    List<Fruit> getFruitList(String keyword,int pageNumber);

    //获取指定fid的水果库存信息
    Fruit getFruitByFid(Integer fid);

    //修改指定的库存记录
    boolean updateFruite(Fruit fruit);

    //删除指定fid的记录
    boolean delFruit(Integer fid);

    //添加一条记录
    boolean addFruit(Fruit fruit);
}
