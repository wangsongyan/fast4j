package cn.wangsy.fast4j.web.service.oauth;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import cn.wangsy.fast4j.core.oauth2.config.OAuthTypes;
import cn.wangsy.fast4j.web.model.entity.OAuthUserAO;
import cn.wangsy.fast4j.web.model.entity.gen.User;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;

public class GithubOAuthService extends OAuthServiceDeractor {

    private static final String PROTECTED_RESOURCE_URL = "https://api.github.com/user";

    public GithubOAuthService(OAuthService oAuthService) {
        super(oAuthService, OAuthTypes.GITHUB);
    }

    @Override
    public OAuthUserAO getOAuthUser(Token accessToken) {
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
        this.signRequest(accessToken, request);
        Response response = request.send();
        OAuthUserAO oAuthUser = new OAuthUserAO();
        oAuthUser.setoAuthType(getoAuthType());
        Object result = JSON.parse(response.getBody());
        oAuthUser.setoAuthId(JSONPath.eval(result, "$.id").toString());
        oAuthUser.setUser(new User());
        oAuthUser.getUser().setUserName(JSONPath.eval(result, "$.login").toString());
        return oAuthUser;
    }

}
