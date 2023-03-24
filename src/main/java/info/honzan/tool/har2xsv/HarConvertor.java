package info.honzan.tool.har2xsv;

import de.sstoehr.harreader.HarReaderException;
import java.text.SimpleDateFormat;

interface HarConvertor {

  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

  void write() throws HarReaderException;

}

