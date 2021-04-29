package ${basePackage}.service.${datasourceName}.impl;

import ${basePackage}.mapper.${datasourceName}.${modelNameUpperCamel}Mapper;
import ${basePackage}.model.${datasourceName}.${modelNameUpperCamel};
import ${basePackage}.service.${datasourceName}.${modelNameUpperCamel}Service;
import ${basePackage}.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @Description:
 * @Author: XXX
 * @Date: ${date}
 */
@Service
public class ${modelNameUpperCamel}ServiceImpl extends AbstractService<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {
    @Resource
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

}
