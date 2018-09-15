package com.siquanc.app.query;

import org.w3c.dom.Document;

import java.util.ArrayList;

public class QueryResponse {

    private ArrayList<String> queryResponseStrings;

    public QueryResponse(){}

    public QueryResponse(ArrayList<String> queryResponseStrings) {
        this.queryResponseStrings = queryResponseStrings;
    }

    public ArrayList<String> getQueryResponseStrings() {
        return queryResponseStrings;
    }
}
