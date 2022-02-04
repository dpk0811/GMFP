package com.gmfp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "historical_data")
public class HistoricalLogsModel {

    @Id
    Double s1;
    Double s2;
    Double s3;
    Double s4;
    Integer load;
    String status;
    String datetime;
    public Double getS1() {
        return s1;
    }
    public void setS1(Double s1) {
        this.s1 = s1;
    }
    public Double getS2() {
        return s2;
    }
    public void setS2(Double s2) {
        this.s2 = s2;
    }
    public Double getS3() {
        return s3;
    }
    public void setS3(Double s3) {
        this.s3 = s3;
    }
    public Double getS4() {
        return s4;
    }
    public void setS4(Double s4) {
        this.s4 = s4;
    }
    public Integer getLoad() {
        return load;
    }
    public void setLoad(Integer load) {
        this.load = load;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDatetime() {
        return datetime;
    }
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((datetime == null) ? 0 : datetime.hashCode());
        result = prime * result + ((load == null) ? 0 : load.hashCode());
        result = prime * result + ((s1 == null) ? 0 : s1.hashCode());
        result = prime * result + ((s2 == null) ? 0 : s2.hashCode());
        result = prime * result + ((s3 == null) ? 0 : s3.hashCode());
        result = prime * result + ((s4 == null) ? 0 : s4.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HistoricalLogsModel other = (HistoricalLogsModel) obj;
        if (datetime == null) {
            if (other.datetime != null)
                return false;
        } else if (!datetime.equals(other.datetime))
            return false;
        if (load == null) {
            if (other.load != null)
                return false;
        } else if (!load.equals(other.load))
            return false;
        if (s1 == null) {
            if (other.s1 != null)
                return false;
        } else if (!s1.equals(other.s1))
            return false;
        if (s2 == null) {
            if (other.s2 != null)
                return false;
        } else if (!s2.equals(other.s2))
            return false;
        if (s3 == null) {
            if (other.s3 != null)
                return false;
        } else if (!s3.equals(other.s3))
            return false;
        if (s4 == null) {
            if (other.s4 != null)
                return false;
        } else if (!s4.equals(other.s4))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "HistoricalLogsModel [datetime=" + datetime + ", load=" + load + ", s1=" + s1 + ", s2=" + s2 + ", s3="
                + s3 + ", s4=" + s4 + ", status=" + status + "]";
    }
    
  
}

