package org.babyLion.sys;

import java.util.HashMap;
import java.util.Map;

public class UriParser {

    private final String URI;

    private String controllerCode;
    private String targetMethod;

    private boolean isValidUri = true;

    private Map<String, Object> parameters = new HashMap<>();


    public UriParser(String URI) {
         this.URI = parse(URI);
    }

    protected String parse(String uri) {

        if ( !uri.startsWith("/") ) {
            this.isValidUri = false;
            return uri;
        }

        String[] uriSplit = uri.split("\\?", 2);

        if ( uriSplit.length == 2 ) {
            setParameters(uriSplit[1]);
        }

        String[] uriFront = uriSplit[0].split("/");

        if ( uriFront.length != 3 ) {
            this.isValidUri = false;
            return uri;
        }

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

    protected String getURI() {
        return URI;
    }

    protected String getControllerCode() {
        return controllerCode;
    }

    protected String getTargetMethod() {
        return targetMethod;
    }

    protected boolean isValidUri() {
        return isValidUri;
    }

    protected Map<String, Object> getParameters() {
        return parameters;
    }
}
