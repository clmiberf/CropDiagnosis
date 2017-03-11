package com.example.developer.cropdiagnosis.shared;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by clmiberf on 2017/3/9.
 */

public class GetUrlImageHelper {
    public InputStream getUrlImage(String url) throws IOException {
        URL myurl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) myurl.openConnection();
        connection.setConnectTimeout(6000);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        InputStream is = connection.getInputStream();
        return is;
    }

}
