package info.honzan.tool.har2xsv;

import de.sstoehr.harreader.HarReader;
import de.sstoehr.harreader.HarReaderException;
import de.sstoehr.harreader.model.Har;
import de.sstoehr.harreader.model.HarEntry;
import de.sstoehr.harreader.model.HarHeader;
import java.io.File;
import java.util.List;

public class Har2Xsv implements HarConvertor {

  private String inputPath;
  private String separator;
  private boolean writeHeader;

  public Har2Xsv(String path, String separator, boolean writeHeader) {
    this.inputPath = path;
    this.separator = separator;
    this.writeHeader = writeHeader;
  }

  @Override
  public void write() throws HarReaderException {

    HarReader harReader = new HarReader();
    Har har = harReader.readFromFile(new File(inputPath));
    List<HarEntry> harEntries = har.getLog().getEntries();

    if (writeHeader) {
      writeHeader();
    }

    for (HarEntry entry : harEntries) {
      writeBody(entry);
    }
  }

  private void writeHeader() {

    // Header
    System.out.println(
        "startedDateTime" + separator
            + "requestUrl" + separator
            + "requestMethod" + separator
            + "requestHttpVersion" + separator
            + "responseStatus" + separator
            + "responseStatusText" + separator
            + "resourceType" + separator

            + "requestHeaderSize" + separator
            + "requestHeaders_Host" + separator
            + "requestHeaders_User-Agent" + separator
            + "requestHeaders_Accept" + separator
            + "requestHeaders_Accept-Language" + separator
            + "requestHeaders_Accept-Encoding" + separator
            + "requestHeaders_Cache-Control" + separator
            + "requestHeaders_If-Modified-Since" + separator
            + "requestHeaders_If-None-Match" + separator
            + "requestHeaders_Connection" + separator
            + "requestHeaders_Cookie" + separator

            + "requestBodySize" + separator

            + "responseContentSize" + separator
            + "responseContentType" + separator

            + "responseHeaders_Content-Encoding" + separator
            + "responseHeaders_Content-Length" + separator
            + "responseHeaders_Content-Type" + separator
            + "responseHeaders_Date" + separator
            + "responseHeaders_Cache-Control" + separator
            + "responseHeaders_ETag" + separator
            + "responseHeaders_Last-Modified" + separator
            + "responseHeaders_Expires" + separator
            + "responseHeaders_Vary" + separator
            + "responseHeaders_Set-Cookie" + separator
            + "responseHeaders_Server" + separator

            + "time" + separator
            + "timingsBlocked" + separator
            + "timingsDns" + separator
            + "timingsSsl" + separator
            + "timingsConnect" + separator
            + "timingsSend" + separator
            + "timingsWait" + separator
            + "timingsReceive" + separator
            + "timings_blocked_queueing");

  }

  private void writeBody(HarEntry entry) {

    HarHeader empty = new HarHeader();
    empty.setValue("");

    // @formatter:off
    // Body
    System.out.println(
        dateFormat.format(entry.getStartedDateTime()) + separator +
            entry.getRequest().getUrl() + separator +
            entry.getRequest().getMethod() + separator +
            entry.getRequest().getHttpVersion() + separator +
            entry.getResponse().getStatus() + separator +
            entry.getResponse().getStatusText() + separator +
            entry.getAdditional().get("_resourceType") + separator +

            entry.getRequest().getHeadersSize() + separator +
            entry.getRequest().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("Host")).findFirst().orElse(empty).getValue() + separator +
            entry.getRequest().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("User-Agent")).findFirst().orElse(empty).getValue() + separator +
            entry.getRequest().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("Accept")).findFirst().orElse(empty).getValue() + separator +
            entry.getRequest().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("Accept-Language")).findFirst().orElse(empty).getValue() + separator +
            entry.getRequest().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("Accept-Encoding")).findFirst().orElse(empty).getValue() + separator +
            entry.getRequest().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("Cache-Control")).findFirst().orElse(empty).getValue() + separator +
            entry.getRequest().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("If-Modified-Since")).findFirst().orElse(empty).getValue() + separator +
            entry.getRequest().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("If-None-Match")).findFirst().orElse(empty).getValue() + separator +
            entry.getRequest().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("Connection")).findFirst().orElse(empty).getValue() + separator +
            entry.getRequest().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("Cookie")).findFirst().orElse(empty).getValue() + separator +

            entry.getRequest().getBodySize() + separator +

            entry.getResponse().getContent().getSize() + separator +
            entry.getResponse().getContent().getMimeType() + separator +

            entry.getResponse().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("Content-Encoding")).findFirst().orElse(empty).getValue() + separator +
            entry.getResponse().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("Content-Length")).findFirst().orElse(empty).getValue() + separator +
            entry.getResponse().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("Content-Type")).findFirst().orElse(empty).getValue() + separator +
            entry.getResponse().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("Date")).findFirst().orElse(empty).getValue() + separator +
            entry.getResponse().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("Cache-Control")).findFirst().orElse(empty).getValue() + separator +
            entry.getResponse().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("ETag")).findFirst().orElse(empty).getValue() + separator +
            entry.getResponse().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("Last-Modified")).findFirst().orElse(empty).getValue() + separator +
            entry.getResponse().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("Expires")).findFirst().orElse(empty).getValue() + separator +
            entry.getResponse().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("Vary")).findFirst().orElse(empty).getValue() + separator +
            entry.getResponse().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("Set-Cookie")).findFirst().orElse(empty).getValue() + separator +
            entry.getResponse().getHeaders().stream().filter(s -> s.getName().equalsIgnoreCase("Server")).findFirst().orElse(empty).getValue() + separator +

            entry.getTime() + separator +
            entry.getTimings().getBlocked() + separator +
            entry.getTimings().getDns() + separator +
            entry.getTimings().getSsl() + separator +
            entry.getTimings().getConnect() + separator +
            entry.getTimings().getSend() + separator +
            entry.getTimings().getWait() + separator +
            entry.getTimings().getReceive() + separator +
            entry.getTimings().getAdditional().get("_blocked_queueing") + separator
    );
    // @formatter:on

  }
}

