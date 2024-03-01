package com.cis.batch33.library.service;

import com.cis.batch33.library.entity.BookIsbn;
import com.cis.batch33.library.entity.Checkout;
import com.cis.batch33.library.entity.LibraryMember;
import com.cis.batch33.library.model.CheckoutDTO;
import com.cis.batch33.library.model.Member;
import com.cis.batch33.library.repository.BookIsbnRepository;
import com.cis.batch33.library.repository.CheckoutRepository;
import com.cis.batch33.library.repository.LIbraryMemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.Optional;

public class CheckoutService {

    @Autowired
    private LIbraryMemberRepository memberRepository;

    @Autowired
    private BookIsbnRepository bookIsbnRepository;

    @Autowired
    private CheckoutRepository checkoutRepository;

    @Autowired
    private ModelMapper mapper;
    public CheckoutDTO createCheckout(CheckoutDTO dto){
        Integer memberId = dto.getMemberId();
        Integer bookIsbn = dto.getIsbn();
        Optional<LibraryMember> member =
                memberRepository.findById(memberId);

        Optional<BookIsbn> bookIsbn1 = bookIsbnRepository.findById(bookIsbn);


        Checkout checkout = mapper.map(dto, Checkout.class);
        checkout.setLibraryMember(member.get());
        checkout.setBookIsbn(bookIsbn1.get());
        Checkout checkout1 = checkoutRepository.save(checkout);
        return mapper.map(checkout1, CheckoutDTO.class);
    }

}
