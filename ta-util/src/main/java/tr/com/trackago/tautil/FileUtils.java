package tr.com.trackago.tautil;

import com.google.common.io.ByteSource;
import org.apache.commons.io.IOUtils;
import tr.com.trackago.tautil.helper.ByteArrayDataSource;
import tr.com.trackago.tautil.helper.InputStreamDataSource;


import java.io.IOException;
import java.io.InputStream;

public class FileUtils extends org.apache.commons.io.FileUtils {

//    public static byte[] dataHandlerToByteArray(DataHandler dataHandler) throws IOException {
//        return (IOUtils.toByteArray(dataHandler.getInputStream()));
//    }
//
//    public static DataHandler byteArrayToDataHandler(byte[] byteArray) throws IOException {
//        InputStream targetStream = ByteSource.wrap(byteArray).openStream();
//        return new DataHandler(new InputStreamDataSource(targetStream));
//    }
//
//    public static DataHandler byteArrayToDataHandlerV2(byte[] byteArray) {
//        ByteArrayDataSource rawData = new ByteArrayDataSource(byteArray);
//        DataHandler dataBelge = new DataHandler(rawData);
//        return dataBelge;
//    }

}
