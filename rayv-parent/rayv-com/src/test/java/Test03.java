import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test03 {
    public static void main(String[] args) {
        String str1 = "Q00000012345";
        String str2 = "我吃西瓜我吃西瓜我吃西瓜";
        String str3 = str1.substring(1, 12);

        System.out.println(isNumeric(str1));
        System.out.println(isNumeric(str2));
        System.out.println(isNumeric(str3));
        System.out.println(StringUtils.isNumeric(str3));
        System.out.println(StringUtils.isNumeric(str1));
    }
    /**
     * 利用正则表达式判断字符串是否是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

}
