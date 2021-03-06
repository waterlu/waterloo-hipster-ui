package cn.lu.hipster.api;

import cn.lu.hipster.consts.ProjectType;
import cn.lu.hipster.model.GeneratorParam;
import cn.lu.hipster.service.ProjectGenerator;
import cn.lu.web.mvc.ResponseCode;
import cn.lu.web.mvc.SimpleResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目生成接口
 *
 * @author lutiehua
 * @date 2017/9/22
 */
@RestController
@RequestMapping("/api/project")
public class ProjectController extends BaseController {

    @Autowired
    @Qualifier("springBootProjectGenerator")
    private ProjectGenerator springBootProjectGenerator;

    @Autowired
    @Qualifier("springCloudProjectGenerator")
    private ProjectGenerator springCloudProjectGenerator;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public SimpleResponseData generate(@RequestBody @Validated GeneratorParam generatorParam) throws Exception {

        if (generatorParam.getTables().size() == 0) {
            int errorCode = ResponseCode.PARAM_ERROR.code;
            String errorMessage = "待生成列表不能为空，请添加数据库表到待生成列表!";
            return new SimpleResponseData(errorMessage);
        }

        String projectType = generatorParam.getProjectInfo().getProjectType();
        if (ProjectType.PROJECT_TYPE_BOOT.equalsIgnoreCase(projectType)) {
            // 生成SpringBoot项目
            String message = springBootProjectGenerator.generateProject(generatorParam);
            SimpleResponseData responseData = new SimpleResponseData(message);
            return responseData;
        } else if (ProjectType.PROJECT_TYPE_CLOUD.equalsIgnoreCase(projectType)) {
            // 生成SpringCloud项目
            String message = springCloudProjectGenerator.generateProject(generatorParam);
            SimpleResponseData responseData = new SimpleResponseData(message);
            return responseData;
        } else {
            // 不支持的类型
            int errorCode = ResponseCode.PARAM_ERROR.code;
            String errorMessage = String.format("unknown projectType [%s]", projectType);
            return new SimpleResponseData(errorMessage);
        }
    }
}