package com.example.microservice_architecture_integration.controller;
import com.alibaba.fastjson.JSONObject;
import com.example.microservice_architecture_integration.util.Constants;
import com.example.microservice_architecture_integration.util.MongoDBUtil;
import com.example.microservice_architecture_integration.util.ResponseMsg;
import com.example.microservice_architecture_integration.util.UuidUtil;
import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin.util.UIUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/MongoDBController")
public class MongoDBController {
    /**
     * 文件上传到mongo
     * @return
     */
    @RequestMapping(value = "/uploadFile")
    @ResponseBody
    public Object uploadFile(@RequestBody String jsonParams){
        Map<String,Object> requestMap = new HashMap<>();
        ResponseMsg responseMsg = new ResponseMsg();
        if(jsonParams==null||"".equals(jsonParams)){
            responseMsg.setRetCode(Constants.RetCode.RET_CODE_FAIL);
            responseMsg.setErrorDesc("请求参数不能为空！");
            return responseMsg;
        }
        Map<String,Object> jsonMap = JSONObject.parseObject(jsonParams);
        String filePath = jsonMap.get("filePath").toString();//文件路径
        if(StringUtils.isEmpty(filePath)){
            responseMsg.setRetCode(Constants.RetCode.RET_CODE_FAIL);
            responseMsg.setErrorDesc("文件路径不能为空！");
            return responseMsg;
        }
        File file = new File(filePath);
        requestMap.put("attachId", UuidUtil.getId());
        String id = MongoDBUtil.uploadFileToMongodb(file, requestMap);//上传文件到mongo
        responseMsg.setRetCode(Constants.RetCode.RET_CODE_SUCCESS);
        responseMsg.setResponseBody(id);
        return responseMsg;
    }

    /**
     * 根据主键删除mongodb中的文件
     * @param jsonParams
     * @return
     */
    @RequestMapping(value = "/deleteFileTOMongoDB")
    @ResponseBody
    public Object deleteFileTOMongoDB(@RequestBody String jsonParams){
        Map<String,Object> requestMap = new HashMap<>();
        ResponseMsg responseMsg = new ResponseMsg();
        if(jsonParams==null||"".equals(jsonParams)){
            responseMsg.setRetCode(Constants.RetCode.RET_CODE_FAIL);
            responseMsg.setErrorDesc("请求参数不能为空！");
            return responseMsg;
        }
        Map<String,Object> jsonMap = JSONObject.parseObject(jsonParams);
        String objectId = jsonMap.get("objectId").toString();//mongodb的主键id
        if(StringUtils.isEmpty(objectId)){
            responseMsg.setRetCode(Constants.RetCode.RET_CODE_FAIL);
            responseMsg.setErrorDesc("主键objectId不能为空！");
            return responseMsg;
        }
        MongoDBUtil.deleteFileToMongoDB(objectId);
        responseMsg.setRetCode(Constants.RetCode.RET_CODE_SUCCESS);
        responseMsg.setErrorDesc("文件删除成功");
        return responseMsg;
    }

    @RequestMapping(value = "/searchFileToMongoDB")
    @ResponseBody
    public Object searchFileToMongoDB(@RequestBody String jsonParams){
        Map<String,Object> requestMap = new HashMap<>();
        ResponseMsg responseMsg = new ResponseMsg();
        if(jsonParams==null||"".equals(jsonParams)){
            responseMsg.setRetCode(Constants.RetCode.RET_CODE_FAIL);
            responseMsg.setErrorDesc("请求参数不能为空！");
            return responseMsg;
        }
        Map<String,Object> jsonMap = JSONObject.parseObject(jsonParams);
//        if(!jsonMap.containsKey("objectId")){
//            responseMsg.setRetCode(Constants.RetCode.RET_CODE_FAIL);
//            responseMsg.setErrorDesc("主键objectId不存在！");
//            return responseMsg;
//        }
//        String objectId = jsonMap.get("objectId").toString();//mongodb的主键id
////        if(StringUtils.isEmpty(objectId)){
////            responseMsg.setRetCode(Constants.RetCode.RET_CODE_FAIL);
////            responseMsg.setErrorDesc("主键objectId不能为空！");
////            return responseMsg;
////        }
        Object resObject = MongoDBUtil.searchFileToMongoDB(jsonMap);
        responseMsg.setRetCode(Constants.RetCode.RET_CODE_SUCCESS);
        responseMsg.setErrorDesc("文件查询成功");
        responseMsg.setResponseBody(resObject);
        return responseMsg;
    }
}
