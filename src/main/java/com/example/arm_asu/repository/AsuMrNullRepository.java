package com.example.arm_asu.repository;

import com.example.arm_asu.domain.AsuMrNull;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.arm_asu.mapper.AsuMrNullRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AsuMrNullRepository {

    private final JdbcTemplate jdbcTemplate;

    public AsuMrNullRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AsuMrNull> findAll() {
        return jdbcTemplate.query("SELECT * FROM asu_mr_null", new AsuMrNullRowMapper());
    }

    public List <AsuMrNull> sumRZD(){
        return jdbcTemplate.query("SELECT kod_dor_rush, pr_vag, SUM(kol_vag) \n" +
                "FROM public.asu_mr_null \n" +
                "GROUP BY kod_dor_rush, pr_vag;", new AsuMrNullRowMapper());
    }


    public List <AsuMrNull> bridgeVushst(){
        return jdbcTemplate.query("SELECT SUM(kol_vag) \n" +
                "FROM public.asu_mr_null \n" +
                "WHERE kod_dor_rush = '51' AND dor_nazn = 85 AND kod_stan_op = 525303;", new AsuMrNullRowMapper());
    }

    public String findAllAsJson() throws JsonProcessingException {
        List<AsuMrNull> asuMrNullList = findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(asuMrNullList);
    }
    public String sumRZDAsJson() throws JsonProcessingException {
        List<AsuMrNull> asuMrNullList = sumRZD();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(asuMrNullList);
    }
    public String bridgeVushstAsJson() throws JsonProcessingException {
        List<AsuMrNull> asuMrNullList = bridgeVushst();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(asuMrNullList);
    }
}