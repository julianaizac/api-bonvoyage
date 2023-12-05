package com.facens.apibonvoyage.domain.services.impl;

import com.facens.apibonvoyage.application.dtos.reserva.ReservaDTO;
import com.facens.apibonvoyage.application.dtos.reserva.ReservaInsertDTO;
import com.facens.apibonvoyage.application.exceptions.BadRequestException;
import com.facens.apibonvoyage.domain.entities.Hotel;
import com.facens.apibonvoyage.domain.entities.Quarto;
import com.facens.apibonvoyage.domain.entities.Reserva;
import com.facens.apibonvoyage.domain.enums.StatusQuarto;
import com.facens.apibonvoyage.domain.enums.StatusReserva;
import com.facens.apibonvoyage.domain.factories.HotelFatory;
import com.facens.apibonvoyage.domain.factories.ReservaFactory;
import com.facens.apibonvoyage.domain.services.ReservaService;
import com.facens.apibonvoyage.infrastrucutre.repositories.QuartoRepository;
import com.facens.apibonvoyage.infrastrucutre.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.facens.apibonvoyage.domain.enums.StatusQuarto.OCUPADO;
import static com.facens.apibonvoyage.domain.enums.StatusReserva.CANCELADA;
import static com.facens.apibonvoyage.domain.enums.StatusReserva.CONFIRMADA;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository repository;

    @Autowired
    private QuartoRepository quartoRepository;

    private String MESSAGE_QUARTO_NOT_FOUND = "Quarto não encontrado";

    @Override
    public List<ReservaDTO> buscar() {
        List<Reserva> list = repository.findAll();
        return list.stream().map(ReservaFactory::createFromEntity).collect(Collectors.toList());
    }

    @Override
    public ReservaDTO criar(ReservaInsertDTO dto) {

        Optional<Quarto> quarto = quartoRepository.findById(dto.getQuartoId());

        if(quarto.isPresent()){

            if(quarto.get().getStatusQuarto() != StatusQuarto.DISPONIVEL){
                throw new BadRequestException("Quarto indisponível", HttpStatus.BAD_REQUEST);
            }

            Reserva novaReserva = ReservaFactory.createFromInsert(dto, quarto.get());
            novaReserva.setStatusReserva(StatusReserva.PENDENTE);
            return ReservaFactory.createFromEntity(repository.save(novaReserva), quarto.get());
        } else{
            throw new BadRequestException(MESSAGE_QUARTO_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ReservaDTO cancelar(UUID idReserva) {

        Optional<Reserva> reserva = repository.findById(idReserva);

        if(reserva.isPresent()){
            reserva.get().setStatusReserva(CANCELADA);
            return ReservaFactory.createFromEntity(repository.save(reserva.get()));
        } else {
            throw new BadRequestException("Reserva não encontrada", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ReservaDTO confirmar(UUID idReserva) {

        Optional<Reserva> reserva = repository.findById(idReserva);

        if(reserva.isPresent()){
            Optional<Quarto> quarto = quartoRepository.findById(reserva.get().getQuarto().getId());
            quarto.get().setStatusQuarto(OCUPADO);
            reserva.get().setStatusReserva(CONFIRMADA);

            quartoRepository.save(quarto.get());
            return ReservaFactory.createFromEntity(repository.save(reserva.get()));
        } else {
            throw new BadRequestException("Reserva não encontrada", HttpStatus.NOT_FOUND);
        }
    }

}
