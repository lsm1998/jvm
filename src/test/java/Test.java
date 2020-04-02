import com.lsm1998.jvm.test.Hello;
import com.lsm1998.jvm.utils.FileUtil;

import java.util.Arrays;

/**
 * @program: jvm
 * @description:
 * @author: lsm
 * @create: 2020-03-24 14:11
 **/
public class Test {
    public static void main(String[] args) {
        Class<Hello> helloClass = Hello.class;
        // System.out.println(helloClass.getName().replace('.','/'));
        System.out.println(Arrays.toString(FileUtil.getBytesByClass(helloClass)));
    }
}
