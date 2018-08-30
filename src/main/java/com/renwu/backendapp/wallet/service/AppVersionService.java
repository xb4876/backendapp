package com.renwu.backendapp.wallet.service;

import com.github.pagehelper.PageInfo;
import com.renwu.backendapp.wallet.entity.AppVersion;
import com.renwu.backendapp.wallet.mapper.AppVersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppVersionService {

    @Autowired
    AppVersionMapper mapper;

    /**
     * 获取问题列表
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    public PageInfo<AppVersion> getAppVersionList(AppVersion entity) {
        List<AppVersion> questions = mapper.findList(entity);
        PageInfo result = new PageInfo(questions);
        return result;
    }

    /**
     * 新增数据
     * @param entity
     * @return
     * @throws Exception
     */
    public int save(AppVersion entity) throws Exception{
        int code = 0;
        entity.setUpdate_date(new Date());
        entity.setCreate_date(new Date());
        entity.setIs_new(1);
        code = mapper.save(entity);
        if(code>0){
            //更新其他信息is_new
            mapper.updateOther(entity);
        }
        return code;
    }

    /**
     * 删除数据
     * @param id
     */
    public void delete(String id) {
        mapper.delete(id);
    }

    public AppVersion findOne(int id) {
        return mapper.findOne(id);
    }

    public int edit(AppVersion entity) {
        int code = 0;
        entity.setUpdate_date(new Date());
        code = mapper.update(entity);
        return code;
    }

    public Boolean checkVersion(AppVersion appVersion) {
        AppVersion check = mapper.checkVersion(appVersion.getVersion());
        //根据版本号查询数据  不为null则版本号重复
        if(check!=null){
            return false;
        }else{
            return true;
        }
    }
}
