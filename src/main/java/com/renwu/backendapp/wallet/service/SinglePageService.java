package com.renwu.backendapp.wallet.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.renwu.backendapp.core.utils.PinyinUtils;
import com.renwu.backendapp.wallet.entity.SinglePage;
import com.renwu.backendapp.wallet.mapper.SinglePageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class SinglePageService {

    @Autowired
    SinglePageMapper mapper;

    /**
     * 获取问题列表
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    public PageInfo<SinglePage> getSinglePageList(SinglePage entity) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(1, 10);
        List<SinglePage> singlePages = mapper.findList(entity);
        PageInfo result = new PageInfo(singlePages);
        return result;
    }
    /**
     * 获取问题列表
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    public PageInfo<SinglePage> getSinglePageList(Integer  pageNum, Integer  pageSize) {
        List<SinglePage> singlePages = mapper.findList(new SinglePage());
        PageInfo result = new PageInfo(singlePages);
        return result;
    }

    /**
     * 新增
     * @param entity
     * @return
     * @throws Exception
     */
    public int save(SinglePage entity) throws Exception{
        int code = 0;
        entity.setUpdate_date(new Date());
        entity.setCreate_date(new Date());
        entity.setModule(PinyinUtils.ToFirstChar(entity.getModule_name()));
        code = mapper.save(entity);
        return code;
    }

    /**
     * 删除数据
     * @param id
     */
    public void delete(String id) {
        mapper.delete(id);
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public SinglePage findOne(int id) {
        return mapper.findOne(id);
    }

    /**
     * 编辑
     * @param entity
     * @return
     */
    public int edit(SinglePage entity) {
        int code = 0;
        entity.setUpdate_date(new Date());
        entity.setModule(PinyinUtils.ToFirstChar(entity.getModule_name()));
        code = mapper.update(entity);
        return code;
    }
}
