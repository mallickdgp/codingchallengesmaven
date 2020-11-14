package com.mallickdgp;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertParamToMap {

    public void convertParamtoMap(String userID, String accountId) throws Exception{
        Map<String, Object> requestMap = new HashMap<>();
        Map<String, Object> serviceFilters = new HashMap<>();
        Map<String, Object> additionalDataFilters = new HashMap<>();
        Map<String, Object> payeeFilters = new HashMap<>();

        payeeFilters.put("key", "XX3eer4");
        payeeFilters.put("value", accountId);
        List filters = new ArrayList();
        List payeeFiltersList = new ArrayList();


        serviceFilters.put("type", "serviceId");
        serviceFilters.put("value", "101");
        payeeFiltersList.add(payeeFilters);
        additionalDataFilters.put("type", "additionalData");
        additionalDataFilters.put("value", payeeFiltersList);

        filters.add(serviceFilters);
        filters.add(additionalDataFilters);
        requestMap.put("userId", userID);
        requestMap.put("filters", filters);

        String JSON = new ObjectMapper().writeValueAsString(requestMap);

        System.out.println(JSON);

    }
}
