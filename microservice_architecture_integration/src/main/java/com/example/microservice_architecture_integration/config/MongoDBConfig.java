package com.example.microservice_architecture_integration.config;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * mongodb 配置
 */
@Configuration
@Component
public class MongoDBConfig {

    private static final Logger logger = LoggerFactory.getLogger(MongoDBConfig.class);

    @Value("${spring.data.mongodb.grid-fs-database}")
    String db;
    @Value("${mongodb.collectionName}")
    String collectionName;
    @Autowired
    private MongoDbFactory mongoDbFactory;
    @Autowired
    private GridFSBucket gridFSBucket;

    // 将GridFSFile 转成 GridFsResource
    public GridFsResource convertGridFSFile2Resource(GridFSFile gridFsFile) {
        InputStream inputStream = gridFSBucket.openDownloadStream(new ObjectId(gridFsFile.getId().toString()));
        return new GridFsResource(gridFsFile, inputStream);
    }
    @Bean
    public GridFSBucket getGridFSBuckets() {
        MongoDatabase db = mongoDbFactory.getDb();
        return GridFSBuckets.create(db,collectionName);
    }
}
