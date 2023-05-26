package ro.pao.application.csv;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.LogRecord;

public class CsvFormatter {

    private static CsvFormatter INSTANCE;
    private static final CsvWriter CSV_WRITER = CsvWriter.getInstance();
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private CsvFormatter() {

    }
    public static CsvFormatter getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new CsvFormatter();

        }

        return INSTANCE;
    }

    public String[] format(LogRecord record) {

        String timestamp = DATE_FORMAT.format(new Date(record.getMillis()));
        String message = record.getMessage();

        return new String[]{timestamp, message};
    }

}