package src.model;



public class Location {
    private Double latitude;
    private Double longitude;
    private String LOCATIONNAME;
    private String district;
    private String province;

    public Location() {
    }

    public Location(Double latitude, Double longitude, String lOCATIONNAME, String district, String province) {
        this.latitude = latitude;
        this.longitude = longitude;
        LOCATIONNAME = lOCATIONNAME;
        this.district = district;
        this.province = province;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getLOCATIONNAME() {
        return LOCATIONNAME;
    }

    public void setLOCATIONNAME(String lOCATIONNAME) {
        LOCATIONNAME = lOCATIONNAME;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    
    public double distanceTo(Location other) {
        final int EARTH_RADIUS_KM = 6371;

        double latDiff = Math.toRadians(other.latitude - this.latitude);
        double lonDiff = Math.toRadians(other.longitude - this.longitude);

        double a = Math.sin(latDiff / 2) * Math.sin(latDiff / 2)
                + Math.cos(Math.toRadians(this.latitude))
                * Math.cos(Math.toRadians(other.latitude))
                * Math.sin(lonDiff / 2) * Math.sin(lonDiff / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS_KM * c;
    }

    @Override
    public String toString() {
        return "Location [latitude=" + latitude + ", longitude=" + longitude + ", LOCATIONNAME=" + LOCATIONNAME
                + ", district=" + district + ", province=" + province + "]";
    }

    


}
