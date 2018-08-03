package com.renwu.backendapp.wallet.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.renwu.backendapp.wallet.entity.Problem;
import com.renwu.backendapp.wallet.mapper.ProblemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProblemService {

    @Autowired
    ProblemMapper mapper;

    /**
     * 获取问题反馈列表
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    public PageInfo<Problem> getProblemList(Problem entity) {
        List<Problem> problems = mapper.findList(entity);
        PageInfo result = new PageInfo(problems);
        return result;
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
    public Problem findOne(int id) {
        return mapper.findOne(id);
    }

    /**
     * 编辑
     * @param entity
     * @return
     */
    public int edit(Problem entity) {
        entity.setUpdate_date(new Date());
        int code = mapper.update(entity);
        return code;
    }
}
