package com.qht.springbootproducer.api;

import com.alibaba.fastjson.JSONObject;
import com.qht.springbootproducer.response.UserInformationResponse;
import com.qht.springbootproducer.service.UserLoginService;
import com.qht.springbootproducer.util.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/UserLoginApi")
public class UserLoginApi {

    @Autowired
    private UserLoginService userLoginService;

    /**
     *  查询用户信息
     * @param responstJson
     * @return
     */
    @RequestMapping(value = "/findUserInformationList",method = RequestMethod.POST)
    public Object findUserInformationList(@RequestBody String responstJson){
        Object resOnject = null;
        JSONObject jsonObject = JSONObject.parseObject(responstJson);
        String user_name = jsonObject.getString("user_name");
        List<UserInformationResponse> userInformationList = null;
        try {
            userInformationList = userLoginService.findUserInformationList(user_name);
            resOnject = userInformationList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resOnject;
    }

    /**
     * 插入用户信息
     * @param responstJson
     * @return
     */
    @RequestMapping(value = "/insertUserInformation",method = RequestMethod.POST)
    public Object insertUserInformation(@RequestBody String responstJson){
        ResponseMsg responseMsg = new ResponseMsg();
        Map<String,Object> paramsMap = JSONObject.parseObject(responstJson);
        try {
            userLoginService.insertUserInformation(paramsMap);
            responseMsg.setErrorDesc("新增成功");
            responseMsg.setRetCode("200");
        } catch (Exception e) {
            responseMsg.setErrorDesc(e.getMessage());
            responseMsg.setRetCode("201");
            e.printStackTrace();
        }
        return responseMsg;
    }

    /**
     * 修改用户信息
     * @param responstJson
     * @return
     */
    @RequestMapping(value = "/updateUserInformation",method = RequestMethod.POST)
    public Object updateUserInformation(@RequestBody String responstJson){
        ResponseMsg responseMsg = new ResponseMsg();
        Map<String,Object> paramsMap = JSONObject.parseObject(responstJson);
        try {
            userLoginService.updateUserInformation(paramsMap);
            responseMsg.setErrorDesc("修改成功");
            responseMsg.setRetCode("200");
        } catch (Exception e) {
            responseMsg.setErrorDesc(e.getMessage());
            responseMsg.setRetCode("201");
            e.printStackTrace();
        }
        return responseMsg;
    }

    /**
     * 删除用户信息
     * @param responstJson
     * @return
     */
    @RequestMapping(value = "/deleteUserInformation",method = RequestMethod.POST)
    public Object deleteUserInformation(@RequestBody String responstJson){
        ResponseMsg responseMsg = new ResponseMsg();
        Map<String,Object> paramsMap = JSONObject.parseObject(responstJson);
        try {
            String idString = paramsMap.get("id").toString();
            userLoginService.deleteUserInformation(Integer.valueOf(idString));
            responseMsg.setErrorDesc("删除成功");
            responseMsg.setRetCode("200");
        } catch (Exception e) {
            responseMsg.setErrorDesc(e.getMessage());
            responseMsg.setRetCode("201");
            e.printStackTrace();
        }
        return responseMsg;
    }
}
