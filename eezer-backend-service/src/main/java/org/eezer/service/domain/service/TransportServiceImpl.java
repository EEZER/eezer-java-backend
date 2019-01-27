package org.eezer.service.domain.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

import org.eezer.api.request.EezerStoreTransportRequest;
import org.eezer.api.valueobject.Coordinate;
import org.eezer.api.valueobject.Transport;
import org.eezer.service.domain.model.TransportModel;
import org.eezer.service.domain.repository.TransportRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * Default implementation of the {@link TransportService} interface.
 */
@Service
public class TransportServiceImpl implements TransportService {

    @Resource
    private TransportRepository transportRepository;

    @Resource
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     */
    @Override
    public Transport storeTransport(@NotNull EezerStoreTransportRequest request) {

        TransportModel transportModel = conversionService.convert(request, TransportModel.class);
        transportRepository.save(transportModel);

        return conversionService.convert(transportModel, Transport.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeTransport(@NotNull String transportId) {

        TransportModel transport = transportRepository.getByTransportId(transportId);

        if (transport != null) {
            transportRepository.delete(transport);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Transport> getTransports() {

        List<TransportModel> transports = transportRepository.findAll();
        return Arrays.asList(conversionService.convert(transports, Transport[].class));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Coordinate> getCoordinates(@NotNull String transportId) {

        TransportModel transport = transportRepository.getByTransportId(transportId);

        if (transport != null) {
            return transport.getCoordinates();
        }

        return Collections.emptyList();
    }
}