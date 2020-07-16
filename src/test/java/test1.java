import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dj.ssm.pojo.User;
import com.dj.ssm.pojo.UserTest;

import java.util.*;
import java.util.stream.Collectors;

public class test1 {
    public static void main(String[] args) {
        String str = "{\n" +
                "    \"id\": 1,\n" +
                "    \"userName\": \"zs\",\n" +
                "    \"userPwd\": \"123\"\n" +
                "}";
        /*JSONObject obj= JSONObject.parseObject(str);
        User user = obj.toJavaObject(User.class);
        System.out.println(user.getId()+"-"+user.getUserName()+"-"+user.getUserPwd());*/
        //json字符串格式转java对象
        User user1 = JSONObject.parseObject(str, User.class);
        System.out.println(user1.getId() + "-" + user1.getUserName() + "-" + user1.getUserPwd());
        //java对象转json字符串
        String jsonString = JSONObject.toJSONString(user1);
        System.out.println(jsonString);

        String arr = "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"userName\": \"zs\",\n" +
                "        \"userPwd\": \"123\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"userName\": \"ls\",\n" +
                "        \"userPwd\": \"123\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"userName\": \"ww\",\n" +
                "        \"userPwd\": \"123\"\n" +
                "    }\n" +
                " \n" +
                "]";
        //json数组转 list
        JSONArray array = JSONArray.parseArray(arr);
        List<User> userList = array.toJavaList(User.class);
        /*for (User user:userList) {
            System.out.println(user);
        }*/
        //list 转json数组
        String string = JSONArray.toJSONString(userList);
        System.out.println(string);

        String strTest = "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"userName\": \"zs\",\n" +
                "        \"hobby\": [\n" +
                "            \"篮球\",\n" +
                "            \"足球\"\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"userName\": \"ls\",\n" +
                "        \"hobby\": [\n" +
                "            \"篮球\",\n" +
                "            \"排球\"\n" +
                "        ]\n" +
                "    }\n" +
                "]";
        //json数组转 list
        JSONArray arrayTest = JSONArray.parseArray(strTest);
        List<UserTest> userListTest = arrayTest.toJavaList(UserTest.class);

        for (UserTest userTest : userListTest) {
            System.out.println(userTest);
        }
        //list 转json数组
        String stringTest = JSONArray.toJSONString(userListTest);
        System.out.println(stringTest);

        String strMap = "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"userName\": \"zs\",\n" +
                "        \"hobby\": [\n" +
                "            {\n" +
                "                \"name\": \"足球\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"篮球\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"userName\": \"lisi\",\n" +
                "        \"hobby\": [\n" +
                "            {\n" +
                "                \"name\": \"足球\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"棒球\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]";
        List<Map<String,Object>> listObjectFir = (List<Map<String,Object>>) JSONArray.parse(strMap);
        for(Map<String,Object> mapList : listObjectFir){
            for (Map.Entry entry : mapList.entrySet()){
                System.out.println( entry.getKey()  + "  " +entry.getValue());
            }
        }
        String json1= JSON.toJSONString(listObjectFir);
        System.out.println(json1);

        //str转map<String,List<Object>>
        String mapStr = "{\n" +
                "\"1\":[{\"id\":4}, " +
                "{\"id\":5}],\n" +
                "\"2\":[{\"id\":14}]\n"
                + "}";
        Map<String, List<Object>> result =
                JSONObject.parseObject(mapStr).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> JSONObject.parseArray(String.valueOf(entry.getValue()), Object.class)));

    }
    

}
