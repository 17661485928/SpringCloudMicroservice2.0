package com.qht.springbootproducer.service.impl;

import com.qht.springbootproducer.dao.UserLoginDao;
import com.qht.springbootproducer.response.UserInformationResponse;
import com.qht.springbootproducer.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginDao userLoginDao;


    /**
     * 查询用户信息
     * @param user_name
     * @return
     * @throws Exception
     */
    @Override
    public List<UserInformationResponse> findUserInformationList(String user_name) throws Exception {
        List<UserInformationResponse> userInformationList = userLoginDao.findUserInformationList(user_name);
        return userInformationList;
    }

    /**
     * 插入用户信息
     * @param requestParams
     */
    @Override
    public void insertUserInformation(Map<String, Object> requestParams) throws Exception{
        requestParams.put("create_time",new Date());
        requestParams.put("update_time",new Date());
        userLoginDao.insertUserInformation(requestParams);
    }

    /**
     * 修改用户信息
     * @param requestParams
     * @throws Exception
     */
    @Override
    public void updateUserInformation(Map<String, Object> requestParams) throws Exception {
        requestParams.put("update_time",new Date());
        userLoginDao.updateUserInformation(requestParams);
    }

    /**
     * 删除用户信息
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteUserInformation(Integer id) throws Exception {
        userLoginDao.deleteUserInformation(id);
    }
}
