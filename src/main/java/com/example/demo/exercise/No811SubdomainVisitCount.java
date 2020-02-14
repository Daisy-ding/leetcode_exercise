package com.example.demo.exercise;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yubang
 * @date 2019/11/24 4:11 下午
 */
public class No811SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainVisitsMap = new LinkedHashMap<>();
        for (String cpdomain : cpdomains) {
            String[] parts = cpdomain.split(" ");
            Integer count = Integer.valueOf(parts[0]);
            String[] subDomainParts = parts[1].split("\\.");
            String currrentSubDomain = "";
            int i = subDomainParts.length - 1;
            while (i >= 0) {
                currrentSubDomain = currrentSubDomain.isEmpty() ? subDomainParts[i] : subDomainParts[i] + "." + currrentSubDomain;
                if (domainVisitsMap.containsKey(currrentSubDomain)) {
                    domainVisitsMap.put(currrentSubDomain, domainVisitsMap.get(currrentSubDomain).intValue() + count);
                } else {
                    domainVisitsMap.put(currrentSubDomain, count);
                }
                i--;
            }
        }
        return domainVisitsMap.entrySet().stream()
                .map(entry -> "" + entry.getValue() + " " + entry.getKey())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        No811SubdomainVisitCount solution = new No811SubdomainVisitCount();
        String[] inputs = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

        List<String> results = solution.subdomainVisits(inputs);
        for (String result : results) {
            System.out.println(result);
        }
    }
}
