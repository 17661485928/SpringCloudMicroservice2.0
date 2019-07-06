package com.qht.springbootproducer.dao;

import com.qht.springbootproducer.response.UserInformationResponse;

import java.util.List;
import java.util.Map;

public interface UserLoginDao {

    /**
     * 查询用户信息
     * @param user_name
     * @return
     */
    List<UserInformationResponse> findUserInformationList(String user_name);

    /**
     * 增加用户信息
     * @param requestParams
     */
    void insertUserInformation(Map<String,Object> requestParams);

    /**
     * 修改用户信息
     * @param requestParams
     */
    void updateUserInformation(Map<String,Object> requestParams);

    /**
     * 删除用户信息
     * @param id
     */
    void deleteUserInformation(Integer id);
}
