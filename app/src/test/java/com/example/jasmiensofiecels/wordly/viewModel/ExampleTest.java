package com.example.jasmiensofiecels.wordly.viewModel;

import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of this class is to represent the mocked response Example return object for the
 * tests. Only the result Id has been set for simplicity reasons.
 *
 * Created by Jasmien Cels on 11/04/2018.
 */

public class ExampleTest {

    private Example testExample = new Example();


    public void setTestExample(String id) {
        List<Result> results = new ArrayList<>();

        Result result = new Result();
        result.setId(id);
        results.add(result);

        testExample.setResults(results);
    }

    public Example getTestExample() {
        return testExample;
    }

    public Result getTestResult() { return  testExample.getResults().get(0); }


}
