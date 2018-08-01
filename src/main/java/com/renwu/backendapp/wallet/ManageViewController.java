package com.renwu.backendapp.wallet;

import com.renwu.backendapp.wallet.mapper.AboutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  H5页面视图
 *  @author xb4876
 */
@Controller
@RequestMapping("/manage-view")
public class ManageViewController {

    @Autowired
    private AboutMapper aboutMapper;

    /**
     * 后端管理首页
     * http://localhost:8099/manage-view/manage-index
     * @return
     */
    @RequestMapping("/manage-index")
    public String manageIndex(Model mode) {

        return "manage/index";
    }

    /**
     * 帮助中心管理页面
     * http://localhost:8099/manage-view/manage-index
     * @return
     */
    @RequestMapping("/help-list")
    public String helpList(Model mode) {

        return "help/help_list";
    }
}
