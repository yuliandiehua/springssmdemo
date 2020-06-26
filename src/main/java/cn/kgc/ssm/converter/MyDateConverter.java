package cn.kgc.ssm.converter;
import com.mysql.jdbc.StringUtils;
import org.springframework.core.convert.converter.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 日期类型格式转换
 */
public class MyDateConverter implements Converter<String,Date> {
    private SimpleDateFormat[] formats=new SimpleDateFormat[]{
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyy/MM/dd"),
            new SimpleDateFormat("yyyy年MM月dd日"),
    };
    @Override
    public Date convert(String s) {
        //通过StringUtils判断传参是否为空
        if(StringUtils.isNullOrEmpty(s)){
            //将日期格式循环遍历，按照匹配类型输出
            for (SimpleDateFormat format:formats){
                try {
                    return format.parse(s);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
