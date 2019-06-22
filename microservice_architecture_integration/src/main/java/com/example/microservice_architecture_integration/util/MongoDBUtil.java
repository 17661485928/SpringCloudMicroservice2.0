package com.example.microservice_architecture_integration.util;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * mongodb数据库操作工具
 */
public class MongoDBUtil {
    private static final Logger logger = LoggerFactory.getLogger(MongoDBUtil.class);

    @Autowired
    private static MongoTemplate mongoTemplate;
    @Autowired
    private MongoDbFactory mongoDbFactory;
    @Value("${mongodb.uri}")
    private static String url = "127.0.0.1";
    @Value("${mongodb.port}")
    private static String port = "27017";
    @Value("${mongodb.database}")
    private static String dbBase = "admin";
    @Value("${mongodb.collectionName}")
    private static String collectionName = "test";
    private static Mongo mongo = null;   //数据库地址，端口号
    private static DB imgDB = null;
    private static GridFS gridFS;
    private static DBCollection dbc = null;

    private static void init() {
        try {
            mongo = new Mongo(url, Integer.valueOf(port));
            imgDB = mongo.getDB(dbBase);  // 数据库名称
            dbc = imgDB.getCollection(collectionName + ".files");
            gridFS = new GridFS(imgDB, collectionName);
        } catch (Exception e) {
            logger.info("连接mongodb服务器异常=============================init() Exception:" + e.getMessage());
        }
    }

    /**
     * 文件存入mongo，并返回id
     *
     * @param file
     * @return
     */
    public static String uploadFileToMongodb(File file, Map<String, Object> paramMap) {
        init();
        String id = "";
        try {
            GridFSInputFile gridFSInputFile = gridFS.createFile(file);
            gridFSInputFile.setFilename(file.getName());
            if (paramMap != null && paramMap.size() != 0) {
                Set<String> keySet = paramMap.keySet();
                for (Iterator iterator = keySet.iterator(); iterator.hasNext(); ) {
                    String key = iterator.next().toString();
                    gridFSInputFile.put(key, paramMap.get(key).toString());
                }
            }
            gridFSInputFile.save();
            id = gridFSInputFile.getId().toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * 根据主键删除mongodb中的文件
     * @param objectId
     */
    public static void deleteFileToMongoDB(String objectId){
        init();
        gridFS.remove(new ObjectId(objectId));
    }

    /**
     * 查询
     * @param paramMap
     * @return
     */
    public static Object searchFileToMongoDB(Map<String, Object> paramMap) {
        init();
        Object resObject = null;
        String objectId = "";
        String attachId = "";
        Map<String,Object> responseMp = new HashMap<>();
        GridFSDBFile gridFSDBFile = null;
        try {
            if (paramMap.containsKey("objectId")) {
                objectId = paramMap.get("objectId").toString();
                if("".equals(objectId)||objectId==null){
                    responseMp.put("retCode",Constants.RetCode.RET_CODE_FAIL);
                    responseMp.put("errorDesc","主键objectId不存在！");
                    resObject = responseMp;
                    return responseMp;
                }
                gridFSDBFile = gridFS.find(new ObjectId(objectId));
            } else {
                attachId = paramMap.get("attachId").toString();
                if("".equals(attachId)||attachId==null){
                    responseMp.put("retCode",Constants.RetCode.RET_CODE_FAIL);
                    responseMp.put("errorDesc","主键attachId不存在！");
                    resObject = responseMp;
                    return resObject;
                }
                DBObject dbObject = new BasicDBObject("attachId",attachId);
                List<GridFSDBFile> gridFSDBFiles = gridFS.find(dbObject);
                gridFSDBFile = gridFSDBFiles.get(0);
            }
            gridFSDBFile.writeTo(new File("F:/etc/"+gridFSDBFile.getFilename()));
            responseMp.put("fileName",gridFSDBFile.getFilename());
            responseMp.put("id",gridFSDBFile.getId());
            responseMp.put("contentType",gridFSDBFile.getContentType());
            responseMp.put("length",gridFSDBFile.getLength());
            responseMp.put("md5",gridFSDBFile.getMD5());
            responseMp.put("metaData",gridFSDBFile.getMetaData());
            responseMp.put("getAliases",gridFSDBFile.getAliases());
            responseMp.put("getChunkSize",gridFSDBFile.getChunkSize());
            responseMp.put("getUploadDate",gridFSDBFile.getUploadDate());
            resObject = responseMp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resObject;
    }

}
