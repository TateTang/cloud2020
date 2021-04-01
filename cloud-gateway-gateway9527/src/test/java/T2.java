import java.time.ZonedDateTime;

/**
 * @Author tangmf
 * @Date 2021/3/30 9:00 下午
 * @Description
 */
public class T2 {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();//默认时区
        System.out.println(zonedDateTime);
        //2021-03-30T21:01:17.441+08:00[Asia/Shanghai]
    }
}
