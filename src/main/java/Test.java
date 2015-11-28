import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by PiroACC on 2015-11-28.
 */
public class Test {

    public static void main(String ... args){
        String dateAsString= "2015-11-28T17:20:05.977+0100";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date date = new Date();
        try {
            date = dateFormat.parse(dateAsString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date.toString());
    }
}
