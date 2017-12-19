package items;

public class Locality {
    public int id;
    public String name;
    public int populationAmount;
    public String isCapital;
    public String isRegionCentre;
    public int countryId;
    public int localityTypeId;
    public int emblemId;
    public int regionId;

    public Locality(int id, String name, int populationAmount, String isCapital, String isRegionCentre,
                    int countryId, int localityTypeId, int emblemId, int regionId) {
        this.id = id;
        this.name = name;
        this.populationAmount = populationAmount;
        this.isCapital = isCapital;
        this.isRegionCentre = isRegionCentre;
        this.countryId = countryId;
        this.localityTypeId = localityTypeId;
        this.emblemId = emblemId;
        this.regionId = regionId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulationAmount(int populationAmount) {
        this.populationAmount = populationAmount;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public void setLocalityTypeId(int localityTypeId) {
        this.localityTypeId = localityTypeId;
    }

    public void setEmblemId(int emblemId) {
        this.emblemId = emblemId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPopulationAmount() {
        return populationAmount;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getIsCapital() {
        return isCapital;
    }

    public void setIsCapital(String isCapital) {
        this.isCapital = isCapital;
    }

    public String getIsRegionCentre() {
        return isRegionCentre;
    }

    public void setIsRegionCentre(String isRegionCentre) {
        this.isRegionCentre = isRegionCentre;
    }

    public int getLocalityTypeId() {
        return localityTypeId;
    }

    public int getEmblemId() {
        return emblemId;
    }

    public int getRegionId() {
        return regionId;
    }
    
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locality locality = (Locality) o;

        if (id != locality.id) return false;
        if (populationAmount != locality.populationAmount) return false;
        if (isCapital != locality.isCapital) return false;
        if (isRegionCentre != locality.isRegionCentre) return false;
        if (countryId != locality.countryId) return false;
        if (localityTypeId != locality.localityTypeId) return false;
        if (emblemId != locality.emblemId) return false;
        if (regionId != locality.regionId) return false;
        return name != null ? name.equals(locality.name) : locality.name == null;
    }

    @Override
    public String toString() {
        return String.format("|Id: %d|Name: %s|Population amount: %d|Is capital: %s|Is region centre: %s|" +
                        "Country id: %d|Locality type id: %d|Emblem id: %d|Region id: %d|", id, name, populationAmount,
                isCapital, isRegionCentre, countryId, localityTypeId, emblemId, regionId);
    }
}
