package com.example.arm_asu.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AsuMrNull {

        private String prDat;
        private int kodGrzUch;
        private String kodDorRash;
        private int dorNazn;
        private int kolVag;
        private int prVag;
        private String prVagDecoding;
}
