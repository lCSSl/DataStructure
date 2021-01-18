package work.kaiyu.datastructure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Assert {
    public static void test(boolean value) {
        try {
            if (!value) {
                log.error("测试不通过");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
