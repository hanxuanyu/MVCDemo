package test.utils;

import com.hxuanyu.commodity.utils.CommonUtils;
import org.junit.Test;

import java.util.Date;

/**
 * TODO
 *
 * @author hanxuanyu
 * @version 1.0
 */
public class testCommonUtils {
    @Test
    public void testGetDateFromString() {

        String dateString = "2021-01-01 00:00:00";
        Date date = CommonUtils.getDateFromString(dateString);
        System.out.println(date);

    }
}
