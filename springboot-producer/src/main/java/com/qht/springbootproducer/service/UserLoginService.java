package com.qht.springbootproducer.service;

import com.qht.springbootproducer.response.UserInformationResponse;

import java.util.List;
import java.util.Map;

public interface UserLoginService {

    /**
     * 查询用户信息
     *
     * @param user_name
     * @return
     * @throws Exception
     */
    List<UserInformationResponse> findUserInformationList(String user_name) throws Exception;

    /**
     * 插入用户信息
     *
     * @param requestParams
     */
    void insertUserInformation(Map<String, Object> requestParams) throws Exception;

    /**
     * 修改用户信息
     *
     * @param requestParams
     */
    void updateUserInformation(Map<String, Object> requestParams) throws Exception;

    /**
     * 删除用户信息
     *
     * @param id
     */
    void deleteUserInformation(Integer id) throws Exception;
}
