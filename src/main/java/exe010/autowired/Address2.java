package exe010.autowired;

public class Address2 {    
    
    private String city;
    
    private String province;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Address2(String city, String province) {
        super();
        this.city = city;
        this.province = province;
    }       
    
    public Address2() {
        super();       
    }

    @Override
    public String toString() {
        return "Address2 [city=" + city + ", province=" + province + "]";
    }     
    
}
