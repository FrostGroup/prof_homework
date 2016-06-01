package week3.aliexpres.service;


import week3.aliexpres.model.Phone;

import java.io.IOException;

public interface AliService {

    public Phone getInfo(String url) throws IOException;


}
