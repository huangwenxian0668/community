package life.majiang.community.controller;

import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wenxian
 * @date 2020/3/20 - 11:59
 */
@Controller
public class AuthorizeController {
    @Autowired
    GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("6af3692d03aae1162b8c");
        accessTokenDTO.setClient_secret("21fa7eee5f26279f295487a91694fa621188d199");
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        githubProvider.getAccessToken(accessTokenDTO);
        return "";
    }
}
