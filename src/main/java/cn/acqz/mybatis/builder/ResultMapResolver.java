package cn.acqz.mybatis.builder;

import cn.acqz.mybatis.mapping.ResultMap;
import cn.acqz.mybatis.mapping.ResultMapping;

import java.util.List;

/**
 * @description 结果映射解析器
 * @date 2023/6/19
 */
public class ResultMapResolver {

    private final MapperBuilderAssistant assistant;
    private String id;
    private Class<?> type;
    private List<ResultMapping> resultMappings;

    public ResultMapResolver(MapperBuilderAssistant assistant, String id, Class<?> type, List<ResultMapping> resultMappings) {
        this.assistant = assistant;
        this.id = id;
        this.type = type;
        this.resultMappings = resultMappings;
    }

    public ResultMap resolve() {
        return assistant.addResultMap(this.id, this.type, this.resultMappings);
    }

}
