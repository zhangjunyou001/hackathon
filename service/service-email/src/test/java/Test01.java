import org.junit.Test;

import java.util.UUID;

/**
 * @Author: GengKY
 * @Date: 2021/9/30 14:04
 */
public class Test01 {

    @Test
    public void test01(){
        String code= UUID.randomUUID().toString().replaceAll("-","").substring(0,6);
        System.out.println(code);
    }

    @Test
    public void test02(){

        String content= String.format("来自%s的通知:%s","1","2");
        System.out.println(content);

    }

}
