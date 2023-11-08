package cn.acqz.mybatis.scripting.xmltags;

/**
 * @description SQL 节点
 * @date 2023/5/17
 */
public interface SqlNode {

    boolean apply(DynamicContext context);

}