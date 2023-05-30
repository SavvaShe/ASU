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

    public String findAllAsJson() throws JsonProcessingException {
        List<AsuMrNull> asuMrNullList = findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(asuMrNullList);
    }
}