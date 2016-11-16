package cn.wangsy.fast4j.web.service.oauth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OAuthServices {
    
    @Autowired List<OAuthServiceDeractor> oAuthServiceDeractors;
    
    public OAuthServiceDeractor getOAuthService(String type){
//        Optional<OAuthServiceDeractor> oAuthService = oAuthServiceDeractors.stream().filter(o -> o.getoAuthType().equals(type))
//                .findFirst();
//        if(oAuthService.isPresent()){
//            return oAuthService.get();
//        }
//        return null;
    	for(OAuthServiceDeractor deractor : oAuthServiceDeractors){
    		if(deractor.getoAuthType().equals(type)){
    			return deractor;
    		}
    	}
    	return null;
    }
    
    public List<OAuthServiceDeractor> getAllOAuthServices(){
        return oAuthServiceDeractors;
    }

}
