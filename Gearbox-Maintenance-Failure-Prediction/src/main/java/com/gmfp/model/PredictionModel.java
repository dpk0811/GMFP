package com.gmfp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "sensor_data") //todo: change table name
public class PredictionModel {

    @Id
    Integer iD;
    Double s1;
    Double s2;
    Double s3;
    Double s4;
    Integer load;

    public Integer getiD() {
        return iD;
    }

    public Double getS1() {
        return s1;
    }

    public Double getS2() {
        return s2;
    }

    public Double getS3() {
        return s3;
    }

    public Double getS4() {
        return s4;
    }

    public Integer getLoad() {
        return load;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PredictionModel that = (PredictionModel) o;
        return Objects.equals(iD, that.iD) && Objects.equals(s1, that.s1) && Objects.equals(s2, that.s2) && Objects.equals(s3, that.s3) && Objects.equals(s4, that.s4) && Objects.equals(load, that.load);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iD, s1, s2, s3, s4, load);
    }

    @Override
    public String toString() {
        return "PredictionModel{" +
                "iD=" + iD +
                ", s1=" + s1 +
                ", s2=" + s2 +
                ", s3=" + s3 +
                ", s4=" + s4 +
                ", load=" + load +
                '}';
    }
}
