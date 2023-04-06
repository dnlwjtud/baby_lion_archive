package org.babyLion.sys;

import java.util.HashMap;
import java.util.Map;

public class UriParser {
    /*
    @ 본 프로젝트에서 기대되는 URL 입력 형태

    1. /controller/target -> 파라미터가 없는 형태의  URL
    2. /controller/target?param=1 -> 단일 파라미터가 있는 URL
    3. /controller/target?param1=val1&param2=val2 -> 복합 파라미터가 있는 URL
     */
    private final String URI;

    private String controllerCode;
    private String targetMethod;

    private boolean isValidUri = true;

    private Map<String, Object> parameters = new HashMap<>();


    public UriParser(String URI) {
         this.URI = parse(URI);
    }

    protected String parse(String uri) {

        // '/' articles/update
        if ( !uri.startsWith("/") ) {
            this.isValidUri = false;
            return uri;
        }

        String[] uriSplit = uri.split("\\?", 2);

        // /articles/update '?' key1=val1&...
        if ( uriSplit.length == 2 ) {
            setParameters(uriSplit[1]);
        }

        // /Controller/target
        // /articles/update
        String[] uriFront = uriSplit[0].split("/");
        // [ "", articles, update ]

        if ( uriFront.length != 3 ) {
            this.isValidUri = false;
            return uri;
        }

        // [ "", articles, update ]
        this.controllerCode = uriFront[1];
        this.targetMethod = uriFront[2];

        return uri;
    }

    protected void setParameters(String uriPart) {

        try {

            if ( uriPart.contains("&") ) {

                String[] uriPartSplit = uriPart.split("&");

                for (String param : uriPartSplit) {
                    String[] parameterData = param.split("=", 2);

                    if ( parameterData[1].equals("") ||  parameterData[0].equals("")) {
                        throw new IllegalArgumentException("Invalid parameter value is input");
                    }

                    parameters.put(parameterData[0], parameterData[1]);
                }

            } else {
                String[] split = uriPart.split("=", 2);

                if ( split[0].equals("") || split[1].equals("") ) {
                    throw new IllegalArgumentException("Invalid parameter value is input");
                }

                parameters.put(split[0], split[1]);
            }
        } catch (Exception e) {
            this.isValidUri = false;
        }

    }



}
