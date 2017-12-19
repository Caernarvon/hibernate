package items;

public class Locality_type {
    public int id;
    public String type;
    public String description;

    public Locality_type(int id, String type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locality_type that = (Locality_type) o;

        if (id != that.id) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public String toString() {
        return String.format("|Id: %d|Type: %s|Description: %s|", id, type, description);
    }
}
