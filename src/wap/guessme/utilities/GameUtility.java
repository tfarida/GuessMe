package wap.guessme.utilities;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 */

/**
 * @author romiezaw
 *
 */
public class GameUtility {
	
	public static String getPresentTime() {
		LocalDateTime datetime1 = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTime = datetime1.format(format);
		System.out.println(datetime1);
		System.out.println(formatDateTime);
		return formatDateTime;
	}

	
}