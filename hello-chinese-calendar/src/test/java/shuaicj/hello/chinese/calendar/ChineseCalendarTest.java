package shuaicj.hello.chinese.calendar;

import net.time4j.PlainDate;
import net.time4j.calendar.ChineseCalendar;
import net.time4j.calendar.CommonElements;
import net.time4j.calendar.EastAsianMonth;
import net.time4j.calendar.EastAsianYear;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test {@link ChineseCalendar}.
 *
 * @author shuaicj 2019/08/30
 */
public class ChineseCalendarTest {

    /**
     * Lunar 2019-01-01  =>  Solar 2019-02-05.
     */
    @Test
    public void fromChineseNewYearToSolar() {
        ChineseCalendar cc = ChineseCalendar.ofNewYear(2019);
        PlainDate pd = cc.transform(PlainDate.axis());
        assertThat(pd.getYear()).isEqualTo(2019);
        assertThat(pd.getMonth()).isEqualTo(2);
        assertThat(pd.getDayOfMonth()).isEqualTo(5);
    }

    /**
     * Solar 2019-02-05  =>  Lunar 2019-01-01.
     */
    @Test
    public void fromSolarToChineseNewYear() {
        PlainDate pd = PlainDate.of(2019, 2, 5);
        ChineseCalendar cc = pd.transform(ChineseCalendar.axis());
        assertThat(cc.getInt(CommonElements.RELATED_GREGORIAN_YEAR)).isEqualTo(2019);
        assertThat(cc.getInt(ChineseCalendar.MONTH_AS_ORDINAL)).isEqualTo(1);
        assertThat(cc.getInt(ChineseCalendar.DAY_OF_MONTH)).isEqualTo(1);
    }

    /**
     * Lunar 2019-08-15  =>  Solar 2019-09-13.
     */
    @Test
    public void fromChineseMidAutumnToSolar() {
        ChineseCalendar cc = ChineseCalendar.of(EastAsianYear.forGregorian(2019), EastAsianMonth.valueOf(8), 15);
        PlainDate pd = cc.transform(PlainDate.axis());
        assertThat(pd.getYear()).isEqualTo(2019);
        assertThat(pd.getMonth()).isEqualTo(9);
        assertThat(pd.getDayOfMonth()).isEqualTo(13);
    }

    /**
     * Solar 2019-09-13  =>  Lunar 2019-08-15.
     */
    @Test
    public void fromSolarToChineseMidAutumn() {
        PlainDate pd = PlainDate.of(2019, 9, 13);
        ChineseCalendar cc = pd.transform(ChineseCalendar.axis());
        assertThat(cc.getInt(CommonElements.RELATED_GREGORIAN_YEAR)).isEqualTo(2019);
        assertThat(cc.getInt(ChineseCalendar.MONTH_AS_ORDINAL)).isEqualTo(8);
        assertThat(cc.getInt(ChineseCalendar.DAY_OF_MONTH)).isEqualTo(15);
    }
}
