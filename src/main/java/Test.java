import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by PiroACC on 2015-11-28.
 */
public class Test {

    public static void main(String... args) {
        String dateAsString = "2015-12-01T21:45:23.000+0100";
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            String reformattedStr = myFormat.format(fromUser.parse(dateAsString));
            System.out.println(reformattedStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
