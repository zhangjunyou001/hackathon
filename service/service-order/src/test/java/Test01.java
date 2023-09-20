import org.junit.Test;

import java.util.UUID;

/**
 * @Author: GengKY
 * @Date: 2021/9/25 18:21
 */

public class Test01 {

    @Test
    public void testUUID(){

        for (int i = 0; i <10 ; i++) {
            String substring = UUID.randomUUID().toString().replaceAll("-","").substring(0, 16);
            System.out.println(substring);
        }
    }

}
