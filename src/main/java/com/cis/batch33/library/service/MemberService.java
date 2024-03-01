package com.cis.batch33.library.service;

import com.cis.batch33.library.entity.LibraryMember;
import com.cis.batch33.library.model.Member;
import com.cis.batch33.library.repository.LIbraryMemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LIbraryMemberRepository memberRepository;

    public Member createMember(Member member){
        Random r = new Random();
        Integer memberId = r.nextInt(Integer.MAX_VALUE);
        member.setMemberId(memberId);
        member.getAddress().setAddressId(r.nextInt(Integer.MAX_VALUE));
        LibraryMember libraryMember =
                modelMapper.map(member,LibraryMember.class);

        LibraryMember lm =  memberRepository.save(libraryMember);
        return modelMapper.map(lm, Member.class);

    }

    public Member getMember(Integer memberId) {

       Optional<LibraryMember> memberOptional =
               memberRepository.findById(memberId);
       LibraryMember libraryMember =
               memberOptional.orElseThrow(() -> new IllegalArgumentException());

        Member m =   modelMapper.map(libraryMember, Member.class);
        return m;
    }

    public Member updateMember(Member member) {
        LibraryMember libraryMember = modelMapper.map(member, LibraryMember.class);
        LibraryMember returnValue = memberRepository.save(libraryMember);
        return modelMapper.map(returnValue, Member.class);
    }

    public void deleteMember(Integer memberId) {
        Optional<LibraryMember> lm = memberRepository.findById(memberId);
        if(lm.isPresent())
            memberRepository.delete(lm.get());
    }

    public List<Member> getAllMembers() {
       List<LibraryMember> libraryMembers = memberRepository.findAll();
       return libraryMembers.stream().map( lm ->
       {
           return modelMapper.map(lm, Member.class);
       }).collect(Collectors.toList());
    }
}

// relational databases ( SQL )
    // tables and rows, foreign key, structured
    // mysql, oracle, postgres, db2, H2 Microsoft Sql Server
    // SQL - structured query language
    // programming -
    // create and manage tables - DDL - data definition language
    // create and manage data within tables - DML - Data manipulation
    // access control - DCL - data control language
    // install mysql
// TOAD, mysql workbench - IDE

// non- relational databases ( No-SQL)
    // unstructured
    // document based - mongodb,
    // key value database - redis, dynamodb,  cassandra
    // graph database -


// schema
    // tables
        // rows and columns
    // functions -
    // stored procedures -

// user name and password


// JAVA to Database connectivity

        //  JDBC package , java.sql.*

        // Connection - url, username and password, mysql - driver
        // PreparedStatement
        // ResultSet
        // CallabaleStatement

// ORM - object relational mapping
// JPA Repositories

// GET POST PUT DELETE - member and book

//GET
// Member DTO with address and checkouts
// Book DTO with all ISBNS and all Checkouts

// POST and PUT

// Member DTO along with Address,
// Book DTO along with isbns,
