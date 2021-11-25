package modules.ossutil;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * 阿里云学习文档
 * https://helpcdn.aliyun.com/document_detail/32007.html
 */

@Component
public class OssUtil {

    static Logger logger = LoggerFactory.getLogger(OssUtil.class);

    @Value("${aliyun.AccessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.AccessKeySecret}")
    private String accessKeySecret;

    @Value("${aliyun.endpoint}")
    private String endpoint;

    @Value("${aliyun.bucketName}")
    private String bucketName;

    /**
     *
     * 上传文件
     * @param objectPath 目录
     * @param objectKey  文件对象名
     */
    public void uploadSomethings(String objectPath, String objectKey){
        OSS ossClient = checkBucketExist();

        File file = new File("E:\\ItemsOfSelf\\测试oss文件上传.txt");
        ossClient.putObject(bucketName, objectPath + objectKey, file);

        ossClient.shutdown();
        logger.info("上传文件over");

    }

    /**
     * 下载文件
     * @param objectPath 目录
     * @param objectKey  文件对象名
     */
    public void downloadSomethings(String objectPath, String objectKey){
        OSS ossClient = checkBucketExist();

        File file = new File("E:\\ItemsOfSelf\\test.txt");
        ossClient.getObject(new GetObjectRequest(bucketName, "test"), file);

        ossClient.shutdown();
        logger.info("下载文件over");
    }

    /**
     * 删除文件
     * @param objectPath 目录
     * @param objectKey  文件对象名
     */
    public void deleteSomethings(String objectPath, String objectKey){
        OSS ossClient = checkBucketExist();

        String object = objectPath + objectKey;
        logger.info("删除oss文件：{}", object);
        ossClient.deleteObject(bucketName, object);

        ossClient.shutdown();
        logger.info("删除文件over");
    }


    /**
     * 查看bucket中有什么object
     */
    public void querySomethings(){
        OSS ossClient = checkBucketExist();

        ObjectListing objectListing = ossClient.listObjects(bucketName);
        List<OSSObjectSummary> ossObjectSummaries = objectListing.getObjectSummaries();
        System.out.println(bucketName + "有以下objext");
        for (OSSObjectSummary ossObjectSummary : ossObjectSummaries) {
            System.out.println("\t" + ossObjectSummary.getKey());
        }

        ossClient.shutdown();
        logger.info("查询对象over");
    }





    /********************************************函数****************************************************/



    /**
     * 检查bucket是否存在，不存在则创建
     */
    private OSS checkBucketExist() {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        if (ossClient.doesBucketExist(bucketName)){
            logger.info("已存在{}", bucketName);
        }else {
            logger.info("未存在{}", bucketName);
            ossClient.createBucket(bucketName);
        }

//        BucketInfo info = ossClient.getBucketInfo(bucketName);
//        logger.info("bucketName信息：{}", JSONObject.toJSONString(info));

        return ossClient;
    }


}
