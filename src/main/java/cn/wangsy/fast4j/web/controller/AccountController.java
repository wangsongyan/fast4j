package cn.wangsy.fast4j.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.bouncycastle.asn1.x9.OtherInfo;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.youymi.youymiframework.service.ServiceResult;

import cn.wangsy.fast4j.web.model.entity.OAuthUserAO;
import cn.wangsy.fast4j.web.model.entity.gen.OAuthUser;
import cn.wangsy.fast4j.web.model.entity.gen.User;
import cn.wangsy.fast4j.web.service.OauthUserService;
import cn.wangsy.fast4j.web.service.UserService;
import cn.wangsy.fast4j.web.service.oauth.OAuthServiceDeractor;
import cn.wangsy.fast4j.web.service.oauth.OAuthServices;


@Controller
public class AccountController {
    
    public static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    
    @Autowired 
    OAuthServices oAuthServices;
    @Autowired 
    OauthUserService oauthUserRepository;
    @Autowired 
    UserService userRepository;
    
    @RequestMapping(value = {"", "/login"}, method=RequestMethod.GET)
    public String showLogin(Model model){
        model.addAttribute("oAuthServices", oAuthServices.getAllOAuthServices());
        return "/oauth/index";
    }
    
    @RequestMapping(value = "/oauth/{type}/callback", method=RequestMethod.GET)
    public String claaback(@RequestParam(value = "code", required = true) String code,
            @PathVariable(value = "type") String type,
            HttpServletRequest request, Model model){
        OAuthServiceDeractor oAuthService = oAuthServices.getOAuthService(type);
        Token accessToken = oAuthService.getAccessToken(null, new Verifier(code));
        OAuthUser oAuthInfo = oAuthService.getOAuthUser(accessToken);
        OAuthUser oAuthUser = oauthUserRepository.findByOAuthTypeAndOAuthId(oAuthInfo.getoAuthType(), 
                oAuthInfo.getoAuthId());
        if(oAuthUser == null){
            model.addAttribute("oAuthInfo", oAuthInfo);
            return "/oauth/register";
        }
        request.getSession().setAttribute("oauthUser", oAuthUser);
        return "redirect:/success";
    }
    
    @RequestMapping(value = "/register", method=RequestMethod.POST)
    public String register(Model model, User user,
            @RequestParam(value = "oAuthType", required = false, defaultValue = "") String oAuthType,
            @RequestParam(value = "oAuthId", required = true, defaultValue = "") String oAuthId,
            HttpServletRequest request){
        OAuthUserAO oAuthInfo = new OAuthUserAO();
        oAuthInfo.setoAuthId(oAuthId);
        oAuthInfo.setoAuthType(oAuthType);
        if(userRepository.findByUsername(user.getUserName()) != null){
            model.addAttribute("errorMessage", "用户名已存在");
            model.addAttribute("oAuthInfo", oAuthInfo);
            return "/oauth/register";
        }
        ServiceResult<User> ret = userRepository.save(user);
        if(ret.isSucceed()){
        	user = ret.getData();
        	OAuthUser oAuthUser = oauthUserRepository.findByOAuthTypeAndOAuthId(oAuthType, oAuthId);
            if(oAuthUser == null){
                oAuthInfo.setUser(user);
                oAuthInfo.setUserId(user.getId());
                oAuthUser = oauthUserRepository.save(oAuthInfo);
            }
            request.getSession().setAttribute("oauthUser", oAuthUser);
            return "redirect:/success";
        }else{
        	 model.addAttribute("errorMessage", ret.getMsg());
             model.addAttribute("oAuthInfo", oAuthInfo);
             return "/oauth/register";
        }
    }
    
    @RequestMapping(value = "/success", method=RequestMethod.GET)
    @ResponseBody
    public Object success(HttpServletRequest request){
        return request.getSession().getAttribute("oauthUser");
    }
    

}
