package fi.antientropy.sideshow.rest;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class Digest {

    @Test
    public void test() {
        String token = "secret";
        System.out.println(DigestUtils.sha512Hex(token));
    }

}
