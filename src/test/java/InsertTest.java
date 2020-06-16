import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

/**
 * @author lj
 * @time 2020/5/31
 */
public class InsertTest {
   @Test
  public void Test() throws ParseException {
       UUID uuid=UUID.randomUUID();
       String sacc = uuid.toString().substring(0, 5);
       UUID uuid1=UUID.randomUUID();
       String sname = uuid1.toString().substring(0, 3);
       String roles="普通用户";
       Date date=new Date();
       System.out.println(date);
       LocalDateTime dateTime = LocalDateTime.now();
       String Currformat = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
       
   }
   
   
}
