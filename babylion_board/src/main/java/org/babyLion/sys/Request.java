package org.babyLion.sys;


import java.util.Map;

public class Request {

     private UriParser uriParser;
     protected Map<String, Object> parameters;


    public Request(String uri) {
        this.uriParser = new UriParser(uri);
        this.parameters = this.uriParser.getParameters();
    }

    public boolean isValidUri() {
        return uriParser.isValidUri();
    }

    public <T> T getValue(String key, Class<T> cls) {

        Object object = parameters.get(key);

        try {
            if ( cls == Integer.class ) {
                return cls.cast(Integer.parseInt(object.toString()));
            } else if ( cls == Long.class ) {
                return cls.cast(Long.parseLong(object.toString()));
            }  else if ( cls == Boolean.class ) {
                return cls.cast(Boolean.parseBoolean(object.toString()));
            }
        } catch ( Exception e ) {
            return null;
        }

        return cls.cast(object);

    }



}
