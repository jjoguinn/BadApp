/**
 * 
 */
package com.fedex.broken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;

/**
 * @author 436498
 *
 */
public class CreateBigRequest {
    private String fileNmStr;

    /**
     * 
     */
    public CreateBigRequest(String fileNm) {

        this.fileNmStr = fileNm;

    }

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        CreateBigRequest cbr = new CreateBigRequest(args[0]);

        cbr.genReq(cbr.getFileBytes());
    }

    /**
     * @return
     * @throws IOException 
     */
    private byte[] getFileBytes() throws IOException {

        Path path = Paths.get(fileNmStr);
        byte[] data = Files.readAllBytes(path);

        return data;
    }

    /**
     * @param bs 
     * @throws IOException 
     * 
     */
    private void genReq(byte[] bs) throws IOException {
        TestRequest tr = new TestRequest();

        tr.setName("test1");
        tr.setContent(bs);

        Writer writer = new FileWriter("test/TestReq.json");

        Gson gson = new Gson();
        gson.toJson(tr, writer);

        writer.close();
    }

}
