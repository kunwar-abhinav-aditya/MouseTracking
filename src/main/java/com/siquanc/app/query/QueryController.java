package com.siquanc.app.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.ws.rs.core.Response;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    QueryService queryService;

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public QueryResponse getQueryResponse(@RequestBody QueryRequest queryRequest) {
        return queryService.getQueryResponse(queryRequest);
    }

    @PostMapping("/feedback")
    public String receiveFeedback(@RequestBody Feedback feedback) {
        return queryService.receiveFeedback(feedback);
    }

    @GetMapping("/result")
    public String getDocument() {
        return queryService.getCreatedDocument();
    }


    @PostMapping(path = "/resource", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ArrayList<DBPediaResource> getLeadAndAbstract(@RequestBody ArrayList<String> resourceURLs) throws IOException {
        return queryService.getLeadAndAbstract(resourceURLs);
    }
}