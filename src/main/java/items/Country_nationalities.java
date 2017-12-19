package items;

public class Country_nationalities {
    public int countryId;
    public int nationId;

    public Country_nationalities(int countryId, int nationId) {
        this.countryId = countryId;
        this.nationId = nationId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    public int getCountryId() {
        return countryId;
    }

    public int getNationId() {
        return nationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country_nationalities that = (Country_nationalities) o;

        if (getCountryId() != that.getCountryId()) return false;
        return getNationId() == that.getNationId();
    }

    @Override
    public String toString() {
        return String.format("|Country id: %d|Nation id: %d|", countryId, nationId);
    }
}
