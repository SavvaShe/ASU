package com.example.arm_asu.mapper;

import com.example.arm_asu.domain.AsuMrNull;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class AsuMrNullRowMapper implements RowMapper<AsuMrNull> {

    @Override
    public AsuMrNull mapRow(ResultSet rs, int rowNum) throws SQLException {
        AsuMrNull asuMrNull = new AsuMrNull();
        asuMrNull.setPrDat(rs.getString("pr_dat"));
        asuMrNull.setKodGrzUch(rs.getInt("kod_grz_uch"));
        asuMrNull.setKodDorRash(rs.getString("kod_dor_rush"));
        asuMrNull.setDorNazn(rs.getInt("dor_nazn"));
        asuMrNull.setKolVag(rs.getInt("kol_vag"));
        asuMrNull.setPrVag(rs.getInt("pr_vag"));
        asuMrNull.setPrVagDecoding(decoding(rs.getInt("pr_vag")));
        return asuMrNull;
    }
    private String decoding(int kod){
        String unKod;
//        switch (kod){
//            case 1:
//                unKod = "груженый";
//            case 2:
//                unKod = "порожний";
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + kod);
//        }
        if(kod == 1){
            unKod = "груженый";
        }
        else {
            unKod = "порожний";
        }
        return unKod;
    }
}