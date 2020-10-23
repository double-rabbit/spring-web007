package com.rabbit.service.impl;

import com.rabbit.dao.GoodsDao;
import com.rabbit.dao.SailDao;
import com.rabbit.domain.Goods;
import com.rabbit.domain.Sail;
import com.rabbit.service.BuyGoodsService;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {
    private SailDao sailDao;
    private GoodsDao goodsDao;

    public BuyGoodsServiceImpl() {
    }

    public BuyGoodsServiceImpl(SailDao sailDao, GoodsDao goodsDao) {
        this.sailDao = sailDao;
        this.goodsDao = goodsDao;
    }

    public void setSailDao(SailDao sailDao) {
        this.sailDao = sailDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }
    @Transactional
    @Override
    public Boolean buyGoods(Integer gid, Integer nums) {
        Goods amount = goodsDao.findAmountById(gid);
        if (amount == null) {
            throw new RuntimeException("无此商品");
        } else if (amount.getAmount() - nums < 0) {
            throw new RuntimeException("库存不足");
        }

        Integer res = goodsDao.updateGoodsById(gid, nums);
        Sail sail = new Sail();
        sail.setGid(gid);
        sail.setNums(nums);
        sailDao.addSail(sail);
        return  true;
    }
}
