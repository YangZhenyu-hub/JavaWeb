package com.yzy.fruit.service.impl;

import com.yzy.fruit.service.FruitService;
import com.yzy.fruit.dao.FruitDAO;
import com.yzy.fruit.pojo.Fruit;

import java.util.List;

/**
 * @ClassName FruitServiceImpl
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-22 22:28
 * @Version
 **/
public class FruitServiceImpl implements FruitService {
    FruitDAO fruitDAO = null;
    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNum) {
        return fruitDAO.getFruitList(keyword,pageNum);
    }

    @Override
    public boolean addFruit(Fruit fruit) {
        return fruitDAO.addFruit(fruit);
    }

    @Override
    public Fruit getFruitByFid(Integer fid) {
        return fruitDAO.getFruitByFid(fid);
    }

    @Override
    public boolean delFruit(Integer fid) {
        return fruitDAO.delFruit(fid);
    }

    @Override
    public Integer getPageCount(String keyword) {
        int fruitCount = fruitDAO.getFruitCount(keyword);
        int pageCount=(fruitCount+5-1)/5;
        return pageCount;
    }

    @Override
    public boolean updateFruit(Fruit fruit) {
         return fruitDAO.updateFruite(fruit);
    }
}
