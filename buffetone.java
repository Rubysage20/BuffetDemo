public class Buffet {
    private String name;
    private String location;

    // Constructor
    public Buffet(String buffetName, String zipCode) {
        setName(buffetName);
        setLocation(zipCode);
    }

    // Setter for name
    public void setName(String newName) {
        name = newName;
    }

    // Setter for location (zip code)
    public void setLocation(String newLocation) {
        // Check if the zip code is an integer
        try {
            int zip = Integer.parseInt(newLocation);
            location = newLocation;
        } catch (NumberFormatException e) {
            System.out.println("Invalid zip code. Please enter an integer.");
        }
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for location (zip code)
    public String getLocation() {
        return location;
    }

    // toString method to display buffet information
    public String toString() {
        return "\nName: " + name + "\nLocation: " + location;
    }
}

}

