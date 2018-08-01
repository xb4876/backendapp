package com.renwu.backendapp.wallet.mapper;

import com.renwu.backendapp.wallet.entity.About;
import com.renwu.backendapp.wallet.entity.AppVersion;
import com.renwu.backendapp.wallet.entity.Question;

import java.util.List;

/**
 * 关于我们相关的数据接口服务
 * @author ChenZhang
 */
public interface AboutMapper {

    /**
     * 返回当前被激活的应用版本信息
     * @return 返回版本信息
     */
    public AppVersion getCurrentAppVersion();

    /**
     * 类型标识符
     * @param dict_type
     * @return
     */
    public About getAbout(String dict_type);

    /**
     * 查询帮助信息（不包含内容，用于列表展示使用），根据类型查询即查询某类型的信息
     * @param type 分类类型
     * @return
     */
    public List<Question> queryHelpByType(String type);

    /**
     * 查询帮助信息（不包含内容，用于列表展示使用），根据浏览量从高到底查询指定数的信息
     * @param num 返回数
     * @return
     */
    public List<Question> queryHelpByHot(int num);

    /**
     * 搜索查询（根据查询关键词条件匹配查询）
     * @param queryKey 查询关键词
     * @return
     */
    public List<Question> queryHelpByQueryKey(String queryKey);

    /**
     * 获取某一个帮助信息的具体内容
     * @param id 帮助信息ID
     * @return
     */
    public Question getHelpInfo(int id);

}
