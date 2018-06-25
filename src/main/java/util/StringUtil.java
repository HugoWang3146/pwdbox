package util;

public class StringUtil {
    public static String convertDotName2CamelName(String dotName) {
        char[] chars = dotName.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                i++;
                sb.append(Character.toUpperCase(chars[i]));
                continue;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static String convertCamelName2DotName(String camelName){
        char[] chars=camelName.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<chars.length;i++){
            if(Character.isUpperCase(chars[i])){
                sb.append('.');
                sb.append(Character.toLowerCase(chars[i]));
                continue;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
