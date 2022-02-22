package com.yzy.fruit.biz;

import com.yzy.fruit.pojo.Fruit;

import java.util.List;

/**
 * @ClassName FruitService
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-22 22:21
 * @Version
 **/
public interface FruitService {
    //获取指定页面的库存列表信息
    List<Fruit> getFruitList(String keyword , Integer pageNum);
    //添加库存记录信息
    boolean addFruit(Fruit fruit);
    //根据id查看指定库存记录
    Fruit getFruitByFid(Integer fid);
    //删除特定库存记录
    boolean delFruit(Integer fid);
    //获取总页数
    Integer getPageCount(String keyword);
    //修改特定库存记录
    boolean updateFruit(Fruit fruit);
}
