package tr.com.trackago.tautil.constant;

/**
 * Sisteme ait icerik turlerinin bulundugu siniftir.
 *
 * @author arifaydogan
 */
public enum CoreContentType {

    /**
     * CSV
     */
    csv("text/csv"),
    /**
     * PDF
     */
    pdf("application/pdf"),
    /**
     * DOC
     */
    doc("application/msword"),
    /**
     * DOCX
     */
    docx("application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
    /**
     * Excel
     */
    xls("application/vnd.ms-excel"),
    /**
     * Excel
     */
    xlsx("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
    /**
     * Octet Stream
     */
    opc("application/octet-stream"),
    /**
     * eyp Stream
     */
    eyp("application/octet-stream"),
    /**
     * MP3
     */
    mp3("audio/mpeg"),
    /**
     * MP$
     */
    mp4("video/mp4"),
    /**
     * WAV
     */
    wav("audio/x-wav"),
    /**
     * XML
     */
    xml("application/xml"),
    /**
     * ZIP
     */
    zip("application/zip"),
    /**
     * TAR
     */
    tar("application/x-tar"),
    /**
     * TAR.GZ
     */
    targz("application/tar+gzip"),
    /**
     * Text
     */
    txt("text/plain"),
    /**
     * JPG
     */
    jpg("image/jpg"),
    /**
     * JPEG
     */
    jpeg("image/jpeg"),
    /**
     * HTML
     */
    html("html"),
    /**
     * PNG
     */
    png("image/png"),
    /**
     * TIFF
     */
    tiff("image/tiff");

    private String contentType;

    CoreContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    public static CoreContentType getFileType(String fileType) {
        CoreContentType[] values = values();
        for (CoreContentType enumFileType : values) {
            if (fileType.equals(enumFileType.toString())) {
                return enumFileType;
            }
        }
        return null;
    }

    public static CoreContentType lookupByContentType(final String value) {
        CoreContentType[] values = CoreContentType.values();
        for (CoreContentType choice : values) {
            if (choice.getContentType().equals(value)) {
                return choice;
            }
        }
        throw new IllegalArgumentException(
                "Value : " + value + " can not be mapped to any EnumFileType value.");
    }

    public static boolean isCSV(CoreContentType contentType) {
        return contentType.equals(CoreContentType.csv);
    }

    public static boolean isXLSX(CoreContentType contentType) {
        return contentType.equals(CoreContentType.xlsx) || contentType.equals(CoreContentType.xls);
    }

    public static boolean isPDF(CoreContentType contentType) {
        return contentType.equals(CoreContentType.pdf);
    }

    public static boolean isHTML(CoreContentType contentType) {
        return contentType.equals(CoreContentType.html);
    }


}