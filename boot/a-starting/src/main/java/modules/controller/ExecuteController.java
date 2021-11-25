package modules.controller;

import modules.ossutil.OssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 本地测试接口
 * http://localhost:8089/szymou/execute/deleteOss?objectPath=test/&objectKey=
 */

@RestController
@RequestMapping("execute")
public class ExecuteController {

    @Autowired
    private OssUtil ossUtil;

    @GetMapping("uploadOss")
    public void upload(String objectPath, String objectKey){
        ossUtil.uploadSomethings(objectPath, objectKey);
    }

    @GetMapping("downloadOss")
    public void downloadOss(String objectPath, String objectKey){
        ossUtil.downloadSomethings(objectPath, objectKey);
    }

    @GetMapping("deleteOss")
    public void deleteOss(String objectPath, String objectKey){
        ossUtil.deleteSomethings(objectPath, objectKey);
    }

    @GetMapping("queryOss")
    public void queryOss(){
        ossUtil.querySomethings();
    }


}
