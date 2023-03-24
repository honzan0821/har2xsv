# Har2Csv

> Convert HTTP session HAR file logs into XSV(CSV, TSV,etc) format

This CLI tool provides you with an easy way to
convert [HAR file](http://www.softwareishard.com/blog/har-12-spec/) HTTP log entries into a flat
CSV, TSV format to make it easier to analyze.
This tool ignores fields that are not essential for analyzing requests/responses such as content.

**Current version(0.x.x) only supports TSV format.**

## Usage

### Install and run

**Requires Java 1.8.x or above**

```
# Install

./gradlew shadowJar

# Run

java -jar ./build/libs/har2xsv-{version}-all.jar path/to/input.har > path/to/output.tsv
```

### Generating a HAR file from a browser session

Example using Chrome:

1. Open Google Chrome and press the F12 button on your keyboard
2. Select "Network" tab
3. Click the "Preserve log" checkbox to enable
4. Reproduce the event by accessing the URL where the problem is occurring
5. Click the circle button of "Stop recording network log"
6. Right-click anywhere within the displayed log data frame
7. Click "Save as HAR with content"
8. Enter any name and save the file in HAR format

## Extracted log entry fields

| Entry path                              | TSV column name                  |
|-----------------------------------------|----------------------------------|
| startedDateTime                         | startedDateTime                  |
| request.url                             | requestUrl                       |
| request.method                          | requestMethod                    |
| request.httpVersion                     | requestHttpVersion               |
| response.status                         | responseStatus                   |
| response.statusText                     | responseStatusText               |
| response.statusText                     | responseStatusText               |
| _resourceType                           | resourceType                     |
| request.headerSize                      | requestHeaderSize                |
| request.headers.name['Host']            | requestHeaders_Host              |
| request.headers.name['User-Agent']      | requestHeaders_User-Agent        |
| request.headers.name['Accept']          | requestHeaders_Accept            |
| request.headers.name['Accept-Language'] | requestHeaders_Accept-Language   |
| request.headers.name['Accept-Encoding'] | requestHeaders_Accept-Encoding   |
| request.headers.name['Cache-Control ']  | requestHeaders_Cache-Control     |
| request.headers.name['If-Modified-Since'] | requestHeaders_If-Modified-Since |
| request.headers.name['If-None-Match']   | requestHeaders_If-None-Match     |
| request.headers.name['Connection']      | requestHeaders_Connection        |
| request.headers.name['Cookie']          | requestHeaders_Cookie |
| request.bodySize                        | requestBodySize      |
| response.content.size                   | responseContentSize  |
| response.content.mimeType                   | responseContentType  |
| response.headers.name['content-type'] | responseHeaders_Content-Encoding  |
| response.headers.name['content-length'] | responseHeaders_Content-Length  |
| response.headers.name['Content-Type '] | responseHeaders_Content-Type |
| response.headers.name['Date'] | responseHeaders_Date |
| response.headers.name['cache-control'] | responseHeaders_Cache-Control |
| response.headers.name['ETag']  | responseHeaders_ETag |
| response.headers.name['Last-Modified '] | responseHeaders_Last-Modified |
| response.headers.name['Expires'] | responseHeaders_Expires |
| response.headers.name['Vary']  | responseHeaders_Vary|
| response.headers.name['Set-Cookie'] | responseHeaders_Set-Cookie |
| response.headers.name['Server'] | responseHeaders_Server|
| time  | time                 |
| timings.blocked  | timingsBlocked              |
| timings.dns  | timingsDns                  |
| timings.ssl  | "timingsSsl"                  |
| timings.connect  | timingsConnect              |
| timings.send  | timingsSend                 |
| timings.wait  | timingsWait                 |
| timings.receive  | timingsReceive              |
| timings._blocked_queueing  | timings_blocked_queueing              |

**Note: Entries that don't match the above fields / paths are not included in the result CSV file**

## WIP

- Refactoring
- Support CSV etc format
- Add flag for not output header mode
- Add flag for select columns from the result

## License

[MIT](LICENSE)
