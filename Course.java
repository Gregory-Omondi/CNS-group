public class Course {
    String cID;
    int cCredits;

    public Course(String cID, int cCredits) {
        this.setcID(cID);
        this.setcCredits(cCredits);
    }
    public String getcID() {
        return cID;
    }
    public void setcID(String cID) {
        this.cID = cID;
    }
    public int getcCredits() {
        return cCredits;
    }
    public void setcCredits(int cCredits) {
        this.cCredits = cCredits;
    }
}
