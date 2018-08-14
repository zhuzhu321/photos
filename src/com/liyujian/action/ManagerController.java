package com.liyujian.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liyujian.po.Manager;
import com.liyujian.service.ManagerService;

@Controller
@Scope(value="prototype")
@RequestMapping("/manager")
public class ManagerController {
	@Resource
	private ManagerService managerService;
	@RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(Manager manager,Model model) throws Exception {
        manager=managerService.checkLogin(manager.getManager_name(), manager.getManager_password());
        if(manager!=null){
            model.addAttribute(manager);
            return "welcome";// 路径 WEB-INF/pages/welcome.jsp            
        }
        return "fail";
    }
	//注销方法
    @RequestMapping("/outLogin")
    public String outLogin(HttpSession session){
        //通过session.invalidata()方法来注销当前的session
        session.invalidate();
        return "redirectLogin";
    }
}
