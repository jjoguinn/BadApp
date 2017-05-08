/**
 * 
 */
package com.fedex.broken;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 436498
 *
 */
public class BadPojo {
    private static Map theRequestStore;
    private DateFormat df = new SimpleDateFormat("yyyyMMdd_kk:mm:ss:S");
    private int nbrOfCopies = 1;

    /**
     * 
     */
    public BadPojo() {
        super();

        theRequestStore = new HashMap<>();
    }

    /**
     * @param theReq
     */
    public void storeTheRequest(MultipartFile theReq) {
        
        for (int i = 0; i < nbrOfCopies; i++) {
            theRequestStore.put(genKey(theReq), theReq);
        }
    }

    /**
     * @param theReq 
     * @return
     */
    private String genKey(MultipartFile theReq) {
        String theKey;
        Date currentDate = new Date();
        Integer rand = (int) (Math.random() * 1000d);
        
        theKey = theReq.getOriginalFilename() + "_" + df.format(currentDate)
                + "_" + rand;

        return theKey;
    }

    /**
     * @param reqContents
     */
    public synchronized void setNbrCopies(Integer reqContents) {
        nbrOfCopies = reqContents;

    }

    /**
     * @return
     */
    public Collection listFiles() {
        // TODO Auto-generated method stub
        return theRequestStore.keySet();
    }

}
