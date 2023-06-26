package ru.shrf.testjob.soap;

import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.shrf.testjob.soap.wservices.ClientWSImpl;
import ru.shrf.testjob.soap.wservices.ProductWSImpl;
import ru.shrf.testjob.soap.wservices.SaleWSImpl;

import javax.xml.ws.Endpoint;

@Configuration
@RequiredArgsConstructor
public class WSConfig {

    private final Bus bus;
    private final ClientWSImpl clientWSImpl;
    private final ProductWSImpl productWSImpl;
    private final SaleWSImpl saleWSImpl;

    @Bean
    public Endpoint clientWS() {
        EndpointImpl endpoint = new EndpointImpl(bus, clientWSImpl);
        endpoint.publish("/clientWS");
        return endpoint;
    }

    @Bean
    public Endpoint productWS() {
        EndpointImpl endpoint = new EndpointImpl(bus, productWSImpl);
        endpoint.publish("/productWS");
        return endpoint;
    }

    @Bean
    public Endpoint saleWS() {
        EndpointImpl endpoint = new EndpointImpl(bus, saleWSImpl);
        endpoint.publish("/saleWS");
        return endpoint;
    }
}
