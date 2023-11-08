package cn.acqz.mybatis.scripting.xmltags;

/**
 * @description 静态文本SQL节点
 * @date 2023/5/17
 */
public class StaticTextSqlNode implements SqlNode{

    private String text;

    public StaticTextSqlNode(String text) {
        this.text = text;
    }

    @Override
    public boolean apply(DynamicContext context) {
        //将文本加入context
        context.appendSql(text);
        return true;
    }

}
