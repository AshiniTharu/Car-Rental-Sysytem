package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.BookingDetailDTO;
import lk.ijse.spring.dto.BookingReqDTO;
import lk.ijse.spring.entity.BookingDetails;
import lk.ijse.spring.entity.BookingReq;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.repo.BookingDetailRepo;
import lk.ijse.spring.repo.BookingReqRepo;
import lk.ijse.spring.service.PlaceBookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlaceBookingServiceImpl implements PlaceBookingService {
    @Autowired
    private BookingReqRepo bookingReqRepo;

    @Autowired
    private BookingDetailRepo bookingDetailRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void placeBooking(BookingReqDTO dto) {
        if (bookingReqRepo.existsById(dto.getBookingId())) {
            throw new ValidateException("Bookin is Already Exist");
        }
        BookingReq book = mapper.map(dto, BookingReq.class);

        bookingReqRepo.save(book);
    }
    @Override
    public ArrayList<BookingDetailDTO> getAllBookingDetails() {
        List<BookingDetails> all = bookingDetailRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<BookingDetailDTO>>() {
        }.getType());
    }

    @Override
    public ArrayList<BookingReqDTO> getAllBookingReq() {
        List<BookingReq> all = bookingReqRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<BookingReqDTO>>() {
        }.getType());
    }
}
