package xyz.cchili.springcloud;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/19 22:02
 */
public class ZoneDateTimeDemo {

    @Test
    public void demo() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);

        //2020-06-19T22:03:30.388+08:00[Asia/Shanghai]
    }
}
