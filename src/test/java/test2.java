import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dj.ssm.pojo.User;
import com.dj.ssm.pojo.UserTest;
import org.apache.taglibs.standard.extra.spath.Step;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class test2 {
    public static void main(String[] args) {
        /*String str = "{\"userName\":\"q\",\"userPwd\":\"123\"}";
        User user = JSONObject.parseObject(str, User.class);
        System.out.println(user);
        String s = JSONObject.toJSONString(user);
        System.out.println(s);*/


        /*String str = "[{\"userName\":\"qa\",\"userPwd\":\"123\"},{\"userName\":\"qb\",\"userPwd\":\"123\"},{\"userName\":\"qc\",\"userPwd\":\"123\"},{\"userName\":\"qw\",\"userPwd\":\"123\"}]";
        JSONArray array = JSONArray.parseArray(str);
        List<User> userList = array.toJavaList(User.class);
        for (User user:userList) {
            System.out.println(user);
        }*/

        /*String str = "{\"userList\":[{\"userName\":\"qa\",\"userPwd\":\"123\"},{\"userName\":\"qb\",\"userPwd\":\"123\"}],\"money\" : \"120\"}";
        UserTest user = JSONObject.parseObject(str, UserTest.class);
        System.out.println(user);*/

        String str = "[{\"userList\":[{\"userName\":\"qa\",\"userPwd\":\"123\"},{\"userName\":\"qb\",\"userPwd\":\"123\"}],\"money\" : \"120\"},{\"userName\":\"qa\",\"userPwd\":\"123\"},{\"userName\":\"qb\",\"userPwd\":\"123\"}]";
        List<UserTest> userTests = JSONArray.parseArray(str, UserTest.class);
        for (UserTest user:userTests) {
            System.out.println(user);
        }

        //String转Map
        String jsonMessage = "{\"Chinese\":\"88\",\"Math\":\"78\",\"English\":\"99\"}";
        Map m = (Map) JSONObject.parseObject(jsonMessage);
        System.out.println("Chinese:" + m.get("Chinese"));
        System.out.println("Math:" + m.get("Math"));
        System.out.println("English:" + m.get("English"));

        System.out.println("-------------------------------------------------------");

        //JSON数组形式字符串转换为List<Map<String,String>>
        String strArr = "[{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}," +
                "{\"00\":\"zhangsan\",\"11\":\"lisi\",\"22\":\"wangwu\",\"33\":\"maliu\"}]";
        List<Map<String,String>> listObjectFir = (List<Map<String,String>>) JSONArray.parse(strArr);
        //利用JSONArray中的parse方法来解析json数组字符串
        for(Map<String,String> mapList : listObjectFir){
            for (Map.Entry entry : mapList.entrySet()){
                System.out.println( entry.getKey()  + "  " +entry.getValue());
            }
        }


    }
}
