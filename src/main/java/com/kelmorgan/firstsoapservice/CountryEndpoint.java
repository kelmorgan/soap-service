package com.kelmorgan.firstsoapservice;

import com.kelmorgan.firstsoapservice.countries.GetCountryRequest;
import com.kelmorgan.firstsoapservice.countries.GetCountryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@RequiredArgsConstructor
@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://kelmorgan.com/firstsoapservice/countries";

    private final CountryRepository countryRepository;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }
}
